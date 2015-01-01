package itsabouttime.common.entities;

import itsabouttime.common.entities.ai.EntityAIFlying;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFlightTest
  extends EntityCreature
{
  private double flightTargetX;
  private double flightTargetY;
  private double flightTargetZ;
  public float wingRotation;
  public float prevWingRotation;
  public float flapSpeed;
  public float prevFlapSpeed;
  public float timeInAir = 1.2F;
  public boolean Isflying;

  public EntityFlightTest(World world)
  {
    super(world);
    setSize(0.3F, 0.6F);
    this.tasks.addTask(0, new EntityAIFlying(this));
    this.tasks.addTask(1, new EntityAISwimming(this));
    this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0F, 1.0D, 1.4D));
    this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 8.0F, 1.0D, 1.4D));
    this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
    this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 4.0F));
    this.tasks.addTask(6, new EntityAILookIdle(this));
  }
  
  protected boolean isAIEnabled()
  {
    return true;
  }
  
  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6.0D);
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);  }
  protected void entityInit()
  {
    super.entityInit();
  
  }
  
  public void onLivingUpdate()
  {
    super.onLivingUpdate();
    this.prevWingRotation = this.wingRotation;
    this.prevFlapSpeed = this.flapSpeed;
    this.flapSpeed = ((float)(this.flapSpeed + (this.onGround ? -1.0D : 1.2D)));
    if (this.flapSpeed < 0.0F) {
      this.flapSpeed = 0.0F;
    }
    if (this.flapSpeed > 1.0F) {
      this.flapSpeed = 1.0F;
    }
    if ((!this.onGround) && (this.timeInAir < 1.0F)) {
      this.timeInAir = 1.0F;
    }
    this.timeInAir = ((float)(this.timeInAir * 0.9D));
    if (((!this.onGround) && (this.motionY < 0.0D)) || (isFlying())) {
      this.motionY *= 0.6D;
    }
    this.wingRotation += this.timeInAir * 2.0F;
  }
  
  protected void updateAITasks()
  {
    super.updateAITasks();
    if (isFlying())
    {
      double d = this.flightTargetX - this.posX;
      double d1 = this.flightTargetY - this.posY;
      double d2 = this.flightTargetZ - this.posZ;
      double d3 = d * d + d1 * d1 + d2 * d2;
      if ((!canBlockSeen(this.flightTargetX, this.flightTargetY, this.flightTargetZ)) || (d3 < 0.4D))
      {
        setFlying(false);
      }
      else
      {
        d3 = MathHelper.sqrt_double(d3);
        this.motionX += d / d3 * 0.1D;
        this.motionY += d1 / d3 * 0.1D;
        this.motionZ += d2 / d3 * 0.1D;
        float f = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / 3.141593653599692D) - 90.0F;
        float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
        this.rotationYaw += f1;
      }
    }
    else if ((getRNG().nextInt(100) == 0) && (findNewFlightTarget(Material.leaves)))
    {
      setFlying(true);
    }
  }
  
  private boolean findNewFlightTarget(Material material)
  {
    AxisAlignedBB axisalignedbb = this.boundingBox.expand(8.0D, 8.0D, 8.0D);
    int i = MathHelper.floor_double(axisalignedbb.minX);
    int j = MathHelper.floor_double(axisalignedbb.maxX + 1.0D);
    int k = MathHelper.floor_double(axisalignedbb.minY);
    int l = MathHelper.floor_double(axisalignedbb.maxY + 1.0D);
    int i1 = MathHelper.floor_double(axisalignedbb.minZ);
    int j1 = MathHelper.floor_double(axisalignedbb.maxZ + 1.0D);
    for (int k1 = i; k1 < j; k1++) {
      for (int l1 = k; l1 < l; l1++) {
        for (int i2 = i1; i2 < j1; i2++)
        {
          Block block = this.worldObj.getBlock(k1, l1 - 1, i2);
          if ((block.getMaterial() == material) && (canBlockSeen(k1 + 0.5D, l1 + 1.0D, i2 + 0.5D)))
          {
            this.flightTargetX = (k1 + 0.5D);
            this.flightTargetY = (l1 + 0.5D);
            this.flightTargetZ = (i2 + 0.5D);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean canBlockSeen(double x, double y, double z)
  {
    return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + getEyeHeight(), this.posZ), Vec3.createVectorHelper(x, y, z)) == null;
  }
  
  protected void fall(float f) {}
  

  
 
  
 
  

  
  protected Item getDropItem()
  {
    return Items.feather;
  }
  
 
  
  public boolean isOnLadder()
  {
    return isFlying() ? false : super.isOnLadder();
  }
  
 
  
  
  public boolean isFlying()
  {
    return this.Isflying;
  }
  
  public void setFlying(boolean flag)
  {
    this.Isflying = flag;
  }
}

