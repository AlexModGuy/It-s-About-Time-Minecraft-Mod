package itsabouttime.common.blocks;

import java.util.List;




import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOldLeaves extends BlockLeaves{
public static final String[] leaves = new String[]	{"Progymnosperm", "Lepidodendron", "TreeFern","Archaeopteris","Bjuvia"};  
private IIcon[][] textures;
public BlockOldLeaves( )
{
super();
this.setHardness(0.2F);
this.setStepSound(Block.soundTypeGrass);
this.setTickRandomly(true);
this.setLightOpacity(1);
}


@SideOnly(Side.CLIENT)
public void getSubBlocks(Item block,CreativeTabs creativetabs, List list){
	
	for (int i = 0; i<leaves.length; i++){
		list.add(new ItemStack(block, 1, i));
	}
}

public int damageDropped(int meta){
	return meta;
}





/**
 * Get the block's damage value (for use with pick block).
 */
public int getDamageValue(World world, int x, int y, int z)
{
return world.getBlockMetadata(x, y, z) & 4;
}






public void registerBlockIcons(IIconRegister iconRegister)
{
	textures = new IIcon[3][leaves.length];
	
		for (int i = 0; i < leaves.length; ++i)
		{
			textures[0][i] = iconRegister.registerIcon("iat:Leaf_" + leaves[i] );
			textures[1][i] = iconRegister.registerIcon("iat:Leaf_"+ "Fast_" + leaves[i]);
		}
}







@Override
public IIcon getIcon(int side, int metadata)
{
	int type = getTypeFromMeta(metadata) ;
	return textures[(!isOpaqueCube() ? 0 : 1)][type >= leaves.length ? 0 : type];
}
private static int getTypeFromMeta(int meta)
{
	meta = meta & 4;
	if (meta < 0 || meta >= leaves.length) {
		meta = 0;
	}
	return meta;
}


	@Override
	public String[] func_150125_e() {
		
		return leaves;
	}
	
	public boolean renderasNormalBlock(){
		return false;
	}
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccsess, int x, int y, int z, int side){
		return true;
		
	}
}
