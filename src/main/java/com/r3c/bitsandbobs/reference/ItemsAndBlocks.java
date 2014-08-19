package com.r3c.bitsandbobs.reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.r3c.bitsandbobs.items.ItemBBAxe;
import com.r3c.bitsandbobs.items.ItemBBEnchant;
import com.r3c.bitsandbobs.items.ItemBBPick;
import com.r3c.bitsandbobs.items.ItemBBShovel;
import com.r3c.bitsandbobs.items.ItemBBSword;
import com.r3c.bitsandbobs.items.ItemEBPick;
import com.r3c.bitsandbobs.items.ItemEBShovel;
import com.r3c.bitsandbobs.items.ItemThickAxe;
import com.r3c.bitsandbobs.items.ItemThickPickaxe;
import com.r3c.bitsandbobs.items.ItemThickShovel;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsAndBlocks 
{
	static final String TEXTURE = "b&b:";
	
	static ToolMaterial lapisMaterial = EnumHelper.addToolMaterial("lapis", 2, 601, 14.0F, 2.5F, 16),
			            ironEBMaterial = EnumHelper.addToolMaterial("EBIron", 2, 101, 6.0F, 2.0F, 14),
			            lapisEBMaterial = EnumHelper.addToolMaterial("EBLapis", 2, 241, 14.0F, 2.5F, 16),
			            diamondEBMaterial = EnumHelper.addToolMaterial("EBDiamond", 3, 601, 8.0F, 3.0F, 10);
	
	public static Item diamondTP = new ItemThickPickaxe(ToolMaterial.EMERALD),
					   diamondTS = new ItemThickShovel(ToolMaterial.EMERALD),
					   diamondTA = new ItemThickAxe(ToolMaterial.EMERALD),
					   ironTP = new ItemThickPickaxe(ToolMaterial.IRON),
					   ironTS = new ItemThickShovel(ToolMaterial.IRON),
					   ironTA = new ItemThickAxe(ToolMaterial.IRON),
					   stoneTP = new ItemThickPickaxe(ToolMaterial.STONE),
					   stoneTS = new ItemThickShovel(ToolMaterial.STONE),
					   stoneTA = new ItemThickAxe(ToolMaterial.STONE),
					   lapisPick = new ItemBBPick(lapisMaterial),
					   lapisShovel = new ItemBBShovel(lapisMaterial),
					   lapisAxe = new ItemBBAxe(lapisMaterial),
					   lapisSword = new ItemBBSword(lapisMaterial),
					   lapisTP = new ItemThickPickaxe(lapisMaterial),
					   lapisTS = new ItemThickShovel(lapisMaterial),
					   lapisTA = new ItemThickAxe(lapisMaterial),
					   diamondPlate = new Item(),
					   ironPlate = new Item(),
					   stonePlate = new Item(),
					   lapisPlate = new Item(),
					   lapisPlateLarge = new Item(),
					   lapisChunk = new Item(),
					   toolHandle = new Item(),
					   opulenceEnchantItem = new ItemBBEnchant(Ref.opulenceID),
					   earthbaneEnchantItem = new ItemBBEnchant(Ref.earthbaneID);
	
	public static ItemEBPick[] pickEB = {
										 new ItemEBPick(ironEBMaterial),
										 new ItemEBPick(lapisEBMaterial),
										 new ItemEBPick(diamondEBMaterial)
										};
	
	public static ItemEBShovel[] shovelEB = {
											 new ItemEBShovel(ironEBMaterial),
											 new ItemEBShovel(lapisEBMaterial),
											 new ItemEBShovel(diamondEBMaterial)
											};
	
	public static Block oreCrackedIron = new BlockOre(),
						oreCrackedGold = new BlockOre();
	
	public static void init()
	{
		
		initializeBlocks();
		registerBlocks();
		initializeItems();
		registerItems();
		registerSmelts();
		registerRecipes();
		registerOreDict();
		
	}
	
	public static void initializeBlocks()
	{
		oreCrackedIron.setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("oreCrackedIron").setBlockTextureName(TEXTURE + "oreCrackedIron");
		oreCrackedGold.setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("oreCrackedGold").setBlockTextureName(TEXTURE + "oreCrackedGold");
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(oreCrackedIron, "oreCrackedIron");
		GameRegistry.registerBlock(oreCrackedGold, "oreCrackedGold");
	}
	
	public static void initializeItems()
	{
		diamondTP.setUnlocalizedName("thickPickaxeDiamond").setTextureName(TEXTURE + "thickPickaxeDiamond");
		diamondTS.setUnlocalizedName("thickShovelDiamond").setTextureName(TEXTURE + "thickShovelDiamond");
		diamondTA.setUnlocalizedName("thickAxeDiamond").setTextureName(TEXTURE + "thickAxeDiamond");
		ironTP.setUnlocalizedName("thickPickaxeIron").setTextureName(TEXTURE + "thickPickaxeIron");
		ironTS.setUnlocalizedName("thickShovelIron").setTextureName(TEXTURE + "thickShovelIron");
		ironTA.setUnlocalizedName("thickAxeIron").setTextureName(TEXTURE + "thickAxeIron");
		stoneTP.setUnlocalizedName("thickPickaxeStone").setTextureName(TEXTURE + "thickPickaxeStone");
		stoneTS.setUnlocalizedName("thickShovelStone").setTextureName(TEXTURE + "thickShovelStone");
		stoneTA.setUnlocalizedName("thickAxeStone").setTextureName(TEXTURE + "thickAxeStone");
		lapisTP.setUnlocalizedName("thickPickaxeLapis").setTextureName(TEXTURE + "thickPickaxeLapis");
		lapisTS.setUnlocalizedName("thickShovelLapis").setTextureName(TEXTURE + "thickShovelLapis");
		lapisTA.setUnlocalizedName("thickAxeLapis").setTextureName(TEXTURE + "thickAxeLapis");
		lapisPick.setUnlocalizedName("pickaxeLapis").setTextureName(TEXTURE + "pickaxeLapis");
		lapisShovel.setUnlocalizedName("shovelLapis").setTextureName(TEXTURE + "shovelLapis");
		lapisAxe.setUnlocalizedName("axeLapis").setTextureName(TEXTURE + "axeLapis");
		lapisSword.setUnlocalizedName("swordLapis").setTextureName(TEXTURE + "swordLapis");
		
		diamondPlate.setUnlocalizedName("plateDiamond").setTextureName(TEXTURE + "diamondPlate").setCreativeTab(Ref.tab);
		ironPlate.setUnlocalizedName("plateIron").setTextureName(TEXTURE + "ironPlate").setCreativeTab(Ref.tab);
		stonePlate.setUnlocalizedName("plateStone").setTextureName(TEXTURE + "stonePlate").setCreativeTab(Ref.tab);
		lapisPlate.setUnlocalizedName("plateLapis").setTextureName(TEXTURE + "lapisPlate").setCreativeTab(Ref.tab);
		lapisPlateLarge.setUnlocalizedName("plateLapisLarge").setTextureName(TEXTURE + "lapisPlateLarge").setCreativeTab(Ref.tab);
		lapisChunk.setUnlocalizedName("chunkLapis").setTextureName(TEXTURE + "lapisChunk").setCreativeTab(Ref.tab);
		toolHandle.setUnlocalizedName("toolHandle").setTextureName(TEXTURE + "toolHandle").setCreativeTab(Ref.tab);
		
		opulenceEnchantItem.setUnlocalizedName("enchantItemOpulence").setTextureName(TEXTURE + "opulenceEnchant");
		earthbaneEnchantItem.setUnlocalizedName("enchantItemEarthbane").setTextureName(TEXTURE + "earthbaneEnchant");
		
		pickEB[0].setUnlocalizedName("pickEBIron").setTextureName(TEXTURE + "thickPickaxeIron").setCreativeTab(null);
		pickEB[1].setUnlocalizedName("pickEBLapis").setTextureName(TEXTURE + "thickPickaxeLapis").setCreativeTab(null);
		pickEB[2].setUnlocalizedName("pickEBDiamond").setTextureName(TEXTURE + "thickPickaxeDiamond").setCreativeTab(null);
		shovelEB[0].setUnlocalizedName("shovelEBIron").setTextureName(TEXTURE + "thickShovelIron").setCreativeTab(null);
		shovelEB[1].setUnlocalizedName("shovelEBLapis").setTextureName(TEXTURE + "thickShovelLapis").setCreativeTab(null);
		shovelEB[2].setUnlocalizedName("shovelEBDiamond").setTextureName(TEXTURE + "thickShovelDiamond").setCreativeTab(null);
	}
	
	public static void registerItems()
	{
		GameRegistry.registerItem(diamondTP, "thickPickaxeDiamond");
		GameRegistry.registerItem(diamondTS, "thickShovelDiamond");
		GameRegistry.registerItem(diamondTA, "thickAxeDiamond");
		GameRegistry.registerItem(ironTP, "thickPickaxeIron");
		GameRegistry.registerItem(ironTS, "thickShovelIron");
		GameRegistry.registerItem(ironTA, "thickAxeIron");
		GameRegistry.registerItem(stoneTP, "thickPickaxeStone");
		GameRegistry.registerItem(stoneTS, "thickShovelStone");
		GameRegistry.registerItem(stoneTA, "thickAxeStone");
		GameRegistry.registerItem(lapisTP, "thickPickaxeLapis");
		GameRegistry.registerItem(lapisTS, "thickShovelLapis");
		GameRegistry.registerItem(lapisTA, "thickAxeLapis");
		GameRegistry.registerItem(lapisPick, "pickaxeLapis");
		GameRegistry.registerItem(lapisShovel, "shovelLapis");
		GameRegistry.registerItem(lapisAxe, "axeLapis");
		GameRegistry.registerItem(lapisSword, "swordLapis");
		
		GameRegistry.registerItem(diamondPlate, "plateDiamond");
		GameRegistry.registerItem(ironPlate, "plateIron");
		GameRegistry.registerItem(stonePlate, "plateStone");
		GameRegistry.registerItem(lapisPlate, "plateLapis");
		GameRegistry.registerItem(lapisPlateLarge, "plateLapisLarge");
		GameRegistry.registerItem(lapisChunk, "chunkLapis");
		GameRegistry.registerItem(toolHandle, "toolHandle");
		
		GameRegistry.registerItem(opulenceEnchantItem, "enchantItemOpulence");
		GameRegistry.registerItem(earthbaneEnchantItem, "enchantItemEarthbane");
		
		GameRegistry.registerItem(pickEB[0], "pickEBIron");
		GameRegistry.registerItem(pickEB[1], "pickEBLapis");
		GameRegistry.registerItem(pickEB[2], "pickEBDiamond");
		GameRegistry.registerItem(shovelEB[0], "shovelEBIron");
		GameRegistry.registerItem(shovelEB[1], "shovelEBLapis");
		GameRegistry.registerItem(shovelEB[2], "shovelEBDiamond");
	}
	
	public static void registerSmelts()
	{
		GameRegistry.addSmelting(oreCrackedIron, new ItemStack(Items.iron_ingot), 3.0F);
		GameRegistry.addSmelting(oreCrackedGold, new ItemStack(Items.gold_ingot), 3.0F);
	}
	
	public static void registerRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(diamondTP), new Object[]{"DDD", " P ", " H ", 'D', new ItemStack(diamondPlate), 'P', new ItemStack(Items.diamond_pickaxe), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(diamondTS), new Object[]{"D", "S", "H", 'D', new ItemStack(diamondPlate), 'S', new ItemStack(Items.diamond_shovel), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(diamondTA), new Object[]{"DD", "DA", " H", 'D', new ItemStack(diamondPlate), 'A', new ItemStack(Items.diamond_axe), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(ironTP), new Object[]{"III", " P ", " H ", 'I', new ItemStack(ironPlate), 'P', new ItemStack(Items.iron_pickaxe), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(ironTS), new Object[]{"I", "S", "H", 'I', new ItemStack(ironPlate), 'S', new ItemStack(Items.iron_shovel), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(ironTA), new Object[]{"II", "IA", " H", 'I', new ItemStack(ironPlate), 'A', new ItemStack(Items.iron_axe), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(stoneTP), new Object[]{"RRR", " P ", " H ", 'R', new ItemStack(stonePlate), 'P', new ItemStack(Items.stone_pickaxe), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(stoneTS), new Object[]{"R", "S", "H", 'R', new ItemStack(stonePlate), 'S', new ItemStack(Items.stone_shovel), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(stoneTA), new Object[]{"RR", "RA", " H", 'R', new ItemStack(stonePlate), 'A', new ItemStack(Items.stone_axe), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisTP), new Object[]{"LLL", " P ", " H ", 'D', new ItemStack(lapisPlateLarge), 'P', new ItemStack(lapisPick), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisTS), new Object[]{"L", "S", "H", 'D', new ItemStack(lapisPlateLarge), 'S', new ItemStack(lapisShovel), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisTA), new Object[]{"LL", "LA", " H", 'D', new ItemStack(lapisPlateLarge), 'A', new ItemStack(lapisAxe), 'H', new ItemStack(toolHandle)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisPick), new Object[]{"LLL", " s ", " s ", 'L', new ItemStack(lapisPlate), 's', new ItemStack(Items.stick)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisShovel), new Object[]{"L", "s", "s", 'L', new ItemStack(lapisPlate), 's', new ItemStack(Items.stick)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisAxe), new Object[]{"LL", "Ls", "s ", 'L', new ItemStack(lapisPlate), 's', new ItemStack(Items.stick)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisSword), new Object[]{"L", "L", "s", 'L', new ItemStack(lapisPlate), 's', new ItemStack(Items.stick)});
		
		GameRegistry.addShapedRecipe(new ItemStack(diamondPlate), new Object[]{"DDD", 'D', new ItemStack(Items.diamond)});
		GameRegistry.addShapedRecipe(new ItemStack(ironPlate), new Object[]{"III", 'I', new ItemStack(Items.iron_ingot)});
		GameRegistry.addShapedRecipe(new ItemStack(stonePlate), new Object[]{"CSC", 'S', new ItemStack(Blocks.stone), 'C', new ItemStack(Blocks.cobblestone)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisPlate), new Object[]{"LLL", 'L', new ItemStack (lapisChunk)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisPlateLarge), new Object[]{"LLL", "LLL", 'L', new ItemStack (lapisPlate)});
		GameRegistry.addShapedRecipe(new ItemStack(lapisChunk), new Object[]{" L ", "LLL", " L ", 'L', new ItemStack(Items.dye, 1, 4)});
		GameRegistry.addShapedRecipe(new ItemStack(toolHandle), new Object[]{"SIS", "SIS", "SIS", 'S', new ItemStack(Blocks.stone), 'I', new ItemStack(Items.stick)});
		
		GameRegistry.addShapedRecipe(new ItemStack(opulenceEnchantItem), new Object[]{"DLD", "RCR", "DLD", 'D', new ItemStack(Items.diamond), 'L', new ItemStack(Blocks.lapis_block), 'R', new ItemStack(Blocks.redstone_block), 'C', new ItemStack(earthbaneEnchantItem)});
		GameRegistry.addShapedRecipe(new ItemStack(earthbaneEnchantItem), new Object[]{"CTC", "TDT", "CTC", 'C', new ItemStack(Blocks.cobblestone), 'T', new ItemStack(Blocks.tnt), 'D', new ItemStack(Items.diamond)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 3), new ItemStack(diamondPlate));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new ItemStack(ironPlate));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 3), new ItemStack(stonePlate));
		GameRegistry.addShapelessRecipe(new ItemStack(lapisChunk, 3), new ItemStack(lapisPlate));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.lapis_block, 6), new ItemStack(lapisPlateLarge));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 5, 4), new ItemStack(lapisChunk));
	}
	
	public static void registerOreDict()
	{}
	
	
}