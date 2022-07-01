package cn.taskeren.mod.creon;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class CreonEffect extends MobEffect {

	protected CreonEffect() {
		super(MobEffectCategory.NEUTRAL, 1);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		if(entity instanceof Player player) {
			if(player.getFoodData().getFoodLevel() > 2) {
				player.causeFoodExhaustion(0.5F * (float) (amplifier + 1));
			} else {
				player.removeEffect(CreonMod.CREON_EFFECT.get());
			}
		}
	}

	@Override
	public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
		return true;
	}
}
