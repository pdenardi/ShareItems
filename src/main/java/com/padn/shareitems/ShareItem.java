package com.padn.shareitems;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ShareItem extends JavaPlugin {

    public static ShareItem plugin = null;

    @Override
    public void onEnable() {

        plugin = this;

        Bukkit.getLogger().info("ShareItems is WORKING :D");
        Bukkit.getLogger().info("By pdenardi");

        Objects.requireNonNull(this.getCommand("shareitem")).setExecutor(new CommandShareItem());

    }
    @Override
    public void onDisable() {
        Bukkit.getLogger().info("ShareItems is disabled now");
    }


    public static class CommandShareItem implements CommandExecutor {

        // This method is called, when somebody uses our command
        @Override
        public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
            return false;
        }

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.getInventory().getItemInMainHand().getType();
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            itemStack.hasItemMeta();
            itemStack.getItemMeta().hasDisplayName();
            itemStack.getItemMeta().hasLore();

            String name = itemStack.getItemMeta().getDisplayName();

        TextComponent interactiveMessage = new TextComponent(player.getDisplayName() + ": " + name);

        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers())
            onlinePlayer.spigot().sendMessage(interactiveMessage);

        }

        // If the player (or console) uses our command correct, we can return true
        return true;

    }

}
