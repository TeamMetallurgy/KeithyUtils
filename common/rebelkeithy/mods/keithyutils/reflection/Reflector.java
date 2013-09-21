package rebelkeithy.mods.keithyutils.reflection;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.item.Item;

public class Reflector 
{
	public static void setItemTexture(Item item, String texture)
	{
		try {
			ObfuscationReflectionHelper.setPrivateValue(Item.class, item, "iconString", texture);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
