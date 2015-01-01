package itsabouttime.common.entities.prehistoric;

import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricWaterMob;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAmmonite extends EntityWaptia implements ISmallWaterCritter
{

	public EntityAmmonite(World p_i1695_1_) {
		super(p_i1695_1_);
		this.setSize(0.5F, 0.5F);
}
}