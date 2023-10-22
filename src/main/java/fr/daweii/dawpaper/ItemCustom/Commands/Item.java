package fr.daweii.dawpaper.ItemCustom.Commands;

import fr.daweii.dawpaper.ItemCustom.Liste;
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
            playerInventory.setChestplate(Liste.JetPackItem());
            playerInventory.setItemInMainHand(Liste.GunPowderI());
            playerInventory.setItem(1, Liste.Parachute());
            playerInventory.setItem(0, Liste.Tourelle());

        }

        return false;
    }
}
