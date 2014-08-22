package com.r3c.bitsandbobs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent.Start;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import com.r3c.bitsandbobs.enchantments.EnchantmentBB;
import com.r3c.bitsandbobs.items.ItemBBEnchant;
import com.r3c.bitsandbobs.items.ItemEBPick;
import com.r3c.bitsandbobs.items.ItemEBShovel;
import com.r3c.bitsandbobs.items.ItemThickAxe;
import com.r3c.bitsandbobs.items.ItemThickPickaxe;
import com.r3c.bitsandbobs.items.ItemThickShovel;
import com.r3c.bitsandbobs.reference.AbilityHelper;
import com.r3c.bitsandbobs.reference.BBTool;
import com.r3c.bitsandbobs.reference.ItemsAndBlocks;
import com.r3c.bitsandbobs.reference.Ref;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler 
{
	Random r = new Random();
	@SubscribeEvent(receiveCanceled=true)
	public void anvilEvent(AnvilUpdateEvent e)
	{
		if ((e.left == null) || (e.right == null)) 
		{
		      return;
		}
		if (((e.left.getItem() instanceof ItemAxe || e.left.getItem() instanceof ItemPickaxe || e.left.getItem() instanceof ItemSpade || e.left.getItem() instanceof ItemSword || e.left.getItem() instanceof ItemThickAxe || e.left.getItem() instanceof ItemThickPickaxe || e.left.getItem() instanceof ItemThickShovel)))
		{
			if(e.right.getItem() == Items.iron_ingot || e.right.getItem() == Items.diamond || e.right.getItem() == Item.getItemFromBlock(Blocks.cobblestone) || e.right.getItem() == ItemsAndBlocks.lapisPlate)
			{
				repair(e);
			}
			else if(e.right.getItem() instanceof ItemBBEnchant)
			{
				enchant(e);
			}
			
		}
	}
	
	@SubscribeEvent(receiveCanceled=true)
	public void doesBreak(BreakEvent e)
	{
		EntityPlayer player = e.getPlayer();
		ItemStack tool = player.getCurrentEquippedItem();
		Block block = e.block;
		Slot slot;
		if(tool == null)
		{
			return;
		}
		else if((tool.getItem() instanceof ItemEBPick && !(block == Blocks.stone || block == Blocks.netherrack || block == Blocks.end_stone || block == Blocks.obsidian)) || (tool.getItem() instanceof ItemEBShovel && !(block == Blocks.dirt || block == Blocks.sand || block == Blocks.gravel)) || (block == Blocks.obsidian && tool.getItem().getHarvestLevel(tool, "ItemPickaxe") < 3))
		{
			e.setCanceled(true);
			return;
		}
		else if(tool.getItem() instanceof ItemEBPick || tool.getItem() instanceof ItemEBShovel)
		{
			tool.damageItem(1, player);
		}
		
	}
	
	@SubscribeEvent(receiveCanceled=true)
	public void doesPlace(PlayerInteractEvent e)
	{
		EntityPlayer player = e.entityPlayer;
		ItemStack item = player.getCurrentEquippedItem();
		
		try
		{
		
			if(e.action == Action.RIGHT_CLICK_BLOCK && item.stackTagCompound.getInteger("cantPlace") == 1)
			{
				e.setCanceled(true);
			}
		}catch(NullPointerException np)
		{}
	}
	
	@SubscribeEvent(receiveCanceled=true)
	public void blockBroke(HarvestDropsEvent e)
	{
		EntityPlayer player = e.harvester;
		
		if(player != null)
		{
			World world = e.world;
			ItemStack tool = player.getCurrentEquippedItem();
			int lvlO, lvlE;
			Block block = e.block;
			
			if(tool != null)
			{
				if(tool.getItem() instanceof ItemEBPick)
				{
					if(block == Blocks.stone || block == Blocks.netherrack || block == Blocks.end_stone || block == Blocks.obsidian)
					{
						e.drops.clear();
						return;
					}
				}
				else if(tool.getItem() instanceof ItemEBShovel)
				{
					if(block == Blocks.dirt || block == Blocks.sand || block == Blocks.gravel)
					{	
						e.drops.clear();
						return;
					}
				}
				else if(EnchantmentHelper.getEnchantmentLevel(Ref.opulenceID, tool) > 0)
				{
					Boolean ore = block.getUnlocalizedName().toLowerCase().contains("ore") ? true : false;
					if(ore && block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore && block != Blocks.lapis_ore && block != Blocks.diamond_ore && block != Blocks.coal_ore)
					{
					
						lvlO = EnchantmentHelper.getEnchantmentLevel(Ref.opulenceID, tool);
						
						e.drops.clear();
						//Block cracked = getCracked(block);
						
						ItemStack drop = new ItemStack(block, 1, e.blockMetadata);
						
						drop.stackTagCompound = new NBTTagCompound();
						drop.stackTagCompound.setInteger("cantPlace", 1);
						
						drop.setStackDisplayName("Smashed " + drop.getDisplayName());
						
						for(int i = 0; i <= r.nextInt(2) + lvlO; i++)
						{
							e.drops.add(drop);
						}
						return;
					}
				}
			}
		}
	}

	private void enchant(AnvilUpdateEvent e) 
	{
		ItemStack tool = e.left;
		Item mod = e.right.getItem();
		int lvlE = (tool.getItem() instanceof ItemEBPick || tool.getItem() instanceof ItemEBShovel) ? tool.stackTagCompound.getInteger("lvl") : 0;
		
		if(EnchantmentHelper.getEnchantmentLevel(Ref.opulenceID, tool) >= 2 || lvlE >= 2)
		{
			e.output = null;
			return;
		}
		else
		{
			ItemStack res;
			
			if(mod == ItemsAndBlocks.opulenceEnchantItem && EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, tool) == 0 && EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, tool) >= 3)
			{
				res = new ItemStack(tool.getItem(), 1, tool.getItemDamage());
				Map enchants = EnchantmentHelper.getEnchantments(tool);
				
				enchants.put(Enchantment.fortune.effectId, 4);
				enchants.put(EnchantmentBB.opulence.effectId, EnchantmentHelper.getEnchantmentLevel(EnchantmentBB.opulence.effectId, tool) + 1);
				
				EnchantmentHelper.setEnchantments(enchants, res);
				
				e.output = res;
				e.cost = 30;
				return;
			}
			else if(mod == ItemsAndBlocks.earthbaneEnchantItem && (tool.getItem() instanceof ItemThickPickaxe || tool.getItem() instanceof ItemThickShovel))
			{
				int index = (tool.getItem() == ItemsAndBlocks.ironTA || tool.getItem() == ItemsAndBlocks.ironTP) ? 0 : (tool.getItem() == ItemsAndBlocks.lapisTA || tool.getItem() == ItemsAndBlocks.lapisTP) ? 1 : 2;
				res =  tool.getItem() instanceof ItemThickPickaxe ? new ItemStack(ItemsAndBlocks.pickEB[index], 1, tool.getItemDamage()) : tool.getItem() instanceof ItemThickShovel ? new ItemStack(ItemsAndBlocks.shovelEB[index], 1, tool.getItemDamage()) : null;
				
				res.stackTagCompound = new NBTTagCompound();
				res.stackTagCompound.setInteger("lvl", 1);
				
				Map enchants = EnchantmentHelper.getEnchantments(tool);
				
				EnchantmentHelper.setEnchantments(enchants, res);
				
				e.output = res.setStackDisplayName("Earthbane I");
				e.cost = 20;
				return;
			}
			else if(mod == ItemsAndBlocks.earthbaneEnchantItem && (tool.getItem() instanceof ItemEBPick || tool.getItem() instanceof ItemEBShovel))
			{
				res = new ItemStack(tool.getItem(), 1, tool.getItemDamage());
				
				res.stackTagCompound = new NBTTagCompound();
				res.stackTagCompound.setInteger("lvl", 2);
				
				e.output = res.setStackDisplayName("Earthbane II");
				e.cost = 30;
				return;
			}
		}
	}

	private void repair(AnvilUpdateEvent e) 
	{
		ItemStack tool = e.left;
		ItemStack right = e.right;
		ItemStack res;
		int dmg;
		if(tool.getItem() instanceof BBTool && tool.getItemDamage() > 0)
		{
			res = new ItemStack(tool.getItem(), 1, tool.getItemDamage());
			
			dmg = (res.getItemDamage() - ((res.getMaxDamage()/4)*right.stackSize) < 0 ? 0 : res.getItemDamage() - ((res.getMaxDamage()/4)*right.stackSize));
			
			if(right.getItem() == Item.getItemFromBlock(Blocks.cobblestone) && (tool.getItem() == ItemsAndBlocks.stoneTA || tool.getItem() == ItemsAndBlocks.stoneTP || tool.getItem() == ItemsAndBlocks.stoneTS))
			{
				res.setItemDamage(dmg);
			}
			else if(right.getItem() == Items.iron_ingot && (tool.getItem() == ItemsAndBlocks.ironTA || tool.getItem() == ItemsAndBlocks.ironTP || tool.getItem() == ItemsAndBlocks.ironTS || tool.getItem() == ItemsAndBlocks.pickEB[1] || tool.getItem() == ItemsAndBlocks.shovelEB[1]))
			{
				res.setItemDamage(dmg);
			}
			else if(right.getItem() == Items.diamond && (tool.getItem() == ItemsAndBlocks.diamondTA || tool.getItem() == ItemsAndBlocks.diamondTP || tool.getItem() == ItemsAndBlocks.diamondTS || tool.getItem() == ItemsAndBlocks.pickEB[3] || tool.getItem() == ItemsAndBlocks.shovelEB[3]))
			{
				res.setItemDamage(dmg);
			}
			else 	
			{
				res.setItemDamage(dmg);
			}
			
			e.output = res;
			e.cost = 5*right.stackSize;
			return;
		}
	}
	
	private Block getCracked(Block block) 
	{
		if(block == Blocks.iron_ore)
			return ItemsAndBlocks.oreCrackedIron;
		else if(block == Blocks.gold_ore)
			return ItemsAndBlocks.oreCrackedGold;
		else
			return null;
	}
	
}