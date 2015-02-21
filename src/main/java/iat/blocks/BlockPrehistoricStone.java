package iat.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockPrehistoricStone extends Block {

	private Block block;
	public BlockPrehistoricStone(Material mat, Block cobbleBlock) {
		super(mat);
		block = cobbleBlock;
		this.setHarvestLevel("pickaxe", 0);
	}
	public Item getItemDropped(int i, Random rand, int u)
	{
		return Item.getItemFromBlock(block);
	}
}
