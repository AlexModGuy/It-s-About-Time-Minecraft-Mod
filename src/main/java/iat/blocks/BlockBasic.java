package iat.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockBasic extends Block {

	public BlockBasic(Material material, String harvestTool, int harvestStrength, float durability, float resistance) {
		super(material);
		this.setHarvestLevel(harvestTool, harvestStrength);
		this.setHardness(durability);
		this.setResistance(resistance);

	}

	public BlockBasic(Material material, String harvestTool, int harvestStrength, float durability, float resistance, float slipperiness) {
		super(material);
		this.setHarvestLevel(harvestTool, harvestStrength);
		this.setHardness(durability);
		this.setResistance(resistance);
		this.slipperiness = slipperiness;

	}


}
