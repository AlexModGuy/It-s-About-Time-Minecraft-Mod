package itsabouttime.common.blocks;

import itsabouttime.common.core.IATstuff;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockShale extends Block {
	 private int randomMeta;
	 Random rand = new Random();
	public BlockShale(Material p_i45394_1_) {
		super(p_i45394_1_);
		if(IATstuff.Shale instanceof BlockShale){

		this.setHarvestLevel("spade", 2);
		this.setBlockTextureName("iat:SandFossil");
		this.setStepSound(Block.soundTypeSand);
	}else{
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockTextureName("iat:Shale");
		this.setStepSound(soundTypePiston);
	}
	}
	
		@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
	return IATstuff.Fossils;
	}
	@Override
	public int damageDropped(int meta)
	{
	return rand.nextInt(11);
	}
	@Override
	public int quantityDropped(Random random)
	{
	return 1;
	}}
