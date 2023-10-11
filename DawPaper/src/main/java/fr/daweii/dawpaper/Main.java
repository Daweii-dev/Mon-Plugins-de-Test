package fr.daweii.dawpaper;

import fr.daweii.dawpaper.Commands.CommandeTest;
import fr.daweii.dawpaper.Commands.Spawn;
import fr.daweii.dawpaper.Commands.Staff.Staff;
import fr.daweii.dawpaper.Commands.Staff.Vanish;
import fr.daweii.dawpaper.Commands.Staff.openinv;
import fr.daweii.dawpaper.Commands.Staff.say;
//import fr.daweii.dawpaper.Commands.TPS;
import fr.daweii.dawpaper.ItemCustom.JetPack.CraftJetPack.CraftC;
import fr.daweii.dawpaper.ItemCustom.Commands.Item;
import fr.daweii.dawpaper.ItemCustom.JetPack.Listeners.onJump;
import fr.daweii.dawpaper.ItemCustom.Parachute.CraftParachutre.CraftP;
import fr.daweii.dawpaper.ItemCustom.Parachute.Listeners.Click;
import fr.daweii.dawpaper.ItemCustom.Tourelle.Listener.DetectPlayer;
import fr.daweii.dawpaper.ItemCustom.Tourelle.Listener.SetTourelle;
import fr.daweii.dawpaper.Listener.DawListener;
import fr.daweii.dawpaper.Listener.Fleur;
import fr.daweii.dawpaper.Listener.Region;
//import fr.daweii.dawpaper.Listener.Test;
import fr.daweii.dawpaper.yml.CUnTest;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("DawPaper ON 22.15");

//Commands
//      Staff
        getCommand("staff").setExecutor(new Staff());
        getCommand("say").setExecutor(new say());
        getCommand("openinv").setExecutor(new openinv());
        getCommand("vanish").setExecutor(new Vanish(this));
//      No Staff
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("commandetest").setExecutor(new CommandeTest());
//        getCommand("tps").setExecutor(new TPS());



        getCommand("item").setExecutor(new Item());
        getCommand("cuntest").setExecutor(new CUnTest(this));

        final Server server = getServer();
        final PluginManager pluginManager = server.getPluginManager();

        pluginManager.registerEvents(new DawListener(), this);
        pluginManager.registerEvents(new Region(), this);
        pluginManager.registerEvents(new Fleur(), this);
        pluginManager.registerEvents(new onJump(), this);
        pluginManager.registerEvents(new Click(), this);
        pluginManager.registerEvents(new SetTourelle(this), this);
        pluginManager.registerEvents(new DetectPlayer(this), this);

//        getServer().getPluginManager().registerEvents(new Test(), this);

        server.addRecipe(CraftC.jetPack(this));
        server.addRecipe(CraftC.gunPowder(this));

        server.addRecipe(CraftP.Parachute(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("DawPaper OFF");

    }
}
