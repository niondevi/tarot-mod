package codes.nion.tarot.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.Map;

import codes.nion.tarot.item.TarotDeckItem;
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
import codes.nion.tarot.block.EnderTarotCardBlock;
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

public class GetRandomCardProcedure {
	public static ItemStack executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TarotMod.LOGGER.warn("Failed to load dependency entity for procedure GetRandomCard!");
			return ItemStack.EMPTY;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TarotMod.LOGGER.warn("Failed to load dependency x for procedure GetRandomCard!");
			return ItemStack.EMPTY;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TarotMod.LOGGER.warn("Failed to load dependency y for procedure GetRandomCard!");
			return ItemStack.EMPTY;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TarotMod.LOGGER.warn("Failed to load dependency z for procedure GetRandomCard!");
			return ItemStack.EMPTY;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TarotMod.LOGGER.warn("Failed to load dependency world for procedure GetRandomCard!");
			return ItemStack.EMPTY;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack card = ItemStack.EMPTY;
		String card_tag = "";
		boolean placingFromDeck = false;
		double deck_size = 0;
		double rnd = 0;
		double total_cards = 0;
		double ctr = 0;
		double missing_ctr = 0;
		card = (ItemStack.EMPTY);
		if ((!(TarotModVariables.DISABLE_MINOR_ARCANA && TarotModVariables.DISABLE_MAJOR_ARCANA))) {
			total_cards = (double) 78;
			deck_size = (double) 78;
			if (TarotModVariables.DISABLE_MINOR_ARCANA) {
				deck_size = (double) 22;
			}
			if (TarotModVariables.DISABLE_MAJOR_ARCANA) {
				deck_size = (double) 56;
			}
			rnd = (double) Math.floor((Math.random() * deck_size));
			if (TarotModVariables.DISABLE_MAJOR_ARCANA) {
				rnd = (double) (rnd + 22);
			}
			placingFromDeck = (boolean) (false);
			if (((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == EnderTarotCardBlock.block)) && ((!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) && ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == TarotDeckItem.block)
					&& ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("missing")) < deck_size))))) {
				ctr = (double) 0;
				if (TarotModVariables.DISABLE_MAJOR_ARCANA) {
					ctr = (double) 22;
				}
				missing_ctr = (double) Math.floor((Math.random()
						* (deck_size - (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getOrCreateTag().getDouble("missing")))));
				for (int index0 = 0; index0 < (int) (deck_size); index0++) {
					if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.getBoolean((("m") + "" + ((new java.text.DecimalFormat("##").format(ctr)))))) == (false))) {
						if ((missing_ctr <= 0)) {
							card_tag = (String) (("m") + "" + ((new java.text.DecimalFormat("##").format(ctr))));
							rnd = (double) ctr;
							break;
						}
						missing_ctr = (double) (missing_ctr - 1);
					}
					ctr = (double) (ctr + 1);
				}
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putBoolean(card_tag, (true));
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.putDouble("missing", ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getOrCreateTag().getDouble("missing")) + 1));
				if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.getDouble("missing")) == deck_size)) {
					if ((!((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getDisplayName()
							.getString()).contains("Empty ")))) {
						(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
								.setDisplayName(new StringTextComponent((("Empty ") + ""
										+ ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getDisplayName().getString())))));
					}
				}
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
						.setDamage((int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getOrCreateTag().getDouble("missing")) / deck_size) * total_cards));
				placingFromDeck = (boolean) (true);
			}
			if ((((entity instanceof AgeableEntity)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == EnderTarotCardBlock.block))
					|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == TarotDeckItem.block) && (placingFromDeck || (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayerEntity) {
										return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
									} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
										NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
												.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
										return _npi != null && _npi.getGameType() == GameType.CREATIVE;
									}
									return false;
								}
							}.checkGamemode(entity)))))) {/* MAJOR */
				if ((true)) {
					if ((rnd == 0)) {
						card = new ItemStack(TheFoolBlock.block);
					}
					if ((rnd == 1)) {
						card = new ItemStack(TheMagicianBlock.block);
					}
					if ((rnd == 2)) {
						card = new ItemStack(TheHighPriestessBlock.block);
					}
					if ((rnd == 3)) {
						card = new ItemStack(TheEmpressBlock.block);
					}
					if ((rnd == 4)) {
						card = new ItemStack(TheEmperorBlock.block);
					}
					if ((rnd == 5)) {
						card = new ItemStack(TheHierophantBlock.block);
					}
					if ((rnd == 6)) {
						card = new ItemStack(TheLoversBlock.block);
					}
					if ((rnd == 7)) {
						card = new ItemStack(TheChariotBlock.block);
					}
					if ((rnd == 8)) {
						card = new ItemStack(StrengthBlock.block);
					}
					if ((rnd == 9)) {
						card = new ItemStack(TheHermitBlock.block);
					}
					if ((rnd == 10)) {
						card = new ItemStack(WheelOfFortuneBlock.block);
					}
					if ((rnd == 11)) {
						card = new ItemStack(JusticeBlock.block);
					}
					if ((rnd == 12)) {
						card = new ItemStack(TheHangedManBlock.block);
					}
					if ((rnd == 13)) {
						card = new ItemStack(DeathBlock.block);
					}
					if ((rnd == 14)) {
						card = new ItemStack(TemperanceBlock.block);
					}
					if ((rnd == 15)) {
						card = new ItemStack(TheDevilBlock.block);
					}
					if ((rnd == 16)) {
						card = new ItemStack(TheTowerBlock.block);
					}
					if ((rnd == 17)) {
						card = new ItemStack(TheStarBlock.block);
					}
					if ((rnd == 18)) {
						card = new ItemStack(TheMoonBlock.block);
					}
					if ((rnd == 19)) {
						card = new ItemStack(TheSunBlock.block);
					}
					if ((rnd == 20)) {
						card = new ItemStack(JudgementBlock.block);
					}
					if ((rnd == 21)) {
						card = new ItemStack(TheWorldBlock.block);
					}
				} /* CUPS */
				if ((true)) {
					if ((rnd == 22)) {
						card = new ItemStack(AceOfCupsBlock.block);
					}
					if ((rnd == 23)) {
						card = new ItemStack(TwoOfCupsBlock.block);
					}
					if ((rnd == 24)) {
						card = new ItemStack(ThreeOfCupsBlock.block);
					}
					if ((rnd == 25)) {
						card = new ItemStack(FourOfCupsBlock.block);
					}
					if ((rnd == 26)) {
						card = new ItemStack(FiveOfCupsBlock.block);
					}
					if ((rnd == 27)) {
						card = new ItemStack(SixOfCupsBlock.block);
					}
					if ((rnd == 28)) {
						card = new ItemStack(SevenOfCupsBlock.block);
					}
					if ((rnd == 29)) {
						card = new ItemStack(EightOfCupsBlock.block);
					}
					if ((rnd == 30)) {
						card = new ItemStack(NineOfCupsBlock.block);
					}
					if ((rnd == 31)) {
						card = new ItemStack(TenOfCupsBlock.block);
					}
					if ((rnd == 32)) {
						card = new ItemStack(PageOfCupsBlock.block);
					}
					if ((rnd == 33)) {
						card = new ItemStack(KnightOfCupsBlock.block);
					}
					if ((rnd == 34)) {
						card = new ItemStack(QueenOfCupsBlock.block);
					}
					if ((rnd == 35)) {
						card = new ItemStack(KingOfCupsBlock.block);
					}
				} /* PENTACLES */
				if ((true)) {
					if ((rnd == 36)) {
						card = new ItemStack(AceOfPentaclesBlock.block);
					}
					if ((rnd == 37)) {
						card = new ItemStack(TwoOfPentaclesBlock.block);
					}
					if ((rnd == 38)) {
						card = new ItemStack(ThreeOfPentaclesBlock.block);
					}
					if ((rnd == 39)) {
						card = new ItemStack(FourOfPentaclesBlock.block);
					}
					if ((rnd == 40)) {
						card = new ItemStack(FiveOfPentaclesBlock.block);
					}
					if ((rnd == 41)) {
						card = new ItemStack(SixOfPentaclesBlock.block);
					}
					if ((rnd == 42)) {
						card = new ItemStack(SevenOfPentaclesBlock.block);
					}
					if ((rnd == 43)) {
						card = new ItemStack(EightOfPentaclesBlock.block);
					}
					if ((rnd == 44)) {
						card = new ItemStack(NineOfPentaclesBlock.block);
					}
					if ((rnd == 45)) {
						card = new ItemStack(TenOfPentaclesBlock.block);
					}
					if ((rnd == 46)) {
						card = new ItemStack(PageOfPentaclesBlock.block);
					}
					if ((rnd == 47)) {
						card = new ItemStack(KnightOfPentaclesBlock.block);
					}
					if ((rnd == 48)) {
						card = new ItemStack(QueenOfPentaclesBlock.block);
					}
					if ((rnd == 49)) {
						card = new ItemStack(KingOfPentaclesBlock.block);
					}
				} /* SWORDS */
				if ((true)) {
					if ((rnd == 50)) {
						card = new ItemStack(AceOfSwordsBlock.block);
					}
					if ((rnd == 51)) {
						card = new ItemStack(TwoOfSwordsBlock.block);
					}
					if ((rnd == 52)) {
						card = new ItemStack(ThreeOfSwordsBlock.block);
					}
					if ((rnd == 53)) {
						card = new ItemStack(FourOfSwordsBlock.block);
					}
					if ((rnd == 54)) {
						card = new ItemStack(FiveOfSwordsBlock.block);
					}
					if ((rnd == 55)) {
						card = new ItemStack(SixOfSwordsBlock.block);
					}
					if ((rnd == 56)) {
						card = new ItemStack(SevenOfSwordsBlock.block);
					}
					if ((rnd == 57)) {
						card = new ItemStack(EightOfSwordsBlock.block);
					}
					if ((rnd == 58)) {
						card = new ItemStack(NineOfSwordsBlock.block);
					}
					if ((rnd == 59)) {
						card = new ItemStack(TenOfSwordsBlock.block);
					}
					if ((rnd == 60)) {
						card = new ItemStack(PageOfSwordsBlock.block);
					}
					if ((rnd == 61)) {
						card = new ItemStack(KnightOfSwordsBlock.block);
					}
					if ((rnd == 62)) {
						card = new ItemStack(QueenOfSwordsBlock.block);
					}
					if ((rnd == 63)) {
						card = new ItemStack(KingOfSwordsBlock.block);
					}
				} /* WANDS */
				if ((true)) {
					if ((rnd == 64)) {
						card = new ItemStack(AceOfWandsBlock.block);
					}
					if ((rnd == 65)) {
						card = new ItemStack(TwoOfWandsBlock.block);
					}
					if ((rnd == 66)) {
						card = new ItemStack(ThreeOfWandsBlock.block);
					}
					if ((rnd == 67)) {
						card = new ItemStack(FourOfWandsBlock.block);
					}
					if ((rnd == 68)) {
						card = new ItemStack(FiveOfWandsBlock.block);
					}
					if ((rnd == 69)) {
						card = new ItemStack(SixOfWandsBlock.block);
					}
					if ((rnd == 70)) {
						card = new ItemStack(SevenOfWandsBlock.block);
					}
					if ((rnd == 71)) {
						card = new ItemStack(EightOfWandsBlock.block);
					}
					if ((rnd == 72)) {
						card = new ItemStack(NineOfWandsBlock.block);
					}
					if ((rnd == 73)) {
						card = new ItemStack(TenOfWandsBlock.block);
					}
					if ((rnd == 74)) {
						card = new ItemStack(PageOfWandsBlock.block);
					}
					if ((rnd == 75)) {
						card = new ItemStack(KnightOfWandsBlock.block);
					}
					if ((rnd == 76)) {
						card = new ItemStack(QueenOfWandsBlock.block);
					}
					if ((rnd == 77)) {
						card = new ItemStack(KingOfWandsBlock.block);
					}
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(((card).getDisplayName().getString())), (true));
				}
			}
		}
		return (card);
	}
}
