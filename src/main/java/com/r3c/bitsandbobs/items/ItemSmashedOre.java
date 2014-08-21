package com.r3c.bitsandbobs.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemSmashedOre extends Item
{
	Item smelt;
	
	public ItemSmashedOre()
	{
		super();
		this.setUnlocalizedName("smashedOre");
	}
	
	@Override
	public void onUpdate(ItemStack item, World world, Entity entity, int int1, boolean bool) 
	{
		
	}

}
