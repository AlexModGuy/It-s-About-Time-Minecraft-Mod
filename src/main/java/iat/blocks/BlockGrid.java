package iat.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGrid extends Block {

	public BlockGrid(Material mat) {
		super(mat);
	}
	public boolean isOpaqueCube()
	{
		return true;
	}
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
}
