package codes.nion.tarot.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import codes.nion.tarot.block.FlippedCardBlock;
import codes.nion.tarot.TarotModVariables;
import codes.nion.tarot.TarotMod;

public class PlaceCardFromDeckProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				TarotMod.LOGGER.warn("Failed to load dependency direction for procedure PlaceCardFromDeck!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TarotMod.LOGGER.warn("Failed to load dependency entity for procedure PlaceCardFromDeck!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TarotMod.LOGGER.warn("Failed to load dependency x for procedure PlaceCardFromDeck!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TarotMod.LOGGER.warn("Failed to load dependency y for procedure PlaceCardFromDeck!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TarotMod.LOGGER.warn("Failed to load dependency z for procedure PlaceCardFromDeck!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TarotMod.LOGGER.warn("Failed to load dependency world for procedure PlaceCardFromDeck!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack card = ItemStack.EMPTY;
		String card_tag = "";
		double rnd = 0;
		double deck_size = 0;
		if ((!(world.isRemote()))) {
			if (((world.isAirBlock(
					new BlockPos((int) ((direction.getXOffset()) + x), (int) ((direction.getYOffset()) + y), (int) ((direction.getZOffset()) + z))))
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == (ItemStack.EMPTY).getItem()))) {
				card = GetRandomCardProcedure.executeProcedure(ImmutableMap.of("entity", entity, "x", x, "y", y, "z", z, "world", world));
				if ((!((card).getItem() == (ItemStack.EMPTY).getItem()))) {
					if ((entity.isSneaking())) {
						world.setBlockState(new BlockPos((int) ((direction.getXOffset()) + x), (int) ((direction.getYOffset()) + y),
								(int) ((direction.getZOffset()) + z)), FlippedCardBlock.block.getDefaultState(), 3);
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) ((direction.getXOffset()) + x),
									(int) ((direction.getYOffset()) + y), (int) ((direction.getZOffset()) + z)));
							if (_ent != null) {
								final int _sltid = (int) (0);
								final ItemStack _setstack = (card);
								_setstack.setCount((int) 1);
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else {
						world.setBlockState(new BlockPos((int) ((direction.getXOffset()) + x), (int) ((direction.getYOffset()) + y),
								(int) ((direction.getZOffset()) + z)), (new Object() {
									public BlockState toBlock(ItemStack _stk) {
										if (_stk.getItem() instanceof BlockItem) {
											return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
										}
										return Blocks.AIR.getDefaultState();
									}
								}.toBlock((card))), 3);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
					if ((TarotModVariables.ENABLE_INVERT_DECK && (Math.random() <= 0.5))) {
						try {
							BlockState _bs = world.getBlockState(new BlockPos((int) ((direction.getXOffset()) + x),
									(int) ((direction.getYOffset()) + y), (int) ((direction.getZOffset()) + z)));
							DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							if (_property != null) {
								world.setBlockState(new BlockPos((int) ((direction.getXOffset()) + x), (int) ((direction.getYOffset()) + y),
										(int) ((direction.getZOffset()) + z)), _bs.with(_property, (entity.getHorizontalFacing())), 3);
							} else {
								world.setBlockState(
										new BlockPos((int) ((direction.getXOffset()) + x), (int) ((direction.getYOffset()) + y),
												(int) ((direction.getZOffset()) + z)),
										_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
												(entity.getHorizontalFacing()).getAxis()),
										3);
							}
						} catch (Exception e) {
						}
					} else {
						try {
							BlockState _bs = world.getBlockState(new BlockPos((int) ((direction.getXOffset()) + x),
									(int) ((direction.getYOffset()) + y), (int) ((direction.getZOffset()) + z)));
							DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							if (_property != null) {
								world.setBlockState(
										new BlockPos((int) ((direction.getXOffset()) + x), (int) ((direction.getYOffset()) + y),
												(int) ((direction.getZOffset()) + z)),
										_bs.with(_property, ((entity.getHorizontalFacing()).getOpposite())), 3);
							} else {
								world.setBlockState(
										new BlockPos((int) ((direction.getXOffset()) + x), (int) ((direction.getYOffset()) + y),
												(int) ((direction.getZOffset()) + z)),
										_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
												((entity.getHorizontalFacing()).getOpposite()).getAxis()),
										3);
							}
						} catch (Exception e) {
						}
					}
				}
			}
		}
	}
}
