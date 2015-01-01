package itsabouttime.common.entities;

import java.util.Calendar;

import itsabouttime.iat;
import itsabouttime.client.gui.GuiScreenFossilBook;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.inventory.InventoryTimeMachine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityTimeMachine extends EntityAnimal{

	 public InventoryTimeMachine InventoryTimeMachine = new InventoryTimeMachine(this);
	
	protected boolean TimeMachineJumping;
	protected float jumpPower;
    private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, Entity.class, 1.2D, false);


	public EntityTimeMachine(World par1World) {
		super(par1World);
        this.isImmuneToFire = true;
		this.setSize(1.4F, 1.6F);        
        this.tasks.addTask(2, this.aiAttackOnCollide);

	}

	public EntityTimeMachine(World par1World, double par2, double par4, double par6) {
		this(par1World);
		this.setPosition(par2, par4 + (double) this.yOffset, par6);

	}

	public  void  GUISTUFF() {
		
	}

	@Override
	public boolean canBreatheUnderwater()
	{
	    return true;
	}
	
	public boolean isTimeMachineJumping() {
		return this.TimeMachineJumping;
	}

	public void setTimeMachineJumping(boolean par1) {
		this.TimeMachineJumping = par1;
	}


	/**
	 * Returns true if this entity should push and be pushed by other entities
	 * when colliding.
	 */
	public boolean canBePushed() {
     
		return this.riddenByEntity == null;
	}
	  protected void collideWithEntity(Entity p_82167_1_)
	    {
	        if (p_82167_1_ != ridingEntity )
	        {
	        	
	        }

	        super.collideWithEntity(p_82167_1_);
	    }
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float par1) {
		if (par1 > 1.0F) {
			//this.playSound("mob.TimeMachine.land", 0.4F, 1.0F);
		}

		int i = MathHelper.ceiling_float_int(par1 * 0.5F - 3.0F);

		
			

			Block block = this.worldObj.getBlock(
					MathHelper.floor_double(this.posX),
					MathHelper.floor_double(this.posY - 0.2D
							- (double) this.prevRotationYaw),
							MathHelper.floor_double(this.posZ));

			if (block.getMaterial() != Material.air) {
				Block.SoundType soundtype = block.stepSound;
				this.worldObj.playSoundAtEntity(this,
						soundtype.getStepResourcePath(),
						soundtype.getVolume() * 0.5F,
						soundtype.getPitch() * 0.75F);
			}
		}
	
  

	/**
	 * Called when a player interacts with a mob.
	 */
	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == Items.spawn_egg) {
			return super.interact(par1EntityPlayer);
		}
		else if (itemstack != null && itemstack.getItem() == Items.blaze_powder) {
			par1EntityPlayer.openGui(iat.instance, iat.guiIdTimeMachine, this.worldObj, getEntityId(), 0, 0);

			return true;

		}
		
		if (this.riddenByEntity != null &&this.riddenByEntity == par1EntityPlayer&& iat.TimeMachineInv.isPressed()) {
			par1EntityPlayer.openGui(iat.instance, iat.guiIdTimeMachine, this.worldObj, getEntityId(), 0, 0);

				return true;
			}
		if (this.riddenByEntity == null) {
			if (itemstack != null
					&& itemstack.interactWithEntity(par1EntityPlayer, this)) {
				return true;
			} else {
				this.onPlayerMounted(par1EntityPlayer);
				return true;
				
				
			}
		} else {
			return super.interact(par1EntityPlayer);
		}
	}

	private void onPlayerMounted(EntityPlayer par1EntityPlayer) {
		par1EntityPlayer.rotationYaw = this.rotationYaw;
		par1EntityPlayer.rotationPitch = this.rotationPitch;

		if (!this.worldObj.isRemote) {
			par1EntityPlayer.mountEntity(this);
		}
	}
	protected String getHurtSound()
    {
        return "random.break";
    }

    


	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
/*if(InventoryTimeMachine.getStackInSlot(0) == new ItemStack(IATStuff.TimeGem)){
		this.travelToDimension(iat.dimensionIdCambrian);	
		}*/
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		Material m = worldObj.getBlock(i, j-1, k).getMaterial();
		boolean flag = (m == Material.water);
		boolean flag2 = (m == Material.lava); 

		if (flag ) {
		  this.playSound("random.fizz", 0.15F, 1.0F);
 
		this.worldObj.setBlock(i, j-1, k, Blocks.ice);
		
		}
		if (flag2 ) {
			  this.playSound("random.fizz", 0.15F, 1.0F);

			this.worldObj.setBlock(i, j-1, k, Blocks.obsidian);
		
		}
		
		else if(this.ridingEntity != null && Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()){
			this.motionY = 0.1D;
		}
		else if(this.ridingEntity != null && Minecraft.getMinecraft().gameSettings.keyBindSneak.getIsKeyPressed()){
			this.motionY = -0.1D;
	
			}
		
		 
		super.onLivingUpdate();
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		
	


		

		super.onUpdate();
	}
	
	private double getTimeMachineJumpPower(){
		return 50.0f;	
		
	}

	/**
	 * Moves the entity based on the specified heading. Args: strafe, forward
	 */
	public void moveEntityWithHeading(float moveStrafing, float moveForward) {
		if (this.riddenByEntity != null) {
			this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			moveStrafing = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F; 
			moveForward = ((EntityLivingBase) this.riddenByEntity).moveForward;

			if (moveForward <= 0.0F) {
				moveForward *= 0.25F;	

			}

			if (this.jumpPower > 0.0F && !this.isTimeMachineJumping() && this.onGround) {
				
				this.motionY = this.jumpPower;

				this.setTimeMachineJumping(true);
				this.isAirBorne = true;

				if (moveForward > 0.0F) {
					float f2 = MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F);
					float f3 = MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F);
					this.motionX += (double) (-0.4F * f2 * this.jumpPower);
					this.motionZ += (double) (0.4F * f3 * this.jumpPower);
					//this.playSound("mob.TimeMachine.jump", 0.4F, 1.0F);
				}

				this.jumpPower = 0.0F;
			}

			this.stepHeight = 1.0F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

			if (!this.worldObj.isRemote) {
				this.setAIMoveSpeed((float) this.getEntityAttribute(
						SharedMonsterAttributes.movementSpeed)
						.getAttributeValue());
				super.moveEntityWithHeading(moveStrafing, moveForward);
			}

			if (this.onGround) {
				this.jumpPower = 0.0F;
				this.setTimeMachineJumping(false);
			}
			if (this.onGround&&Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()) {
				this.jumpPower = 1F;
				this.setTimeMachineJumping(false);
			}

		} else {
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.moveEntityWithHeading(moveStrafing, moveForward);
		}
	}



	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	protected boolean isAIEnabled() {
		return true;
	}

	public void setJumpPower(int par1) {

		if (par1 < 0) {
			par1 = 0;
		}

		if (par1 >= 90) {
			this.jumpPower = 1.0F;
		} else {
			this.jumpPower = 0.4F + 0.4F * (float) par1 / 90.0F;
		}
	}

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
        
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset()-0.7 , this.posZ );


        }
    }
   
    private void func_110232_cE()
    {
        if (!this.worldObj.isRemote)
        {
    
        }
    }
    
	public boolean isOnLadder() {
		return false;
	}


	 public void travelToDimension(int p_71027_1_)
	    {
	        InventoryTimeMachine.dropContentsWhenDead = false;
	        super.travelToDimension(p_71027_1_);
	    }
	
	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
