package itsabouttime.common.entities.prehistoric;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.prehistoric.technical.EntityAdvancedPrehistoricWaterCreature;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMegalograptus
  extends EntityAdvancedPrehistoricWaterCreature
{
    private int attackTimer;

  public EntityMegalograptus(World world)
  {
    super(world);
    setSize(1.5F, 0.4F);
    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, false));
    this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTrilobite.class, 0, true));
    this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityOpabina.class, 0, true));

  }
  //TODO:Add Attack AI
  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
 
  }
  
  protected void entityInit()
  {
    super.entityInit();
    this.dataWatcher.addObject(13, Byte.valueOf((byte)0));
  }
  
  protected void dropFewItems(boolean par1, int par2)
  {
	  int j =  1;
      for (int k = 0; k < j; ++k)
      {


      }
  }
  @SideOnly(Side.CLIENT)
  public int getAttackTimer()
  {
      return this.attackTimer;
  }

  

  
  public IEntityLivingData onSpawnWithEgg(IEntityLivingData ientitylivingdata)
  {
    return ientitylivingdata;
  }
}
