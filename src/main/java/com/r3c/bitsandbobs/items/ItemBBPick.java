package com.r3c.bitsandbobs.items;

import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.Ref;

import net.minecraft.item.ItemPickaxe;

public class ItemBBPick extends ItemPickaxe implements BBTool
{

	public ItemBBPick(ToolMaterial material) {
		super(material);
		this.setCreativeTab(Ref.tab);
	}

}
