package codes.nion.tarot.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import codes.nion.tarot.TarotModVariables;

import java.util.Map;
import java.util.Collections;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class LoadConfigsProcedure {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			executeProcedure(Collections.emptyMap());
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		File cfgfile = new File("");
		cfgfile = new File(((FMLPaths.GAMEDIR.get().toString()) + "" + (((File.separator) + "" + ("config")))), File.separator + "tarot.json");
		if (cfgfile.exists()) {
			{
				try {
					BufferedReader cfgfileReader = new BufferedReader(new FileReader(cfgfile));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = cfgfileReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					cfgfileReader.close();
					JsonObject tarot = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
					if (tarot.has("DisableMajorArcana")) {
						TarotModVariables.DISABLE_MAJOR_ARCANA = (boolean) tarot.get("DisableMajorArcana").getAsBoolean();
					} else {
						TarotModVariables.DISABLE_MAJOR_ARCANA = (boolean) false;
					}
					if (tarot.has("DisableMinorArcana")) {
						TarotModVariables.DISABLE_MINOR_ARCANA = (boolean) tarot.get("DisableMinorArcana").getAsBoolean();
					} else {
						TarotModVariables.DISABLE_MINOR_ARCANA = (boolean) false;
					}
					if (tarot.has("EnableReversedCardPlacementFromDeck")) {
						TarotModVariables.ENABLE_INVERT_DECK = (boolean) tarot.get("EnableReversedCardPlacementFromDeck").getAsBoolean();
					} else {
						TarotModVariables.ENABLE_INVERT_DECK = (boolean) true;
					}
					if (tarot.has("EnableReversedCardPlacementFromEnderCard")) {
						TarotModVariables.ENABLE_INVERT_ENDER = (boolean) tarot.get("EnableReversedCardPlacementFromEnderCard").getAsBoolean();
					} else {
						TarotModVariables.ENABLE_INVERT_ENDER = (boolean) true;
					}
					if (tarot.has("WitchCardDropRate")) {
						TarotModVariables.WITCH_CARD_DROP = (double) tarot.get("WitchCardDropRate").getAsDouble();
					} else {
						TarotModVariables.WITCH_CARD_DROP = (double) 0.15;
					}
					if (tarot.has("WitchEnderCardChance")) {
						TarotModVariables.WITCH_ENDER_CHANCE = (double) tarot.get("WitchEnderCardChance").getAsDouble();
					} else {
						TarotModVariables.WITCH_ENDER_CHANCE = (double) 0.1;
					}
					if (tarot.has("WanderingTraderDeckSellChance")) {
						TarotModVariables.WANDERING_SELL_DECK_CHANCE = (double) tarot.get("WanderingTraderDeckSellChance").getAsDouble();
					} else {
						TarotModVariables.WANDERING_SELL_DECK_CHANCE = (double) 0.1;
					}
					if (tarot.has("WanderingTraderDeckPrice")) {
						TarotModVariables.WANDERING_SELL_DECK_PRICE = (double) tarot.get("WanderingTraderDeckPrice").getAsDouble();
					} else {
						TarotModVariables.WANDERING_SELL_DECK_PRICE = (double) 4.00;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		cfgfile = new File(((FMLPaths.GAMEDIR.get().toString()) + "" + (((File.separator) + "" + ("config")))), File.separator + "tarot.json");
		if (!cfgfile.exists()) {
			try {
				cfgfile.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			JsonObject tarot = new JsonObject();
			tarot.addProperty("DisableMajorArcana", (boolean) TarotModVariables.DISABLE_MAJOR_ARCANA);
			tarot.addProperty("DisableMinorArcana", (boolean) TarotModVariables.DISABLE_MINOR_ARCANA);
			tarot.addProperty("EnableReversedCardPlacementFromDeck", (boolean) TarotModVariables.ENABLE_INVERT_DECK);
			tarot.addProperty("EnableReversedCardPlacementFromEnderCard", (boolean) TarotModVariables.ENABLE_INVERT_ENDER);
			tarot.addProperty("WitchCardDropRate", (double) TarotModVariables.WITCH_CARD_DROP);
			tarot.addProperty("WitchEnderCardChance", (double) TarotModVariables.WITCH_ENDER_CHANCE);
			tarot.addProperty("WanderingTraderDeckSellChance", (double) TarotModVariables.WANDERING_SELL_DECK_CHANCE);
			tarot.addProperty("WanderingTraderDeckPrice", (double) TarotModVariables.WANDERING_SELL_DECK_PRICE);
			try {
				FileWriter cfgfilefw = new FileWriter(cfgfile);
				cfgfilefw.write(mainGSONBuilderVariable.toJson(tarot));
				cfgfilefw.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
