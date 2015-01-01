
package itsabouttime.common.items;
import itsabouttime.client.gui.GuiScreenFossilBook;
import itsabouttime.common.core.IATachievements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class ItemFossilBook extends ItemEditableBook
{
public ItemFossilBook( )
{
super();

}
@Override
public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
if (!world.isRemote) 
	Minecraft.getMinecraft().displayGuiScreen(new GuiScreenFossilBook());
player.triggerAchievement(IATachievements.AchBook);

return stack;
}
@SideOnly(Side.CLIENT)
public boolean hasEffect(ItemStack p_77636_1_)
{
    return false;
}
}