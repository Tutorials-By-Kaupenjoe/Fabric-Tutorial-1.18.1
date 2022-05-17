package net.kaupenjoe.tutorialmod.block.entity.client;

import net.kaupenjoe.tutorialmod.block.entity.AnimatedBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class AnimatedBlockRenderer extends GeoBlockRenderer<AnimatedBlockEntity> {
    public AnimatedBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new AnimatedBlockModel());
    }

    @Override
    public RenderLayer getRenderType(AnimatedBlockEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
