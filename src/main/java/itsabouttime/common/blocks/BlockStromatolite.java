package itsabouttime.common.blocks;

import itsabouttime.common.tileentities.TileEntityStromatolite;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStromatolite extends BlockContainer{

	public BlockStromatolite(Material p_i45394_1_) {
		super(p_i45394_1_);

		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
	}
	 public int getRenderType()
	    {
	        return -43;
	    }
	    public boolean isOpaqueCube()
	    {
	    return false;
	    }
	    public boolean renderAsNormalBlock()
	    {
	    return false;
	    }
	    public TileEntity createNewTileEntity(World var1, int var2)
	    {
	    return new TileEntityStromatolite();
	    }
}
