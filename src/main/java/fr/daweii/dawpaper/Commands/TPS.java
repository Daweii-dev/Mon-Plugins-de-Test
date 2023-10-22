//package fr.daweii.dawpaper.Commands;
//
//import com.sun.security.ntlm.Server;
//import org.bukkit.Bukkit;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//import java.awt.print.Paper;
//
//public class TPS implements CommandExecutor {
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//
//        Player player = (Player) sender;
//
//        if (args.length == 1) {
//            String cmdAmbient = String.valueOf(args[0].equalsIgnoreCase("Ambient"));
//            if (args[0] == cmdAmbient) {
//                int TPSAmbient = Bukkit.getServer().getTicksPerAmbientSpawns();
//
//                if (sender instanceof Player) {
//                    player.sendMessage("§6Le Serveur et a  " + TPSAmbient + " TPS Ambient !");
//                } else if (sender instanceof CommandSender) {
//                    System.out.println("§6Le Serveur et a  " + TPSAmbient + " TPS Ambient !");
//                }
//            }
//        }
//
//        int TPSAmbient = Bukkit.getServer().getTicksPerAmbientSpawns();
//        int TPSAnimal = Bukkit.getServer().getTicksPerAnimalSpawns();
//        int TPSMonster = Bukkit.getServer().getTicksPerMonsterSpawns();
//        int TPSWater = Bukkit.getServer().getTicksPerWaterSpawns();
//
//        int TPS = (TPSAmbient + TPSAnimal + TPSMonster + TPSWater) / 4;
//
//        if (sender instanceof Player) {
//            player.sendMessage("§6Le Serveur et a  " + TPS + " TPS !");
//        } else if (sender instanceof CommandSender) {
//            System.out.println("§6Le Serveur et a  " + TPS + " TPS !");
//        }
//
//
//        player.sendMessage("§6Le Serveur et a  " + TPS + " TPS !");
//
//
//        return false;
//    }
//}
