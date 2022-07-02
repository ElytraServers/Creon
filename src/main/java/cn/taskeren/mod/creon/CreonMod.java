package cn.taskeren.mod.creon;

import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(CreonMod.MODID)
public class CreonMod {

	public static final String MODID = "creon";
	private static final Logger LOGGER = LogUtils.getLogger();

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);

	public static final RegistryObject<Item> CREON_ITEM = ITEMS.register("creon", CreonItem::new);
	public static final RegistryObject<Item> CREON_ULTIMATE_ITEM = ITEMS.register("creon_ultimate", CreonUltimateItem::new);
	public static final RegistryObject<MobEffect> CREON_EFFECT = EFFECT.register("creon", CreonEffect::new);
	public static final RegistryObject<MobEffect> CREON_ULTIMATE_EFFECT = EFFECT.register("creon_ultimate", CreonUltimateEffect::new);

	public CreonMod() {
		LOGGER.info("Creon is now available in drugstores.");

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ITEMS.register(modEventBus);
		EFFECT.register(modEventBus);
	}
}
