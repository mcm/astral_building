package io.mcmaster.astral_building;

import io.mcmaster.astral_building.registry.ModBlockEntities;
import io.mcmaster.astral_building.registry.ModBlocks;
import io.mcmaster.astral_building.registry.ModCreativeTabs;
import io.mcmaster.astral_building.registry.ModItems;
import io.mcmaster.astral_building.registry.ModSoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(AstralBuilding.MOD_ID)
public final class AstralBuilding {
    public static final String MOD_ID = "astral_building";

    public AstralBuilding(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        ModSoundEvents.SOUND_EVENTS.register(modEventBus);
    }
}
