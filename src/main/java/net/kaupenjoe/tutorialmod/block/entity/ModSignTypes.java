package net.kaupenjoe.tutorialmod.block.entity;

import net.kaupenjoe.tutorialmod.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class ModSignTypes {
    public static final SignType JACARANDA =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("jacaranda"));
}
