package codes.nion.tarot.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import codes.nion.tarot.block.EnderTarotCardBlock;
import codes.nion.tarot.TarotModVariables;
import codes.nion.tarot.TarotMod;

public class CardBlockDestroyedByPlayerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TarotMod.LOGGER.warn("Failed to load dependency entity for procedure CardBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TarotMod.LOGGER.warn("Failed to load dependency x for procedure CardBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TarotMod.LOGGER.warn("Failed to load dependency y for procedure CardBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TarotMod.LOGGER.warn("Failed to load dependency z for procedure CardBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TarotMod.LOGGER.warn("Failed to load dependency world for procedure CardBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack card = ItemStack.EMPTY;
		if ((!(world.isRemote()))) {
			if (((entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TarotModVariables.PlayerVariables())).broken_card_was_ender)) {
				card = new ItemStack(EnderTarotCardBlock.block);
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.broken_card_was_ender = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				card = ((entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TarotModVariables.PlayerVariables())).broken_card);
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.blockIsBrokenCard = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (AddBlockToDeckProcedure.executeProcedure(ImmutableMap.of("entity", entity, "x", x, "y", y, "z", z, "world", world))) {
					card = (ItemStack.EMPTY);
				}
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, (card));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
