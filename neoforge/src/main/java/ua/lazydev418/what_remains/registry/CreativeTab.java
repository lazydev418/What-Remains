package ua.lazydev418.what_remains.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.block.ModBlocks;
import ua.lazydev418.what_remains.item.ModItems;
import ua.lazydev418.what_remains.util.Constants;

import java.util.function.Supplier;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final Supplier<CreativeModeTab> WHAT_REMAINS_TAB = CREATIVE_MODE_TABS.register("what_remains_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FIRE_CRYSTAL))
                    .title(Component.translatable("gui.creative_tab.what_remains"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RUINS_BRICKS);
                        output.accept(ModBlocks.RUINS_BRICKS_STAIRS);
                        output.accept(ModBlocks.RUINS_BRICKS_SLAB);
                        output.accept(ModBlocks.RUINS_BRICKS_WALL);

                        output.accept(ModBlocks.RUINS_BRICKS_CRACKED);
                        output.accept(ModBlocks.RUINS_BRICKS_CRACKED_STAIRS);
                        output.accept(ModBlocks.RUINS_BRICKS_CRACKED_SLAB);
                        output.accept(ModBlocks.RUINS_BRICKS_CRACKED_WALL);

                        output.accept(ModBlocks.RUINS_BRICKS_MOSSY);
                        output.accept(ModBlocks.RUINS_BRICKS_MOSSY_STAIRS);
                        output.accept(ModBlocks.RUINS_BRICKS_MOSSY_SLAB);
                        output.accept(ModBlocks.RUINS_BRICKS_MOSSY_WALL);
                        
                        output.accept(ModBlocks.TALL_TORCH);
                        output.accept(ModBlocks.RUINS_STATUE);
                        output.accept(ModBlocks.RUINS_FIRE);
                        output.accept(ModBlocks.RUINS_FIREPLACE_VASE);
                        output.accept(ModBlocks.FIRE_CRYSTAL);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
