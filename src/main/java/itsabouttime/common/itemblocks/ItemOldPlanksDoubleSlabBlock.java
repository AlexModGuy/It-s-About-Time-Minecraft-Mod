package itsabouttime.common.itemblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemOldPlanksDoubleSlabBlock extends ItemBlock {
	final static String[] subBlocks = new String[] {"Progymnosperm", "Lepidodendron", "Prototaxites", "TreeFern"};

	public ItemOldPlanksDoubleSlabBlock(Block block) {
		super(block);
this.setHasSubtypes(true);

	}
public String getUnlocalizedName(ItemStack itemstack){
	int i = itemstack.getItemDamage();
	if (i<0|| i>=subBlocks.length){
		i=0;
	}
	return super.getUnlocalizedName()+ "."+subBlocks[i];
}
public int getMetadata(int meta){
	return meta;
}
}
