package codes.nion.tarot.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import codes.nion.tarot.TarotModVariables;
import codes.nion.tarot.TarotMod;

public class InitPlayerProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TarotMod.LOGGER.warn("Failed to load dependency entity for procedure InitPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			ItemStack _setval = (ItemStack.EMPTY);
			entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.broken_card = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (boolean) (false);
			entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.broken_card_was_ender = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
