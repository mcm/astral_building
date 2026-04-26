package io.mcmaster.astral_building.client;

import io.mcmaster.astral_building.AstralBuilding;
import io.mcmaster.astral_building.registry.ModBlockEntities;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = AstralBuilding.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SLIDING_DOOR.get(), SlidingDoorRenderer::new);
    }

    @SubscribeEvent
    public static void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
        event.register(ModelResourceLocation.standalone(
            ResourceLocation.fromNamespaceAndPath(AstralBuilding.MOD_ID, "block/airlock_flipped")));
        event.register(ModelResourceLocation.standalone(
            ResourceLocation.fromNamespaceAndPath(AstralBuilding.MOD_ID, "block/reinforced_door_flipped")));
    }

    private ClientEvents() {}
}
