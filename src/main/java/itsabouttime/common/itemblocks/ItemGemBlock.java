package itsabouttime.common.itemblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemGemBlock extends ItemBlock {
	final static String[] subBlocks = new String[] {"Cambrian", "Ordovician", "Sillurian", "Denovian", "Carbonofibirous", "Permain", "Triassic", "Jurrasic", "Cretatious", "Palegene", "Neogene"};

	public ItemGemBlock(Block block) {
		super(block);
this.setHasSubtypes(true);
	}
public String getUnlocalizedName(ItemStack itemstack){
	int i = itemstack.getItemDamage();
	if (i<0|| i>=subBlocks.length){
		i=0;
	}
	return super.getUnlocalizedName()+ "."+subBlocks[i];
}
public int getMetadata(int meta){
	return meta;
}
@SideOnly(Side.CLIENT)
public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
{
    switch (stack.getItemDamage())
    {
    case 0:
      
        list.add( StatCollector.translateToLocal("Trilobite.per"));
     

        break;
    case 1:
       
        list.add(StatCollector.translateToLocal("Orthocone.per"));
       

        break;
    case 2:
     
        list.add( StatCollector.translateToLocal("Brontoscoprio.per"));
       
        break;
    case 3:
        
        list.add( StatCollector.translateToLocal("Dunkleosteus.per"));
    
        break;
    case 4:
       
        list.add( StatCollector.translateToLocal("Meganura.per"));

        break;
    case 5:
        list.add( StatCollector.translateToLocal("Dimetrodon.per"));
        break;
    case 6:
        list.add( StatCollector.translateToLocal("Coelophysis.per"));
        break;
    case 7:
        list.add( StatCollector.translateToLocal("Feather.per"));
        break;
    case 8:
        list.add( StatCollector.translateToLocal("Trex.per"));
        break;
    case 9:
        list.add( StatCollector.translateToLocal("Terrorbird.per"));
        break;
        
    case 10:
        list.add( StatCollector.translateToLocal("Human.per"));
        break;
    }
}
}
