package com.r3c.bitsandbobs.items;

import com.r3c.bitsandbobs.reference.Ref;

import net.minecraft.item.Item;

public class ItemBBEnchant extends Item
{
	public ItemBBEnchant(int ench)
	{
		super();
		this.setCreativeTab(Ref.tab);
		this.setMaxStackSize(1);
	}
}
