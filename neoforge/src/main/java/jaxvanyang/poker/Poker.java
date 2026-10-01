package jaxvanyang.poker;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static jaxvanyang.poker.Constants.MOD_ID;

@Mod(MOD_ID)
public class Poker {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            MOD_ID
    );

    public static final DeferredBlock<Block> POKER_TABLE = BLOCKS.registerBlock(
            "poker_table",
            jaxvanyang.poker.block.PokerTable::new
    );
    public static final DeferredItem<BlockItem> POKER_TABLE_ITEM = ITEMS.registerSimpleBlockItem(
            "poker_table",
            POKER_TABLE
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> POKER_TAB = CREATIVE_MODE_TABS.register(
            "poker_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.jaxvanyang_poker"))
                    .icon(() -> POKER_TABLE_ITEM.get().getDefaultInstance())
                    .displayItems((p, output) -> {
                        output.accept(POKER_TABLE_ITEM);
                    })
                    .build()
    );


    public Poker(IEventBus eventBus) {
        CommonClass.init();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
