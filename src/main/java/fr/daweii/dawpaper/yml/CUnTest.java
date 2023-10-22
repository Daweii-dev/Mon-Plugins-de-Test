package fr.daweii.dawpaper.yml;


import fr.daweii.dawpaper.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CUnTest implements CommandExecutor {

    private Main main;

    public CUnTest(Main main) {
        this.main = main;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            final File file = new File(main.getDataFolder(), "config.yml");
            final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);


            configuration.set("Player." + "generalllllllll", ((Player) sender).getUniqueId().toString());

            try {
                configuration.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

//            configuration.getString("Player." + "general");
        }
        return false;
    }
}
