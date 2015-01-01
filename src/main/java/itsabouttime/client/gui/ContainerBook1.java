package itsabouttime.client.gui;

import itsabouttime.common.recipies.TarDistilleryRecipies;
import itsabouttime.common.tileentities.TileEntityTarDistillery;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerBook1 extends Container{
	
	
	
	public ContainerBook1(InventoryPlayer inventory) {		
			
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	
	
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}

