package net.kaupenjoe.tutorialmod.world.dimension;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> KJDIM_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(TutorialMod.MOD_ID, "kjdim"));
    public static final RegistryKey<DimensionType> KJDIM_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            KJDIM_DIMENSION_KEY.getValue());


    public static void register() {
        TutorialMod.LOGGER.debug("Registering ModDimensions for " + TutorialMod.MOD_ID);
    }
}
