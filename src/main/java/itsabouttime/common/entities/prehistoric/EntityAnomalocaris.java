package itsabouttime.common.entities.prehistoric;

import itsabouttime.iat;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.prehistoric.technical.EntityAdvancedPrehistoricWaterCreature;
import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricWaterMob;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityAnomalocaris
  extends EntityAdvancedPrehistoricWaterCreature
{
    private int attackTimer;

  public EntityAnomalocaris(World world)
  {
    super(world);
    setSize(1.5F, 0.4F);
    this.dataWatcher.addObject(13, Byte.valueOf((byte)0));
    
    this.Agrooed = true;
    this.swimRadius = 25F;
    this.swimSpeed = 0.5F;
    this.attackInterval = 23;
    this.landBounce = true;
  }
  
  //TODO:Add Attack AI
  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);

  }
  

  protected void dropFewItems(boolean par1, int par2)
  {
	  int j =  1;
      for (int k = 0; k < j; ++k)
      {
          this.entityDropItem(new ItemStack(IATstuff.ArmorPlates, rand.nextInt(4)+4,1 ), 0.0F);
          this.entityDropItem(new ItemStack(IATstuff.Eyes, 2,1 ), 0.0F);

      }
  }
	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == Items.spawn_egg) {
			return super.interact(par1EntityPlayer);
		}
		else if (itemstack != null && itemstack.getItem() == IATstuff.OldKey) {
		    this.worldObj.spawnParticle("hugeexplosion", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("hugeexplosion", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("hugeexplosion", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    
		    this.worldObj.spawnParticle("angryVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("angryVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("angryVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("angryVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("happyVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("happyVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("happyVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("happyVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("note", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("note", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("note", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("note", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("note", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);

		    this.worldObj.spawnParticle("explode", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		this.playSound("ambient.cave.cave", 0.15F, 1.0F);
		this.playSound("ambient.cave.cave", 0.15F, 1.0F);
		this.playSound("mob.villager.no", 0.15F, 2.0F);
		this.playSound("mob.wither.death", 0.95F, 0.5F);
		this.playSound("note.bass", 1.15F, 1.0F);
		this.playSound("mob.villager.no", 0.15F, 1.0F);
this.setCustomNameTag("RokuroCarisu");

		this.setType(2);
			return true;

		}
		return super.interact(par1EntityPlayer);
	}
  public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.writeEntityToNBT(par1NBTTagCompound);
    par1NBTTagCompound.setInteger("Type", getType());
  }
  
  public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.readEntityFromNBT(par1NBTTagCompound);
    setType(par1NBTTagCompound.getInteger("Type"));
  }
  public int getType()
  {
    return this.dataWatcher.getWatchableObjectByte(13);
  }
  public void setType(int i)
  {
    this.dataWatcher.updateObject(13, Byte.valueOf((byte)i));
  }
  @Override
  protected Entity findPrey()
  {
    AxisAlignedBB area = this.boundingBox.expand(16.0D, 16.0D, 16.0D);
    
    EntityPlayer player = (EntityPlayer)super.findPrey();
    if (player != null) {
      return player;
    }//Up is USELESS
   
    Entity Trilobite = worldObj.findNearestEntityWithinAABB(EntityTrilobite.class, area, this);
    if (Trilobite != null) {
      return Trilobite;
    }
    Entity Opab = worldObj.findNearestEntityWithinAABB(EntityOpabina.class, area, this);
    if (Opab != null) {
      return Opab;
    }
    return worldObj.findNearestEntityWithinAABB(EntityPlayer.class, area, this);
  }
  
  public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
  {
      p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);

      if ( this.getRNG().nextInt(2)>0)
      {
          this.setType(getRNG().nextInt(2));

 
      }
		return p_110161_1_;}




}
