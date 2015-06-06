package iat.blocks;

import iat.core.ModItems;
import iat.enums.EnumPrehistoricTrees;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPrehistoricLeaves extends BlockLeaves
{
	public static final String[][] textures = new String[][] {{"Fancy"}, {"Fast"}};
	@SideOnly(Side.CLIENT)

	private int iconType;
	private IIcon[][] iconArray = new IIcon[2][];
	int[] adjacentTreeBlocks;
	public String textureName;

	public BlockPrehistoricLeaves(String textureName)
	{
		this.textureName = textureName;
		this.setTickRandomly(true);
	}
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int chance = this.func_150123_b(metadata);

		if (fortune > 0)
		{
			chance -= 2 << fortune;
			if (chance < 10) chance = 10;
		}

		if (world.rand.nextInt(chance) == 0)
			if(this == EnumPrehistoricTrees.Ginko.leavesBlock){
				ret.add(new ItemStack(ModItems.ginkoNuts));
			}

		chance = 200;
		if (fortune > 0)
		{
			chance -= 10 << fortune;
			if (chance < 40) chance = 40;
		}
		super.getDrops(world, x, y, z, metadata, fortune);
		this.captureDrops(true);
		this.func_150124_c(world, x, y, z, metadata, chance); // Dammet mojang
		ret.addAll(this.captureDrops(false));
		return ret;
	}
	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	 public Item getItemDropped(int par1, Random xRandom, int y)
	 {
		 return Item.getItemFromBlock(null);
	 }

	 /**
	  * Drops the block items with a specified chance of dropping the specified items
	  */
	 public void dropBlockAsItemWithChance(World world, int x, int y, int z, int a, float b, int c)
	 {
		 if (!world.isRemote)
		 {
			 int j1 = 20;

			 if ((a & 3) == 3)
			 {
				 j1 = 40;
			 }

			 if (c > 0)
			 {
				 j1 -= 2 << c;

				 if (j1 < 10)
				 {
					 j1 = 10;
				 }
			 }

			 if (world.rand.nextInt(j1) == 0)
			 {
				 Item k1 = this.getItemDropped(a, world.rand, c);
				 this.dropBlockAsItem(world, x, y, z, new ItemStack(k1, 1, this.damageDropped(a)));
			 }

			 j1 = 200;

			 if (c > 0)
			 {
				 j1 -= 10 << c;

				 if (j1 < 40)
				 {
					 j1 = 40;
				 }
			 }

		 }
	 }

	 @SideOnly(Side.CLIENT)
	 public IIcon getIcon(int side, int meta)
	 {
		 this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
		 return (meta & 3) == 1 ? this.iconArray[this.field_150127_b][1] : ((meta & 3) == 3 ? this.iconArray[this.field_150127_b][3] : ((meta & 3) == 2 ? this.iconArray[this.field_150127_b][2] : this.iconArray[this.field_150127_b][0]));

	 }
	 @SideOnly(Side.CLIENT)
	 public void registerBlockIcons(IIconRegister iicon)
	 {
		 for (int i = 0; i < textures.length; ++i)
		 {
			 this.iconArray[i] = new IIcon[textures[i].length];

			 for (int j = 0; j < textures[i].length; ++j)
			 {
				 this.iconArray[i][j] = iicon.registerIcon(textureName + "_" + textures[i][j]);
			 }
		 }
	 }
	 @Override
	 public String[] func_150125_e() {
		 return null;
	 }
}
