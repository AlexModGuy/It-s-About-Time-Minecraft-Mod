package iat.blocks;

import iat.core.ModBlocks;
import iat.core.ModItems;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockPlasterFossil extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon1;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon2;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon3;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon4;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon5;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon6;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon7;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon8;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon9;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon10;
	public BlockPlasterFossil(Material mat) {
		super(mat);
		this.setHarvestLevel("pickaxe", 1);
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int meta)
	{
		switch(meta){
		case 0:
			return blockIcon;
		case 1:
			return blockIcon1;
		case 2:
			return blockIcon2;
		case 3:
			return blockIcon3;
		case 4:
			return blockIcon4;
		case 5:
			return blockIcon5;
		case 6:
			return blockIcon6;
		case 7:
			return blockIcon7;
		case 8:
			return blockIcon8;
		case 9:
			return blockIcon9;
		case 10:
			return blockIcon10;
		}
		return super.getIcon(i, meta);
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister i)
	{
		this.blockIcon = i.registerIcon("iat:plaster_Fossil");
		this.blockIcon1 = i.registerIcon("iat:plaster_destroy_0");
		this.blockIcon2 = i.registerIcon("iat:plaster_destroy_1");
		this.blockIcon3 = i.registerIcon("iat:plaster_destroy_2");
		this.blockIcon4 = i.registerIcon("iat:plaster_destroy_3");
		this.blockIcon5 = i.registerIcon("iat:plaster_destroy_4");
		this.blockIcon6 = i.registerIcon("iat:plaster_destroy_5");
		this.blockIcon7 = i.registerIcon("iat:plaster_destroy_6");
		this.blockIcon8 = i.registerIcon("iat:plaster_destroy_7");
		this.blockIcon9 = i.registerIcon("iat:plaster_destroy_8");
		this.blockIcon10 = i.registerIcon("iat:plaster_destroy_9");

	}
	public Item getItemDropped(int i, Random rand, int u)
	{
		if(i != 0){
			return Item.getItemFromBlock(this);
		}
		return null;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var6, float var7, float var8, float var9){
		int l = world.getBlockMetadata(x, y, z) + 1;

		ItemStack itemstack = player.getCurrentEquippedItem();
		if(itemstack != null){
			if(itemstack.getItem() != null){
				Random rand = new Random();
				if(itemstack.getItem() == ModItems.rockPick){
					if(l <= 10){

						this.moveData(world, x, y, z, player);
						world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "dig.stone", 1F, rand.nextFloat() * 0.1F + 0.8F, false);
						float f = 0.7F;
						double d0 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
						double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
						double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
						if(!world.isRemote){
							EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, this.getFossilItem(rand));
							entityitem.delayBeforeCanPickup = 10;
							world.spawnEntityInWorld(entityitem);

						}					if (!player.capabilities.isCreativeMode)
						{
							--itemstack.stackSize;
						}
						if (itemstack.stackSize <= 0)
						{
							player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
						}
						return true;
					}else{
						world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.break", 1F, rand.nextFloat() * 0.1F + 0.8F, false);
						if(!world.isRemote){
						world.setBlock(x, y, z, Blocks.air);
						}
					}
				}
			}
		}
		return false;
	}

	private ItemStack getFossilItem(Random rand) {
		int choice = rand.nextInt(100);
		if(this == ModBlocks.plastered_Fossil_Cambrian){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Ordovician){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Silurian){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Devonian){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Cretaceous){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Permian){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Triassic){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Jurassic){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Cretaceous){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Paleogene){
			return new ItemStack(ModItems.fossil_Shard);

		}
		if(this == ModBlocks.plastered_Fossil_Neogene){
			return new ItemStack(ModItems.fossil_Shard);

		}
		return null;
	}
	private void moveData(World world, int x, int y, int z, EntityPlayer player)
	{

		int l = world.getBlockMetadata(x, y, z) + 1;
		if(l <= 10){
			world.setBlockMetadataWithNotify(x, y, z, l, 2);
		}

	}
}
