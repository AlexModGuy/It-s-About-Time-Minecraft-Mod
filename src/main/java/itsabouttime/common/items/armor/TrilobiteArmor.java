package itsabouttime.common.items.armor;

import itsabouttime.iat;
import itsabouttime.client.model.ModelTrilobiteArmor1;
import itsabouttime.common.core.IATstuff;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TrilobiteArmor extends ItemArmor {

	public TrilobiteArmor(ArmorMaterial dragonarm, int i, int j) {
		super(dragonarm, j, j);
		
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
			list.add( StatCollector.translateToLocal("Trilobite"));
          
    }
	@Override 
	@SideOnly(Side.CLIENT) 
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		ModelBiped armorModel = new ModelBiped(); 

		if(itemStack != null){ if(itemStack.getItem() instanceof TrilobiteArmor){ 
			
			int type = ((ItemArmor)itemStack.getItem()).armorType; if(type == 1 || type == 3){
				
				armorModel = iat.proxy.getArmorModel(0); 
				}else{
					armorModel = iat.proxy.getArmorModel(1); } }
		if(armorModel != null){ armorModel.bipedHead.showModel = armorSlot == 0; armorModel.bipedHeadwear.showModel = armorSlot == 0; 
		armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2; armorModel.bipedRightArm.showModel = armorSlot == 1; 
		armorModel.bipedLeftArm.showModel = armorSlot == 1; armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3; 
		armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3; armorModel.isSneak = entityLiving.isSneaking();
		armorModel.isRiding = entityLiving.isRiding(); armorModel.isChild = entityLiving.isChild();
		armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
		if(entityLiving instanceof EntityPlayer){ armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
		} 
		return armorModel; 
		}
		} 
		return null; 
		} 
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == IATstuff.TrilobiteHelmet || stack.getItem() == IATstuff.TrilobiteChest || stack.getItem() == IATstuff.TrilobiteBoots) {
			return "iat:textures/model/Armor_Trilobite_1.png";
		}else if(stack.getItem() == IATstuff.TrilobiteLegs){
			return "iat:textures/model/Armor_Trilobite_2.png";
		}else{
			return null;
		}
	}

}

	
	
	

