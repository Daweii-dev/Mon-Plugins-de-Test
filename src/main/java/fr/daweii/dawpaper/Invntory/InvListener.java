package fr.daweii.dawpaper.Invntory;

import fr.daweii.dawpaper.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class InvListener implements Listener {

    Main main;

    public InvListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){

        InventoryView inv = event.getView();

        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();


        if (current == null) return;

        if (inv.getOriginalTitle().equals("Menu")){

            event.setCancelled(true);

            switch (current.getItemMeta().getCustomModelData()){

                case 220:
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 50, 50);
                    player.closeInventory();
                    break;

                case 221:
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 50, 999);
                    player.closeInventory();
                    break;

                case 222:
                    player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_AMBIENT, 50, 50);
                    player.closeInventory();
                    break;

                case 223:
                    if (main.inv_grade.contains(player)) {
                        main.inv_grade.remove(player);
                        player.sendMessage("remove");
                    } else if (!main.inv_grade.contains(player)) {
                        main.inv_grade.add(player);
                        player.sendMessage("add");
                    } else {
                        player.sendMessage("rien");
                    }

                    player.closeInventory();
                    break;

                default:
                    return;
            }
        }
    }
}
