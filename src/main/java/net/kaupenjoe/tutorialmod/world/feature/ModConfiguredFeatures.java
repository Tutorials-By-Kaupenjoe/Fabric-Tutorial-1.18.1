package net.kaupenjoe.tutorialmod.world.feature;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<TreeFeatureConfig, ?> JACARANDA_TREE =
            register("jacaranda_tree", Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.JACARANDA_LOG),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.JACARANDA_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build()));


    public static final ConfiguredFeature<RandomFeatureConfig, ?> JACARANDA_FEATURE =
            register("jacaranda_feature", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(
                    new RandomFeatureEntry(
                            JACARANDA_TREE.withWouldSurviveFilter(ModBlocks.JACARANDA_SAPLING), 0.1f)),
                            JACARANDA_TREE.withWouldSurviveFilter(ModBlocks.JACARANDA_SAPLING))));

    // CF -> CF -> PF -> WORLD GEN

    public static final ConfiguredFeature<RandomPatchFeatureConfig, ?> LILAC_FLOWER =
            register("lilac_flower", Feature.FLOWER.configure(
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, Feature.SIMPLE_BLOCK.configure
                            (new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LILAC_FLOWER))).withInAirFilter())));


    public static final List<OreFeatureConfig.Target> OVERWORLD_MYTHRIL_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.MYTHRIL_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_MYTHRIL_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> MYTHRIL_ORE = register("mythril_ore",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_MYTHRIL_ORES, 9)));



    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TutorialMod.MOD_ID, name),
                configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + TutorialMod.MOD_ID);
    }
}
