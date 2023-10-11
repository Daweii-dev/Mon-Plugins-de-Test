package fr.daweii.dawpaper.ItemCustom.Parachute.CraftParachutre;

import fr.daweii.dawpaper.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftP {

    public static ShapedRecipe Parachute(Main main) {

        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta customItem = item.getItemMeta();
        customItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        customItem.displayName(
                Component.text("§4Parachute")
        );
        item.setAmount(1);

        if (true)
        {
            customItem.addEnchant(Enchantment.MENDING,1,true);
            customItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(customItem);

        ShapedRecipe Parachute = new ShapedRecipe(new NamespacedKey(main, "Parachute"),new ItemStack(item));
        Parachute.shape(new String[]{"PPP", "S S", "S S"});
        Parachute.setIngredient('P', Material.PAPER);
        Parachute.setIngredient('S', Material.STRING);

        return Parachute;

    }
}
