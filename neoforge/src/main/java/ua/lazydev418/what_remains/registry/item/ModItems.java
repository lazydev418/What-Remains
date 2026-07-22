package ua.lazydev418.what_remains.registry.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.util.Constants;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    //public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}