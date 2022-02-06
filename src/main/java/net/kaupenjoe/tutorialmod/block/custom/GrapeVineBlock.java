package net.kaupenjoe.tutorialmod.block.custom;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class GrapeVineBlock extends CropBlock {
    public GrapeVineBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.GRAPE_SEEDS;
    }
}
