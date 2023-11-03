package fr.daweii.dawpaper;

import fr.daweii.dawpaper.Commands.CommandeTest;
import fr.daweii.dawpaper.Commands.Spawn;
import fr.daweii.dawpaper.Commands.Staff.Staff;
import fr.daweii.dawpaper.Commands.Staff.Vanish;
import fr.daweii.dawpaper.Commands.Staff.openinv;
import fr.daweii.dawpaper.Commands.Staff.say;
import fr.daweii.dawpaper.Invntory.Commands;
import fr.daweii.dawpaper.Invntory.InvListener;
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
import fr.daweii.dawpaper.Money.Commands.Give;
import fr.daweii.dawpaper.npc.Clone;
import fr.daweii.dawpaper.yml.CUnTest;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();
    public ArrayList<Player> inv_grade = new ArrayList<>();

    public ArrayList<Player> players = new ArrayList<>();


    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        System.out.println("DawPaper ON 23.27");

//Commands

//      Staff
        getCommand("staff").setExecutor(new Staff());
        getCommand("say").setExecutor(new say());
        getCommand("openinv").setExecutor(new openinv());
        getCommand("vanish").setExecutor(new Vanish(this));

//      No Staff
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("commandetest").setExecutor(new CommandeTest());
        getCommand("item").setExecutor(new Item());
        getCommand("cuntest").setExecutor(new CUnTest(this));
        getCommand("moneygive").setExecutor(new Give(this));
        getCommand("test").setExecutor(new Commands(this));

        getCommand("clone").setExecutor(new Clone());



        final PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new DawListener(this), this);
        pm.registerEvents(new Region(), this);
        pm.registerEvents(new Fleur(), this);
        pm.registerEvents(new onJump(), this);
        pm.registerEvents(new Click(), this);
        pm.registerEvents(new SetTourelle(this), this);
        pm.registerEvents(new DetectPlayer(this), this);
        pm.registerEvents(new InvListener(this), this);


        final Server s = getServer();

//        Craft

        s.addRecipe(CraftC.jetPack(this));
        s.addRecipe(CraftC.gunPowder(this));
        s.addRecipe(CraftP.Parachute(this));

    }
}
