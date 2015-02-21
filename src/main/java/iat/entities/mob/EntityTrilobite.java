package iat.entities.mob;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import iat.entities.EntityIatMob;

public class EntityTrilobite extends EntityIatMob implements IWaterPrehistoricSmall{

	public EntityTrilobite(World world) {
		super(world);
		this.setSize(0.7F, 0.5F);
        this.getNavigator().setAvoidsWater(false);
        this.getNavigator().setCanSwim(true);
		this.dataWatcher.addObject(13, Byte.valueOf((byte)0));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D)); 
		this.tasks.addTask(1, new EntityAITempt(this, 1.1D, Items.wheat, true));
		this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityPlayer.class, 6.0F, 1.0D, 1.2D)); 
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLiving.class, 6.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return null;
	}
	
	public boolean canBreatheUnderwater()
	{
		return true;
	}
	public boolean getCanSpawnHere()
	{
		return this.worldObj.checkNoEntityCollision(this.boundingBox);
	}
	public boolean isAIEnabled()
	{
		return true;
	}
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setInteger("Type", getType());
	}

	public void readEntityFromNBT(NBTTagCompound tag)
	{
		super.readEntityFromNBT(tag);
		setType(tag.getInteger("Type"));
	}
	public int getType()
	{
		return this.dataWatcher.getWatchableObjectByte(13);
	}
	public void setType(int i)
	{
		this.dataWatcher.updateObject(13, Byte.valueOf((byte)i));
	}
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data)
	{
		data = super.onSpawnWithEgg(data);

		if ( this.getRNG().nextInt(4) > 0)
		{
			this.setType(getRNG().nextInt(3));
		}
		return data;}


	protected String getHurtSound()
	{
		return "random.anvil_land";
	}
	protected String getDeathSound()
	{
		return "mob.creeper.death";
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}
	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	protected boolean canDespawn()
	{
		return true;
	}

	/**
	 * Get the experience points the entity currently has.
	 */
	protected int getExperiencePoints(EntityPlayer player)
	{
		return 1 + this.worldObj.rand.nextInt(3);
	}

	/**
	 * Gets called every tick from main Entity class
	 */
	public void onEntityUpdate()
	{
		int i = this.getAir();
		super.onEntityUpdate();

		if (this.isEntityAlive() && !this.isInWater())
		{
			--i;
			this.setAir(i);

			if (this.getAir() == -20)
			{
				this.setAir(0);
				this.attackEntityFrom(DamageSource.drown, 2.0F);
			}
		}
		else
		{
			this.setAir(300);
		}
	}

}
