package fr.daweii.dawpaper.ItemCustom.Parachute.CraftParachutre;

import fr.daweii.dawpaper.ItemCustom.Liste;
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

        ShapedRecipe Parachute = new ShapedRecipe(new NamespacedKey(main, "Parachute"),new ItemStack(Liste.Parachute()));
        Parachute.shape(new String[]{"PPP", "S S", "S S"});
        Parachute.setIngredient('P', Material.PAPER);
        Parachute.setIngredient('S', Material.STRING);

        return Parachute;

    }
}
