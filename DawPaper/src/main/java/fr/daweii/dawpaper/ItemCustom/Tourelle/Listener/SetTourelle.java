package fr.daweii.dawpaper.ItemCustom.Tourelle.Listener;

import fr.daweii.dawpaper.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class SetTourelle implements Listener {

    private Main main;

    public SetTourelle(Main main) {
        this.main = main;
    }

    @EventHandler
    public void set(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (player.getMainHand() != null) {

            ItemStack Tourelle = new ItemStack(getItem(Material.OBSIDIAN, "Tourelle", true, 1));

            if (event.getAction() == Action.RIGHT_CLICK_BLOCK ) {

                if (player.getInventory().getItemInMainHand().isSimilar(Tourelle)) {

//                    Vector face = player.getTargetBlockFace(3).getDirection();

//                    String LocationWorld = player.getWorld().getName();

                    double LocationX = player.getTargetBlockExact(6).getX();
                    double LocationY = player.getTargetBlockExact(6).getY();
                    double LocationZ = player.getTargetBlockExact(6).getZ();

//                    double LocationX = 3.2;

//                    System.out.println(LocationWorld);

                    System.out.println(LocationX);
                    System.out.println(LocationY);
                    System.out.println(LocationZ);

//                    System.out.println(face);

                    final File file = new File(main.getDataFolder(), "config.yml");
                    final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);


                    configuration.set("Tourelle." + "X" , LocationX);
                    configuration.set("Tourelle." + "Y", LocationY);
                    configuration.set("Tourelle." + "Z", LocationZ);


//                    configuration.set("Tourelle." + "Face", face);
//                    configuration.set("Tourelle." + "Player", player.getUniqueId());


                    try {
                        configuration.save(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        }
    }

    public ItemStack getItem(Material material, String customName, boolean enchant, int amount, String... Lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta customItem = item.getItemMeta();
        customItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        customItem.displayName(
                Component.text(customName)
        );

        item.setAmount(amount);

        if (enchant)
        {
            customItem.addEnchant(Enchantment.MENDING,1,true);
            customItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(customItem);
        return item;
    }
}