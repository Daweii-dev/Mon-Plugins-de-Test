package fr.daweii.dawpaper.Commands.Staff;

import fr.daweii.dawpaper.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {

    Main plugin;

    public Vanish(Main main) {this.plugin = plugin;}

    @Override
    public  boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (plugin.invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, player);
                }
                plugin.invisible_list.remove(player);
                player.sendMessage("Vous êtes maintenant visible pour les autres joueurs sur le serveur.");
            }else if(!plugin.invisible_list.contains(player)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, player);
                }
                plugin.invisible_list.add(player);
                player.sendMessage("Vous êtes maintenant invisible !");
            }
        }

        return false;
    }
}
