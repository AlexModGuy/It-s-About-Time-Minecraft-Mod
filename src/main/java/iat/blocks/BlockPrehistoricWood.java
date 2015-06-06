package iat.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPrehistoricWood extends BlockLog{
	@SideOnly(Side.CLIENT)
	private IIcon Top;
	public String textureName;
	public BlockPrehistoricWood(String textureName){
		this.textureName = textureName;
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconregistry){
		this.blockIcon = iconregistry.registerIcon(textureName);
		this.Top = iconregistry.registerIcon(textureName + "_Top");
	} 

	public IIcon getIcon(int side, int meta)
	{
		return ((meta & 12) == 0 && side < 2) || ((meta & 12) == 8 && side > 1 && side < 4) || ((meta & 12) == 4 && side > 3) ? this.Top : this.blockIcon;
	}

}
