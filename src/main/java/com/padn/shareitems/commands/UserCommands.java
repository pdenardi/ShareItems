package com.padn.shareitems.commands;

import com.padn.shareitems.ShareItem;
import cloud.commandframework.Command.Builder;
import cloud.commandframework.Command;
import cloud.commandframework.meta.CommandMeta;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class UserCommands {

    public <BukkitCommandManager> UserCommands(BukkitCommandManager manager, Builder<CommandSender> builder) {

        manager.command(builder.literal("shareitem")
                .meta(CommandMeta.DESCRIPTION, "Show the item in your hand.")
                .senderType(Player.class)
                .permission("shareitems.use")
                .handler(commandContext -> ShareItem.showOnChat((Player) commandContext.getSender())));

    }

}
