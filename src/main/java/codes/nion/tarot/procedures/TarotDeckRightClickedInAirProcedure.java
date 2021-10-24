package codes.nion.tarot.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import codes.nion.tarot.TarotModVariables;
import codes.nion.tarot.TarotMod;

public class TarotDeckRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TarotMod.LOGGER.warn("Failed to load dependency entity for procedure TarotDeckRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TarotMod.LOGGER.warn("Failed to load dependency x for procedure TarotDeckRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TarotMod.LOGGER.warn("Failed to load dependency y for procedure TarotDeckRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TarotMod.LOGGER.warn("Failed to load dependency z for procedure TarotDeckRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TarotMod.LOGGER.warn("Failed to load dependency world for procedure TarotDeckRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.isRemote()))) {
			if ((!(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
					entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getType() == RayTraceResult.Type.BLOCK))) {
				if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("tarot:tarot_card_items").toLowerCase(java.util.Locale.ENGLISH)))
						.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem()))) {
					{
						ItemStack _setval = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
						entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.broken_card = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (boolean) (true);
						entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.blockIsBrokenCard = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (AddBlockToDeckProcedure.executeProcedure(ImmutableMap.of("entity", entity, "x", x, "y", y, "z", z, "world", world))) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = (ItemStack.EMPTY);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else {
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
								capability.blockIsBrokenCard = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Already in deck"), (true));
						}
					}
				} else {
					if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == (ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = GetRandomCardProcedure
									.executeProcedure(ImmutableMap.of("entity", entity, "x", x, "y", y, "z", z, "world", world));
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					}
				}
			}
		}
	}
}
