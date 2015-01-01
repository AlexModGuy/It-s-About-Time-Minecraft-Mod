package itsabouttime.common.entities.prehistoric;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricSeaCrawler;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityTrilobite extends EntityPrehistoricSeaCrawler implements ISmallWaterCritter{

	

	public EntityTrilobite(World par1World) {
		super(par1World);
		this.setSize(0.7F, 0.5F);
		 this.dataWatcher.addObject(13, Byte.valueOf((byte)0));
	        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
	       
	       // this.tasks.addTask(1, new EntityAITempt(this, 1.1D, Item.getItemFromBlock(Main.DBCoral), false));
	      //  this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityAnomacalaris.class, 6.0F, 1.0D, 1.2D));

	       
	        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
	        this.tasks.addTask(6, new EntityAILookIdle(this));
	}
	 protected void dropFewItems(boolean par1, int par2)
	  {
	      int j =  1;

	      for (int k = 0; k < j; ++k)
	      {
	          this.entityDropItem(new ItemStack(IATstuff.ArmorPlates, 1,0 ), 0.0F);
	          this.entityDropItem(new ItemStack(IATstuff.Eyes, 2,0 ), 0.0F);

	      }
	  }
	public boolean isAIEnabled()
    {
        return true;
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
	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	    }


	    public void setType(int i)
	    {
	      this.dataWatcher.updateObject(13, Byte.valueOf((byte)i));
	    }
	    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
	    {
	        p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);

	        if ( this.getRNG().nextInt(4) > 0)
	        {
	            this.setType(getRNG().nextInt(3));
	        }
			return p_110161_1_;}

	
	  protected String getHurtSound()
	    {
	        return "random.anvil_land";
	    }
	   protected String getDeathSound()
	    {
	        return "mob.creeper.death";
	    }
	
	   
	   
	 
	   
	
	  }
		   


