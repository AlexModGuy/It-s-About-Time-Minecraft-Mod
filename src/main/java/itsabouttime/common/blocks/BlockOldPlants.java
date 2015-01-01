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
import net.minecraft.util.IIcon;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOldPlants extends BlockBush{

	private IIcon[] texture;
	final static String[] subBlocks = new String[] {"ClubMoss", "Cooksonia", "Lycopods"};

    protected BlockOldPlants(Material p_i45395_1_)
    {
        super(p_i45395_1_);
        this.setTickRandomly(true);
        float f = 0.2F;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public BlockOldPlants()
    {
        this(Material.plants);
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


    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block block)
    {
        return block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland || block == IATstuff.CambrianStone || block == IATstuff.OrdovicianStone | block == IATstuff.SilurianStone ;
    }

}