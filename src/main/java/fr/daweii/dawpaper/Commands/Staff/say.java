package fr.daweii.dawpaper.Commands.Staff;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class say implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player playersender = (Player) sender;
            if (args.length != 1 || args.length != 0) {
                Player player = Bukkit.getPlayer(args[0]);
                String name = player.getName();
                if (player != null) {
                    String message = args[1];
                    Bukkit.broadcastMessage("<"+ name + "> " + message);
                }
            }
        }
        return false;
    }

}
