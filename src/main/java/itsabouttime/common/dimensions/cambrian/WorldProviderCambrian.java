package itsabouttime.common.dimensions.cambrian;


import itsabouttime.iat;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderCambrian extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerCambrian(worldObj.getSeed(), terrainType);
		this.dimensionId = iat.dimensionIdCambrian;
	}
	public IChunkProvider createChunkProvider(){//true or false
		return new ChunkProviderCambrian(this.worldObj, this.worldObj.getSeed(), false);
	}
	@Override
	public String getDimensionName() {
		return "Cambrian Period";
	}
	public static WorldProvider getProviderForDimension(int id)
	{
	return DimensionManager.createProviderFor(iat.dimensionIdCambrian);
	}
	public String getWelcomeMessage()
	{
	return "Entering the Cambrian Period";
	}
	public IChunkProvider createChunkGenerator()
	{
	return new ChunkProviderCambrian(worldObj, worldObj.getSeed(), true);
	}
	public boolean canRespawnHere()
	{
	return true;
	}
	protected synchronized String setUserMessage(String par1Str)
	{
	return "Building Cambrian Period";
	}
	public int getRespawnDimension(EntityPlayerMP player)
	{
	return iat.dimensionIdCambrian;
	}
	public double getMovementFactor()
	{
	return 1.0;
	}
}
