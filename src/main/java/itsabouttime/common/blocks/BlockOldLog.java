package itsabouttime.common.blocks;

import java.util.List;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockOldLog extends BlockLog{
	public static final String[] logs = new String[] {"Progymnosperm", "Lepidodendron", "Prototaxites","Archaeopteris"};
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks (Item item, CreativeTabs tabs, List list){
		for (int i = 0; i < logs.length; i++){
			list.add(new ItemStack(item, 1,i));
		}
}
private static int getTypeFromMeta(int meta)
{
return meta & 4;
}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconregistry){
		this.field_150167_a = new IIcon[logs.length];
		this.field_150166_b = new IIcon[logs.length];
		
		for(int i = 0; i <  this.field_150167_a.length; i++){
			this.field_150167_a[i] = iconregistry.registerIcon("iat:Log_" + logs[i] );
			this.field_150166_b[i] = iconregistry.registerIcon("iat:Log_Top_" + logs[i] );
		}
	} 
}
