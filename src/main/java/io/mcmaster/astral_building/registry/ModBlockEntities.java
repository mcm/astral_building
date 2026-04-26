package io.mcmaster.astral_building.registry;

import io.mcmaster.astral_building.AstralBuilding;
import io.mcmaster.astral_building.block.SlidingDoorBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AstralBuilding.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SlidingDoorBlockEntity>> SLIDING_DOOR =
        BLOCK_ENTITIES.register("sliding_door", () ->
            BlockEntityType.Builder.of(SlidingDoorBlockEntity::new,
                ModBlocks.IRON_SLIDING_DOOR.get(),
                ModBlocks.STEEL_SLIDING_DOOR.get(),
                ModBlocks.AIRLOCK.get(),
                ModBlocks.REINFORCED_DOOR.get()
            ).build(null));

    private ModBlockEntities() {}
}
