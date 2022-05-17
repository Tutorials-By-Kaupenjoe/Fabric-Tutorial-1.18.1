package net.kaupenjoe.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.entity.ModBlockEntities;
import net.kaupenjoe.tutorialmod.block.entity.client.AnimatedBlockRenderer;
import net.kaupenjoe.tutorialmod.entity.ModEntities;
import net.kaupenjoe.tutorialmod.entity.client.RaccoonRenderer;
import net.kaupenjoe.tutorialmod.entity.client.armor.MythrilArmorRenderer;
import net.kaupenjoe.tutorialmod.fluid.ModFluids;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.item.client.AnimatedBlockItemRenderer;
import net.kaupenjoe.tutorialmod.item.client.AnimatedItemRenderer;
import net.kaupenjoe.tutorialmod.particle.ModParticles;
import net.kaupenjoe.tutorialmod.particle.custom.CitrineParticle;
import net.kaupenjoe.tutorialmod.screen.ModScreenHandlers;
import net.kaupenjoe.tutorialmod.screen.MythrilBlasterScreen;
import net.kaupenjoe.tutorialmod.util.ModModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class TutorialClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KAUPEN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KAUPEN_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LILAC_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LILAC_FLOWER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WINTER_WINDOW, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_VINE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JACARANDA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JACARANDA_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MYTHRIL_BLASTER, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        ScreenRegistry.register(ModScreenHandlers.MYTHRIL_BLASTER_SCREEN_HANDLER, MythrilBlasterScreen::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.CITRINE_PARTICLE, CitrineParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.HONEY_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xe9860c));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.HONEY_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0xe9860c));

        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);

        GeoArmorRenderer.registerArmorRenderer(new MythrilArmorRenderer(), ModItems.MYTHRIL_BOOTS,
                ModItems.MYTHRIL_LEGGINGS, ModItems.MYTHRIL_CHESTPLATE, ModItems.MYTHRIL_HELMET);

        GeoItemRenderer.registerItemRenderer(ModItems.ANIMATED_ITEM, new AnimatedItemRenderer());

        GeoItemRenderer.registerItemRenderer(ModItems.ANIMATED_BLOCK_ITEM, new AnimatedBlockItemRenderer());
        BlockEntityRendererRegistry.register(ModBlockEntities.ANIMATED_BLOCK_ENTITY, AnimatedBlockRenderer::new);
    }
}
