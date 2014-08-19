package com.r3c.bitsandbobs.items;

import net.minecraft.item.ItemAxe;
import net.minecraftforge.common.util.EnumHelper;

import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.Ref;

public class ItemThickAxe extends ItemAxe implements BBTool
{
	public ItemThickAxe(ToolMaterial material)
	{
		super(EnumHelper.addToolMaterial("thick" + material.name(), material.getHarvestLevel(), material.getMaxUses()*4, material.getEfficiencyOnProperMaterial(), material.getDamageVsEntity(), material.getEnchantability()));
		this.setCreativeTab(Ref.tab);
	}
}
