package iat.blocks;

import iat.core.ModItems;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFossil extends Block{

	@SideOnly(Side.CLIENT)
	private IIcon blockTop;
	@SideOnly(Side.CLIENT)
	private IIcon blockBottom;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon1;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon2;
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon3;
	private Block blockFossil;
	public BlockFossil(Material mat, Block block) {
		super(mat);
		this.setHarvestLevel("pickaxe", 2);
		blockFossil = block;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int meta)
	{
		if(meta == 0){
			return super.getIcon(i, meta);
		}
		if(meta == 1){
			return i == 1 ? this.blockIcon : (i == 0 ? this.blockBottom : (i != 1 || i != 0 ? this.blockIcon1 : this.blockIcon1));
		}
		if(meta == 2){
			return i == 1 ? this.blockIcon : (i == 0 ? this.blockBottom : (i != 1 || i != 0 ? this.blockIcon2 : this.blockIcon2));
		}
		if(meta == 3){
			return i == 1 ? this.blockIcon : (i == 0 ? this.blockBottom : (i != 1 || i != 0 ? this.blockIcon3 : this.blockIcon3));
		}
		return super.getIcon(i, meta);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister i)
	{

		this.blockIcon = i.registerIcon(this.getTextureName() + "_0");
		this.blockIcon1 = i.registerIcon(this.getTextureName() + "_1");
		this.blockIcon2 = i.registerIcon(this.getTextureName() + "_2");
		this.blockIcon3 = i.registerIcon(this.getTextureName() + "_3");
		this.blockBottom = i.registerIcon("iat:plaster_Fossil");



	}

	public int quantityDropped(Random rand)
	{
		return rand.nextInt(2) + 1;
	}
	public Item getItemDropped(int i, Random rand, int u)
	{
		return ModItems.fossil_Shard;
	}

	@Override
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9){
		ItemStack itemstack = player.getCurrentEquippedItem();
		if(itemstack != null){
			if(itemstack.getItem() != null){
				Random rand = new Random();
				if(itemstack.getItem() == ModItems.plaster_Ball){
					this.moveData(var1, var2, var3, var4, player);
					var1.playSound((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "dig.gravel", 1F, rand.nextFloat() * 0.1F + 0.8F, false);

					if (!player.capabilities.isCreativeMode)
					{
						--itemstack.stackSize;
					}
					if (itemstack.stackSize <= 0)
					{
						player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
					}
					return true;
				}
			}
		}
		return false;
	}
	private void moveData(World world, int var1, int var2, int var3, EntityPlayer player)
	{

		int l = world.getBlockMetadata(var1, var2, var3) + 1;

		if (l >= 4)
		{
			if(blockFossil != null){
				world.setBlock(var1, var2, var3, blockFossil);
			}
		}
		else
		{
			world.setBlockMetadataWithNotify(var1, var2, var3, l, 2);
		}
	}
}

