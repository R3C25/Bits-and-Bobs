package com.r3c.bitsandbobs.items;

import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.Ref;

public class ItemThickPickaxe extends ItemPickaxe implements BBTool
{

	public ItemThickPickaxe(ToolMaterial material) 
	{
		super(EnumHelper.addToolMaterial("thick" + material.name(), material.getHarvestLevel(), (int)(material.getMaxUses()*3.75), (float)(material.getEfficiencyOnProperMaterial()*1.15), material.getDamageVsEntity(), material.getEnchantability()));	
		this.setCreativeTab(Ref.tab);
	}

}
