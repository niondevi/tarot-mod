package codes.nion.tarot.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import codes.nion.tarot.block.WheelOfFortuneBlock;
import codes.nion.tarot.block.TwoOfWandsBlock;
import codes.nion.tarot.block.TwoOfSwordsBlock;
import codes.nion.tarot.block.TwoOfPentaclesBlock;
import codes.nion.tarot.block.TwoOfCupsBlock;
import codes.nion.tarot.block.ThreeOfWandsBlock;
import codes.nion.tarot.block.ThreeOfSwordsBlock;
import codes.nion.tarot.block.ThreeOfPentaclesBlock;
import codes.nion.tarot.block.ThreeOfCupsBlock;
import codes.nion.tarot.block.TheWorldBlock;
import codes.nion.tarot.block.TheTowerBlock;
import codes.nion.tarot.block.TheSunBlock;
import codes.nion.tarot.block.TheStarBlock;
import codes.nion.tarot.block.TheMoonBlock;
import codes.nion.tarot.block.TheMagicianBlock;
import codes.nion.tarot.block.TheLoversBlock;
import codes.nion.tarot.block.TheHighPriestessBlock;
import codes.nion.tarot.block.TheHierophantBlock;
import codes.nion.tarot.block.TheHermitBlock;
import codes.nion.tarot.block.TheHangedManBlock;
import codes.nion.tarot.block.TheFoolBlock;
import codes.nion.tarot.block.TheEmpressBlock;
import codes.nion.tarot.block.TheEmperorBlock;
import codes.nion.tarot.block.TheDevilBlock;
import codes.nion.tarot.block.TheChariotBlock;
import codes.nion.tarot.block.TenOfWandsBlock;
import codes.nion.tarot.block.TenOfSwordsBlock;
import codes.nion.tarot.block.TenOfPentaclesBlock;
import codes.nion.tarot.block.TenOfCupsBlock;
import codes.nion.tarot.block.TemperanceBlock;
import codes.nion.tarot.block.StrengthBlock;
import codes.nion.tarot.block.SixOfWandsBlock;
import codes.nion.tarot.block.SixOfSwordsBlock;
import codes.nion.tarot.block.SixOfPentaclesBlock;
import codes.nion.tarot.block.SixOfCupsBlock;
import codes.nion.tarot.block.SevenOfWandsBlock;
import codes.nion.tarot.block.SevenOfSwordsBlock;
import codes.nion.tarot.block.SevenOfPentaclesBlock;
import codes.nion.tarot.block.SevenOfCupsBlock;
import codes.nion.tarot.block.QueenOfWandsBlock;
import codes.nion.tarot.block.QueenOfSwordsBlock;
import codes.nion.tarot.block.QueenOfPentaclesBlock;
import codes.nion.tarot.block.QueenOfCupsBlock;
import codes.nion.tarot.block.PageOfWandsBlock;
import codes.nion.tarot.block.PageOfSwordsBlock;
import codes.nion.tarot.block.PageOfPentaclesBlock;
import codes.nion.tarot.block.PageOfCupsBlock;
import codes.nion.tarot.block.NineOfWandsBlock;
import codes.nion.tarot.block.NineOfSwordsBlock;
import codes.nion.tarot.block.NineOfPentaclesBlock;
import codes.nion.tarot.block.NineOfCupsBlock;
import codes.nion.tarot.block.KnightOfWandsBlock;
import codes.nion.tarot.block.KnightOfSwordsBlock;
import codes.nion.tarot.block.KnightOfPentaclesBlock;
import codes.nion.tarot.block.KnightOfCupsBlock;
import codes.nion.tarot.block.KingOfWandsBlock;
import codes.nion.tarot.block.KingOfSwordsBlock;
import codes.nion.tarot.block.KingOfPentaclesBlock;
import codes.nion.tarot.block.KingOfCupsBlock;
import codes.nion.tarot.block.JusticeBlock;
import codes.nion.tarot.block.JudgementBlock;
import codes.nion.tarot.block.FourOfWandsBlock;
import codes.nion.tarot.block.FourOfSwordsBlock;
import codes.nion.tarot.block.FourOfPentaclesBlock;
import codes.nion.tarot.block.FourOfCupsBlock;
import codes.nion.tarot.block.FiveOfWandsBlock;
import codes.nion.tarot.block.FiveOfSwordsBlock;
import codes.nion.tarot.block.FiveOfPentaclesBlock;
import codes.nion.tarot.block.FiveOfCupsBlock;
import codes.nion.tarot.block.EightOfWandsBlock;
import codes.nion.tarot.block.EightOfSwordsBlock;
import codes.nion.tarot.block.EightOfPentaclesBlock;
import codes.nion.tarot.block.EightOfCupsBlock;
import codes.nion.tarot.block.DeathBlock;
import codes.nion.tarot.block.AceOfWandsBlock;
import codes.nion.tarot.block.AceOfSwordsBlock;
import codes.nion.tarot.block.AceOfPentaclesBlock;
import codes.nion.tarot.block.AceOfCupsBlock;
import codes.nion.tarot.TarotModVariables;
import codes.nion.tarot.TarotMod;

