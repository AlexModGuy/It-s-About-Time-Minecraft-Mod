package itsabouttime.client.gui;

import itsabouttime.common.entities.EntityTimeMachine;
import itsabouttime.common.inventory.InventoryTimeMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerTimeMachineInventory extends Container
{
    private EntityTimeMachine theEntity;
    private InventoryTimeMachine inv;


    public ContainerTimeMachineInventory(InventoryPlayer p_i1812_1_,EntityTimeMachine entity, InventoryTimeMachine p_i1812_2_)
    {
        this.theEntity = entity;
        this.inv = p_i1812_2_;
        this.addSlotToContainer(new Slot(p_i1812_2_, 0, 79, 17));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(p_i1812_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(p_i1812_1_, i, 8 + i * 18, 142));
        }
    }

   
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return this.inv.isUseableByPlayer(p_75145_1_);
    }

   
}