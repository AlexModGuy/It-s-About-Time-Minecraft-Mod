package itsabouttime.common.items.armor;

import java.util.List;

import itsabouttime.common.core.IATstuff;

import com.google.common.base.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class NecklaceArmor extends ItemArmor {

	public NecklaceArmor(ArmorMaterial dragonarm, int i, int j) {
		// TODO Auto-generated constructor stub
		super(dragonarm, j, j);
		
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == IATstuff.GoldenNecklace ) {
			return "iat:textures/model/Armor_Necklace.png";
		
		}else{
			return null;
		}
	}

}

	
	
	

