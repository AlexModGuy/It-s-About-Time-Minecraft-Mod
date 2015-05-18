package iat.entities.tile;

import net.minecraft.tileentity.TileEntity;

public class TileEntityAmber extends TileEntity {

	private int amberID;
	public TileEntityAmber(int amberID) {
		super();
		this.amberID = amberID;
	}
	public int getAmberID() {
		return amberID;
	}
	public void setAmberID(int amberID) {
		this.amberID = amberID;
	}

}
