package itsabouttime.common.biomes;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.EntityJellyfish;

import java.util.Random;








import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenCambrianBeach extends BiomeGenBase {

	public BiomeGenCambrianBeach(int id) {
		super(id);
		this.topBlock = IATstuff.CambrianStone;
		this.fillerBlock = IATstuff.CambrianStone;						//EntityClass, how often does it spawn,how big are the groups MIN, MAX
		//this.spawnableMonsterList.add(new SpawnListEntry(EntityBison.class, 12, 4, 4));
		//this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityAnomacalaris.class, 5, 1, 2));
		//this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityHaikouichthys.class, 9, 5, 21));

		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();

		 this.theBiomeDecorator.dirtGen = null;
		
		 this.theBiomeDecorator.mushroomsPerChunk = -100;
		 this.theBiomeDecorator.coalGen = null;
		 this.theBiomeDecorator.redstoneGen = null;
		 this.flowers.clear();
		
	      	}}
	
	