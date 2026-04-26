package io.mcmaster.astral_building.block;

import com.mojang.serialization.MapCodec;
import io.mcmaster.astral_building.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class SlidingDoorBlock extends BaseEntityBlock {

    public static final MapCodec<SlidingDoorBlock> CODEC = simpleCodec(SlidingDoorBlock::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<SlidingDoorPartProperty> PART = EnumProperty.create("part", SlidingDoorPartProperty.class);

    private static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 1, 16, 16, 4);
    private static final VoxelShape EAST_SHAPE = Block.box(12, 0, 0, 15, 16, 16);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 12, 16, 16, 15);
    private static final VoxelShape WEST_SHAPE = Block.box(1, 0, 0, 4, 16, 16);

    public SlidingDoorBlock(Properties properties) {
        super(properties.pushReaction(PushReaction.BLOCK));
        registerDefaultState(stateDefinition.any()
            .setValue(FACING, Direction.NORTH)
            .setValue(OPEN, false)
            .setValue(POWERED, false)
            .setValue(PART, SlidingDoorPartProperty.BOTTOM));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, POWERED, PART);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> NORTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        BlockState controllerState = level.getBlockState(getController(state, pos));
        if (!controllerState.getValues().containsKey(PART)) {
            return super.getCollisionShape(state, level, pos, context);
        }
        return controllerState.getValue(OPEN) || controllerState.getValue(POWERED) ?
            Shapes.empty() :
            super.getCollisionShape(state, level, pos, context);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return switch (type) {
            case LAND, AIR -> state.getValue(OPEN) || state.getValue(POWERED);
            case WATER -> false;
        };
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return state.getValue(PART).isController() ? new SlidingDoorBlockEntity(pos, state) : null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (!state.getValue(PART).isController()) return null;
        return createTickerHelper(type, ModBlockEntities.SLIDING_DOOR.get(), SlidingDoorBlockEntity::tick);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        BlockPos controllerPos = getController(state, pos);
        BlockState controllerState = level.getBlockState(controllerPos);
        if (controllerState.isAir()) return InteractionResult.PASS;
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        Direction direction = state.getValue(FACING).getClockWise();
        for (SlidingDoorPartProperty part : SlidingDoorPartProperty.values()) {
            BlockPos partPos = controllerPos.relative(direction, part.xOffset()).above(part.yOffset());
            BlockState partState = level.getBlockState(partPos);
            if (partState.getBlock() instanceof SlidingDoorBlock) {
                level.setBlockAndUpdate(partPos, partState.cycle(OPEN));
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        Direction direction = state.getValue(FACING).getClockWise();
        for (SlidingDoorPartProperty part : SlidingDoorPartProperty.values()) {
            BlockPos partPos = pos.relative(direction.getOpposite(), part.xOffset()).above(part.yOffset());
            level.setBlock(partPos, state.setValue(PART, part), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if (!level.isClientSide()) {
            BlockPos controllerPos = getController(state, pos);
            BlockState controllerState = level.getBlockState(controllerPos);
            if (controllerState.getBlock() instanceof SlidingDoorBlock) {
                level.setBlock(controllerPos, controllerState.setValue(POWERED, level.hasNeighborSignal(pos)), Block.UPDATE_CLIENTS);
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (!Block.canSupportRigidBlock(level, pos.below())) return false;
        Direction direction = state.getValue(FACING).getClockWise();
        for (SlidingDoorPartProperty part : SlidingDoorPartProperty.values()) {
            BlockPos offset = pos.relative(direction, part.xOffset()).above(part.yOffset());
            if (!level.getBlockState(offset).isAir()) return false;
        }
        return true;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        destroy(level, pos, state);
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        if (!level.isClientSide()) {
            for (Direction direction : Direction.values()) {
                BlockPos offset = pos.relative(direction);
                BlockState state = level.getBlockState(offset);
                if (state.getBlock().equals(this)) {
                    destroy(level, offset, state);
                    break;
                }
            }
        }
        super.wasExploded(level, pos, explosion);
    }

    private void destroy(Level level, BlockPos pos, BlockState state) {
        Direction direction = state.getValue(FACING).getClockWise();
        BlockPos controllerPos = getController(state, pos);
        for (SlidingDoorPartProperty part : SlidingDoorPartProperty.values()) {
            BlockPos partPos = controllerPos.relative(direction, part.xOffset()).above(part.yOffset());
            level.destroyBlock(partPos, true);
        }
    }

    private BlockPos getController(BlockState state, BlockPos pos) {
        SlidingDoorPartProperty part = state.getValue(PART);
        Direction direction = state.getValue(FACING).getClockWise();
        return pos.relative(direction.getOpposite(), -part.xOffset()).below(part.yOffset());
    }
}
