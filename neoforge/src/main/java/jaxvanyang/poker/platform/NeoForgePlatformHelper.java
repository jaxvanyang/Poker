package jaxvanyang.poker.platform;

import jaxvanyang.poker.Constants;
import jaxvanyang.poker.entity.SeatEntity;
import jaxvanyang.poker.platform.services.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgePlatformHelper implements IPlatformHelper {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(
            BuiltInRegistries.ENTITY_TYPE,
            Constants.MOD_ID
    );

    public static final Supplier<EntityType<SeatEntity>> SEAT = ENTITY_TYPES.register(
            "seat",
            () -> EntityType.Builder.of(
                    SeatEntity::new,
                    MobCategory.MISC
            ).sized(0, 0).build("seat")
    );

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public EntityType<SeatEntity> getSeatEntityType() {
        return SEAT.get();
    }
}
