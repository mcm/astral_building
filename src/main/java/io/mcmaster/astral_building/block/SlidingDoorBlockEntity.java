package io.mcmaster.astral_building.block;

import io.mcmaster.astral_building.registry.ModBlockEntities;
import io.mcmaster.astral_building.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class SlidingDoorBlockEntity extends BlockEntity {

    private int slideTicks;
    private int lastSlideTicks;

    public SlidingDoorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SLIDING_DOOR.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SlidingDoorBlockEntity entity) {
        boolean isOpen = state.getValue(SlidingDoorBlock.OPEN) || state.getValue(SlidingDoorBlock.POWERED);
        entity.lastSlideTicks = entity.slideTicks;

        if (!level.isClientSide()) {
            if (!isOpen && entity.slideTicks == 97) {
                level.playSound(null, pos, ModSoundEvents.SLIDING_DOOR_CLOSE.get(), SoundSource.BLOCKS, 0.25f, 1);
            } else if (isOpen && entity.slideTicks == 3) {
                level.playSound(null, pos, ModSoundEvents.SLIDING_DOOR_OPEN.get(), SoundSource.BLOCKS, 0.25f, 1);
            }
        }

        entity.slideTicks = Mth.clamp(entity.slideTicks + (isOpen ? 3 : -3), 0, 100);
    }

    public int getSlideTicks() {
        return slideTicks;
    }

    public int getLastSlideTicks() {
        return lastSlideTicks;
    }

    public AABB getRenderBoundingBox() {
        return new AABB(this.getBlockPos()).inflate(3);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("SlideTicks", slideTicks);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        slideTicks = tag.getInt("SlideTicks");
    }
}
