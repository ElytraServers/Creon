package cn.taskeren.mod.creon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CreonItem extends Item {

	private static final FoodProperties foodProp = new FoodProperties.Builder()
			.nutrition(1)
			.saturationMod(0.1F)
			.alwaysEat()
			.fast()
			.effect(() -> new MobEffectInstance(CreonMod.CREON_EFFECT.get(), 400), 1.0F)
			.build();

	private static final Item.Properties prop = new Item.Properties()
			.food(foodProp)
			.tab(CreativeModeTab.TAB_BREWING);

	public CreonItem() {
		super(prop);
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
		if(player.hasEffect(CreonMod.CREON_EFFECT.get())) {
			return InteractionResultHolder.pass(player.getItemInHand(hand));
		}
		return super.use(level, player, hand);
	}
}
