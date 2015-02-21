package iat.items.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemCarboniferousBlock extends ItemBlock {

	public ItemCarboniferousBlock(Block block) {
		super(block);
	}

	public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal("Carboniferous"));
		list.add(StatCollector.translateToLocal("358.9 MYA – 298.9 MYA"));

	}
}
