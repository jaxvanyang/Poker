package jaxvanyang.poker;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import static jaxvanyang.poker.Constants.MOD_ID;

@Mod(MOD_ID)
public class Poker {

    public Poker(IEventBus eventBus) {
        CommonClass.init();

    }
}
