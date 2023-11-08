package fr.daweii.dawpaper.Listener;

import fr.daweii.dawpaper.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class DawListener implements Listener {

    private Main main;

    public DawListener(Main main) {
        this.main = main;
    }


    Location spawn = new Location(Bukkit.getWorld("world"), 9.5, 103, 7.5, 0, 0);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.joinMessage(
                Component.text("["+ "§2+" +"§f]" + "§2 " + player.getName())
        );

        player.teleport(spawn);

        player.sendMessage("Bienvenue sur ....");
        player.sendMessage("--------");
        player.sendMessage("§6Discord:§f https://discord.gg/VSHaCd9s7t");

        // First Join

        Integer firstJoin = player.getTicksLived();

        if (player.hasPlayedBefore()){
            Bukkit.broadcast(
                    Component.text("Bienvenue a §6§l" + player.getName() + "§f§l qui rejoin le serveur pour la premier fois !!!"));
        }

//        for (int i = 0; i < plugin.invisible_list.size(); i++){
//            player.hidePlayer(plugin, plugin.invisible_list.get(i));
//        }

        final FileConfiguration config = this.main.getConfig();

        if (config.get("Money." + player.getUniqueId()) == null) {
            config.set("Money." + player.getUniqueId(), 0);
        }

        config.set("Tourelle.X", 0);
        config.set("Tourelle.Y", 0);
        config.set("Tourelle.Z", 0);
        config.set("Tourelle.World", "world");

        this.main.saveConfig();

    }


    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.quitMessage(
                Component.text("["+ "§4-" +"§f]" + "§4 " + player.getName())
        );
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player.isOp() == false) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInterractInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player.isOp() == false) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreackBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        PlayerInventory playerInventory = player.getInventory();

        if (player.getTargetBlockExact(3) == new ItemStack(getItem(Material.SWEET_BERRY_BUSH, "Fraise", false, 1, 123456))) {

            playerInventory.setItemInMainHand(getItem(Material.SWEET_BERRIES, "Fraisier", false, 1, 12345));
        }

        if (player.isOp() == false) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (player.isOp() == false &&
            event.getBlock().getType() == Material.FIRE) {
            event.setCancelled(true);
        }
    }

//    @EventHandler
//    public void onDied(EntityDamageByEntityEvent event) {
//        Entity victim = event.getEntity();
//        Entity dammager = event.getDamager();
//
//        Player player = (Player)victim;
//        Player killer = null;
//
//        if (dammager instanceof Player) killer = (Player)dammager;
//
//        if (dammager instanceof Arrow) {
//            Arrow arrow = (Arrow) dammager;
//            if (arrow.getShooter() instanceof Player) {
//                killer = (Player) arrow.getShooter();
//            }
//        }
//
//
//            killer.sendMessage("+1 §2kill §f" + victim.getName());
//            victim.sendMessage("+1 §4mort §fde " + killer.getName());
//    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        player.teleport(spawn);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getY() < 0) {
            player.teleport(spawn);
        }
    }

    public ItemStack getItem(Material material, String customName, boolean enchant, int amount, int CustomModelData, String... Lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta customItem = item.getItemMeta();
        customItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        customItem.displayName(Component.text(customName));

        item.setAmount(amount);
        customItem.setCustomModelData(CustomModelData);

        if (enchant)
        {
            customItem.addEnchant(Enchantment.MENDING,1,true);
            customItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(customItem);
        return item;
    }
}
