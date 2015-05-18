package iat.misc;
import iat.core.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CreativeTabsIat extends CreativeTabs
{

	public CreativeTabsIat(int position, String tabID){
		super(position, tabID);
	}
	@Override
	public ItemStack getIconItemStack(){
		return new ItemStack(ModBlocks.timeRift_nowhere);
	}
	@Override
	public Item getTabIconItem() {
		return null;
	}
}