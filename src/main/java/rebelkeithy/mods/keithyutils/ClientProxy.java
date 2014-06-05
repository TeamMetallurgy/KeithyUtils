package rebelkeithy.mods.keithyutils;

import rebelkeithy.mods.keithyutils.capes.CapeTickHandler;

public class ClientProxy extends CommonProxy
{
	
	public void registerParticles()
	{
	}
	
	public void registerTickHandlers()
	{
		//TickRegistry.registerTickHandler(new CapeTickHandler(), Side.CLIENT);
		
		CapeTickHandler.registerCapes();
	}
}
