package net.kaupenjoe.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.custom.*;
import net.kaupenjoe.tutorialmod.block.entity.ModSignTypes;
import net.kaupenjoe.tutorialmod.fluid.ModFluids;
import net.kaupenjoe.tutorialmod.item.ModItemGroup;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.kaupenjoe.tutorialmod.world.feature.tree.JacarandaSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),
            ModItemGroup.MYTHRIL, "tooltip.tutorialmod.mythril_block");

    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool(),
                    UniformIntProvider.create(2, 6)), ModItemGroup.MYTHRIL);

    public static final Block DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block NETHERRACK_MYTHRIL_ORE = registerBlock("netherrack_mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);


    public static final Block MYTHRIL_BUTTON = registerBlock("mythril_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(4.0f).requiresTool().noCollision()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_PRESSURE_PLATE = registerBlock("mythril_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL)
                    .strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);


    public static final Block MYTHRIL_FENCE = registerBlock("mythril_fence",
            new FenceBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_FENCE_GATE = registerBlock("mythril_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_WALL = registerBlock("mythril_wall",
            new WallBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);


    public static final Block MYTHRIL_SLAB = registerBlock("mythril_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_STAIRS = registerBlock("mythril_stairs",
            new ModStairsBlock(ModBlocks.MYTHRIL_BLOCK.getDefaultState(),
                    FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block KAUPEN_DOOR = registerBlock("kaupen_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(4.0f).requiresTool().nonOpaque()), ModItemGroup.MYTHRIL);

    public static final Block KAUPEN_TRAPDOOR = registerBlock("kaupen_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
                    .strength(4.0f).requiresTool().nonOpaque()), ModItemGroup.MYTHRIL);


    public static final Block LILAC_FLOWER = registerBlock("lilac_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 12,
                    FabricBlockSettings.copy(Blocks.DANDELION).strength(4.0f).nonOpaque()), ModItemGroup.MYTHRIL);

    public static final Block POTTED_LILAC_FLOWER = registerBlockWithoutBlockItem("potted_lilac_flower",
            new FlowerPotBlock(ModBlocks.LILAC_FLOWER,
                    FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).nonOpaque()), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_LAMP = registerBlock("mythril_lamp",
            new MythrilLampBlock(FabricBlockSettings.of(Material.METAL)
                    .strength(4.0f).requiresTool()
                    .luminance((state) -> state.get(MythrilLampBlock.CLICKED) ? 15 : 0)
                    .sounds(ModSounds.MYTHRIL_SOUNDS)), ModItemGroup.MYTHRIL);


    public static final Block WINTER_WINDOW = registerBlock("winter_window",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(3.0f).nonOpaque()), ModItemGroup.MYTHRIL);

    public static final Block GRAPE_VINE = registerBlockWithoutBlockItem("grape_vine",
            new GrapeVineBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()), ModItemGroup.MYTHRIL);

    public static final Block JACARANDA_LOG = registerBlock("jacaranda_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block JACARANDA_WOOD = registerBlock("jacaranda_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block STRIPPED_JACARANDA_LOG = registerBlock("stripped_jacaranda_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);
    public static final Block STRIPPED_JACARANDA_WOOD = registerBlock("stripped_jacaranda_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block JACARANDA_PLANKS = registerBlock("jacaranda_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL);

    public static final Block JACARANDA_LEAVES = registerBlock("jacaranda_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()), ModItemGroup.MYTHRIL);

    public static final Block JACARANDA_SAPLING = registerBlock("jacaranda_sapling",
            new ModSaplingBlock(new JacarandaSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.MYTHRIL);

    public static final Block MYTHRIL_BLASTER = registerBlock("mythril_blaster",
            new MythrilBlasterBlock(FabricBlockSettings.of(Material.METAL).nonOpaque()), ModItemGroup.MYTHRIL);


    public static final Block JACARANDA_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("jacaranda_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.JACARANDA), ModItemGroup.MYTHRIL);

    public static final Block JACARANDA_SIGN_BLOCK = registerBlockWithoutBlockItem("jacaranda_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.JACARANDA), ModItemGroup.MYTHRIL);

    public static final Block HONEY_FLUID_BLOCK = registerBlockWithoutBlockItem("honey_fluid_block",
            new ModFluidBlock(ModFluids.HONEY_STILL, FabricBlockSettings.of(Material.WATER)
                    .noCollision().nonOpaque().dropsNothing()), ModItemGroup.MYTHRIL);


    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings().group(group)) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(new TranslatableText(tooltipKey));
                }
            });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
