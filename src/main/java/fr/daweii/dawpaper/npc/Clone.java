package fr.daweii.dawpaper.npc;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.jetbrains.annotations.NotNull;

public class Clone implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("No");
            return true;
        }
        return true;
    }

    private void spawn(Player player, Location loc) {
        Location location = loc;

    }

}
