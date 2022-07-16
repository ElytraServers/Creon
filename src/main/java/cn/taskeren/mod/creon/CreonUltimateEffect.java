package cn.taskeren.mod.creon;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.jetbrains.annotations.NotNull;

public class CreonUltimateEffect extends MobEffect {

	protected CreonUltimateEffect() {
		super(MobEffectCategory.NEUTRAL, 1);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		var duration = entity.getEffect(CreonMod.CREON_ULTIMATE_EFFECT.get()).getDuration();

		if(entity instanceof Player player) {
			if(player.getFoodData().getFoodLevel() > 2) {
				FoodData fd = player.getFoodData();
				if(fd.getFoodLevel() > 19) {
					fd.setFoodLevel(19);
				}
			} else {
				player.removeEffect(CreonMod.CREON_ULTIMATE_EFFECT.get());
			}
		}
	}

	@Override
	public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
		return true;
	}
}
