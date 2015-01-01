package itsabouttime.common.items;

import itsabouttime.common.entities.EntityTimeMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTimeMachine extends Item{

	public ItemTimeMachine( Entity entity){
		

	}
    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }
    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }
    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_)
    {
        return EnumRarity.uncommon ;
    }
    @Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffSet)
	{
		if(!world.isRemote) {
		EntityTimeMachine skeleton = new EntityTimeMachine(world);
			skeleton.setLocationAndAngles(x -0.5, y+1, z - 0.5, 0, 0);
			world.spawnEntityInWorld(skeleton);
			}
		return true;
		}
	}

