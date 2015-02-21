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

public class ItemCleaningTable extends ItemBlock {

	public ItemCleaningTable(Block block) {
		super(block);
	}

	public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal("message.iat.cleaning_table_1"));
		list.add(StatCollector.translateToLocal("message.iat.cleaning_table_2"));

	}
}
