package com.r3c.bitsandbobs.items;

import net.minecraft.item.ItemSpade;
import net.minecraftforge.common.util.EnumHelper;

import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.Ref;

public class ItemThickShovel extends ItemSpade implements BBTool
{

	public ItemThickShovel(ToolMaterial material) 
	{
		super(EnumHelper.addToolMaterial("thick" + material.name(), material.getHarvestLevel(), material.getMaxUses()*4, material.getEfficiencyOnProperMaterial(), material.getDamageVsEntity(), material.getEnchantability()));
		this.setCreativeTab(Ref.tab);
	}

}
