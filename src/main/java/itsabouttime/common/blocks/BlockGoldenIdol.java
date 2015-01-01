package itsabouttime.common.blocks;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.EntityGoldIdol;
import itsabouttime.common.tileentities.TileEntityGoldenIdol;

import java.util.Random;

import com.sun.imageio.plugins.gif.GIFImageReader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGoldenIdol extends BlockContainer
{
	GIFImageReader gifrender;

    public BlockGoldenIdol(Material m)
    {
        super(m);
        this.setBlockBounds(0f, 0f, 0f,  1f, 0.5f,1f);
        this.setHardness(15f);
        this.setResistance(1000f);
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(1f);
    }

    public int getRenderType()
    {
        return -42;
    }
    public boolean isOpaqueCube()
    {
    return false;
    }
    public boolean renderAsNormalBlock()
    {
    return false;
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        if (p_149734_5_.nextInt(100) == 0)
        {
            p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "iat:Raptor-say", 0.1F, 10F, false);
        }

    /*    for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;

            if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this)
            {
                d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
                d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
                d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }

            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }*/
    }
    public TileEntity createNewTileEntity(World var1, int var2)
    {
    return new TileEntityGoldenIdol();
    }
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	if(!world.isRemote) {
/*    	EntityGoldIdol skeleton = new EntityGoldIdol(world);
		skeleton.setLocationAndAngles(x, y+1, z, 0, 0);
		world.spawnEntityInWorld(skeleton);  
		skeleton.setHealth(0f);
skeleton.moveEntity(0.0D, 0.10000000149011612D, 0.0D);

world.setBlockToAir(x, y, z);*/

		}        return true;
		
    }

 
   
}