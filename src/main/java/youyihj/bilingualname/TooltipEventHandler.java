package youyihj.bilingualname;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.Locale;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.client.resource.VanillaResourceType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.List;
import java.util.Map;

/**
 * @author youyihj
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class TooltipEventHandler {
    public static final Locale EN_US = new Locale();

    static {
        load();
        IResourceManager iResourceManager = Minecraft.getMinecraft().getResourceManager();
        if (iResourceManager instanceof IReloadableResourceManager){
            ((IReloadableResourceManager)iResourceManager).registerReloadListener(
                    (ISelectiveResourceReloadListener) (iResourceManager1, type) -> {
                        if (type.test(VanillaResourceType.LANGUAGES)) {
                            load();
                        }
                    }
            );
        }
    }

    private static void load(){
        EN_US.loadLocaleDataFiles(Minecraft.getMinecraft().getResourceManager(), Lists.newArrayList("en_us"));
    }

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getJavaLocale().equals(java.util.Locale.US)) return;
        Locale prevLocale = I18n.i18nLocale;
        Map<String, String> prevLanguageList = LanguageMap.getInstance().languageList;
        I18n.i18nLocale = EN_US;
        LanguageMap.getInstance().languageList = EN_US.properties;
        ItemStack item = event.getItemStack();
        if (!item.hasDisplayName()) {
            event.getToolTip().add(1, TextFormatting.GREEN + TextFormatting.getTextWithoutFormattingCodes(item.getDisplayName()));
        }
        I18n.i18nLocale = prevLocale;
        LanguageMap.getInstance().languageList = prevLanguageList;
    }
}
