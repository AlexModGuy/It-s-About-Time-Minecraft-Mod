package iat.world.worldProvider;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import iat.core.ModDimensions;
import iat.world.chunkProvider.ChunkProviderNowhere;
import iat.world.chunkProvider.WorldChunkManagerNowhere;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderNowhere extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerNowhere(worldObj.getSeed(), terrainType);
		this.dimensionId = ModDimensions.Dim_nowhere;
	}
	public IChunkProvider createChunkProvider(){//true or false
		return new ChunkProviderNowhere(this.worldObj, this.worldObj.getSeed(), false);
	}
	@Override
	public String getDimensionName() {
		return "Nowhere";
	}
	public boolean isSurfaceWorld()
	{
		return false;
	}
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(ModDimensions.Dim_nowhere);
	}
	public String getWelcomeMessage()
	{
		return "Your Going Nowhere";
	}
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderNowhere(worldObj, worldObj.getSeed(), true);
	}
	public boolean canRespawnHere()
	{
		return true;
	}
	protected synchronized String setUserMessage(String par1Str)
	{
		return "Building Nowhere";
	}
	public int getRespawnDimension(EntityPlayerMP player)
	{
		return ModDimensions.Dim_nowhere;
	}
	public double getMovementFactor()
	{
		return 0;
	}
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int y)
	{
		return true;
	}
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float x, float y)
	{
		int i = 10518688;
		float f2 = MathHelper.cos(x * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

		if (f2 < 0.0F)
		{
			f2 = 0.0F;
		}

		if (f2 > 1.0F)
		{
			f2 = 1.0F;
		}

		float f3 = (float)(i >> 16 & 255) / 255.0F;
		float f4 = (float)(i >> 8 & 255) / 255.0F;
		float f5 = (float)(i & 255) / 255.0F;
		f3 *= f2 * 0.0F + 0.15F;
		f4 *= f2 * 0.0F + 0.15F;
		f5 *= f2 * 0.0F + 0.15F;
		return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
	}
	public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_)
	{
		return 0.5F;
	}
}
