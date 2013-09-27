package rebelkeithy.mods.keithyutils.reflection;

import net.minecraft.item.Item;

public class Reflector 
{
	public static void setItemTexture(Item item, String texture)
	{
		item.iconString = texture;
	}
}
