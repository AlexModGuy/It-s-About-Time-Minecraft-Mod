package iat.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCarrotOnAStick;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRockPick extends Item
{
    public ItemRockPick()
    {
        super();
        this.setMaxDamage(90);
        this.setMaxStackSize(1);
    }
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
            player.swingItem();
        return itemstack;
    }
}