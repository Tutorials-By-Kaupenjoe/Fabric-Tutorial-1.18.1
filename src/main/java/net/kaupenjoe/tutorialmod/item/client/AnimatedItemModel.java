package net.kaupenjoe.tutorialmod.item.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.custom.AnimatedItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedItemModel extends AnimatedGeoModel<AnimatedItem> {
    @Override
    public Identifier getModelResource(AnimatedItem object) {
        return new Identifier(TutorialMod.MOD_ID, "geo/animated_item.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedItem object) {
        return new Identifier(TutorialMod.MOD_ID, "textures/item/animated_item_texture.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedItem animatable) {
        return new Identifier(TutorialMod.MOD_ID, "animations/animated_item.animation.json");
    }
}
