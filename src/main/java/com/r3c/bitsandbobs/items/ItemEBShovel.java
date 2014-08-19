package com.r3c.bitsandbobs.items;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.r3c.bitsandbobs.reference.AbilityHelper;
import com.r3c.bitsandbobs.reference.BBTool;

public class ItemEBShovel extends ItemPickaxe implements BBTool
{

	public ItemEBShovel(ToolMaterial material) 
	{
		super(material);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack tool, World world, Block block, int x, int y, int z, EntityLivingBase user)
	{
		if(user instanceof EntityPlayer && canMine(block) && !world.isRemote)
		{
			EntityPlayer player = (EntityPlayer)user;
			int lvlE = tool.stackTagCompound.getInteger("lvl");
			Block dropBlock = block;
			
			MovingObjectPosition mop = AbilityHelper.raytraceFromEntity(world, player, true, 4.5D);
			int limit = 0;
			int count = 0;
			
			 int xStart = lvlE;
			 int xStop = lvlE;
	         int yStart = 1;
	         int yStop = lvlE == 1 ? 1 : 3;
	         int zStart = lvlE;
	         int zStop = lvlE;
	         
	         //0 = Bottom, 1 = Top, 2 = , 3 = , 4 = East, 5 = West
	         switch (mop.sideHit)
	         {
	         case 0:
	        	 System.out.println("Hit Bottom");
	        	 yStart = 0;
	        	 yStop = 2*lvlE;
	        	 break;
	         case 1:
	        	 System.out.println("Hit Top");
	             yStart = 2*lvlE;
	        	 yStop = 0;
	             break;
	         case 2:
	        	 System.out.println("Hit 2");
	        	 zStart = 0;
	        	 zStop = 2*lvlE;
	        	 break;
	         case 3:
	        	 System.out.println("Hit 3");
	             zStart = 2*lvlE;
	             zStop = 0;
	             break;
	         case 4:
	        	 System.out.println("Hit 4");
	        	 xStart = 0;
	        	 xStop = 2*lvlE;
	        	 break;
	         case 5:
	        	 System.out.println("Hit 5");
	             xStart = 2*lvlE;
	             xStop = 0;
	             break;
	         }
	         
	         Slot slot;
	         ArrayList<Integer> slots = new ArrayList();
	         ArrayList<Integer> numInSlot = new ArrayList();
	         int drops = 0;
	         
	         for(int i = 9; i < 45; i++)
	 		 {
	 			slot = player.inventoryContainer.getSlot(i);
	 			if (slot.getStack() == null)
	 			{
	 				slots.add(i);
	 				numInSlot.add(64);
	 				drops += 64;
	 			}
	 			else if(slot.getStack().getItem() == Item.getItemFromBlock(dropBlock) && slot.getStack().stackSize < slot.getSlotStackLimit())
	 			{
	 				slots.add(i);
	 				numInSlot.add(slot.getSlotStackLimit() - slot.getStack().stackSize);
	 				drops += slot.getSlotStackLimit() - slot.getStack().stackSize;
	 			}
	 		 }
	         
	         int max = lvlE == 1 ? 27 : 125;
	         
	         drops = drops > max ? max : drops;
	         
	         limit = drops;

	         for (int xPos = x - xStart; xPos <= x + xStop; xPos++)
	         {
	             for (int yPos = y - yStart; yPos <= y + yStop; yPos++)
	             {
	                 for (int zPos = z - zStart; zPos <= z + zStop; zPos++)
	                 {
	                	 if(world.getBlock(xPos, yPos, zPos) == block)
	 					{
	                		if(limit < 1)
	                		{
	                			break;
	                		}
	 						world.setBlockToAir(xPos, yPos, zPos);
	 	 					count++;
	 	 					limit--;
	 					}
	                 }
	             }
	         }
	         
	         drops = count;
	         
	         Iterator slotIt = slots.iterator();
	         Iterator dropsIt = numInSlot.iterator();
	         int putInSlot;
	         int currentSlot;
	         int putStackSize;
	         int currStackSize;
	         
	         while(drops > 0)
	         {
	        	 putInSlot = (Integer)dropsIt.next();
	        	 currentSlot = (Integer)slotIt.next();
	        	 
	        	 try
	        	 {
	        		 currStackSize = player.inventoryContainer.getSlot(currentSlot).getStack().stackSize;
	        	 }
	        	 catch(NullPointerException e)
	        	 {
	        		 currStackSize = 0;
	        	 }
	        	 if(putInSlot > drops)
	        		 putInSlot = drops;
	        	 
	        	 putStackSize = currStackSize + putInSlot;
	        	 
	        	 player.inventoryContainer.putStackInSlot(currentSlot, new ItemStack(dropBlock, putStackSize));
	        	 drops -= putInSlot;
	         }
	         
		}
		
		return true;
	}
	
	private boolean canMine(Block block) 
	{
		return block == Blocks.dirt ? true : block == Blocks.sand ? true : block == Blocks.gravel ? true : false;
	}
	
	@Override
	public void onCreated(ItemStack item, World world, EntityPlayer player)
	{
		item.stackTagCompound = new NBTTagCompound();
		item.stackTagCompound.setInteger("lvl", 1);
	}
}
