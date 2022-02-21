package net.kaupenjoe.tutorialmod.world.feature.tree;

import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class JacarandaSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected ConfiguredFeature<?, ?> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.JACARANDA_TREE;
    }
}
