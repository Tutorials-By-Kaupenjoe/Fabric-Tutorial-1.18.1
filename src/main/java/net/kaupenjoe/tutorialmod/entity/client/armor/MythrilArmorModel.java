package net.kaupenjoe.tutorialmod.entity.client.armor;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.custom.MythrilArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MythrilArmorModel extends AnimatedGeoModel<MythrilArmorItem> {
    @Override
    public Identifier getModelResource(MythrilArmorItem object) {
        return new Identifier(TutorialMod.MOD_ID, "geo/mythril_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(MythrilArmorItem object) {
        return new Identifier(TutorialMod.MOD_ID, "textures/models/armor/mythril_armor_texture.png");
    }

    @Override
    public Identifier getAnimationResource(MythrilArmorItem animatable) {
        return new Identifier(TutorialMod.MOD_ID, "animations/armor_animation.json");
    }
}
