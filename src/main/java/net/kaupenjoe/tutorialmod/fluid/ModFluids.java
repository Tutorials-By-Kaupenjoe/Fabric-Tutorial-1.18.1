package net.kaupenjoe.tutorialmod.fluid;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid HONEY_STILL = register("honey_still", new HoneyFluid.Still());
    public static final FlowableFluid HONEY_FLOWING = register("honey_flowing", new HoneyFluid.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registry.FLUID, new Identifier(TutorialMod.MOD_ID, name), flowableFluid);
    }
}
