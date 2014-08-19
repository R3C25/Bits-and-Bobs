package com.r3c.bitsandbobs.items;

import net.minecraft.item.ItemSpade;

import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.Ref;

public class ItemBBShovel extends ItemSpade implements BBTool
{

	public ItemBBShovel(ToolMaterial material) {
		super(material);
		this.setCreativeTab(Ref.tab);
	}

}
