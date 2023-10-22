package fr.daweii.dawpaper.Invntory;

import fr.daweii.dawpaper.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
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
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;


public class Commands implements CommandExecutor {

    Main main;

    public Commands(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skull = (SkullMeta) playerHead.getItemMeta();
            skull.setOwningPlayer(Bukkit.getOfflinePlayer("sasasa1723"));
            playerHead.setItemMeta(skull);
            skull.displayName(
                    Component.text("§5Ender-world")
            );

            Inventory inv = Bukkit.createInventory(null, 45,
                    Component.text("Menu")
                    );

            inv.setItem(16, createSkull("sasasa1723", "§5Ender-world", 220));
            inv.setItem(25, createSkull("4rd4loji", "§aOver-World", 221));
            inv.setItem(34, createSkull("Rjukas", "§6Nether-World", 222));

            if (!main.inv_grade.contains(player)){
                inv.setItem(32, createItem(Material.EMERALD, "dfsdfdsf", true, 1, 223));
                player.sendMessage("true");
            } else if (main.inv_grade.contains(player)) {
                inv.setItem(32, createItem(Material.EMERALD, "dfsdfdsf", false, 1, 223));
                player.sendMessage("false");
            }

            player.openInventory(inv);
        }
        return false;
    }


    public static ItemStack createItem(Material material, String customName, boolean enchant, int amount, Integer customModelData, String... Lore) {
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



    public static ItemStack createSkull(String namePlayer, String name, Integer CustomMD){

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skull = (SkullMeta) playerHead.getItemMeta();
        skull.setOwningPlayer(Bukkit.getOfflinePlayer(namePlayer));
        skull.displayName(
                Component.text(name)
        );
        skull.setCustomModelData(CustomMD);
        playerHead.setItemMeta(skull);
        return playerHead;
    }
}
