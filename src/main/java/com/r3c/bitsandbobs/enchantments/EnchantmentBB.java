package com.r3c.bitsandbobs.enchantments;

import com.r3c.bitsandbobs.reference.Ref;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentBB extends Enchantment
{

	int id;
	
	public static final Enchantment opulence = new EnchantmentBB(Ref.opulenceID);
	public static final Enchantment earthbane = new EnchantmentBB(Ref.earthbaneID);
	
	protected EnchantmentBB(int id) {
		super(id == Ref.opulenceID ? Ref.opulenceID : Ref.earthbaneID, 0, EnumEnchantmentType.all);
		this.setName(id == Ref.opulenceID ? "Opulence" : "Earthbane");
		this.id = id;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack)
    {
        return false;
    }
	
	@Override
	public boolean isAllowedOnBooks()
    {
        return false;
    }
	
	@Override
	public boolean canApplyTogether(Enchantment enchantment)
    {
		if(id == Ref.opulenceID && (enchantment == Enchantment.fortune || enchantment == Enchantment.silkTouch || enchantment == Enchantment.looting))
		{
			return false;
		}
		else
		{
			return true;
		}
    }

}
