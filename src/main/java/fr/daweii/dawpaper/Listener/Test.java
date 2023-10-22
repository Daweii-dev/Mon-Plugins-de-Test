//package fr.daweii.dawpaper.Listener;
//
//import fr.daweii.dawpaper.Main;
//import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.configuration.file.YamlConfiguration;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerInteractEvent;
//import org.bukkit.event.player.PlayerJoinEvent;
//
//import java.io.File;
//
//public class Test implements Listener {
//
////    @EventHandler
////    public void onMove(PlayerJoinEvent event) {
////        Player player = event.getPlayer();
////        String name = player.getName();
////
////        Bukkit.createBossBar("Bienvenue à " + name + " sur le serveur !!!", BarColor.GREEN, BarStyle.SOLID);
//
//
//    private Main main;
//
//    @EventHandler
//    public boolean onJoin(PlayerJoinEvent event) {
//
//
//        Player player = event.getPlayer();
//
//        final File file = new File(main.getDataFolder(), "config.yml");
//        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
//
////        configuration.set("Salon." + "neutre.", player.getUniqueId());
//
//        configuration.set("Salon.", player.getUniqueId());
//
//        player.sendMessage("Test");
//
//
//        return false;
//    }
//}
