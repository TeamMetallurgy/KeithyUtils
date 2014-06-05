package rebelkeithy.mods.keithyutils.capes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.util.ResourceLocation;

public class CapeTickHandler
{
	private static final String REMOTE_CAPES_LIST = "http://gwycraft.gcod.net/wp-content/uploads/2013/09/capeinfo.txt";
	
	static List<String> modders = Arrays.asList(new String[]{ "RebelKeithy" , "Shadowclaimer" });
		
    public static void registerCapes()
    {

        setDevCapes(modders, "http://i.imgur.com/AMVu0m2.png");
        getDonatorCapes();
                
    }
    
    private static void setDevCapes(List<String> modders, String cloakURL)
    {
        for(String modder : modders)
        {
            setCape(modder, cloakURL);
        }
        
    }

    private static void getDonatorCapes()
    {
        try
        {
            final URL url = new URL(REMOTE_CAPES_LIST);

            final InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
            final BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                if(!line.contains(",")) {
                    continue;
                }
                
                String[] strings = line.split(",");
                
                String donator = strings[0];
                String image = strings[1];
                
                setCape(donator, image);
                
            }
        } catch (final Exception ex)
        {
          
        }
    }
    
    private static void setCape(String username, String capeImage)
    {
        ThreadDownloadImageData cape = new ThreadDownloadImageData(capeImage, null, null);
        Minecraft.getMinecraft().getTextureManager().loadTexture(new ResourceLocation("cloaks/" + username),(TextureObject) cape);  
    }

}