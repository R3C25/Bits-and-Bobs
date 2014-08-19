package com.r3c.bitsandbobs.items;

import net.minecraft.item.ItemAxe;

import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.Ref;

public class ItemBBAxe extends ItemAxe implements BBTool
{

	public ItemBBAxe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(Ref.tab);
	}

}
