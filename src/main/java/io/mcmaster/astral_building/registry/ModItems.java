package io.mcmaster.astral_building.registry;

import io.mcmaster.astral_building.AstralBuilding;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, AstralBuilding.MOD_ID);

    // ========== IRON TIER ==========

    public static final DeferredHolder<Item, BlockItem> VENT = blockItem(ModBlocks.VENT);
    public static final DeferredHolder<Item, BlockItem> IRON_FACTORY_BLOCK = blockItem(ModBlocks.IRON_FACTORY_BLOCK);
    public static final DeferredHolder<Item, BlockItem> ENCASED_IRON_BLOCK = blockItem(ModBlocks.ENCASED_IRON_BLOCK);
    public static final DeferredHolder<Item, BlockItem> IRON_PLATEBLOCK = blockItem(ModBlocks.IRON_PLATEBLOCK);
    public static final DeferredHolder<Item, BlockItem> IRON_PANEL = blockItem(ModBlocks.IRON_PANEL);
    public static final DeferredHolder<Item, BlockItem> IRON_PLATING = blockItem(ModBlocks.IRON_PLATING);
    public static final DeferredHolder<Item, BlockItem> IRON_PLATING_STAIRS = blockItem(ModBlocks.IRON_PLATING_STAIRS);
    public static final DeferredHolder<Item, BlockItem> IRON_PLATING_SLAB = blockItem(ModBlocks.IRON_PLATING_SLAB);
    public static final DeferredHolder<Item, BlockItem> IRON_PILLAR = blockItem(ModBlocks.IRON_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GLOWING_IRON_PILLAR = blockItem(ModBlocks.GLOWING_IRON_PILLAR);
    public static final DeferredHolder<Item, BlockItem> MARKED_IRON_PILLAR = blockItem(ModBlocks.MARKED_IRON_PILLAR);
    public static final DeferredHolder<Item, BlockItem> IRON_PLATING_BUTTON = blockItem(ModBlocks.IRON_PLATING_BUTTON);
    public static final DeferredHolder<Item, BlockItem> IRON_PLATING_PRESSURE_PLATE = blockItem(ModBlocks.IRON_PLATING_PRESSURE_PLATE);
    public static final DeferredHolder<Item, BlockItem> IRON_SLIDING_DOOR = blockItem(ModBlocks.IRON_SLIDING_DOOR);

    // ========== STEEL TIER ==========

    public static final DeferredHolder<Item, BlockItem> STEEL_FACTORY_BLOCK = blockItem(ModBlocks.STEEL_FACTORY_BLOCK);
    public static final DeferredHolder<Item, BlockItem> ENCASED_STEEL_BLOCK = blockItem(ModBlocks.ENCASED_STEEL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> STEEL_PLATEBLOCK = blockItem(ModBlocks.STEEL_PLATEBLOCK);
    public static final DeferredHolder<Item, BlockItem> STEEL_PANEL = blockItem(ModBlocks.STEEL_PANEL);
    public static final DeferredHolder<Item, BlockItem> STEEL_BLOCK = blockItem(ModBlocks.STEEL_BLOCK);
    public static final DeferredHolder<Item, BlockItem> STEEL_PLATING = blockItem(ModBlocks.STEEL_PLATING);
    public static final DeferredHolder<Item, BlockItem> STEEL_PLATING_STAIRS = blockItem(ModBlocks.STEEL_PLATING_STAIRS);
    public static final DeferredHolder<Item, BlockItem> STEEL_PLATING_SLAB = blockItem(ModBlocks.STEEL_PLATING_SLAB);
    public static final DeferredHolder<Item, BlockItem> STEEL_PILLAR = blockItem(ModBlocks.STEEL_PILLAR);
    public static final DeferredHolder<Item, BlockItem> GLOWING_STEEL_PILLAR = blockItem(ModBlocks.GLOWING_STEEL_PILLAR);
    public static final DeferredHolder<Item, BlockItem> STEEL_PLATING_BUTTON = blockItem(ModBlocks.STEEL_PLATING_BUTTON);
    public static final DeferredHolder<Item, BlockItem> STEEL_PLATING_PRESSURE_PLATE = blockItem(ModBlocks.STEEL_PLATING_PRESSURE_PLATE);
    public static final DeferredHolder<Item, BlockItem> STEEL_SLIDING_DOOR = blockItem(ModBlocks.STEEL_SLIDING_DOOR);
    public static final DeferredHolder<Item, BlockItem> AIRLOCK = blockItem(ModBlocks.AIRLOCK);
    public static final DeferredHolder<Item, BlockItem> REINFORCED_DOOR = blockItem(ModBlocks.REINFORCED_DOOR);
    public static final DeferredHolder<Item, Item> STEEL_DOOR = ITEMS.register("steel_door",
        () -> new DoubleHighBlockItem(ModBlocks.STEEL_DOOR.get(), new Item.Properties()));
    public static final DeferredHolder<Item, BlockItem> STEEL_TRAPDOOR = blockItem(ModBlocks.STEEL_TRAPDOOR);

    // ========== INDUSTRIAL LAMPS ==========

    public static final DeferredHolder<Item, BlockItem> BLACK_INDUSTRIAL_LAMP = blockItem(ModBlocks.BLACK_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> BLUE_INDUSTRIAL_LAMP = blockItem(ModBlocks.BLUE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> BROWN_INDUSTRIAL_LAMP = blockItem(ModBlocks.BROWN_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> CYAN_INDUSTRIAL_LAMP = blockItem(ModBlocks.CYAN_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> GRAY_INDUSTRIAL_LAMP = blockItem(ModBlocks.GRAY_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> GREEN_INDUSTRIAL_LAMP = blockItem(ModBlocks.GREEN_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> LIGHT_BLUE_INDUSTRIAL_LAMP = blockItem(ModBlocks.LIGHT_BLUE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> LIGHT_GRAY_INDUSTRIAL_LAMP = blockItem(ModBlocks.LIGHT_GRAY_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> LIME_INDUSTRIAL_LAMP = blockItem(ModBlocks.LIME_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> MAGENTA_INDUSTRIAL_LAMP = blockItem(ModBlocks.MAGENTA_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> ORANGE_INDUSTRIAL_LAMP = blockItem(ModBlocks.ORANGE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> PINK_INDUSTRIAL_LAMP = blockItem(ModBlocks.PINK_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> PURPLE_INDUSTRIAL_LAMP = blockItem(ModBlocks.PURPLE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> RED_INDUSTRIAL_LAMP = blockItem(ModBlocks.RED_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> WHITE_INDUSTRIAL_LAMP = blockItem(ModBlocks.WHITE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> YELLOW_INDUSTRIAL_LAMP = blockItem(ModBlocks.YELLOW_INDUSTRIAL_LAMP);

    // ========== SMALL INDUSTRIAL LAMPS ==========

    public static final DeferredHolder<Item, BlockItem> SMALL_BLACK_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_BLACK_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_BLUE_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_BLUE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_BROWN_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_BROWN_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_CYAN_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_CYAN_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_GRAY_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_GRAY_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_GREEN_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_GREEN_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_BLUE_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_LIGHT_BLUE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIGHT_GRAY_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_LIGHT_GRAY_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_LIME_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_LIME_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_MAGENTA_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_MAGENTA_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_ORANGE_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_ORANGE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_PINK_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_PINK_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_PURPLE_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_PURPLE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_RED_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_RED_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_WHITE_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_WHITE_INDUSTRIAL_LAMP);
    public static final DeferredHolder<Item, BlockItem> SMALL_YELLOW_INDUSTRIAL_LAMP = blockItem(ModBlocks.SMALL_YELLOW_INDUSTRIAL_LAMP);

    // ========== HELPERS ==========

    private static <T extends Block> DeferredHolder<Item, BlockItem> blockItem(DeferredHolder<Block, T> block) {
        return ITEMS.register(block.getId().getPath(),
            () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private ModItems() {}
}
