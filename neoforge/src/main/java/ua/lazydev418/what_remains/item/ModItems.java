package ua.lazydev418.what_remains.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ua.lazydev418.what_remains.util.Constants;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    //public static final DeferredItem<Item> FIRE_SWORD = ITEMS.registerSimpleItem("fire_sword");

    public static final DeferredItem<Item> FIRE_SWORD = ITEMS.registerItem("fire_sword",
            properties -> new Item(properties.sword(ToolMaterial.NETHERITE, 3, -2.4f)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}