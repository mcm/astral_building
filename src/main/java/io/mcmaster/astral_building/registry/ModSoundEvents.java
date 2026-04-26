package io.mcmaster.astral_building.registry;

import io.mcmaster.astral_building.AstralBuilding;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
        DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, AstralBuilding.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SLIDING_DOOR_OPEN = SOUND_EVENTS.register(
        "sliding_door_open",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AstralBuilding.MOD_ID, "sliding_door_open")));

    public static final DeferredHolder<SoundEvent, SoundEvent> SLIDING_DOOR_CLOSE = SOUND_EVENTS.register(
        "sliding_door_close",
        () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AstralBuilding.MOD_ID, "sliding_door_close")));

    private ModSoundEvents() {}
}
