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

public class ItemTriassicBlock extends ItemBlock {

	public ItemTriassicBlock(Block block) {
		super(block);
	}

	public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal("Triassic"));
		list.add(StatCollector.translateToLocal("252.17 MYA – 201.3 MYA"));

	}
}
