package fr.daweii.dawpaper.ItemCustom.JetPack.Listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class onJump implements Listener {

    @EventHandler
    public void onJump(PlayerToggleSneakEvent event) throws InterruptedException {

//        if (event.getTo().getY() == event.getFrom().getY()) return;

//        if (event.getPlayer().getVelocity().getY() == 0) return;

        Player player = event.getPlayer();

        ItemStack itemJetPack = new ItemStack(getItem(Material.LEATHER_CHESTPLATE, "§4JetPack", true, 1));

        if (player.isSneaking())

            if (player.getMainHand() != null) {

                if (player.getInventory().getChestplate() != null) {

                    if (player.getInventory().getChestplate().isSimilar(itemJetPack)) {

                        ItemStack itemGunPowder = new ItemStack(getItem(Material.GUNPOWDER, "§4GunPowder I", true, 1));

                        if (player.getInventory().getItemInMainHand().isSimilar(itemGunPowder)) {

                            int nbGunPowder = player.getInventory().getItemInMainHand().getAmount();

                            //                        int nbr = nbGunPowder -1;

                            ItemStack nbrApres = new ItemStack(getItem(Material.GUNPOWDER, "§4GunPowder I", true, nbGunPowder - 1));


                            player.spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 10);
                            player.getInventory().setItemInMainHand(nbrApres);
                            player.addPotionEffects(Collections.singleton(new PotionEffect(PotionEffectType.LEVITATION, 10, 10)));
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

//    @EventHandler
//    public void test(PlayerInteractEvent event) throws InterruptedException {
//        Player player = event.getPlayer();
//        if (player.sne)
//    }

}
