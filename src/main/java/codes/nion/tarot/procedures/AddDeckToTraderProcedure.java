package codes.nion.tarot.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import codes.nion.tarot.TarotModVariables;
import codes.nion.tarot.TarotMod;

public class AddDeckToTraderProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			if (event.getHand() != sourceentity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TarotMod.LOGGER.warn("Failed to load dependency entity for procedure AddDeckToTrader!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TarotMod.LOGGER.warn("Failed to load dependency world for procedure AddDeckToTrader!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((!(world.isRemote())) && (entity instanceof WanderingTraderEntity))) {
			if ((Math.random() < TarotModVariables.WANDERING_SELL_DECK_CHANCE)) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								(("data modify entity @e[type=minecraft:wandering_trader,tag=!tarot_vendor,limit=1] Offers.Recipes append value {MaxUses:1, buy:{id:\"minecraft:emerald\", Count:")
										+ "" + ((((new java.text.DecimalFormat("##").format(TarotModVariables.WANDERING_SELL_DECK_PRICE))) + ""
												+ ("b}, sell:{id:\"tarot:tarot_deck\", Count:1b, xp:0, priceMultiplier:0.00f, specialPrice:0, demand:0, rewardxp:0}}")))));
					}
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"data modify entity @e[type=minecraft:wandering_trader,tag=!tarot_vendor,limit=1] Tags append value \"tarot_vendor\"");
				}
			}
		}
	}
}
