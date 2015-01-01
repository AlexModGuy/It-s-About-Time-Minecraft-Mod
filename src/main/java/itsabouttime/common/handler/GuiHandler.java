package itsabouttime.common.handler;

import itsabouttime.iat;
import itsabouttime.client.gui.ContainerBook1;
import itsabouttime.client.gui.ContainerTarDistillery;
import itsabouttime.client.gui.ContainerTimeMachineInventory;
import itsabouttime.client.gui.GuiTarDistillery;
import itsabouttime.client.gui.GuiTimeMachineInventory;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.EntityTimeMachine;
import itsabouttime.common.tileentities.TileEntityTarDistillery;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		Entity entity2 = world.getEntityByID(x);

			switch(ID) {
			case iat.guiIdTarDistillery:
				if(entity != null) {

				if (entity instanceof TileEntityTarDistillery) {
					return new ContainerTarDistillery(player.inventory, (TileEntityTarDistillery) entity);

				}
				}
				break;
				case iat.guiIdTimeMachine:
					if(entity2 != null) {

					if (entity2 instanceof EntityTimeMachine) {
						System.out.println("calling TM Container from GUIHandler");

						return new ContainerTimeMachineInventory(player.inventory, (EntityTimeMachine)entity2, ((EntityTimeMachine) entity2).InventoryTimeMachine);
					}
				}
					break;

			}
		
		
		return null;
	
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		Entity entity2 = world.getEntityByID(x);

			switch(ID) {
			
			case iat.guiIdTarDistillery:
				if(entity != null) {

				if (entity instanceof TileEntityTarDistillery) {
					return new GuiTarDistillery(player.inventory, (TileEntityTarDistillery) entity);
				}
				}
				break;
			case iat.guiIdTimeMachine:
				if(entity2 != null) {

				if (entity2 instanceof EntityTimeMachine) {
					System.out.println("calling TM Gui from GUIHandler");

					return new GuiTimeMachineInventory(player.inventory, (EntityTimeMachine) entity2, ((EntityTimeMachine) entity2).InventoryTimeMachine);
				}
				
			}
				break;
		}
		return null;

	}

}

