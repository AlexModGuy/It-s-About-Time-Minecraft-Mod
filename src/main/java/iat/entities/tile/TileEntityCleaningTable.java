package iat.entities.tile;

import iat.blocks.BlockCleaningTable;
import iat.recipes.CleaningTableRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCleaningTable extends TileEntity implements ISidedInventory
{
	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {2, 1};
	private static final int[] slotsSides = new int[] {1};
	private ItemStack[] furnaceItemStacks = new ItemStack[3];
	public int furnaceBurnTime;
	public int currentItemBurnTime;
	public int furnaceCookTime;
	private String name;

	public int getSizeInventory()
	{
		return this.furnaceItemStacks.length;
	}

	public ItemStack getStackInSlot(int i)
	{
		return this.furnaceItemStacks[i];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int i, int mumberOfItems)
	{
		if (this.furnaceItemStacks[i] != null)
		{
			ItemStack itemstack;

			if (this.furnaceItemStacks[i].stackSize <= mumberOfItems)
			{
				itemstack = this.furnaceItemStacks[i];
				this.furnaceItemStacks[i] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.furnaceItemStacks[i].splitStack(mumberOfItems);

				if (this.furnaceItemStacks[i].stackSize == 0)
				{
					this.furnaceItemStacks[i] = null;
				}

				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int i)
	{
		if (this.furnaceItemStacks[i] != null)
		{
			ItemStack itemstack = this.furnaceItemStacks[i];
			this.furnaceItemStacks[i] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int i, ItemStack stack)
	{
		this.furnaceItemStacks[i] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Returns the name of the inventory
	 */
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.name : "container.iat.cleaning_Table";
	}

	/**
	 * Returns if the inventory is named
	 */
	public boolean hasCustomInventoryName()
	{
		return this.name != null && this.name.length() > 0;
	}

	public void func_145951_a(String name)
	{
		this.name = name;
	}
	public boolean doesRenderWater() {
		if(this.getStackInSlot(1).getItem() == Items.water_bucket){
			if(this.worldObj.isRemote){
				return true;
			}

		}
			return false;
		
		}

		public void readFromNBT(NBTTagCompound tag)
		{
			super.readFromNBT(tag);
			NBTTagList nbttaglist = tag.getTagList("Items", 10);
			this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

			for (int i = 0; i < nbttaglist.tagCount(); ++i)
			{
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				byte b0 = nbttagcompound1.getByte("Slot");

				if (b0 >= 0 && b0 < this.furnaceItemStacks.length)
				{
					this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
				}
			}

			this.furnaceBurnTime = tag.getShort("BurnTime");
			this.furnaceCookTime = tag.getShort("CookTime");
			this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

			if (tag.hasKey("CustomName", 8))
			{
				this.name = tag.getString("CustomName");
			}
		}

		public void writeToNBT(NBTTagCompound tag)
		{
			super.writeToNBT(tag);
			tag.setShort("BurnTime", (short)this.furnaceBurnTime);
			tag.setShort("CookTime", (short)this.furnaceCookTime);
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < this.furnaceItemStacks.length; ++i)
			{
				if (this.furnaceItemStacks[i] != null)
				{
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();
					nbttagcompound1.setByte("Slot", (byte)i);
					this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
					nbttaglist.appendTag(nbttagcompound1);
				}
			}

			tag.setTag("Items", nbttaglist);

			if (this.hasCustomInventoryName())
			{
				tag.setString("CustomName", this.name);
			}
		}

		/**
		 * Returns the maximum stack size for a inventory slot.
		 */
		public int getInventoryStackLimit()
		{
			return 64;
		}

		/**
		 * Returns an integer between 0 and the passed value representing how close the current item is to being completely
		 * cooked
		 */
		@SideOnly(Side.CLIENT)
		public int getCookProgressScaled(int i)
		{
			return this.furnaceCookTime * i / 200;
		}

		/**
		 * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
		 * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
		 */
		@SideOnly(Side.CLIENT)
		public int getBurnTimeRemainingScaled(int time)
		{
			if (this.currentItemBurnTime == 0)
			{
				this.currentItemBurnTime = 200;
			}

			return this.furnaceBurnTime * time / this.currentItemBurnTime;
		}

		/**
		 * Furnace isBurning
		 */
		public boolean isBurning()
		{
			return this.furnaceBurnTime > 0;
		}

		public void updateEntity()
		{
			boolean flag = this.furnaceBurnTime > 0;
			boolean flag1 = false;

			if (this.furnaceBurnTime > 0)
			{
				--this.furnaceBurnTime;
			}

			if (!this.worldObj.isRemote)
			{
				if (this.furnaceBurnTime != 0 || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null)
				{
					if (this.furnaceBurnTime == 0 && this.canSmelt())
					{
						this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

						if (this.furnaceBurnTime > 0)
						{
							flag1 = true;

							if (this.furnaceItemStacks[1] != null)
							{
								--this.furnaceItemStacks[1].stackSize;

								if (this.furnaceItemStacks[1].stackSize == 0)
								{
									this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
								}
							}
						}
					}

					if (this.isBurning() && this.canSmelt())
					{
						++this.furnaceCookTime;

						if (this.furnaceCookTime == 200)
						{
							this.furnaceCookTime = 0;
							this.smeltItem();
							flag1 = true;
						}
					}
					else
					{
						this.furnaceCookTime = 0;
					}
				}

				if (flag != this.furnaceBurnTime > 0)
				{
					flag1 = true;
					BlockCleaningTable.updateDistilleryBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
				}
			}

			if (flag1)
			{
				this.markDirty();
			}
		}

		/**
		 * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
		 */
		private boolean canSmelt()
		{
			if (this.furnaceItemStacks[0] == null)
			{
				return false;
			}
			else
			{
				ItemStack itemstack = CleaningTableRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
				if (itemstack == null) return false;
				if (this.furnaceItemStacks[2] == null) return true;
				if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
				int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
				return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
			}
		}

		/**
		 * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
		 */
		public void smeltItem()
		{
			if (this.canSmelt())
			{
				
				ItemStack itemstack = CleaningTableRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

				if (this.furnaceItemStacks[2] == null)
				{
					this.furnaceItemStacks[2] = itemstack.copy();
				}
				else if (this.furnaceItemStacks[2].getItem() == itemstack.getItem())
				{
					this.furnaceItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
				}

				--this.furnaceItemStacks[0].stackSize;

				if (this.furnaceItemStacks[0].stackSize <= 0)
				{
					this.furnaceItemStacks[0] = null;
				}
			}
		}

		/**
		 * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
		 * fuel
		 */
		public static int getItemBurnTime(ItemStack stack)
		{
			if (stack == null)
			{
				return 0;
			}
			else
			{

				 if(stack.getItem() != null){
					if (stack.getItem() == Items.water_bucket) return 200;
				}

				return GameRegistry.getFuelValue(stack);
			}
		}

		public static boolean isItemFuel(ItemStack fuel)
		{
			/**
			 * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
			 * fuel
			 */
			return getItemBurnTime(fuel) > 0;
		}

		/**
		 * Do not make give this method the name canInteractWith because it clashes with Container
		 */
		public boolean isUseableByPlayer(EntityPlayer player)
		{
			return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
		}

		public void openInventory() {}

		public void closeInventory() {}

		/**
		 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
		 */
		public boolean isItemValidForSlot(int i, ItemStack stack)
		{
			return i == 2 ? false : (i == 1 ? isItemFuel(stack) : true);
		}

		/**
		 * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
		 * block.
		 */
		public int[] getAccessibleSlotsFromSide(int p_94128_1_)
		{
			return p_94128_1_ == 0 ? slotsBottom : (p_94128_1_ == 1 ? slotsTop : slotsSides);
		}

		/**
		 * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
		 * side
		 */
		public boolean canInsertItem(int i, ItemStack stack, int var1)
		{
			return this.isItemValidForSlot(i, stack);
		}

		/**
		 * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
		 * side
		 */
		public boolean canExtractItem(int i, ItemStack item, int var2)
		{
			return var2 != 0 || i != 1 || item.getItem() == Items.bucket;
		}
	}