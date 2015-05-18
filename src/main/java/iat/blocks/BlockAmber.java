package iat.blocks;

import iat.core.ModItems;
import iat.entities.tile.TileEntityAmber;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAmber extends BlockContainer{

	private int amberID;
	public BlockAmber(Material rock, int amberID) {
		super(rock);
		this.amberID = amberID;
		this.setHarvestLevel("pickaxe", 2);

	}
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess access, int x, int y, int z, int i)
	{
		return super.shouldSideBeRendered(access, x, y, z, 1 - i);
	}
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
	{
		byte b0 = 0;
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0)
		{
			b0 = 2;
		}

		if (l == 1)
		{
			b0 = 5;
		}

		if (l == 2)
		{
			b0 = 3;
		}

		if (l == 3)
		{
			b0 = 4;
		}

		world.setBlockMetadataWithNotify(x, y, z, b0, 2);


		world.markBlockForUpdate(x, y, z);

		super.onBlockPlacedBy(world, x, y, z, entity, stack);
	}
	public int getRenderType()
	{
		return -28;
	}
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	public boolean isOpaqueCube()
	{
		return false;
	}
	@Override
	public int damageDropped(int i)
	{
		return amberID;
	}
	@Override
	public Item getItemDropped(int i, Random rand, int u)
	{
		return ModItems.amber;
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityAmber(amberID);
	}

	public int getAmberID() {
		return amberID;
	}

	public void setAmberID(int amberID) {
		this.amberID = amberID;
	}

}
