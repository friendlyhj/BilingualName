package youyihj.bilingualname;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.Locale;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

/**
 * @author youyihj
 */
@Mod.EventBusSubscriber
public class TooltipEventHandler {
    public static final Locale EN_US = new Locale();

    static {
        EN_US.loadLocaleDataFiles(Minecraft.getMinecraft().getResourceManager(), Lists.newArrayList("en_us"));
    }

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getJavaLocale().equals(java.util.Locale.US)) return;
        ItemStack stack = event.getItemStack();
        List<String> tooltip = event.getToolTip();
        String localizedName = EN_US.formatMessage(stack.getUnlocalizedName() + ".name", new Object[0]);
        tooltip.add(localizedName);
    }
}