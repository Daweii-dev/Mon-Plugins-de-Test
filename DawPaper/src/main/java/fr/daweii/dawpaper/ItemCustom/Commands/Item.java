package fr.daweii.dawpaper.ItemCustom.Commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Item implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,  Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerInventory playerInventory = player.getInventory();

            player.sendMessage("Tu a le jetPack");
            playerInventory.setChestplate(getItem(Material.LEATHER_CHESTPLATE, "§4JetPack", true, 1));
            playerInventory.setItemInMainHand(getItem(Material.GUNPOWDER, "§4GunPowder I", true, 10));
            playerInventory.setItem(1, getItem(Material.PAPER, "§4Parachute", true, 1));
            playerInventory.setItem(0, getItem(Material.OBSIDIAN, "Tourelle", true, 1));

        }

        return false;
    }

    public ItemStack getItem(Material material, String customName, boolean enchant, int amount, String... Lore)
    {
        ItemStack item = new ItemStack(material);
        ItemMeta customItem = item.getItemMeta();
        customItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        customItem.displayName(
                Component.text(customName)
                );

        item.setAmount(amount);


        if (enchant)
        {
            customItem.addEnchant(Enchantment.MENDING,1,true);
            customItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(customItem);
        return item;
    }
}
