package itsabouttime.common.biomes;

import itsabouttime.common.core.IATstuff;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.FlowerEntry;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenSilurianBeach extends BiomeGenBase {
    private static final WorldGenBlockBlob field_150643_aG = new WorldGenBlockBlob(Blocks.mossy_cobblestone, 0);
    private int field_150644_aH;
	public BiomeGenSilurianBeach(int id) {
		super(id);
		this.topBlock = IATstuff.SilurianStone;
		this.fillerBlock = IATstuff.SilurianStone;						//EntityClass, how often does it spawn,how big are the groups MIN, MAX
		//this.spawnableMonsterList.add(new SpawnListEntry(EntityBison.class, 12, 4, 4));
		//No Passive Creatures can spawn
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		 this.theBiomeDecorator.dirtGen = null;
		
		 this.theBiomeDecorator.mushroomsPerChunk = -100;
		 this.theBiomeDecorator.coalGen = null;
		 this.theBiomeDecorator.redstoneGen = null;
		 this.flowers.clear();
	        this.addFlower(IATstuff.OldPlants, 0, 10);
	        this.addFlower(IATstuff.OldPlants, 1, 20);
	}
	/*@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand)
    {
        return rand.nextInt(4) == 0? new  WorldGenDeadBush(Main.Cookisonia) : new WorldGenDeadBush(Main.ClubMoss)  ;
    }*/
	 public void addDefaultFlowers()
	    {
	        this.flowers.add(new FlowerEntry(IATstuff.OldPlants, 0, 10));
	        this.flowers.add(new FlowerEntry(IATstuff.OldPlants, 1, 20));

	    }

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        int k;
        int l;
        int i1;
        int j1;
        
        if (this.field_150644_aH == 1 || this.field_150644_aH == 2)
        {
            k = par2Random.nextInt(3);

            for (l = 0; l < k; ++l)
            {
                i1 = par3 + par2Random.nextInt(16) + 8;
                j1 = par4 + par2Random.nextInt(16) + 8;
                int k1 = par1World.getHeightValue(i1, j1);
                field_150643_aG.generate(par1World, par2Random, i1, k1, j1);
            }
        }
	}
}
	
	


