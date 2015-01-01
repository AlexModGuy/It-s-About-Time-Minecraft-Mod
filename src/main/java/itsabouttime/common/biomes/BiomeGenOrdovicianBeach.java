package itsabouttime.common.biomes;

import itsabouttime.common.core.IATstuff;

import java.util.Random;




import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.FlowerEntry;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenOrdovicianBeach extends BiomeGenBase {

	public BiomeGenOrdovicianBeach(int id) {
		super(id);
		this.topBlock = IATstuff.OrdovicianStone;
		this.fillerBlock = IATstuff.OrdovicianStone;						//EntityClass, how often does it spawn,how big are the groups MIN, MAX
		//this.spawnableMonsterList.add(new SpawnListEntry(EntityBison.class, 12, 4, 4));
		
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
	
}
	


