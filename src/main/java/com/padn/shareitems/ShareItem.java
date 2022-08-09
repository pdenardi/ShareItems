package com.padn.shareitems;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class ShareItem extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ShareItems is WORKING :D");
    }
    @Override
    public void onDisable() {
        getLogger().info("ShareItems is disabled now");
    }


    public static void showOnChat(@NotNull Player player) {
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) return;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!itemStack.hasItemMeta()) return;
        if (!itemStack.getItemMeta().hasDisplayName()) return;
        if (!itemStack.getItemMeta().hasLore()) return;

        String name = itemStack.getItemMeta().getDisplayName();

        TextComponent interactiveMessage = new TextComponent(player.getDisplayName() + ": " + name);

        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers())
            onlinePlayer.spigot().sendMessage(interactiveMessage);
    }

}
