package itsabouttime.common.dimensions;


import itsabouttime.common.core.IATstuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class Teleporter_Prehistoric extends Teleporter {
private final WorldServer worldserverInstance;
private final Random random;
private final LongHashMap destinationCoordCoodinateCache = new LongHashMap();
private final List destinationCoordCoodinateKeys = new ArrayList();
	public Teleporter_Prehistoric(WorldServer worldserver) {
		super(worldserver);
		this.worldserverInstance = worldserver;
		this.random = new Random(worldserver.getSeed());
	}
	@Override
		public void placeInPortal(Entity entity, double x, double y, double z, float f){
		
			//return;
	    }
	    
	public void removeStalePortalLocations(long i){
		
	}
	}
