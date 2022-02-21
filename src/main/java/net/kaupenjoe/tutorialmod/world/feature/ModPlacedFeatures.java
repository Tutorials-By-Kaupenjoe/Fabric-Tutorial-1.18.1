package net.kaupenjoe.tutorialmod.world.feature;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> JACARANDA_PLACED_KEY = registerKey("jacaranda_placed");
    public static final RegistryKey<PlacedFeature> LILAC_PLACED_KEY = registerKey("lilac_placed");
    public static final RegistryKey<PlacedFeature> MYTHRIL_ORE_PLACED_KEY = registerKey("mythril_ore_placed");

    public static final PlacedFeature JACARANDA_PLACED = registerPlacedFeature("jacaranda_placed",
            ModConfiguredFeatures.JACARANDA_FEATURE.withPlacement(VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 2))));

    public static final PlacedFeature LILAC_PLACED = registerPlacedFeature("lilac_placed",
            ModConfiguredFeatures.LILAC_FLOWER.withPlacement(RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                    PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));

    public static final PlacedFeature MYTHRIL_ORE_PLACED = registerPlacedFeature("mythril_ore_placed",
            ModConfiguredFeatures.MYTHRIL_ORE.withPlacement(ModOreFeatures.modifiersWithCount(7,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80)))));



    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TutorialMod.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TutorialMod.MOD_ID, name));
    }
}
