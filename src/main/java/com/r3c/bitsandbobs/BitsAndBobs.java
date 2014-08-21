package com.r3c.bitsandbobs;

/**
 * @author R3C
 */

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import com.r3c.bitsandbobs.reference.Config;
import com.r3c.bitsandbobs.reference.ItemsAndBlocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "b&b", name = "Bits and Bobs", version = "0.0.1")
public class BitsAndBobs 
{   
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	Config.init(event.getSuggestedConfigurationFile());
    	ItemsAndBlocks.init();
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) 
    {
    	MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {}
}
