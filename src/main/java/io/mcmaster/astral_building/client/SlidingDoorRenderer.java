package io.mcmaster.astral_building.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.mcmaster.astral_building.AstralBuilding;
import io.mcmaster.astral_building.block.SlidingDoorBlock;
import io.mcmaster.astral_building.block.SlidingDoorBlockEntity;
import io.mcmaster.astral_building.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class SlidingDoorRenderer implements BlockEntityRenderer<SlidingDoorBlockEntity> {

    private static final Set<Block> SIMPLE_SLIDING_DOORS = Set.of();

    public SlidingDoorRenderer(BlockEntityRendererProvider.Context context) {
    }

    private static Set<Block> getSimpleDoors() {
        return Set.of(
            ModBlocks.IRON_SLIDING_DOOR.get(),
            ModBlocks.STEEL_SLIDING_DOOR.get()
        );
    }

    @Override
    public void render(SlidingDoorBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        float slide = Mth.lerp(partialTick, entity.getLastSlideTicks(), entity.getSlideTicks()) / 81.0f;
        var state = entity.getBlockState();
        var direction = state.getValue(SlidingDoorBlock.FACING);
        var minecraft = Minecraft.getInstance();
        var model = minecraft.getBlockRenderer().getBlockModel(state);
        boolean flipSecondDoor = !getSimpleDoors().contains(state.getBlock());

        poseStack.pushPose();
        try {
            poseStack.translate(0.5f, 1, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(direction.toYRot()));
            poseStack.translate(-0.5f, 0, -0.5f);

            poseStack.translate(slide, 0, 0.0625f);
            if (direction.getAxis() == Direction.Axis.Z) {
                poseStack.translate(0, 0, 0.6875f);
                if (state.is(ModBlocks.REINFORCED_DOOR.get())) {
                    poseStack.translate(0, 0, -0.3125f);
                }
            }

            minecraft.getBlockRenderer().getModelRenderer().renderModel(poseStack.last(),
                buffer.getBuffer(Sheets.cutoutBlockSheet()),
                state,
                model,
                1f, 1f, 1f,
                packedLight, packedOverlay);

            poseStack.translate(-slide - slide, 0, 0);

            if (!flipSecondDoor) {
                poseStack.translate(0.5f, 0, 0.5f);
                poseStack.mulPose(Axis.YP.rotationDegrees(180));
                poseStack.translate(-0.5f, 0, -0.5f);
                poseStack.translate(0, 0, 0.8125f);

                minecraft.getBlockRenderer().getModelRenderer().renderModel(poseStack.last(),
                    buffer.getBuffer(Sheets.cutoutBlockSheet()),
                    state,
                    model,
                    1f, 1f, 1f,
                    packedLight, packedOverlay);
            } else {
                poseStack.translate(-1.25f, 0, 0);
                String blockId = BuiltInRegistries.BLOCK.getKey(state.getBlock()).getPath();
                ResourceLocation flippedLoc = ResourceLocation.fromNamespaceAndPath(
                    AstralBuilding.MOD_ID, "block/" + blockId + "_flipped");
                BakedModel blockModel = minecraft.getModelManager()
                    .getModel(ModelResourceLocation.standalone(flippedLoc));
                minecraft.getBlockRenderer().getModelRenderer().renderModel(
                    poseStack.last(),
                    buffer.getBuffer(Sheets.cutoutBlockSheet()),
                    state,
                    blockModel,
                    1f, 1f, 1f,
                    packedLight, packedOverlay);
            }
        } finally {
            poseStack.popPose();
        }
    }
}
