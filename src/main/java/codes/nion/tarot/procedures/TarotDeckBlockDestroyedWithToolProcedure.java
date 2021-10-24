package codes.nion.tarot.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import codes.nion.tarot.TarotMod;

public class TarotDeckBlockDestroyedWithToolProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TarotMod.LOGGER.warn("Failed to load dependency itemstack for procedure TarotDeckBlockDestroyedWithTool!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).setDamage((int) ((((itemstack)).getDamage()) - 1));
	}
}
