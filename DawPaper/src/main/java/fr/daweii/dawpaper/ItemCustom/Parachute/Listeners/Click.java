package fr.daweii.dawpaper.ItemCustom.Parachute.Listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.jar.Attributes;

public class Click implements Listener {

    @EventHandler
    public void onClick(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null) return;

        ItemStack itemParachute = new ItemStack(Material.PAPER);
        ItemMeta customItem = itemParachute.getItemMeta();
        customItem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        customItem.displayName(
                Component.text("§4Parachute")
        );
        itemParachute.setAmount(1);

        if (true)
        {
            customItem.addEnchant(Enchantment.MENDING,1,true);
            customItem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemParachute.setItemMeta(customItem);

        if (item.isSimilar(itemParachute)) {

            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 5, 255));

        }
    }
}
