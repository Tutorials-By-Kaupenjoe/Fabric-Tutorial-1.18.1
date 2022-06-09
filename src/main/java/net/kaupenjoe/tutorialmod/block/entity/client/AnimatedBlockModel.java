package net.kaupenjoe.tutorialmod.block.entity.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.entity.AnimatedBlockEntity;
import net.kaupenjoe.tutorialmod.item.custom.AnimatedBlockItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedBlockModel extends AnimatedGeoModel<AnimatedBlockEntity> {
    @Override
    public Identifier getModelResource(AnimatedBlockEntity object) {
        return new Identifier(TutorialMod.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedBlockEntity object) {
        return new Identifier(TutorialMod.MOD_ID, "textures/machines/animated_block.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedBlockEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID, "animations/animated_block.animation.json");
    }
}
