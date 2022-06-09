package net.kaupenjoe.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.RaccoonEntity;
import net.kaupenjoe.tutorialmod.entity.variant.RaccoonVariant;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public static final Map<RaccoonVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RaccoonVariant.class), (map) -> {
                map.put(RaccoonVariant.DEFAULT,
                        new Identifier(TutorialMod.MOD_ID, "textures/entity/raccoon/raccoon.png"));
                map.put(RaccoonVariant.DARK,
                        new Identifier(TutorialMod.MOD_ID, "textures/entity/raccoon/raccoondark.png"));
                map.put(RaccoonVariant.RED,
                        new Identifier(TutorialMod.MOD_ID, "textures/entity/raccoon/redraccoon.png"));
            });


    public RaccoonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RaccoonModel());
    }

    @Override
    public Identifier getTextureResource(RaccoonEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderLayer getRenderType(RaccoonEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
        } else {
            stack.scale(1f, 1f, 1f);
        }

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder,
                packedLightIn, textureLocation);
    }
}
