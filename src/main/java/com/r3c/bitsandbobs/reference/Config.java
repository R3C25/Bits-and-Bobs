package com.r3c.bitsandbobs.reference;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config extends Configuration
{
	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		Ref.opulenceID = config.get("Settings", "Opulence Enchantment ID", 60).getInt();
		Ref.earthbaneID = config.get("Settings", "Earthbane Enchantment ID", 63).getInt();
		
		config.save();
	}

}
