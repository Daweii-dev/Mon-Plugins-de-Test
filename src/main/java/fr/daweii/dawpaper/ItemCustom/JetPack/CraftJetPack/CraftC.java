package fr.daweii.dawpaper.ItemCustom.JetPack.CraftJetPack;

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

public class CraftC {

    public static ShapedRecipe jetPack(Main main) {
;
        ShapedRecipe jetPack = new ShapedRecipe(new NamespacedKey(main, "JetPack"),new ItemStack(Liste.JetPackItem()));
        jetPack.shape(new String[] {"IFI", "IDI", "I I"});
        jetPack.setIngredient('I', Material.IRON_BLOCK);
        jetPack.setIngredient('F', Material.FIRE_CHARGE);
        jetPack.setIngredient('D', Material.DISPENSER);

        return jetPack;

    }

    public static ShapedRecipe gunPowder(Main main) {

        ShapedRecipe gunPowder = new ShapedRecipe(new NamespacedKey(main, "GunPowder"), new ItemStack(Liste.GunPowderI()));
        gunPowder.shape(new String[] {"PPP", "PIP", "PPP"});
        gunPowder.setIngredient('P', Material.GUNPOWDER);
        gunPowder.setIngredient('I', Material.IRON_INGOT);

        return gunPowder;

    }
}
