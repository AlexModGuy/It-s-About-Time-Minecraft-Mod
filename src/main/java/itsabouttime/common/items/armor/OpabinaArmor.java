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

public class OpabinaArmor extends ItemArmor {

	public OpabinaArmor(ArmorMaterial dragonarm, int i, int j) {
		// TODO Auto-generated constructor stub
		super(dragonarm, j, j);
		
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
			list.add( StatCollector.translateToLocal("Opabina"));
          
    }
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == IATstuff.OpabinaHelmet || stack.getItem() == IATstuff.OpabinaChest || stack.getItem() == IATstuff.OpabinaBoots) {
			return "iat:textures/model/Armor_Opabina_1.png";
		}else if(stack.getItem() == IATstuff.OpabinaLegs){
			return "iat:textures/model/Armor_Opabina_2.png";
		}else{
			return null;
		}
	}

}

	
	
	

