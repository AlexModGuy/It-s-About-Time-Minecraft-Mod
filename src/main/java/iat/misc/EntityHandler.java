package iat.misc;

import iat.ItsAboutTime;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;


import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {



	public static void registerSpawnable(Class entityClass, String name, int MAINCOLORS, int SUBCOLORS){
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = MAINCOLORS;
		int subColor = SUBCOLORS;

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId,ItsAboutTime.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));
	}
	public static void registerUnspawnable(Class entityClass, String name){
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, ItsAboutTime.instance, 64, 1, true);

	}
}

