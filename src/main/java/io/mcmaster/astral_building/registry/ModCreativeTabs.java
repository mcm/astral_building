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
            })
            .build());

    private ModCreativeTabs() {}
}
