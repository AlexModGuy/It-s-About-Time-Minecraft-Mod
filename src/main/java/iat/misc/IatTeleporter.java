package iat.misc;


import iat.core.ModBlocks;
import iat.core.ModDimensions;

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

public class IatTeleporter extends Teleporter {
	private final WorldServer worldserverInstance;
	private final Random random;
	private final LongHashMap destinationCoordCoodinateCache = new LongHashMap();
	private final List destinationCoordCoodinateKeys = new ArrayList();
	private int DimensionID;
	private int prev_DimensionID;

	public IatTeleporter(WorldServer worldserver, int Dim_ID, int prev_Dim_ID) {
		super(worldserver);
		this.worldserverInstance = worldserver;
		this.random = new Random(worldserver.getSeed());
		DimensionID = Dim_ID;
		prev_DimensionID = prev_Dim_ID;
	}
	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float f){

		entity.motionX = entity.motionY = entity.motionZ = 0.0D;
		entity.setLocationAndAngles((double)x-0.5F, (double)y+1, (double)z-0.5F, entity.rotationYaw, 0.0F);
		int i = MathHelper.floor_double(entity.posX);
		int j = MathHelper.floor_double(entity.posY);
		int k = MathHelper.floor_double(entity.posZ);
		
		if(DimensionID == ModDimensions.Dim_cretaceous)this.worldserverInstance.setBlock(i,j,k, ModBlocks.timeRift_cretaceous);
		if(DimensionID == ModDimensions.Dim_nowhere)this.worldserverInstance.setBlock(i,j,k, ModBlocks.timeRift_nowhere);

		if(prev_DimensionID == ModDimensions.Dim_cretaceous)this.worldserverInstance.setBlock(i,j,k, ModBlocks.timeRift_cretaceous);
		if(prev_DimensionID == ModDimensions.Dim_nowhere)this.worldserverInstance.setBlock(i,j,k, ModBlocks.timeRift_nowhere);

		if(worldserverInstance.getBlock(i, j+1, k) != Blocks.air){
			this.worldserverInstance.setBlock(i,j+1,k, Blocks.air);
		}
		if(worldserverInstance.getBlock(i, j-1, k) == Blocks.air){
			this.worldserverInstance.setBlock(i,j-1,k, Blocks.stone);
		}
		if(worldserverInstance.getBlock(i-1, j-1, k) == Blocks.air){
			this.worldserverInstance.setBlock(i-1,j-1,k, Blocks.stone);
		}
		if(worldserverInstance.getBlock(i+1, j-1, k) == Blocks.air){
			this.worldserverInstance.setBlock(i+1,j-1,k, Blocks.stone);
		}
		if(worldserverInstance.getBlock(i, j-1, k+1) == Blocks.air){
			this.worldserverInstance.setBlock(i,j-1,k+1, Blocks.stone);
		}
		if(worldserverInstance.getBlock(i, j-1, k-1) == Blocks.air){
			this.worldserverInstance.setBlock(i,j-1,k-1, Blocks.stone);
		}
		


	}

	public void removeStalePortalLocations(long i){

	}
}
