package net.kaupenjoe.tutorialmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<MythrilBlasterBlockEntity> MYTHRIL_BLASTER;

    public static void registerAllBlockEntities() {
        MYTHRIL_BLASTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(TutorialMod.MOD_ID, "mythril_blaster"),
                FabricBlockEntityTypeBuilder.create(MythrilBlasterBlockEntity::new,
                        ModBlocks.MYTHRIL_BLASTER).build(null));
    }
}
