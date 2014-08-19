package com.r3c.bitsandbobs.items;

import net.minecraft.item.ItemSword;

import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.Ref;

public class ItemBBSword extends ItemSword implements BBTool
{

	public ItemBBSword(ToolMaterial material) {
		super(material);
		this.setCreativeTab(Ref.tab);
	}

}
