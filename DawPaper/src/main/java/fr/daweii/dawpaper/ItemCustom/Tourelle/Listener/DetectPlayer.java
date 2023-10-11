package fr.daweii.dawpaper.ItemCustom.Tourelle.Listener;

import fr.daweii.dawpaper.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;

public class DetectPlayer implements Listener {

    private Main main;

    public DetectPlayer(Main main) {
        this.main = main;
    }

    @EventHandler
    public void detect(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        Location playerLocation =  player.getLocation();

        player.sendMessage("1");

        final File file = new File(main.getDataFolder(), "config.yml");
        final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        player.sendMessage("2");

        final String key = "Tourelle.";
        final ConfigurationSection configurationSection = configuration.getConfigurationSection(key);

        player.sendMessage("3");

        if (configurationSection == null) {
            player.sendMessage("non");
        } else {

            final double X = configurationSection.getDouble("X");
            final double Y = configurationSection.getDouble("Y");
            final double Z = configurationSection.getDouble("Z");

            player.sendMessage("4");
            player.sendMessage("Co " + X);
            player.sendMessage("Co " + Y);
            player.sendMessage("Co " + Z);

            if (player.getLocation().getX() <= X+4 && player.getLocation().getX() >= X-4) {
                player.sendMessage("5");
                player.sendMessage("6");

//                #######################################################################################################
//                #######################################################################################################
//                ##########                                                                                   ##########
//                ##########          Detect player dans la zone avec le Z fonctionne mais pas X et Y          ##########
//                ##########                                                                                   ##########
//                #######################################################################################################
//                #######################################################################################################

                if (player.getLocation().getX() <= Z+4 && player.getLocation().getX() >= Z-4) {
                    player.sendMessage("7");
                    if (player.getLocation().getX() <= Y+10 && player.getLocation().getX() >= Y-10) {
                        player.sendMessage("8");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5, 255));
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
