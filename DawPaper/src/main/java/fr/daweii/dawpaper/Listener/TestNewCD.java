package fr.daweii.dawpaper.Listener;//package com.daweii.dawfaction.Listener;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Material;
//import org.bukkit.Sound;
//import org.bukkit.block.Block;
//import org.bukkit.block.Jukebox;
//import org.bukkit.block.data.BlockData;
//import org.bukkit.entity.Item;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.BlockDataMeta;
//import org.bukkit.inventory.meta.BlockStateMeta;
//import org.bukkit.inventory.meta.ItemMeta;
//
//public class TestNewCD implements Listener {
//
////    @EventHandler
////    public void onInteract(PlayerInteractEvent event) {
////        Player player = event.getPlayer();
////        Action action = event.getAction();
////        ItemStack it = event.getItem();
////        Block block = event.getClickedBlock();
////        Jukebox jukebox = (Jukebox) block.getState();
////        ItemStack record = jukebox.getRecord();
////
////        if (it != null && action == Action.RIGHT_CLICK_BLOCK && block.getType().equals(Material.JUKEBOX) && it.getType() == Material.MUSIC_DISC_11 && it.getItemMeta().getDisplayName().equals("Nom de l'iteme)){
////            event.setCancelled(true);
////            player.playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, 10, 10);
////        }
////    }
//
//    @EventHandler(ignoreCancelled = true)
//    public void onPlayerInteract(PlayerInteractEvent e) {
//        // Ensure we want to do something with this event
//        if (e.getAction() != Action.RIGHT_CLICK_BLOCK
//                || e.getClickedBlock() == null
//                || e.getClickedBlock().getType() != Material.JUKEBOX
//                || !(e.getClickedBlock().getState() instanceof Jukebox)
//        ) {
//            return;
//        }
//        ItemStack it = e.getItem();
//        Action action = e.getAction();
//
//        Player player = e.getPlayer();
//        // Cast the clicked block's state to JukeBox
//        Jukebox jukebox = (Jukebox) e.getClickedBlock().getState();
//        // Get the record in the JukeBox
//        ItemStack record = jukebox.getRecord();
//        // If the record's material type is AIR, there is nothing playing
//        if (record.getType() == Material.AIR) {
//            player.sendMessage("There is nothing playing in this JukeBox.");
//            return;
//        } else if (jukebox.isPlaying() && record.getType() == Material.MUSIC_DISC_11) {
//            player.sendMessage("blablabla");
//        }
//    }
//}