package itsabouttime.common.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemCreativeTabIcon extends Item {
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Creative Tab Icon");}
	public ItemCreativeTabIcon() {	
this.setTextureName("iat:CreativeTabIcon");
	}

}
