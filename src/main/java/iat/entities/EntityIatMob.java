package iat.entities;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public abstract class EntityIatMob extends EntityTameable implements IAnimals{

	private int inLove;
	private int breeding;
	private EntityPlayer theBreeder;
	public int frame;
	public float minSize;
	public float maxSize;
	public int adultAge;
	public int maxAge;

	public EntityIatMob(World world)
	{
		super(world);
		this.experienceValue = 5;
		this.dataWatcher.addObject(27, Byte.valueOf((byte)0));
		this.dataWatcher.addObject(30, Byte.valueOf((byte)0));

	}
	/**
	 * The item that is used to breed the mob(ex. Wheat for Sheep, carrots for pigs, etc.)
	 * @return stack.getItem() == ITEM
	 */
	public boolean isBreedingItem(ItemStack stack)
	{
		return stack.getItem() == Items.wheat;
	}
	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setInteger("InLove", this.inLove);
		tag.setInteger("Gender", getGender());
		tag.setInteger("AnimalAge", getAnimalAge());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound tag)
	{
		super.readEntityFromNBT(tag);
		this.inLove = tag.getInteger("InLove");
		setGender(tag.getInteger("Gender"));
		setAnimalAge(tag.getInteger("AnimalAge"));
	}
	/**returns and integer for the mobs gender. 0 = female, 1 = male*/
	public int getGender()
	{
		return this.dataWatcher.getWatchableObjectByte(27);
	}

	/**returns and integer for the mobs gender. 0 = female, 1 = male*/
	public void setGender(int i)
	{
		this.dataWatcher.updateObject(27, Byte.valueOf((byte)i));
	}
	/**returns and integer for the mobs age.*/
	public int getAnimalAge()
	{
		return this.dataWatcher.getWatchableObjectByte(30);
	}
	/**returns and integer for the mobs age.*/
	public void setAnimalAge(int i)
	{
		this.dataWatcher.updateObject(30, Byte.valueOf((byte)i));
	}
	public boolean increaseAnimalAge() {
		if (getAnimalAge() < maxAge) {
			setAnimalAge(getAnimalAge() + 1);
			return true;
		}

		return false;
	}
	public float getAnimalSize() {
		float step;
		step = (maxSize - minSize) / (adultAge + 1);

		if (getAnimalAge() > adultAge) {
			return minSize + (step * adultAge);
		}

		return minSize + (step * getAnimalAge());
	}
	public boolean isChild() {
		return  getAnimalAge() < adultAge;
	}
	@Override
	public void setScaleForAge(boolean par1) {
		this.setScale(getAnimalSize());
	}
	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
		this.onSpawn();
		return par1EntityLivingData;
	}
	public void onSpawn(){
		this.setAnimalAge(adultAge);
		if(hasGenders()){
			this.setGender(this.getRNG().nextInt(2));
		}
	}
	public boolean hasGenders()
	{
		return false;
	}
	/**
	 * when the player clicks on the mob.
	 */
	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack != null && this.isBreedingItem(itemstack) && this.getGrowingAge() == 0 && this.inLove <= 0)
		{
			this.destroyItemIfPossible(player);
			this.onPlayerBreed(player);
			return true;
		}
		else
		{
			return super.interact(player);
		}
	}
	/**Destroys the item if possible(if the player is not in creative, or if the itemstack is not null).*/
	public void destroyItemIfPossible(EntityPlayer player) {
		ItemStack itemstack = player.inventory.getCurrentItem();
		if(itemstack != null){
			if (!player.capabilities.isCreativeMode)
			{
				--itemstack.stackSize;

				if (itemstack.stackSize <= 0)
				{
					player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
				}
			}
		}


	}
	protected void updateAITick()
	{
		if (this.getGrowingAge() != 0)
		{
			this.inLove = 0;
		}
		super.updateAITick();
	}
	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		this.updateArmSwingProgress();
		float f = this.getBrightness(1.0F);

		if (f > 0.5F)
		{
			this.entityAge += 2;
		}
		if (this.getGrowingAge() != 0)
		{
			this.inLove = 0;
		}

		if (this.inLove > 0)
		{
			--this.inLove;
			String s = "heart";

			if (this.inLove % 10 == 0)
			{
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.worldObj.spawnParticle(s, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
			}
		}
		else
		{
			this.breeding = 0;
		}
		super.onLivingUpdate();
	}
	/**
	 * When the player breeds the mob.
	 */
	public void onPlayerBreed(EntityPlayer entity)
	{
		this.inLove = 600;
		this.theBreeder = entity;
		this.entityToAttack = null;
		this.worldObj.setEntityState(this, (byte)18);
	}
	/**
	 * Gets the player that breeds the mob.
	 */
	public EntityPlayer getBreeder()
	{
		return this.theBreeder;
	}
	/**
	 * Returns if the entity is currently in 'love mode'.
	 */
	public boolean isInLove()
	{
		return this.inLove > 0;
	}

	public void resetInLove()
	{
		this.inLove = 0;
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	public boolean canMateWith(EntityAnimal mob)
	{
		if(hasGenders()){
			if( this.getGender() == 0 && ((EntityIatMob) mob).getGender() == 1){
            	return true;
            }if(this.getGender() == 1 && ((EntityIatMob) mob).getGender() == 0){
            	return true;
            }	
		}
		return mob == this ? false : (mob.getClass() != this.getClass() ? false : this.isInLove() && mob.isInLove());
	}

	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte hp)
	{
		if (hp == 18)
		{
			for (int i = 0; i < 7; ++i)
			{
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
			}
		}
		else
		{
			super.handleHealthUpdate(hp);
		}
	}

	/**
	 * Called when the mob breeds.
	 * @param mob
	 */
	private void procreate(EntityIatMob mob)
	{
		EntityAgeable entityageable = this.createChild(mob);

		if (entityageable != null)
		{
			if (this.theBreeder == null && mob.getBreeder() != null)
			{
				this.theBreeder = mob.getBreeder();
			}

			if (this.theBreeder != null)
			{
				this.theBreeder.triggerAchievement(StatList.field_151186_x);


			}

			this.setGrowingAge(6000);
			mob.setGrowingAge(6000);
			this.inLove = 0;
			this.breeding = 0;
			this.entityToAttack = null;
			mob.entityToAttack = null;
			mob.breeding = 0;
			mob.inLove = 0;
			entityageable.setGrowingAge(-24000);
			entityageable.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);

			for (int i = 0; i < 7; ++i)
			{
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
			}

			this.worldObj.spawnEntityInWorld(entityageable);
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		frame++;
		super.onUpdate();
	}

	protected String getSwimSound()
	{
		return "game.hostile.swim";
	}

	protected String getSplashSound()
	{
		return "game.hostile.swim.splash";
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
	 * (Animals, Spiders at day, peaceful PigZombies).
	 */
	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource damage, float f)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else if (super.attackEntityFrom(damage, f))
		{
			Entity entity = damage.getEntity();

			if (this.riddenByEntity != entity && this.ridingEntity != entity)
			{
				if (entity != this)
				{
					this.entityToAttack = entity;
				}

				return true;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "game.hostile.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "game.hostile.die";
	}

	protected String func_146067_o(int i)
	{
		return i > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
	}

	public boolean attackEntityAsMob(Entity entity)
	{
		float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		int i = 0;

		if (entity instanceof EntityLivingBase)
		{
			f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)entity);
			i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)entity);
		}

		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);

		if (flag)
		{
			if (i > 0)
			{
				entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}

			int j = EnchantmentHelper.getFireAspectModifier(this);

			if (j > 0)
			{
				entity.setFire(j * 4);
			}

			if (entity instanceof EntityLivingBase)
			{
				EnchantmentHelper.func_151384_a((EntityLivingBase)entity, this);
			}

			EnchantmentHelper.func_151385_b(this, entity);
		}

		return flag;
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	protected void attackEntity(Entity entity, float f)
	{
		if (this.attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(entity);
		}
	}

	/**
	 * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
	 * Args: x, y, z
	 */
	public float getBlockPathWeight(int x, int y, int z)
	{
		return 0.5F - this.worldObj.getLightBrightness(x, y, z);
	}

	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	protected boolean isValidLightLevel()
	{
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);

		if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32))
		{
			return false;
		}
		else
		{
			int l = this.worldObj.getBlockLightValue(i, j, k);

			if (this.worldObj.isThundering())
			{
				int i1 = this.worldObj.skylightSubtracted;
				this.worldObj.skylightSubtracted = 10;
				l = this.worldObj.getBlockLightValue(i, j, k);
				this.worldObj.skylightSubtracted = i1;
			}

			return l <= this.rand.nextInt(8);
		}
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	public boolean getCanSpawnHere()
	{
		return  super.getCanSpawnHere();
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	}

	protected boolean func_146066_aG()
	{
		return true;
	}
}