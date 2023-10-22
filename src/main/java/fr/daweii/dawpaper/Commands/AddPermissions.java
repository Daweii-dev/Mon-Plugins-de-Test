package fr.daweii.dawpaper.Commands;/*
package com.daweii.dawplugins.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddPermissions implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player1 = (Player) sender;

        if (args.length == 2) {

            player1.sendMessage("1");

            Player player = Bukkit.getPlayer(args[0]);
            if (player != null) {

                player1.sendMessage("2");
                String permissions1 = "staff";
                if (args[1] == permissions1 && !player.hasPermission("permission.staff")) {

                    player1.sendMessage("3");

                    player.isPermissionSet("permission.staff");
                }
            }
        }
        return false;
    }
}
*/
