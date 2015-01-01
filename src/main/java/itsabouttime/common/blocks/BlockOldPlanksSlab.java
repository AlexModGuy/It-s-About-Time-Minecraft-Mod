
package itsabouttime.common.blocks;
import itsabouttime.common.core.IATstuff;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockOldPlanksSlab extends BlockSlab
{

private static final String[] subBlocks = new String[] {"Progymnosperm", "Lepidodendron", "Prototaxites", "TreeFern"};
private IIcon[] texture;

public BlockOldPlanksSlab(boolean isDoubleSlab)
{
super(isDoubleSlab, Material.wood);

this.setHardness(2.0F);
this.setResistance(5.0F);
this.setStepSound(Block.soundTypeWood);
useNeighborBrightness = true;

}


@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister iconregister){
	
	texture = new IIcon[subBlocks.length];
	for(int i = 0; i < subBlocks.length; i++){
		texture[i]=iconregister.registerIcon("iat:" + "Planks_" + subBlocks[i] );
	}
}

@Override
public IIcon getIcon(int side, int meta)
{
	return texture[meta];
}

@Override
@SuppressWarnings({ "rawtypes", "unchecked" })
public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
{
for (int i = 0; i < 4; ++i) {
list.add(new ItemStack(block, 1, i));
}
}

@Override
public int damageDropped(int meta)
{
return meta & 7;
}
@Override
public Item getItemDropped(int metadata, Random random, int fortune)
{
if (field_150004_a)
{

return Item.getItemFromBlock(IATstuff.OldPlanksSlab);

}
else
return Item.getItemFromBlock(this);
}


@Override
public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
{
return new ItemStack(IATstuff.OldPlanksSlab, 1, world.getBlockMetadata(x, y, z));
}

@Override
protected ItemStack createStackedBlock(int meta)
{
return new ItemStack(this, 2, meta);
}


private static int getTypeFromMeta(int meta)
{
return meta & 7;
}



public String func_150002_b(int p_150002_1_)
{
    if (p_150002_1_ < 0 || p_150002_1_ >= subBlocks.length)
    {
        p_150002_1_ = 0;
    }

    return super.getUnlocalizedName() + "." + subBlocks[p_150002_1_];
}
}

