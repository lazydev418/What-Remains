package ua.lazydev418.what_remains.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import ua.lazydev418.what_remains.blockentity.ModBlockEntities;
import ua.lazydev418.what_remains.blockentity.custom.FireCrystalBlockEntity;

public class FireCrystal extends BaseEntityBlock {
    public static final MapCodec<FireCrystal> CODEC = simpleCodec(FireCrystal::new);

    public FireCrystal(Properties properties) {
        super(properties.destroyTime(100.0F).noOcclusion());
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state) {
        return new FireCrystalBlockEntity(blockPos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (!level.isClientSide()) {
            if (level.getBlockEntity(pos) instanceof FireCrystalBlockEntity crystal) {
                ItemStack mainHand = player.getMainHandItem();
                float damage = calculateDamage(mainHand);

                if (damage > 0.0F) {
                    crystal.dealDamage(damage);
                }
            }
        }

        super.attack(state, level, pos, player);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.FIRE_CRYSTAL_BLOCK_ENTITY.get(), FireCrystalBlockEntity::tick);
    }


    private float calculateDamage(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0.0F;
        }

        if (stack.is(ItemTags.PICKAXES)) {
            if (stack.is(Items.NETHERITE_PICKAXE)) return 12.0F;
            if (stack.is(Items.DIAMOND_PICKAXE)) return 8.0F;
            if (stack.is(Items.IRON_PICKAXE)) return 6.0F;
            if (stack.is(Items.STONE_PICKAXE)) return 4.0F;
            return 2.5F;
        }

        if (stack.is(ItemTags.SWORDS)) {
            if (stack.is(Items.NETHERITE_SWORD)) return 5.0F;
            if (stack.is(Items.DIAMOND_SWORD)) return 3.0F;
            return 1.0F;
        }

        return 0.5F;
    }
}
