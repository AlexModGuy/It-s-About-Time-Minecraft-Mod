package iat.blocks;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import iat.core.ModItems;
import iat.enums.EnumPrehistoricTrees;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGinkoNut extends BlockCocoa {
	@SideOnly(Side.CLIENT)
    private IIcon[] texture;
   
	 @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int i, int l)
	    {
	        return this.texture[2];
	    }
	 @Override
	    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int p_149690_5_, int fortune)
	    {
	        ArrayList<ItemStack> dropped = super.getDrops(world, x, y, z, p_149690_5_, fortune);
	        int j1 = func_149987_c(p_149690_5_);
	        byte b0 = 1;

	        if (j1 >= 2)
	        {
	            b0 = 3;
	        }

	        for (int k1 = 0; k1 < b0; ++k1)
	        {
	            dropped.add(new ItemStack(ModItems.ginkoNuts, 1, 0));
	        }
	        return dropped;
	    }
	  @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister p_149651_1_)
	    {
	        this.texture = new IIcon[3];

	        for (int i = 0; i < this.texture.length; ++i)
	        {
	            this.texture[i] = p_149651_1_.registerIcon("iat:ginkoNut_stage_" + i);
	        }
	    }
	 @SideOnly(Side.CLIENT)
	    public IIcon getCocoaIcon(int i)
	    {
	        if (i < 0 || i >= this.texture.length)
	        {
	            i = this.texture.length - 1;
	        }

	        return this.texture[i];
	    }

}
