package iat.enums;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenerator;
import iat.client.models.MowzieModelBase;
import iat.world.structure.WorldGenGinkoTree;

public enum EnumPrehistoricTrees {
	Ginko(new WorldGenGinkoTree()),
	Monkeypuzzle(null),
	Podocarpus(null),
	Kauri(null);
	
	public WorldGenerator tree;
	public Block logBlock;
	public Block leavesBlock;
	public Block saplingBlock;
	public Block planksBlock;
	public Block planksStairsBlock;
	public Block planksSlabsBlock;
	public Block planksSlabsDoubleBlock;

	private EnumPrehistoricTrees(WorldGenerator tree){
		this.tree = tree;
	}
}
