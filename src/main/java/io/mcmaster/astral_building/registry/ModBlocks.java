package io.mcmaster.astral_building.registry;

import io.mcmaster.astral_building.AstralBuilding;
import io.mcmaster.astral_building.block.SlidingDoorBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, AstralBuilding.MOD_ID);

    // ========== IRON TIER ==========

    public static final DeferredHolder<Block, Block> IRON_PLATING = BLOCKS.register("iron_plating",
        () -> new Block(ironProperties()));
    public static final DeferredHolder<Block, StairBlock> IRON_PLATING_STAIRS = BLOCKS.register("iron_plating_stairs",
        () -> new StairBlock(IRON_PLATING.get().defaultBlockState(), ironProperties()));
    public static final DeferredHolder<Block, SlabBlock> IRON_PLATING_SLAB = BLOCKS.register("iron_plating_slab",
        () -> new SlabBlock(ironProperties()));
    public static final DeferredHolder<Block, RotatedPillarBlock> IRON_PILLAR = BLOCKS.register("iron_pillar",
        () -> new RotatedPillarBlock(ironProperties()));
    public static final DeferredHolder<Block, RotatedPillarBlock> GLOWING_IRON_PILLAR = BLOCKS.register("glowing_iron_pillar",
        () -> new RotatedPillarBlock(ironProperties().lightLevel(state -> 15)));
    public static final DeferredHolder<Block, RotatedPillarBlock> MARKED_IRON_PILLAR = BLOCKS.register("marked_iron_pillar",
        () -> new RotatedPillarBlock(ironProperties()));
    public static final DeferredHolder<Block, ButtonBlock> IRON_PLATING_BUTTON = BLOCKS.register("iron_plating_button",
        () -> new ButtonBlock(BlockSetType.IRON, 20, Properties.ofFullCopy(Blocks.STONE_BUTTON).mapColor(MapColor.METAL)));
    public static final DeferredHolder<Block, PressurePlateBlock> IRON_PLATING_PRESSURE_PLATE = BLOCKS.register("iron_plating_pressure_plate",
        () -> new PressurePlateBlock(BlockSetType.IRON, Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).mapColor(MapColor.METAL)));
    public static final DeferredHolder<Block, SlidingDoorBlock> IRON_SLIDING_DOOR = BLOCKS.register("iron_sliding_door",
        () -> new SlidingDoorBlock(Properties.ofFullCopy(Blocks.IRON_DOOR).explosionResistance(6).mapColor(MapColor.METAL)));

    // ========== STEEL TIER ==========

    public static final DeferredHolder<Block, Block> STEEL_BLOCK = BLOCKS.register("steel_block",
        () -> new Block(steelProperties()));
    public static final DeferredHolder<Block, Block> STEEL_PLATING = BLOCKS.register("steel_plating",
        () -> new Block(steelProperties()));
    public static final DeferredHolder<Block, StairBlock> STEEL_PLATING_STAIRS = BLOCKS.register("steel_plating_stairs",
        () -> new StairBlock(STEEL_PLATING.get().defaultBlockState(), steelProperties()));
    public static final DeferredHolder<Block, SlabBlock> STEEL_PLATING_SLAB = BLOCKS.register("steel_plating_slab",
        () -> new SlabBlock(steelProperties()));
    public static final DeferredHolder<Block, RotatedPillarBlock> STEEL_PILLAR = BLOCKS.register("steel_pillar",
        () -> new RotatedPillarBlock(steelProperties()));
    public static final DeferredHolder<Block, RotatedPillarBlock> GLOWING_STEEL_PILLAR = BLOCKS.register("glowing_steel_pillar",
        () -> new RotatedPillarBlock(steelProperties().lightLevel(state -> 15)));
    public static final DeferredHolder<Block, ButtonBlock> STEEL_PLATING_BUTTON = BLOCKS.register("steel_plating_button",
        () -> new ButtonBlock(BlockSetType.IRON, 20, Properties.ofFullCopy(Blocks.STONE_BUTTON).mapColor(MapColor.COLOR_GRAY)));
    public static final DeferredHolder<Block, PressurePlateBlock> STEEL_PLATING_PRESSURE_PLATE = BLOCKS.register("steel_plating_pressure_plate",
        () -> new PressurePlateBlock(BlockSetType.IRON, Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).mapColor(MapColor.COLOR_GRAY)));
    public static final DeferredHolder<Block, SlidingDoorBlock> STEEL_SLIDING_DOOR = BLOCKS.register("steel_sliding_door",
        () -> new SlidingDoorBlock(Properties.ofFullCopy(Blocks.IRON_DOOR).explosionResistance(12).mapColor(MapColor.COLOR_GRAY)));
    public static final DeferredHolder<Block, SlidingDoorBlock> AIRLOCK = BLOCKS.register("airlock",
        () -> new SlidingDoorBlock(Properties.ofFullCopy(Blocks.IRON_DOOR).explosionResistance(18).mapColor(MapColor.COLOR_GRAY)));
    public static final DeferredHolder<Block, SlidingDoorBlock> REINFORCED_DOOR = BLOCKS.register("reinforced_door",
        () -> new SlidingDoorBlock(Properties.ofFullCopy(Blocks.IRON_DOOR).strength(25, 40).mapColor(MapColor.COLOR_GRAY)));
    public static final DeferredHolder<Block, DoorBlock> STEEL_DOOR = BLOCKS.register("steel_door",
        () -> new DoorBlock(BlockSetType.IRON, Properties.ofFullCopy(Blocks.IRON_DOOR).mapColor(MapColor.COLOR_GRAY)));
    public static final DeferredHolder<Block, TrapDoorBlock> STEEL_TRAPDOOR = BLOCKS.register("steel_trapdoor",
        () -> new TrapDoorBlock(BlockSetType.IRON, Properties.ofFullCopy(Blocks.IRON_TRAPDOOR).mapColor(MapColor.COLOR_GRAY)));

    // ========== BLOCK PROPERTIES ==========

    private static Properties ironProperties() {
        return Properties.of()
            .mapColor(MapColor.METAL)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops()
            .strength(5, 6)
            .sound(SoundType.COPPER);
    }

    private static Properties steelProperties() {
        return Properties.of()
            .mapColor(MapColor.COLOR_GRAY)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops()
            .strength(5, 12)
            .sound(SoundType.COPPER);
    }

    private ModBlocks() {}
}
