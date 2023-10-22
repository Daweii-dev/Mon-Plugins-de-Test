package fr.daweii.dawpaper.ItemCustom.Tourelle.Listener;

import fr.daweii.dawpaper.ItemCustom.Liste;
import fr.daweii.dawpaper.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetTourelle implements Listener {

    private Main main;

    public SetTourelle(Main main) {
        this.main = main;
    }

    @EventHandler
    public void set(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (player.getMainHand() != null) {

            ItemStack Tourelle = new ItemStack(Liste.Tourelle());

            if (player.getInventory().getItemInMainHand().isSimilar(Tourelle)) {

                if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {

                    final Block block = player.getTargetBlockExact(6);

                    final FileConfiguration config = this.main.getConfig();

                    config.set("Tourelle.X", block.getX());
                    config.set("Tourelle.Y", block.getY());
                    config.set("Tourelle.Z", block.getZ());
                    config.set("Tourelle.World", block.getWorld().getName());

                    this.main.saveConfig();

                }
            }
        }
    }
}