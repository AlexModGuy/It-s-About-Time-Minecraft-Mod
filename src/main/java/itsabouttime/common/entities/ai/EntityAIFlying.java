package itsabouttime.common.entities.ai;

import itsabouttime.common.entities.EntityFlightTest;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIFlying
  extends EntityAIBase
{
  private EntityFlightTest theEntity;
  
  public EntityAIFlying(EntityFlightTest entity)
  {
    this.theEntity = entity;
    setMutexBits(5);
  }
  
  public boolean shouldExecute()
  {
    return this.theEntity.isFlying();
  }
  
  public boolean continueExecuting()
  {
    return this.theEntity.isFlying();
  }
}
