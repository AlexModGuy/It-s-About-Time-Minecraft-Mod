package itsabouttime.common.dimensions.silurian;


import itsabouttime.iat;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderSilurian extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerSilurian(worldObj.getSeed(), terrainType);
		this.dimensionId = iat.dimensionIdSilurian;
	}
	public IChunkProvider createChunkProvider(){//true or false
		return new ChunkProviderSilurian(this.worldObj, this.worldObj.getSeed(), false);
	}
	@Override
	public String getDimensionName() {
		return "Silurian Period";
	}
	public static WorldProvider getProviderForDimension(int id)
	{
	return DimensionManager.createProviderFor(iat.dimensionIdSilurian);
	}
	public String getWelcomeMessage()
	{
	return "Entering the Silurian Period";
	}
	public IChunkProvider createChunkGenerator()
	{
	return new ChunkProviderSilurian(worldObj, worldObj.getSeed(), true);
	}
	public boolean canRespawnHere()
	{
	return true;
	}
	protected synchronized String setUserMessage(String par1Str)
	{
	return "Building Silurian Period";
	}
	public int getRespawnDimension(EntityPlayerMP player)
	{
	return iat.dimensionIdSilurian;
	}
	public double getMovementFactor()
	{
	return 1.0;
	}
}
