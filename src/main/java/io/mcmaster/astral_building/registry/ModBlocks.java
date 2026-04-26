package io.mcmaster.astral_building.registry;

import io.mcmaster.astral_building.AstralBuilding;
import io.mcmaster.astral_building.block.IndustrialLampBlock;
import io.mcmaster.astral_building.block.SlidingDoorBlock;
import io.mcmaster.astral_building.block.SmallIndustrialLampBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, AstralBuilding.MOD_ID);

    // ========== IRON TIER ==========

    public static final DeferredHolder<Block, Block> VENT = BLOCKS.register("vent",
        () -> new Block(ironProperties()));
    public static final DeferredHolder<Block, Block> IRON_FACTORY_BLOCK = BLOCKS.register("iron_factory_block",
        () -> new Block(ironProperties()));
    public static final DeferredHolder<Block, Block> ENCASED_IRON_BLOCK = BLOCKS.register("encased_iron_block",
        () -> new Block(ironProperties()));
    public static final DeferredHolder<Block, Block> IRON_PLATEBLOCK = BLOCKS.register("iron_plateblock",
        () -> new Block(ironProperties()));
    public static final DeferredHolder<Block, Block> IRON_PANEL = BLOCKS.register("iron_panel",
        () -> new Block(ironProperties()));
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

    public static final DeferredHolder<Block, Block> STEEL_FACTORY_BLOCK = BLOCKS.register("steel_factory_block",
        () -> new Block(steelProperties()));
    public static final DeferredHolder<Block, Block> ENCASED_STEEL_BLOCK = BLOCKS.register("encased_steel_block",
        () -> new Block(steelProperties()));
    public static final DeferredHolder<Block, Block> STEEL_PLATEBLOCK = BLOCKS.register("steel_plateblock",
        () -> new Block(steelProperties()));
    public static final DeferredHolder<Block, Block> STEEL_PANEL = BLOCKS.register("steel_panel",
        () -> new Block(steelProperties()));
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

    // ========== INDUSTRIAL LAMPS ==========

    public static final DeferredHolder<Block, IndustrialLampBlock> BLACK_INDUSTRIAL_LAMP = BLOCKS.register("black_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> BLUE_INDUSTRIAL_LAMP = BLOCKS.register("blue_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> BROWN_INDUSTRIAL_LAMP = BLOCKS.register("brown_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> CYAN_INDUSTRIAL_LAMP = BLOCKS.register("cyan_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> GRAY_INDUSTRIAL_LAMP = BLOCKS.register("gray_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> GREEN_INDUSTRIAL_LAMP = BLOCKS.register("green_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> LIGHT_BLUE_INDUSTRIAL_LAMP = BLOCKS.register("light_blue_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> LIGHT_GRAY_INDUSTRIAL_LAMP = BLOCKS.register("light_gray_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> LIME_INDUSTRIAL_LAMP = BLOCKS.register("lime_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> MAGENTA_INDUSTRIAL_LAMP = BLOCKS.register("magenta_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> ORANGE_INDUSTRIAL_LAMP = BLOCKS.register("orange_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> PINK_INDUSTRIAL_LAMP = BLOCKS.register("pink_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> PURPLE_INDUSTRIAL_LAMP = BLOCKS.register("purple_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> RED_INDUSTRIAL_LAMP = BLOCKS.register("red_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> WHITE_INDUSTRIAL_LAMP = BLOCKS.register("white_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));
    public static final DeferredHolder<Block, IndustrialLampBlock> YELLOW_INDUSTRIAL_LAMP = BLOCKS.register("yellow_industrial_lamp",
        () -> new IndustrialLampBlock(steelProperties().lightLevel(state -> 12)));

    // ========== SMALL INDUSTRIAL LAMPS ==========

    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_BLACK_INDUSTRIAL_LAMP = BLOCKS.register("small_black_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_BLUE_INDUSTRIAL_LAMP = BLOCKS.register("small_blue_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_BROWN_INDUSTRIAL_LAMP = BLOCKS.register("small_brown_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_CYAN_INDUSTRIAL_LAMP = BLOCKS.register("small_cyan_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_GRAY_INDUSTRIAL_LAMP = BLOCKS.register("small_gray_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_GREEN_INDUSTRIAL_LAMP = BLOCKS.register("small_green_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_LIGHT_BLUE_INDUSTRIAL_LAMP = BLOCKS.register("small_light_blue_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_LIGHT_GRAY_INDUSTRIAL_LAMP = BLOCKS.register("small_light_gray_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_LIME_INDUSTRIAL_LAMP = BLOCKS.register("small_lime_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_MAGENTA_INDUSTRIAL_LAMP = BLOCKS.register("small_magenta_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_ORANGE_INDUSTRIAL_LAMP = BLOCKS.register("small_orange_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_PINK_INDUSTRIAL_LAMP = BLOCKS.register("small_pink_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_PURPLE_INDUSTRIAL_LAMP = BLOCKS.register("small_purple_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_RED_INDUSTRIAL_LAMP = BLOCKS.register("small_red_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_WHITE_INDUSTRIAL_LAMP = BLOCKS.register("small_white_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));
    public static final DeferredHolder<Block, SmallIndustrialLampBlock> SMALL_YELLOW_INDUSTRIAL_LAMP = BLOCKS.register("small_yellow_industrial_lamp",
        () -> new SmallIndustrialLampBlock(steelProperties().lightLevel(state -> 8)));

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
