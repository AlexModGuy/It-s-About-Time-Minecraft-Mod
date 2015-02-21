package iat.misc;


import iat.ItsAboutTime;
import iat.ProxyClient;
import iat.client.gui.GuiCleaningTable;
import iat.client.gui.GuiMatterConverter;
import iat.entities.tile.TileEntityCleaningTable;
import iat.entities.tile.TileEntityMatterConverter;
import iat.inventory.ContainerCleaningTable;
import iat.inventory.ContainerMatterConverter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		Entity entity2 = world.getEntityByID(x);

		switch(ID) {
		case ItsAboutTime.GUIMatterConverterID:
			if(entity != null) {

				if (entity instanceof TileEntityMatterConverter) {
					return new ContainerMatterConverter(player.inventory, (TileEntityMatterConverter) entity);

				}
			}
			break;

		case ItsAboutTime.GUICleaningTableID:
			if(entity != null) {

				if (entity instanceof TileEntityCleaningTable) {
					return new ContainerCleaningTable(player.inventory, (TileEntityCleaningTable) entity);

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

		case ItsAboutTime.GUIMatterConverterID:
			if(entity != null) {

				if (entity instanceof TileEntityMatterConverter) {
					return new GuiMatterConverter(player.inventory, (TileEntityMatterConverter) entity);
				}
			}
			break;


		case ItsAboutTime.GUICleaningTableID:
			if(entity != null) {

				if (entity instanceof TileEntityCleaningTable) {
					return new GuiCleaningTable(player.inventory, (TileEntityCleaningTable) entity);
				}
			}
			break;
		}
		return null;

	}

}

