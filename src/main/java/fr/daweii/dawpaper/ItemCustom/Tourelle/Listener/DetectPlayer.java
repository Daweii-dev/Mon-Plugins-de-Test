package fr.daweii.dawpaper.ItemCustom.Tourelle.Listener;

import fr.daweii.dawpaper.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DetectPlayer implements Listener {

    private Main main;

    public DetectPlayer(Main main) {
        this.main = main;
    }

    @EventHandler
    public void detect(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        final ConfigurationSection configSection = this.main.getConfig().getConfigurationSection("Tourelle");
        final Location location = new Location(
                Bukkit.getWorld(configSection.getString("World")),
                configSection.getInt("X"),
                configSection.getInt("Y"),
                configSection.getInt("Z")
        );


        if (event.getPlayer().getLocation().distance(location) <= 3) {
            //TODO: Si il est à 3 blocks ou moin avec (<= 3)
            player.sendMessage("C bon");
            player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5, 255));
        }
    }
}
