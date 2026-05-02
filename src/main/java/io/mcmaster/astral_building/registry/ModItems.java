package io.mcmaster.astral_building.registry;

import io.mcmaster.astral_building.AstralBuilding;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, AstralBuilding.MOD_ID);

    // ========== IRON TIER ==========

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

    // ========== HELPERS ==========

    private static <T extends Block> DeferredHolder<Item, BlockItem> blockItem(DeferredHolder<Block, T> block) {
        return ITEMS.register(block.getId().getPath(),
            () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private ModItems() {}
}
