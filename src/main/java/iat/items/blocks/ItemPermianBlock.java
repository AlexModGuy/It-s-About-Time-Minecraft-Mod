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

public class ItemPermianBlock extends ItemBlock {

	public ItemPermianBlock(Block block) {
		super(block);
	}

	public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal("Permian"));
		list.add(StatCollector.translateToLocal("298.9 MYA – 252.17 MYA"));

	}
}
