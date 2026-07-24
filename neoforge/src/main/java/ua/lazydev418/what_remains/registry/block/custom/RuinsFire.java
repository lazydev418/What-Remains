package ua.lazydev418.what_remains.registry.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;
import ua.lazydev418.what_remains.registry.blockentity.ModBlockEntities;
import ua.lazydev418.what_remains.registry.blockentity.custom.FireCrystalBlockEntity;
import ua.lazydev418.what_remains.registry.blockentity.custom.RuinsFireBlockEntity;

public class RuinsFire extends BaseEntityBlock {
    public static final MapCodec<RuinsFire> CODEC = simpleCodec(RuinsFire::new);

    public static final IntegerProperty STATE = IntegerProperty.create("state", 0, 2);

    public RuinsFire(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(STATE, 2));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STATE);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(STATE, 0);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new RuinsFireBlockEntity(blockPos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.RUINS_FIRE_BLOCK_ENTITY.get(),
                RuinsFireBlockEntity::tick);
    }
}
