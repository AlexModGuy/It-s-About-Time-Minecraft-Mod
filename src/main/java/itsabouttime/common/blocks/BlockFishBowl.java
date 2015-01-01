package itsabouttime.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import itsabouttime.common.tileentities.TileEntityFishBowl;
import itsabouttime.common.tileentities.TileEntityStromatolite;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFishBowl extends BlockContainer{

	public BlockFishBowl(Material p_i45394_1_) {
		super(p_i45394_1_);

		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
	}
	 public int getRenderType()
	    {
	        return -44;
	    }
	    public boolean isOpaqueCube()
	    {
	    return false;
	    }
	    public boolean renderAsNormalBlock()
	    {
	    return false;
	    }
	    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
	    {
	        return !super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) ? false : this.canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
	    }
	    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
	    {
	        return p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_).getMaterial().isSolid();
	    }
	
	    @SideOnly(Side.CLIENT)
	    public static float getRenderLiquidLevel(int p_150025_0_)
	    {
	        int j = MathHelper.clamp_int(p_150025_0_, 0, 3);
	        return (float)(6 + 3 * j) / 16.0F;
	    }
	    public TileEntity createNewTileEntity(World var1, int var2)
	    {
	    return new TileEntityFishBowl();
	    }
}
