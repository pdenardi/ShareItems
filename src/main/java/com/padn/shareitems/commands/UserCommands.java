package com.padn.shareitems.commands;

import cloud.commandframework.bukkit.BukkitCommandManager;
import com.padn.shareitems.ShareItem;
import cloud.commandframework.Command.Builder;
import cloud.commandframework.meta.CommandMeta;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class UserCommands  {

    public UserCommands(BukkitCommandManager<CommandSender> manager, Builder<CommandSender> builder) {

        manager.command(builder.literal("shareitem")
                .meta(CommandMeta.DESCRIPTION, "Show the item in your hand.")
                .senderType(Player.class)
                .permission("shareitem.use")
                .handler(commandContext -> ShareItem.showOnChat((Player) commandContext.getSender())));

    }

}
