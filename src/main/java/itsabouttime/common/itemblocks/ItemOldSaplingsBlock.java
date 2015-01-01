package itsabouttime.common.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemOldSaplingsBlock extends ItemBlock
{
	private static final String[] saplings = new String[] {"Progymnosperm", "Lepidodendron", "Prototaxites", "TreeFern", "Archaeopteris","Bjuvia"};

	public ItemOldSaplingsBlock(Block block)
	{
		super(block);
		
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta & 5;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if (i<0|| i>=saplings.length){
			i=0;
		}
		return super.getUnlocalizedName()+ "."+saplings[i];
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		return field_150939_a.getIcon(0, meta);
	}
}
