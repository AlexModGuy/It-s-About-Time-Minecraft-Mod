package itsabouttime.common.itemblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemGoldIdolBlock extends ItemBlock {

	public ItemGoldIdolBlock(Block block) {
		super(block);
this.setHasSubtypes(true);
	}
	 public EnumRarity getRarity(ItemStack p_77613_1_)
	    {
	        return EnumRarity.epic;
	    }
	 public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	 {
	        list.add( StatCollector.translateToLocal("???"));

	 }
}
