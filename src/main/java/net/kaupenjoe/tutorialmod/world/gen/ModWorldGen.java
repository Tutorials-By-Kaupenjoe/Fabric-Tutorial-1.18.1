package net.kaupenjoe.tutorialmod.world.gen;

public class ModWorldGen {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModFlowerGeneration.generateFlowers();
        ModTreeGeneration.generateTrees();
    }
}
