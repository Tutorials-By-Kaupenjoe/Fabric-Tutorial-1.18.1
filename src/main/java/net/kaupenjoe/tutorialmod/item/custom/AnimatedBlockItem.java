package net.kaupenjoe.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AnimatedBlockItem extends BlockItem implements IAnimatable {
    public AnimationFactory factory = new AnimationFactory(this);

    public AnimatedBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        // event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
