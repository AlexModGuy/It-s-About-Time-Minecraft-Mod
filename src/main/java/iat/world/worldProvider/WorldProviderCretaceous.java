package iat.world.worldProvider;


import iat.core.ModDimensions;
import iat.world.chunkProvider.ChunkProviderCretaceous;
import iat.world.chunkProvider.WorldChunkManagerCretaceous;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderCretaceous extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerCretaceous(worldObj.getSeed(), terrainType);
		this.dimensionId = ModDimensions.Dim_cretaceous;
	}
	public IChunkProvider createChunkProvider(){//true or false
		return new ChunkProviderCretaceous(this.worldObj, this.worldObj.getSeed(), false);
	}
	@Override
	public String getDimensionName() {
		return "Cretaceous Period";
	}
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(ModDimensions.Dim_cretaceous);
	}
	public String getWelcomeMessage()
	{
		return "Entering the Cretaceous Period";
	}
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderCretaceous(worldObj, worldObj.getSeed(), true);
	}
	public boolean canRespawnHere()
	{
		return true;
	}
	protected synchronized String setUserMessage(String par1Str)
	{
		return "Building the Cretaceous Period";
	}
	public int getRespawnDimension(EntityPlayerMP player)
	{
		return ModDimensions.Dim_cretaceous;
	}
	public double getMovementFactor()
	{
		return 1;
	}
}
