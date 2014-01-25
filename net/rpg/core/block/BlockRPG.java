package net.rpg.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.rpg.core.RPGTabs;

public class BlockRPG extends Block {
	protected BlockRPG(Material material) {
		super(material);
		this.func_149647_a(RPGTabs.tabBlock);
	}
}
