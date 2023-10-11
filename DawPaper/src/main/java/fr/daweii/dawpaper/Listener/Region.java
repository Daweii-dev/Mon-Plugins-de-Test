package fr.daweii.dawpaper.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Region implements Listener {

    @EventHandler
    public void Test(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if (player.getLocation().getX() > -100 && player.getLocation().getX() < 100
            && player.getLocation().getY() > -100 && player.getLocation().getY() < 100) {
//            sdqdqsfqsfqsfsqfqsfqsf
        }


//        PlayerInventory inv = player.getInventory();
//        ItemStack item = inv.getItem();
//        ItemStack fleur1 = new ItemStack(Material.COMPASS);
//
//
//        if (item == fleur1) {
//            player.sendMessage("J'ai une fleur !!!");
//            player.kickPlayer("Test");
//        }
    }
}
