package cn.taskeren.mod.creon;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
				player.getAbilities().invulnerable = duration > 1;
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
