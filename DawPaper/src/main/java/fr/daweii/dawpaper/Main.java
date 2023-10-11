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
import org.bukkit.entity.Player;
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


        getServer().getPluginManager().registerEvents(new DawListener(), this);
        getServer().getPluginManager().registerEvents(new Region(), this);
        getServer().getPluginManager().registerEvents(new Fleur(), this);
        getServer().getPluginManager().registerEvents(new onJump(), this);
        getServer().getPluginManager().registerEvents(new Click(), this);
        getServer().getPluginManager().registerEvents(new SetTourelle(this), this);
        getServer().getPluginManager().registerEvents(new DetectPlayer(this), this);

//        getServer().getPluginManager().registerEvents(new Test(), this);

        getServer().addRecipe(CraftC.jetPack(this));
        getServer().addRecipe(CraftC.gunPowder(this));

        getServer().addRecipe(CraftP.Parachute(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("DawPaper OFF");

    }
}
