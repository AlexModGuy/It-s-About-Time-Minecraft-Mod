package itsabouttime.common.dimensions.silurian;


import itsabouttime.common.core.IATbiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesSilurian extends GenLayer {

	protected BiomeGenBase[] allowedBiomes = {IATbiomes.SilurianBeach, IATbiomes.SilurianHills, IATbiomes.SilurianRiver, IATbiomes.SilurianSea};
	public GenLayerBiomesSilurian(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
		}
	public GenLayerBiomesSilurian(long seed) {
		super(seed);


	}
	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
	int[] dest = IntCache.getIntCache(width*depth);

	for (int dz=0; dz<depth; dz++)
	{
	for (int dx=0; dx<width; dx++)
	{
	this.initChunkSeed(dx+x, dz+z);
	dest[(dx+dz*width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
	}
	}
	return dest;
	}
	}


