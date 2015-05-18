package iat.entities.mob;

import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import iat.entities.EntityIatMob;
import iat.entities.EntityLargeCarnivore;
import iat.entities.ai.MobAITargetWithoutScent;
import iat.entities.mob.classification.ILandPrehistoricLargeHerbivore;
import iat.entities.mob.classification.ILandPrehistoricMediumHerbivore;
import iat.entities.mob.classification.ILandPrehistoricSmall;
import iat.entities.mob.classification.ILandPrehistoricSmallHerbivore;

public class EntityCarnotaurus extends EntityLargeCarnivore{

	public EntityCarnotaurus(World world) {
		super(world);
		this.setSize(6, 3);
		this.isBreedable = true;
		minSize = 0.2F;
		maxSize = 1.5F;
		adultAge = 10;
		maxAge = 16;
		this.targetTasks.addTask(3, new MobAITargetWithoutScent(this, EntityPlayer.class, 200, false));
		this.targetTasks.addTask(3, new MobAITargetWithoutScent(this, EntityLiving.class, 200, false, true, ILandPrehistoricLargeHerbivore.mobSelector));
		this.targetTasks.addTask(3, new MobAITargetWithoutScent(this, EntityLiving.class, 200, false, true, ILandPrehistoricMediumHerbivore.mobSelector));
		this.targetTasks.addTask(3, new MobAITargetWithoutScent(this, EntityLiving.class, 200, false, true, ILandPrehistoricSmallHerbivore.mobSelector));
		this.targetTasks.addTask(3, new MobAITargetWithoutScent(this, EntityLiving.class, 200, false, true, ILandPrehistoricSmall.mobSelector));
		this.targetTasks.addTask(3, new MobAITargetWithoutScent(this, EntityAnimal.class, 200, false));
	}
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
	}
	public boolean isBreedingItem(ItemStack stack)
	{
		return stack.getItem() == Items.porkchop;
	}
	public boolean isAIEnabled()
	{
		return true;
	}
	public boolean hasGenders()
	{
		return true;
	}
}
