package youyihj.bilingualname;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = BilingualName.MODID, name = BilingualName.NAME, version = BilingualName.VERSION, clientSideOnly = true)
public class BilingualName
{
    public static final String MODID = "bilingualname";
    public static final String NAME = "Bilingual Name";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }
}
