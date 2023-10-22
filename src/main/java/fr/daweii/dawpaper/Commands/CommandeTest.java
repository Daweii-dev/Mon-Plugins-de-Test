package fr.daweii.dawpaper.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CommandeTest implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory playerInventory = player.getInventory();

            playerInventory.setItem(1, getItem(Material.SWEET_BERRY_BUSH, "Fraise", false, 1, 123456));
        }
        return false;
    }

    public ItemStack getItem(Material material, String customName, boolean enchant, int amount, int CustomModelData, String... Lore)
    {
        ItemStack item = new ItemStack(material);
        ItemMeta customItem = item.getItemMeta();
        customItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        customItem.setDisplayName(customName);

        customItem.setLore(Arrays.asList(Lore));
        item.setAmount(amount);
        customItem.setCustomModelData(CustomModelData);



        if (enchant)
        {
            customItem.addEnchant(Enchantment.MENDING,1,true);
            customItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(customItem);
        return item;
    }
}
