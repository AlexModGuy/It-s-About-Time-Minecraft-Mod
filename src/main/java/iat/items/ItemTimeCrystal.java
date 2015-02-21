package iat.items;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemTimeCrystal extends Item {

	public ItemTimeCrystal(){
		super();
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int x, boolean bool1) {
		Random rand = new Random();
		EntityPlayer player = (EntityPlayer)entity;
		if(rand.nextInt(4000) == 0){
			int potionSelector = rand.nextInt(6);
			if(potionSelector == 0){
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1000, 0));
			}
			if(potionSelector == 1){
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 225, 0));
			}
			if(potionSelector == 2){
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1500, 0));
			}
			if(potionSelector == 3){
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2000, 0));
			}
			if(potionSelector == 4){
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 3000, 0));
			}
			if(potionSelector == 5){
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 3000, 0));
			}
			if(potionSelector == 6){
				player.addPotionEffect(new PotionEffect(Potion.weakness.id, 1000, 0));
			}
			if(potionSelector == 7){
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 4000, 0));
			}
		}
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(StatCollector.translateToLocal("message.iat.time_Crystal_1"));
		list.add(StatCollector.translateToLocal("message.iat.time_Crystal_2"));
		list.add(StatCollector.translateToLocal("message.iat.time_Crystal_3"));
	}

}
