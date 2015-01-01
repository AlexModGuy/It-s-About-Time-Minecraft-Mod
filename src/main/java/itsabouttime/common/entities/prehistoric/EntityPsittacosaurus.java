package itsabouttime.common.entities.prehistoric;

import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.ai.AIPsittacoGrassEating;
import itsabouttime.common.entities.ai.EntityAIEatPsittacoGrass;
import itsabouttime.common.entities.ai.EntityAINearestAttackablePisscatoTarget;
import itsabouttime.common.entities.ai.EntityAIPrehistoricMobMate;
import itsabouttime.common.entities.ai.EntityAIPrehistoricTargetNonTamed;
import itsabouttime.common.entities.prehistoric.technical.EntityPehistoricAnimal;
import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricMob;
import itsabouttime.common.entities.prehistoric.technical.EntityTamablePrehistoric;

public class EntityPsittacosaurus extends EntityPrehistoricMob implements IAnimatedEntity{
    private EntityAIEatPsittacoGrass field_146087_bs = new EntityAIEatPsittacoGrass(this, this);
    private int sheepTimer;
    private int animID;
    private int animTick;
	public EntityPsittacosaurus(World p_i1681_1_) {
		super(p_i1681_1_);
        this.setSize(1.5F, 1F);
        this.dataWatcher.addObject(13, Byte.valueOf((byte)0));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false));
        this.tasks.addTask(3, new EntityAIPrehistoricMobMate(this, 1.0D));
        this.tasks.addTask(4, this.field_146087_bs);
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAITempt(this, 1.2D, Items.blaze_powder, false));
        this.tasks.addTask(7, new EntityAITempt(this, 1.2D, Items.wheat, false));
        this.tasks.addTask(8, new EntityAIAvoidEntity(this, EntityPlayer.class, 32.0F, 0.8D, 1.33D));
        this.tasks.addTask(9, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLivingBase.class, 6.0F));
        this.tasks.addTask(11, new EntityAILookIdle(this));
        this.targetTasks.addTask(10, new EntityAINearestAttackablePisscatoTarget(this, EntityMob.class, 0, true));

        this.isImmuneToFire=this.getType()==0 ? true : false;
		}
	  public boolean attackEntityAsMob(Entity p_70652_1_)
	    {
	
		  p_70652_1_.worldObj.addWeatherEffect(new EntityLightningBolt(p_70652_1_.worldObj, p_70652_1_.posX, p_70652_1_.posY, p_70652_1_.posZ));
return true;
}
	  protected float getSoundPitch()
	    {
	        return super.getSoundPitch() * 3.1F;
	    }

	  /**
	     * Returns the sound this mob makes while it's alive.
	     */
	    protected String getLivingSound()
	    {
	        return "iat:Psittaco-say";
	    }

	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "iat:Psittaco-hurt";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "iat:Psittaco-hurt";
	    }
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(18.0D);

        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        
    }
	 @SideOnly(Side.CLIENT)
	    public float func_70894_j(float p_70894_1_)
	    {
	        return this.sheepTimer <= 0 ? 0.0F : (this.sheepTimer >= 4 && this.sheepTimer <= 36 ? 1.0F : (this.sheepTimer < 4 ? ((float)this.sheepTimer - p_70894_1_) / 4.0F : -((float)(this.sheepTimer - 40) - p_70894_1_) / 4.0F));
	    }

	    @SideOnly(Side.CLIENT)
	    public float func_70890_k(float p_70890_1_)
	    {
	        if (this.sheepTimer > 4 && this.sheepTimer <= 36)
	        {
	            float f1 = ((float)(this.sheepTimer - 4) - p_70890_1_) / 32.0F;
	            return ((float)Math.PI / 5F) + ((float)Math.PI * 7F / 100F) * MathHelper.sin(f1 * 28.7F);
	        }
	        else
	        {
	            return this.sheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch / (180F / (float)Math.PI);
	        }
	    }
    public boolean isAIEnabled()
    {
        return true;
    }
    public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		if (itemstack != null && itemstack.getItem() == Items.spawn_egg) {
			return super.interact(par1EntityPlayer);
		}
		else if (itemstack != null && itemstack.getItem() == Items.blaze_powder&&this.getType()==0) {
		    this.worldObj.spawnParticle("hugeexplosion", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("hugeexplosion", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("hugeexplosion", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		    this.worldObj.spawnParticle("explode", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		this.playSound("ambient.cave.cave", 0.15F, 1.0F);
		this.playSound("ambient.cave.cave", 0.15F, 1.0F);
		this.playSound("mob.wither.death", 0.95F, 0.5F);
this.setCustomNameTag("Bringer of Peace");
		this.setType(1);
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
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return new EntityPsittacosaurus(this.worldObj);
	}
	protected void updateAITasks()
    {
        this.sheepTimer = this.field_146087_bs.func_151499_f();
        super.updateAITasks();
    }
	 public void eatGrassBonus()
	    {
		 this.heal(1F);
		 if(animID == 0) AnimationAPI.sendAnimPacket(this, 60);	        
	    }
    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.worldObj.isRemote)
        {
            this.sheepTimer = Math.max(0, this.sheepTimer - 1);
        }
        if(this.getType()==1){
        this.worldObj.spawnParticle("smoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        this.worldObj.spawnParticle("dripLava", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        this.worldObj.spawnParticle("magicCrit", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        this.worldObj.spawnParticle("flame", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
      //  this.worldObj.spawnParticle("heart", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        }
        super.onLivingUpdate();
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
    {
        p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);
            this.setType(0);
       
  		return p_110161_1_;
  		}
    public void onUpdate(){
super.onUpdate();
if(animID != 0) animTick++;

}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Set the animID field to the id in the parameter.
	 */
	public void setAnimID(int id) {
		animID = id;
	}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Set the animTick field to the tick in the parameter.
	 */
	public void setAnimTick(int tick) {
		animTick = tick;
	}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Return the animID.
	 */
	public int getAnimID() {
		return animID;
	}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Return the animTick.
	 */
	public int getAnimTick() {
		return animTick;
	}
}
    



