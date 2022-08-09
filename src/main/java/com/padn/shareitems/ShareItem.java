package com.padn.shareitems;

import com.padn.shareitems.commands.CommandHandler;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ShareItem extends JavaPlugin {

    public static ShareItem plugin = null;

    @Override
    public void onEnable() {

        plugin = this;

        Bukkit.getLogger().info("ShareItems is WORKING :D");
        Bukkit.getLogger().info("By pdenardi");

        new CommandHandler();
    }
    @Override
    public void onDisable() {
        Bukkit.getLogger().info("ShareItems is disabled now");
    }


    public static void showOnChat(Player player) {
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
