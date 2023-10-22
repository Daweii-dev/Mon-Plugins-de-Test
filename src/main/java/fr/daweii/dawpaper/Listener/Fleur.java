package fr.daweii.dawpaper.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Fleur implements Listener {

    @EventHandler
    public void Fleur1(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null) {

            return;
        }

        if (item.getType() == Material.ACACIA_WOOD) {
            player.sendMessage("J'ai une fleur !!!");
            player.kickPlayer("Test");
        }
    }
}
