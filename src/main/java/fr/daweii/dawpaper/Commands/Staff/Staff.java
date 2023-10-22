package fr.daweii.dawpaper.Commands.Staff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class Staff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player playersender = (Player) sender;
            if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    PlayerInventory inventory = player.getInventory();
                    playersender.openInventory(inventory);
                }

            }
        }
        return false;
    }
}