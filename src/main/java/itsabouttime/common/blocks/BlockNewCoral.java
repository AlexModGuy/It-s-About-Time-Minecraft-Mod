package itsabouttime.common.blocks;

import itsabouttime.common.core.IATstuff;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNewCoral extends BlockBush{

	private IIcon[] texture;
	final static String[] subBlocks = new String[] {"CoralBlue", "CoralGreen", "CoralYellow", "CoralPink", "CoralRed"};

    public BlockNewCoral( )
    {
        super(Material.water);
        this.setTickRandomly(true);
        float f = 0.2F;

    }


    @SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister){
		
		texture = new IIcon[subBlocks.length];
		for(int i = 0; i < subBlocks.length; i++){
			texture[i]=iconregister.registerIcon("iat:" + "Plant_" + subBlocks[i]);

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block,CreativeTabs creativetabs, List list){
		
		for (int i = 0; i<subBlocks.length; i++){
			list.add(new ItemStack(block, 1, i));
		}
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return texture[meta];
	}
	public int damageDropped(int meta){
		return meta;
	}

    protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.sand || block == Blocks.dirt || block == Blocks.gravel || block == Blocks.clay  || block == Blocks.sponge;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        return false;
    }
   @Override
	public boolean canReplace(World world, int x, int y, int z, int side, ItemStack itemStack)
    {
    	return world.getBlock(x, y + 1, z) == Blocks.water && this.canBlockStay(world, x, y, z, itemStack.getItemDamage());
    }

	public boolean canBlockStay(World world, int x, int y, int z, int metadata)
	{
		Block block = world.getBlock(x, y - 1, z);
		
		return block == Blocks.dirt || block == Blocks.sand || block == Blocks.sponge || block == Blocks.stone || block == Blocks.clay || block == Blocks.gravel || block == Blocks.grass; }
	
	@Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int silkTouch) 
	{
		world.setBlock(x, y, z, Blocks.water) ;
    }
	@Override
	public int getRenderType()
	{
		return 1;
	}
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}



}