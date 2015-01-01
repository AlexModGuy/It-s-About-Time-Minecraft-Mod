package itsabouttime.common.items;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MyFood1Item extends ItemFood
{
private static final String[] itemlist = new String[] {"ArthropodLeg", "ArthropodLegCooked", "ArthropodMeat", "ArhtropodMeatCooked", "Tentacle", "TentacleCooked", "Waptia", "WaptiaCooked"};
private IIcon[] textures;
public MyFood1Item()
{
super( 0, false);
this.setHasSubtypes(true);
}
@Override
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
{

if (player.canEat(false))
{
player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
}

return itemstack;
}


@Override
public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
{
--itemstack.stackSize;
switch (itemstack.getItemDamage())
{
case 0:
player.getFoodStats().addStats(2, 0.3F);
break;
case 1:
player.getFoodStats().addStats(5, 0.6F);
break;
case 2:
player.getFoodStats().addStats(3, 0.3F);
break;
case 3:
player.getFoodStats().addStats(8, 0.8F);
break;
case 4:
player.getFoodStats().addStats(2, 0.3F);
break;
case 5:
player.getFoodStats().addStats(6, 0.3F);
break;
case 6:
player.getFoodStats().addStats(2, 0.3F);
break;
case 7:
	
player.getFoodStats().addStats(6, 0.6F);
break;
}
return itemstack;
}
@Override
public EnumAction getItemUseAction(ItemStack itemStack)
{
return EnumAction.none;
}


@Override
protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player)
{
if (!world.isRemote)
{
switch (itemstack.getItemDamage())
{
case 4:
if (world.rand.nextFloat() < 0.6F)
player.addPotionEffect(new PotionEffect(Potion.hunger.id, 225, 0));
break;
}
	
}
}

public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
{
for (int i = 0; i < itemlist.length; ++i)
{
if (i != 8)
{
list.add(new ItemStack(item, 1, i));
}
}
}
@Override
public void registerIcons(IIconRegister iconRegister)
{
textures = new IIcon[itemlist.length];
for (int i = 0; i < itemlist.length; ++i)
{
textures[i] = iconRegister.registerIcon("iat:"+"Food_" + itemlist[i]);
}
}
@Override
public IIcon getIconFromDamage(int meta)
{
if (meta < 0 || meta >= textures.length)
{
meta = 0;
}
return textures[meta];
}
@Override
public String getUnlocalizedName(ItemStack itemStack)
{
int meta = itemStack.getItemDamage();
if (meta < 0 || meta >= itemlist.length)
{
meta = 0;
}
return super.getUnlocalizedName() + "." + itemlist[meta];
}
}
