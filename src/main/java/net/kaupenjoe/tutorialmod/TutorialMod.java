package net.kaupenjoe.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.entity.ModBlockEntities;
import net.kaupenjoe.tutorialmod.effect.ModEffects;
import net.kaupenjoe.tutorialmod.enchantment.ModEnchantments;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.painting.ModPaintings;
import net.kaupenjoe.tutorialmod.particle.ModParticles;
import net.kaupenjoe.tutorialmod.potion.ModPotions;
import net.kaupenjoe.tutorialmod.recipe.ModRecipes;
import net.kaupenjoe.tutorialmod.screen.ModScreenHandlers;
import net.kaupenjoe.tutorialmod.util.ModLootTableModifiers;
import net.kaupenjoe.tutorialmod.util.ModRegistries;
import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeatures;
import net.kaupenjoe.tutorialmod.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModPaintings.registerPaintings();
		ModRegistries.registerModStuffs();

		ModWorldGen.generateModWorldGen();
		ModLootTableModifiers.modifyLootTables();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModBlockEntities.registerAllBlockEntities();
		ModRecipes.registerRecipes();

		ModScreenHandlers.registerAllScreenHandlers();

		ModParticles.registerParticles();
		ModEnchantments.registerModEnchantments();

		GeckoLib.initialize();

	}
}
