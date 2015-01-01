package itsabouttime.common.entities.prehistoric;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import itsabouttime.common.entities.prehistoric.technical.EntityPehistoricAnimal;

public class EntityTiktaalik extends EntityPehistoricAnimal implements ISmallWaterCritter{
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
	public EntityTiktaalik(World p_i1681_1_) {
		super(p_i1681_1_);
		this.setSize(1.3F, 0.25F);	
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
	}
	 public boolean canBreatheUnderwater()
	    {
	        return true;
	    }
	 /**
	     * Returns the sound this mob makes while it's alive.
	     */
	    protected String getLivingSound()
	    {
	        return "iat:Anphib-say";
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
	    
	    }
	    
	    public void onUpdate()
	    {
	      super.onUpdate();
	      if (isInWater()) {
	        this.motionY *= 0.1D;
	      }
	    }
	    protected Entity findPrey()
	    {
	      EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
	      return (player != null) && (canEntityBeSeen(player)) ? player : null;
	    }
	    
	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "iat:Coelophysis-hurt";
	    }
	    public boolean isInWater()
	    {
	      return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
	    }
	    
	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "iat:Coelophysis-hurt";
	    }
	  protected void applyEntityAttributes()
	  {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);

	  }	
	  protected boolean isAIEnabled()
	  {
	    return true;
	  }
	  protected void dropFewItems(boolean par1, int par2)
	  {
		  int j =  1;
	      for (int k = 0; k < j; ++k)
	      {
	         // this.entityDropItem(new ItemStack(IATStuff.ArmorPlates, rand.nextInt(4)+ 3,2 ), 0.0F);
	        //  this.entityDropItem(new ItemStack(IATStuff.Eyes, 5,2 ), 0.0F);

	      }
	  }
}
