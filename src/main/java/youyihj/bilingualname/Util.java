package youyihj.bilingualname;

import net.minecraft.client.resources.Locale;
import net.minecraft.item.ItemStack;

/**
 * @author youyihj
 */
public class Util {
    private Util() {}

    public static String tryFindingKey(Locale locale, ItemStack stack) {
        String key = stack.getUnlocalizedName();
        if (locale.hasKey(key)) return key;
        key += ".name";
        if (locale.hasKey(key)) return key;
        key = stack.getItem().getUnlocalizedNameInefficiently(stack);
        if (locale.hasKey(key)) return key;
        key += ".name";
        if (locale.hasKey(key)) return key;
        return "";
    }
}
