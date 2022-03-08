package net.kaupenjoe.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.painting.ModPaintings;
import net.kaupenjoe.tutorialmod.util.ModRegistries;
import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeatures;
import net.kaupenjoe.tutorialmod.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	}
}
