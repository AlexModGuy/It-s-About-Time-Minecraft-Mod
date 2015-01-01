package itsabouttime.common.blocks;

import itsabouttime.iat;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGemBlock extends Block{
	@SideOnly(Side.CLIENT)
private IIcon[] texture;
	final static String[] subBlocks = new String[] {"Cambrian", "Ordovician", "Sillurian", "Denovian", "Carbonofibirous", "Permain", "Triassic", "Jurrasic", "Cretatious", "Palegene", "Neogene"};
	public BlockGemBlock() {
		super(Material.iron);
		this.setHardness(0.6F);
		this.setStepSound(soundTypeGrass);
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister){
		
		texture = new IIcon[subBlocks.length];
		for(int i = 0; i < subBlocks.length; i++){
			texture[i]=iconregister.registerIcon("iat:" +subBlocks[i] + "_Block");
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
	
}