public class AddBlockToDeckProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TarotMod.LOGGER.warn("Failed to load dependency entity for procedure AddBlockToDeck!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TarotMod.LOGGER.warn("Failed to load dependency x for procedure AddBlockToDeck!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TarotMod.LOGGER.warn("Failed to load dependency y for procedure AddBlockToDeck!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TarotMod.LOGGER.warn("Failed to load dependency z for procedure AddBlockToDeck!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TarotMod.LOGGER.warn("Failed to load dependency world for procedure AddBlockToDeck!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack card = ItemStack.EMPTY;
		boolean added = false;
		double deck_size = 0;
		double total_cards = 0;
		added = (boolean) (false);
		if ((!(TarotModVariables.DISABLE_MINOR_ARCANA && TarotModVariables.DISABLE_MAJOR_ARCANA))) {
			total_cards = (double) 78;
			deck_size = (double) 78;
			if (TarotModVariables.DISABLE_MINOR_ARCANA) {
				deck_size = (double) 22;
			}
			if (TarotModVariables.DISABLE_MAJOR_ARCANA) {
				deck_size = (double) 56;
			}
			if ((!(world.isRemote()))) {
				if ((!(new Object() {
					public boolean getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ender")))) {
					if (((entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TarotModVariables.PlayerVariables())).blockIsBrokenCard)) {
						card = ((entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TarotModVariables.PlayerVariables())).broken_card);
					} else {
						card = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
					}
					if ((!TarotModVariables.DISABLE_MAJOR_ARCANA)) {/* MAJOR */
						if ((true)) {
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m0")) && ((card).getItem() == TheFoolBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m0", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m1")) && ((card).getItem() == TheMagicianBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m1", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m2")) && ((card).getItem() == TheHighPriestessBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m2", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m3")) && ((card).getItem() == TheEmpressBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m3", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m4")) && ((card).getItem() == TheEmperorBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m4", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m5")) && ((card).getItem() == TheHierophantBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m5", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m6")) && ((card).getItem() == TheLoversBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m6", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m7")) && ((card).getItem() == TheChariotBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m7", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m8")) && ((card).getItem() == StrengthBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m8", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m9")) && ((card).getItem() == TheHermitBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m9", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m10")) && ((card).getItem() == WheelOfFortuneBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m10", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m11")) && ((card).getItem() == JusticeBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m11", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m12")) && ((card).getItem() == TheHangedManBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m12", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m13")) && ((card).getItem() == DeathBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m13", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m14")) && ((card).getItem() == TemperanceBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m14", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m15")) && ((card).getItem() == TheDevilBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m15", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m16")) && ((card).getItem() == TheTowerBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m16", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m17")) && ((card).getItem() == TheStarBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m17", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m18")) && ((card).getItem() == TheMoonBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m18", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m19")) && ((card).getItem() == TheSunBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m19", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m20")) && ((card).getItem() == JudgementBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m20", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m21")) && ((card).getItem() == TheWorldBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m21", (false));
								added = (boolean) (true);
							}
						}
					}
					if ((!TarotModVariables.DISABLE_MINOR_ARCANA)) {/* CUPS */
						if ((true)) {
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m22")) && ((card).getItem() == AceOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m22", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m23")) && ((card).getItem() == TwoOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m23", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m24")) && ((card).getItem() == ThreeOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m24", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m25")) && ((card).getItem() == FourOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m25", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m26")) && ((card).getItem() == FiveOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m26", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m27")) && ((card).getItem() == SixOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m27", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m28")) && ((card).getItem() == SevenOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m28", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m29")) && ((card).getItem() == EightOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m29", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m30")) && ((card).getItem() == NineOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m30", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m31")) && ((card).getItem() == TenOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m31", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m32")) && ((card).getItem() == PageOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m32", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m33")) && ((card).getItem() == KnightOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m33", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m34")) && ((card).getItem() == QueenOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m34", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m35")) && ((card).getItem() == KingOfCupsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m35", (false));
								added = (boolean) (true);
							}
						} /* PENTACLES */
						if ((true)) {
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m36")) && ((card).getItem() == AceOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m36", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m37")) && ((card).getItem() == TwoOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m37", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m38")) && ((card).getItem() == ThreeOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m38", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m39")) && ((card).getItem() == FourOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m39", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m40")) && ((card).getItem() == FiveOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m40", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m41")) && ((card).getItem() == SixOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m41", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m42")) && ((card).getItem() == SevenOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m42", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m43")) && ((card).getItem() == EightOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m43", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m44")) && ((card).getItem() == NineOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m44", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m45")) && ((card).getItem() == TenOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m45", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m46")) && ((card).getItem() == PageOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m46", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m47")) && ((card).getItem() == KnightOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m47", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m48")) && ((card).getItem() == QueenOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m48", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m49")) && ((card).getItem() == KingOfPentaclesBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m49", (false));
								added = (boolean) (true);
							}
						} /* SWORDS */
						if ((true)) {
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m50")) && ((card).getItem() == AceOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m50", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m51")) && ((card).getItem() == TwoOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m51", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m52")) && ((card).getItem() == ThreeOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m52", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m53")) && ((card).getItem() == FourOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m53", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m54")) && ((card).getItem() == FiveOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m54", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m55")) && ((card).getItem() == SixOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m55", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m56")) && ((card).getItem() == SevenOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m56", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m57")) && ((card).getItem() == EightOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m57", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m58")) && ((card).getItem() == NineOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m58", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m59")) && ((card).getItem() == TenOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m59", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m60")) && ((card).getItem() == PageOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m60", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m61")) && ((card).getItem() == KnightOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m61", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m62")) && ((card).getItem() == QueenOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m62", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m63")) && ((card).getItem() == KingOfSwordsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m63", (false));
								added = (boolean) (true);
							}
						} /* WANDS */
						if ((true)) {
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m64")) && ((card).getItem() == AceOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m64", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m65")) && ((card).getItem() == TwoOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m65", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m66")) && ((card).getItem() == ThreeOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m66", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m67")) && ((card).getItem() == FourOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m67", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m68")) && ((card).getItem() == FiveOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m68", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m69")) && ((card).getItem() == SixOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m69", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m70")) && ((card).getItem() == SevenOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m70", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m71")) && ((card).getItem() == EightOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m71", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m72")) && ((card).getItem() == NineOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m72", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m73")) && ((card).getItem() == TenOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m73", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m74")) && ((card).getItem() == PageOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m74", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m75")) && ((card).getItem() == KnightOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m75", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m76")) && ((card).getItem() == QueenOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m76", (false));
								added = (boolean) (true);
							}
							if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getOrCreateTag().getBoolean("m77")) && ((card).getItem() == KingOfWandsBlock.block.asItem()))) {
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.putBoolean("m77", (false));
								added = (boolean) (true);
							}
						}
					}
					if (added) {
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("missing",
										((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("missing")) - 1));
						if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getDisplayName()
								.getString()).contains("Empty "))) {
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
									.setDisplayName(new StringTextComponent(
											((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
													.getDisplayName().getString()).replace("Empty ", ""))));
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent((((new java.text.DecimalFormat("##").format((deck_size
											- (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
													.getOrCreateTag().getDouble("missing"))))))
											+ ""
											+ (((" / ") + ""
													+ ((((new java.text.DecimalFormat("##").format(deck_size))) + "" + (" cards in deck"))))))),
									(true));
						}
						(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
								(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getOrCreateTag().getDouble("missing")) / deck_size) * total_cards));
						if ((!((entity.getCapability(TarotModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TarotModVariables.PlayerVariables())).blockIsBrokenCard))) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						}
					}
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
				}
			}
		}
		return added;
	}
}
