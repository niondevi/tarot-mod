
package codes.nion.tarot.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import codes.nion.tarot.block.EnderTarotCardBlock;
import codes.nion.tarot.TarotModElements;

@TarotModElements.ModElement.Tag
public class TarotItemGroup extends TarotModElements.ModElement {
	public TarotItemGroup(TarotModElements instance) {
		super(instance, 102);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtarot") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EnderTarotCardBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
