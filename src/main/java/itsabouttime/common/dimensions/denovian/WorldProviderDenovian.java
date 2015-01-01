package itsabouttime.common.dimensions.denovian;


import itsabouttime.iat;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderDenovian extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerDenovian(worldObj.getSeed(), terrainType);
		this.dimensionId = iat.dimensionIdDenovian;
	}
	public IChunkProvider createChunkProvider(){//true or false
		return new ChunkProviderDenovian(this.worldObj, this.worldObj.getSeed(), false);
	}
	@Override
	public String getDimensionName() {
		return "Devonian Period";
	}
	public static WorldProvider getProviderForDimension(int id)
	{
	return DimensionManager.createProviderFor(iat.dimensionIdDenovian);
	}
	public String getWelcomeMessage()
	{
	return "Entering the Devonian Period";
	}
	public IChunkProvider createChunkGenerator()
	{
	return new ChunkProviderDenovian(worldObj, worldObj.getSeed(), true);
	}
	public boolean canRespawnHere()
	{
	return true;
	}
	protected synchronized String setUserMessage(String par1Str)
	{
	return "Building Devonian Period";
	}
	public int getRespawnDimension(EntityPlayerMP player)
	{
	return iat.dimensionIdDenovian;
	}
	public double getMovementFactor()
	{
	return 1.0;
	}
}
