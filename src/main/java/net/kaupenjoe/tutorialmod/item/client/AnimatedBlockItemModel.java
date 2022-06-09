package net.kaupenjoe.tutorialmod.item.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.custom.AnimatedBlockItem;
import net.kaupenjoe.tutorialmod.item.custom.AnimatedItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedBlockItemModel extends AnimatedGeoModel<AnimatedBlockItem> {
    @Override
    public Identifier getModelResource(AnimatedBlockItem object) {
        return new Identifier(TutorialMod.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedBlockItem object) {
        return new Identifier(TutorialMod.MOD_ID, "textures/machines/animated_block.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedBlockItem animatable) {
        return new Identifier(TutorialMod.MOD_ID, "animations/animated_block.animation.json");
    }
}
