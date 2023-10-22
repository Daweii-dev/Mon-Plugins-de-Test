package fr.daweii.dawpaper.ItemCustom;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Liste {

    public static ItemStack JetPackItem() {
        ItemStack jetpack = new ItemStack(createItem(Material.LEATHER_CHESTPLATE, "§4JetPack", true, 1, 1));
        return jetpack;
    }

    public static ItemStack GunPowderI() {
        ItemStack gunpowder = new ItemStack(createItem(Material.GUNPOWDER, "§4GunPowder I", true, 10, 2));
        return gunpowder;
    }

    public static ItemStack Parachute() {
        ItemStack parachute = new ItemStack(createItem(Material.PAPER, "§4Parachute", true, 1, 3));
        return parachute;
    }

    public static ItemStack Tourelle() {
        ItemStack tourelle = new ItemStack(createItem(Material.OBSIDIAN, "Tourelle", true, 1, 4));
        return tourelle;
    }

    public static ItemStack createItem(Material material, String customName, boolean enchant, int amount, Integer customModelData, String... Lore)
    {
        ItemStack item = new ItemStack(material);
        ItemMeta customItem = item.getItemMeta();
        customItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        customItem.displayName(
                Component.text(customName)
        );

        item.setAmount(amount);
        customItem.setCustomModelData(customModelData);

        if (enchant)
        {
            customItem.addEnchant(Enchantment.MENDING,1,true);
            customItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(customItem);
        return item;
    }
}
