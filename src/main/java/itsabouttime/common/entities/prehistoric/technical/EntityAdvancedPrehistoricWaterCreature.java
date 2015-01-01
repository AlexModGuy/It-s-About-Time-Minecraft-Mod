package itsabouttime.common.entities.prehistoric.technical;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAdvancedPrehistoricWaterCreature
  extends EntityPrehistoricWaterMob
  implements IAnimals
{
  protected int attackInterval = 50;
  protected float attackSpeed = 1.2F;
  protected float swimSpeed = 0.5F;
  private double targetX;
  private double targetY;
  private double targetZ;
  private Entity targetedEntity;
  private boolean isAttacking;
  protected float swimRadius = 4.0F;
  protected float swimRadiusHeight = 4.0F;
  protected boolean Agrooed = false;
  protected boolean landBounce = true;
  
  public EntityAdvancedPrehistoricWaterCreature(World world)
  {
    super(world);
  }
  
  protected boolean canTriggerWalking()
  {
    return false;
  }
  
  protected boolean isAIEnabled()
  {
    return true;
  }
  public boolean canBreatheUnderwater()
  {
    return true;
  }
  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
  }
   
  public boolean isInWater()
  {
    return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
  }
  
  public void onUpdate()
  {
    super.onUpdate();
    if (isInWater()) {
      this.motionY *= 0.1D;
    }
  }
  public void applyEntityCollision(Entity entity)
  {
    super.applyEntityCollision(entity);
    if ((this.Agrooed) && (this.targetedEntity == entity)) {
      attackEntityAsMob(entity);
    }
  }
  
  
  protected Entity findPrey()
  {
    EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
    return (player != null) && (canEntityBeSeen(player)) ? player : null;
  }
  

  
  public boolean attackEntityAsMob(Entity entity)
  {
    float f = (float)getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
    return entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
  }
  

  public void onEntityUpdate()
  {
    int air = getAir();
    super.onEntityUpdate();
    if ((isEntityAlive()) && (!isInWater()))
    {
      air--;
      setAir(air);
      if (getAir() == -20)
      {
        setAir(0);
        attackEntityFrom(DamageSource.drown, 2.0F);
      }
    }
    else
    {
      setAir(300);
    }
  }
  

  protected void updateAITasks()
  {
    super.updateAITasks();
    if (isInWater())
    {
      double dx = this.targetX - this.posX;
      double dy = this.targetY - this.posY;
      double dz = this.targetZ - this.posZ;
      double dist = MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz);
      if ((dist < 1.0D) || (dist > 1000.0D))
      {
        this.targetX = (this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
        this.targetY = (this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadiusHeight);
        this.targetZ = (this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
        this.isAttacking = false;
      }
      if (this.worldObj.getBlock(MathHelper.floor_double(this.targetX), MathHelper.floor_double(this.targetY + this.height), MathHelper.floor_double(this.targetZ)).getMaterial() == Material.water)
      {
        this.motionX += dx / dist * 0.05D * this.swimSpeed;
        this.motionY += dy / dist * 0.1D * this.swimSpeed;
        this.motionZ += dz / dist * 0.05D * this.swimSpeed;
      }
      else
      {
        this.targetX = this.posX;
        this.targetY = (this.posY + 0.1D);
        this.targetZ = this.posZ;
      }
      if (this.isAttacking)
      {
        this.motionX *= this.attackSpeed;
        this.motionY *= this.attackSpeed;
        this.motionZ *= this.attackSpeed;
      }
      if ((this.Agrooed) && (this.rand.nextInt(this.attackInterval) == 0))
      {
        this.targetedEntity = findPrey();
        if ((this.targetedEntity != null) && (this.targetedEntity.isInWater()))
        {
          this.targetX = this.targetedEntity.posX;
          this.targetY = this.targetedEntity.posY;
          this.targetZ = this.targetedEntity.posZ;
          this.isAttacking = true;
        }
      }
      this.renderYawOffset += (-(float)Math.atan2(this.motionX, this.motionZ) * 180.0F / 3.141593F - this.renderYawOffset) * 0.5F;
      this.rotationYaw = this.renderYawOffset;
      float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
      this.rotationPitch += ((float)Math.atan2(this.motionY, f) * 180.0F / 3.141593F - this.rotationPitch) * 0.5F;
    }
    else
    {
      this.motionX = 0.0D;
      this.motionY -= 0.08D;
      this.motionY *= 0.9800000190734863D;
      this.motionZ = 0.0D;
      if ((this.landBounce) && (this.onGround) && (this.rand.nextInt(30) == 0))
      {
        this.motionY = 0.300000011920929D;
        this.motionX = (-0.4F + this.rand.nextFloat() * 0.8F);
        this.motionZ = (-0.4F + this.rand.nextFloat() * 0.8F);
      }
    }
  }
}
