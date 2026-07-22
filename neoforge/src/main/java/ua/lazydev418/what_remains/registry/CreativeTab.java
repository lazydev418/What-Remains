package ua.lazydev418.what_remains.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.util.Constants;

import java.util.function.Supplier;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final Supplier<CreativeModeTab> WHAT_REMAINS_TAB = CREATIVE_MODE_TABS.register("what_remains_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.END_CRYSTAL.asItem())) // Тимчасова іконка.
                    .title(Component.translatable("gui.creative_tab.what_remains"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.GLOW_ITEM_FRAME); // Тимчасово.
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
