package com.r3c.bitsandbobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabBB extends CreativeTabs
{

	public CreativeTabBB() {
		super(CreativeTabs.getNextID(), "B&B");
	}

	@Override
	public Item getTabIconItem() {
		return Items.egg;
	}
	
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Bits & Bobs";
	}

}
