package iat.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPlasterFossil extends Block {

	public BlockPlasterFossil(Material mat) {
		super(mat);
		this.setHarvestLevel("pickaxe", 1);
	}
	
}
