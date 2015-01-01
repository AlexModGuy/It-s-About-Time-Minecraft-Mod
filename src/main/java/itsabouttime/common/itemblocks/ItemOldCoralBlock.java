package itsabouttime.common.itemblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

public class ItemOldCoralBlock extends ItemBlock {
	final static String[] subBlocks = new String[] {"Archaeocyatha1", "Archaeocyatha2", "Archaeocyatha3", "Graptolite", "Greenalgae", "Paracrinoid"};

	public ItemOldCoralBlock(Block block) {
		super(block);
this.setHasSubtypes(true);
	}
	@Override
public String getUnlocalizedName(ItemStack itemstack){
	int i = itemstack.getItemDamage();
	if (i<0|| i>=subBlocks.length){
		i=0;
	}
	return super.getUnlocalizedName()+ "."+subBlocks[i];
}
	@Override
public int getMetadata(int meta){
	return meta;
}
@Override
public IIcon getIconFromDamage(int meta)
{
	return field_150939_a.getIcon(0, meta);
}

}
