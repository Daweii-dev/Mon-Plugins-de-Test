package fr.daweii.dawpaper.Money.Commands;

import fr.daweii.dawpaper.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Give implements CommandExecutor {

    private Main main;

    public Give(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 2) {
            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {

                final FileConfiguration config = this.main.getConfig();

                int last = config.getInt("Money." + player.getUniqueId());

                config.set("Money." + player.getUniqueId(), last + Integer.parseInt(args[1]));

                this.main.saveConfig();
            }
        }
        return false;
    }
}
