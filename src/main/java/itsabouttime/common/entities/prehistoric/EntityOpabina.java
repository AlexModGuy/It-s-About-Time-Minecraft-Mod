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

public class EntityOpabina extends EntityAdvancedPrehistoricWaterCreature implements ISmallWaterCritter
{
    private int attackTimer;

  public EntityOpabina(World world)
  {
    super(world);
    setSize(0.7F, 0.2F);
  }
  //TODO:Add Attack AI
  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(7.0D);
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
          this.entityDropItem(new ItemStack(IATstuff.ArmorPlates, rand.nextInt(4)+ 3,2 ), 0.0F);
          this.entityDropItem(new ItemStack(IATstuff.Eyes, 5,2 ), 0.0F);

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
