package itsabouttime.common.entities.prehistoric;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.prehistoric.technical.EntityAdvancedPrehistoricWaterCreature;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPikaia extends EntityAdvancedPrehistoricWaterCreature implements ISmallWaterCritter
{

  public EntityPikaia(World world)
  {
    super(world);
    setSize(0.7F, 0.2F);
	 this.dataWatcher.addObject(13, Byte.valueOf((byte)0));

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
  public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
  {
      p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);

      if ( this.getRNG().nextInt(2) > 0)
      {
          this.setType(getRNG().nextInt(2));
      }
		return p_110161_1_;
		}


  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(7.0D);
  }
  
 
  
  protected void dropFewItems(boolean par1, int par2)
  {
	  int j =  1;
      for (int k = 0; k < j; ++k)
      {


      }
  }

}
