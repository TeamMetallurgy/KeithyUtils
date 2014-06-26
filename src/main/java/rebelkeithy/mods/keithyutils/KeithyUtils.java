package rebelkeithy.mods.keithyutils;

import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="KeithyUtils", name="Keithy Utils", version="1.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class KeithyUtils {

	@SidedProxy(clientSide = "rebelkeithy.mods.keithyutils.ClientProxy", serverSide = "rebelkeithy.mods.keithyutils.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(value = "KeithyUtils")
	public static KeithyUtils instance;

	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		ServerCommandManager serverCommand = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();
	}
	 
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{       
		
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new EventListener());
		proxy.registerTickHandlers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
