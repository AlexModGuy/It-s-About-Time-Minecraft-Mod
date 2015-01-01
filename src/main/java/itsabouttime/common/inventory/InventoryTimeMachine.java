package itsabouttime.common.inventory;

import itsabouttime.common.entities.EntityTimeMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryTimeMachine implements IInventory {
    private ItemStack[] stackList = new ItemStack[1];
    public boolean dropContentsWhenDead = true;
    private EntityTimeMachine timemachine;
    public InventoryTimeMachine(EntityTimeMachine timemachine)
    {
    this.timemachine = timemachine;
    }
	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		 return p_70301_1_ >= this.getSizeInventory() ? null : this.stackList[p_70301_1_];	
		 }

	@Override
	 public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.stackList[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.stackList[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.stackList[p_70298_1_];
                this.stackList[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.stackList[p_70298_1_].splitStack(p_70298_2_);

                if (this.stackList[p_70298_1_].stackSize == 0)
                {
                    this.stackList[p_70298_1_] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

public void readFromNBT(NBTTagList tagList)
{
if (tagList == null || tagList.tagCount() <= 0)
{
return;
}
this.stackList = new ItemStack[this.stackList.length];
for (int i = 0; i < tagList.tagCount(); ++i)
{
final NBTTagCompound nbttagcompound = tagList.getCompoundTagAt(i);
final int j = nbttagcompound.getByte("Slot") & 255;
final ItemStack itemstack = ItemStack.loadItemStackFromNBT(nbttagcompound);
if (itemstack != null)
{
this.stackList[j] = itemstack;
}
}
}
public NBTTagList writeToNBT(NBTTagList tagList)
{
NBTTagCompound nbttagcompound;
for (int i = 0; i < this.stackList.length; ++i)
{
if (this.stackList[i] != null)
{
nbttagcompound = new NBTTagCompound();
nbttagcompound.setByte("Slot", (byte) i);
this.stackList[i].writeToNBT(nbttagcompound);
tagList.appendTag(nbttagcompound);
}
}
return tagList;
}
	 
	@Override
	  public ItemStack getStackInSlotOnClosing(int p_70304_1_)
    {
        if (this.stackList[p_70304_1_] != null)
        {
            ItemStack itemstack = this.stackList[p_70304_1_];
            this.stackList[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }
	@Override
	 public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.stackList[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
    }

	@Override
	 public String getInventoryName()
    {
        return "container.TM";
    }
	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO 
		return 64;
	}

	@Override
	public void markDirty() {
		
	}

	@Override
	 public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
		 return !timemachine.isDead && p_70300_1_.getDistanceSqToEntity(timemachine) <= 64.0D;
		 }

    public void openInventory() {}

    public void closeInventory() {}




	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO 
		return true;
	}
}