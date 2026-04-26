package io.mcmaster.astral_building.registry;

import io.mcmaster.astral_building.AstralBuilding;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstralBuilding.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ASTRAL_BUILDING_TAB = TABS.register("astral_building",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.astral_building"))
            .icon(() -> new ItemStack(ModBlocks.STEEL_PLATING.get()))
            .displayItems((params, output) -> {
                // Iron tier
                output.accept(ModItems.VENT.get());
                output.accept(ModItems.IRON_FACTORY_BLOCK.get());
                output.accept(ModItems.ENCASED_IRON_BLOCK.get());
                output.accept(ModItems.IRON_PLATEBLOCK.get());
                output.accept(ModItems.IRON_PANEL.get());
                output.accept(ModItems.IRON_PLATING.get());
                output.accept(ModItems.IRON_PLATING_STAIRS.get());
                output.accept(ModItems.IRON_PLATING_SLAB.get());
                output.accept(ModItems.IRON_PILLAR.get());
                output.accept(ModItems.GLOWING_IRON_PILLAR.get());
                output.accept(ModItems.MARKED_IRON_PILLAR.get());
                output.accept(ModItems.IRON_PLATING_BUTTON.get());
                output.accept(ModItems.IRON_PLATING_PRESSURE_PLATE.get());
                output.accept(ModItems.IRON_SLIDING_DOOR.get());

                // Steel tier
                output.accept(ModItems.STEEL_FACTORY_BLOCK.get());
                output.accept(ModItems.ENCASED_STEEL_BLOCK.get());
                output.accept(ModItems.STEEL_PLATEBLOCK.get());
                output.accept(ModItems.STEEL_PANEL.get());
                output.accept(ModItems.STEEL_BLOCK.get());
                output.accept(ModItems.STEEL_PLATING.get());
                output.accept(ModItems.STEEL_PLATING_STAIRS.get());
                output.accept(ModItems.STEEL_PLATING_SLAB.get());
                output.accept(ModItems.STEEL_PILLAR.get());
                output.accept(ModItems.GLOWING_STEEL_PILLAR.get());
                output.accept(ModItems.STEEL_PLATING_BUTTON.get());
                output.accept(ModItems.STEEL_PLATING_PRESSURE_PLATE.get());
                output.accept(ModItems.STEEL_SLIDING_DOOR.get());
                output.accept(ModItems.AIRLOCK.get());
                output.accept(ModItems.REINFORCED_DOOR.get());
                output.accept(ModItems.STEEL_DOOR.get());
                output.accept(ModItems.STEEL_TRAPDOOR.get());

                // Industrial lamps
                output.accept(ModItems.BLACK_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.BLUE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.BROWN_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.CYAN_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.GRAY_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.GREEN_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.LIGHT_BLUE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.LIGHT_GRAY_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.LIME_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.MAGENTA_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.ORANGE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.PINK_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.PURPLE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.RED_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.WHITE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.YELLOW_INDUSTRIAL_LAMP.get());

                // Small industrial lamps
                output.accept(ModItems.SMALL_BLACK_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_BLUE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_BROWN_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_CYAN_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_GRAY_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_GREEN_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_LIGHT_BLUE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_LIGHT_GRAY_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_LIME_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_MAGENTA_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_ORANGE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_PINK_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_PURPLE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_RED_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_WHITE_INDUSTRIAL_LAMP.get());
                output.accept(ModItems.SMALL_YELLOW_INDUSTRIAL_LAMP.get());
            })
            .build());

    private ModCreativeTabs() {}
}
