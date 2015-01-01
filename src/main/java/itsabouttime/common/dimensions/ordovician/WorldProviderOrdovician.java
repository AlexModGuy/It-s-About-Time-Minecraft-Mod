package itsabouttime.common.dimensions.ordovician;


import itsabouttime.iat;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderOrdovician extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerOrdovician(worldObj.getSeed(), terrainType);
		this.dimensionId = iat.dimnsionIdOrdovician;
	}
	public IChunkProvider createChunkProvider(){//true or false
		return new ChunkProviderOrdovician(this.worldObj, this.worldObj.getSeed(), false);
	}
	@Override
	public String getDimensionName() {
		return "Ordovician Period";
	}
	public static WorldProvider getProviderForDimension(int id)
	{
	return DimensionManager.createProviderFor(iat.dimnsionIdOrdovician);
	}
	public String getWelcomeMessage()
	{
	return "Entering the Ordovician Period";
	}
	public IChunkProvider createChunkGenerator()
	{
	return new ChunkProviderOrdovician(worldObj, worldObj.getSeed(), true);
	}
	public boolean canRespawnHere()
	{
	return true;
	}
	protected synchronized String setUserMessage(String par1Str)
	{
	return "Building Ordovician Period";
	}
	public int getRespawnDimension(EntityPlayerMP player)
	{
	return iat.dimnsionIdOrdovician;
	}
	public double getMovementFactor()
	{
	return 1.0;
	}
}
