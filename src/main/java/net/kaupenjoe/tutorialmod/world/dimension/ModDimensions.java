package net.kaupenjoe.tutorialmod.world.dimension;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
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

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.GLOWSTONE)
                .destDimID(KJDIM_DIMENSION_KEY.getValue())
                .tintColor(45, 79, 195)
                .lightWithItem(ModItems.MYTHRIL_STAFF)
                .onlyLightInOverworld()
                .registerPortal();
    }
}
