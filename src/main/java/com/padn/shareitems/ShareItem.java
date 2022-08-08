package com.padn.shareitems;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ShareItem {

    public static void showOnChat(Player player) {
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) return;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!itemStack.hasItemMeta()) return;
        if (!itemStack.getItemMeta().hasDisplayName()) return;
        if (!itemStack.getItemMeta().hasLore()) return;

        String name = itemStack.getItemMeta().getDisplayName();

        TextComponent interactiveMessage = new TextComponent(player.getDisplayName() + ": " + name);
        setItemHoverEvent(interactiveMessage, itemStack);

        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers())
            onlinePlayer.spigot().sendMessage(interactiveMessage);
    }

    private static void setItemHoverEvent(TextComponent interactiveMessage, ItemStack itemStack) {
    }


}
