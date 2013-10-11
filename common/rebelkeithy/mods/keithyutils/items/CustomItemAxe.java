package rebelkeithy.mods.keithyutils.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class CustomItemAxe extends ItemAxe
{

	private EnumToolMaterial material;

	public CustomItemAxe(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
		this.material = par2EnumToolMaterial;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advancedItemTooltips) {
		list.add("Material: " + this.material.toString());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			list.add("Speed: " + this.material.getEfficiencyOnProperMaterial());
			list.add("Enchantability: " + this.material.getEnchantability());
			
			if(!advancedItemTooltips)
			{
				list.add("Durability: " + (itemStack.getMaxDamage() - itemStack.getItemDamage()));
			}
		}
	}
}
