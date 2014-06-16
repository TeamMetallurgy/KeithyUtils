package rebelkeithy.mods.keithyutils.metablock;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMetaBlock extends ItemBlock
{
	public ItemMetaBlock(int par1)
	{
		super(par1);
		setHasSubtypes(true);
	}
	
    public CreativeTabs[] getCreativeTabs()
    {
        return ((MetaBlock)Block.blocksList[this.getBlockID()]).getCreativeTabArray();
    }
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int meta = itemstack.getItemDamage();
		Block block = Block.blocksList[this.getBlockID()];

		if (block != null && block instanceof MetaBlock)
		{
		    return ((MetaBlock)block).getUnlocalizedName(meta);
		}
		else
		{
		    return getUnlocalizedName() + "." + meta;
		}

	}
}
