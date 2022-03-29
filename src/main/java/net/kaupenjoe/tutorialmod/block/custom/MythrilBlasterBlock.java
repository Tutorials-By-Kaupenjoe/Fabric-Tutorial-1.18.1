package net.kaupenjoe.tutorialmod.block.custom;

import net.kaupenjoe.tutorialmod.block.entity.ModBlockEntities;
import net.kaupenjoe.tutorialmod.block.entity.MythrilBlasterBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class MythrilBlasterBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public MythrilBlasterBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(13, 0, 0, 16, 3, 3),
            Block.createCuboidShape(13, 0, 13, 16, 3, 16),
            Block.createCuboidShape(0, 0, 13, 3, 3, 16),
            Block.createCuboidShape(0, 0, 0, 3, 3, 3),
            Block.createCuboidShape(3, 2, 4, 13, 6, 5),
            Block.createCuboidShape(2, 0, 1, 14, 2, 14),
            Block.createCuboidShape(3, 0, 15, 13, 2, 16),
            Block.createCuboidShape(3, 2, 5, 13, 14, 14),
            Block.createCuboidShape(3, 0, 14, 13, 7, 15),
            Block.createCuboidShape(4, 13, 7, 12, 15, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(13, 0, 13, 16, 3, 16),
            Block.createCuboidShape(0, 0, 13, 3, 3, 16),
            Block.createCuboidShape(0, 0, 0, 3, 3, 3),
            Block.createCuboidShape(13, 0, 0, 16, 3, 3),
            Block.createCuboidShape(11, 2, 3, 12, 6, 13),
            Block.createCuboidShape(2, 0, 2, 15, 2, 14),
            Block.createCuboidShape(0, 0, 3, 1, 2, 13),
            Block.createCuboidShape(2, 2, 3, 11, 14, 13),
            Block.createCuboidShape(1, 0, 3, 2, 7, 13),
            Block.createCuboidShape(3, 13, 4, 9, 15, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(0, 0, 13, 3, 3, 16),
            Block.createCuboidShape(0, 0, 0, 3, 3, 3),
            Block.createCuboidShape(13, 0, 0, 16, 3, 3),
            Block.createCuboidShape(13, 0, 13, 16, 3, 16),
            Block.createCuboidShape(3, 2, 11, 13, 6, 12),
            Block.createCuboidShape(2, 0, 2, 14, 2, 15),
            Block.createCuboidShape(3, 0, 0, 13, 2, 1),
            Block.createCuboidShape(3, 2, 2, 13, 14, 11),
            Block.createCuboidShape(3, 0, 1, 13, 7, 2),
            Block.createCuboidShape(4, 13, 3, 12, 15, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(0, 0, 0, 3, 3, 3),
            Block.createCuboidShape(13, 0, 0, 16, 3, 3),
            Block.createCuboidShape(13, 0, 13, 16, 3, 16),
            Block.createCuboidShape(0, 0, 13, 3, 3, 16),
            Block.createCuboidShape(4, 2, 3, 5, 6, 13),
            Block.createCuboidShape(1, 0, 2, 14, 2, 14),
            Block.createCuboidShape(15, 0, 3, 16, 2, 13),
            Block.createCuboidShape(5, 2, 3, 14, 14, 13),
            Block.createCuboidShape(14, 0, 3, 15, 7, 13),
            Block.createCuboidShape(7, 13, 4, 13, 15, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /* BLOCK ENTITY */

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MythrilBlasterBlockEntity) {
                ItemScatterer.spawn(world, pos, (MythrilBlasterBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MythrilBlasterBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.MYTHRIL_BLASTER, MythrilBlasterBlockEntity::tick);
    }
}
