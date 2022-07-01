package cn.taskeren.mod.creon.datagen;

import cn.taskeren.mod.creon.CreonMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CreonMod.MODID)
public class CreonDataGen {

	@SubscribeEvent
	public static void register(GatherDataEvent event) {
		var generator = event.getGenerator();
		var helper = event.getExistingFileHelper();
		if(event.includeClient()) {
			generator.addProvider(new CreonItemModelProvider(generator, helper));
		}
		if(event.includeServer()) {
			generator.addProvider(new CreonRecipeProvider(generator));
			generator.addProvider(new CreonEnglishLanguageProvider(generator, "en_us"));
			generator.addProvider(new CreonChineseLanguageProvider(generator, "zh_cn"));
		}
	}

}

class CreonItemModelProvider extends ItemModelProvider {

	CreonItemModelProvider(DataGenerator g, ExistingFileHelper helper) {
		super(g, CreonMod.MODID, helper);
	}

	@Override
	protected void registerModels() {
		this.basicItem(CreonMod.CREON_ITEM.get());
	}
}

class CreonRecipeProvider extends RecipeProvider {

	public CreonRecipeProvider(DataGenerator g) {
		super(g);
	}

	@Override
	protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> recipe) {
		ShapelessRecipeBuilder.shapeless(CreonMod.CREON_ITEM.get(), 8)
				.requires(Items.ROTTEN_FLESH)
				.unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
				.save(recipe);
	}
}

class CreonEnglishLanguageProvider extends LanguageProvider {

	public CreonEnglishLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CreonMod.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		addItem(CreonMod.CREON_ITEM, "Creon Capsule");
		addEffect(CreonMod.CREON_EFFECT, "Creon");
	}
}

class CreonChineseLanguageProvider extends LanguageProvider {

	public CreonChineseLanguageProvider(DataGenerator gen, String locale) {
		super(gen, CreonMod.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		addItem(CreonMod.CREON_ITEM, "健胃消食片");
		addEffect(CreonMod.CREON_EFFECT, "健胃消食片");
	}
}