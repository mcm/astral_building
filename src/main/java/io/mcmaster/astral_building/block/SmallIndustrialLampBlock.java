package io.mcmaster.astral_building.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallIndustrialLampBlock extends IndustrialLampBlock {

    public static final VoxelShape SMALL_NORTH_SHAPE = Shapes.join(
        Block.box(3, 3, 14, 13, 13, 16),
        Block.box(4, 4, 8, 12, 12, 14), BooleanOp.OR);

    public static final VoxelShape SMALL_EAST_SHAPE = Shapes.join(
        Block.box(0, 3, 3, 2, 13, 13),
        Block.box(2, 4, 4, 8, 12, 12), BooleanOp.OR);

    public static final VoxelShape SMALL_SOUTH_SHAPE = Shapes.join(
        Block.box(3, 3, 0, 13, 13, 2),
        Block.box(4, 4, 2, 12, 12, 8), BooleanOp.OR);

    public static final VoxelShape SMALL_WEST_SHAPE = Shapes.join(
        Block.box(14, 3, 3, 16, 13, 13),
        Block.box(8, 4, 4, 14, 12, 12), BooleanOp.OR);

    public static final VoxelShape SMALL_UP_SHAPE = Shapes.join(
        Block.box(3, 14, 3, 13, 16, 13),
        Block.box(4, 8, 4, 12, 14, 12), BooleanOp.OR);

    public static final VoxelShape SMALL_DOWN_SHAPE = Shapes.join(
        Block.box(3, 0, 3, 13, 2, 13),
        Block.box(4, 2, 4, 12, 8, 12), BooleanOp.OR);

    public SmallIndustrialLampBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACE)) {
            case FLOOR -> SMALL_DOWN_SHAPE;
            case WALL -> switch (state.getValue(FACING)) {
                case NORTH -> SMALL_NORTH_SHAPE;
                case EAST -> SMALL_EAST_SHAPE;
                case SOUTH -> SMALL_SOUTH_SHAPE;
                case WEST -> SMALL_WEST_SHAPE;
                default -> SMALL_UP_SHAPE;
            };
            case CEILING -> SMALL_UP_SHAPE;
        };
    }
}
