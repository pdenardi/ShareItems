package com.padn.shareitems.commands;

import cloud.commandframework.Command;
import cloud.commandframework.CommandTree;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.bukkit.BukkitCommandManager;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.minecraft.extras.MinecraftExceptionHandler;
import cloud.commandframework.minecraft.extras.MinecraftHelp;
import com.padn.shareitems.ShareItem;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityPotionEffectEvent;

import java.lang.reflect.Method;
import java.util.function.Function;

import static net.kyori.adventure.text.Component.text;


public class CommandHandler {

    private BukkitCommandManager<CommandSender> manager;
    //private CommandConfirmationManager<CommandSender> paymentConfirmationManager;
    private MinecraftHelp<CommandSender> minecraftHelp;
    private BukkitAudiences bukkitAudiences;

    /*
    Commands powered by Cloud
     */

    public CommandHandler() {
        Function<CommandTree, CommandExecutionCoordinator> commandExecutionCoordinator = null;
        try {
            Class<?> c = Class.forName("cloud.commandframework.execution.CommandExecutionCoordinator");
            Method method = c.getDeclaredMethod("simpleCoordinator");
            commandExecutionCoordinator = (Function<CommandTree, CommandExecutionCoordinator>) method.invoke(Function.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityPotionEffectEvent.Cause MetadataHandler;
};

    public void constructCommands() {
        
        // /shareitem
        final Command.Builder<CommandSender> shareItemBuilder = manager.commandBuilder("shareitem");
        manager.command(shareItemBuilder.meta(CommandMeta.DESCRIPTION, "Show the item in your hand.")
                .senderType(Player.class)
                //permission is dealt inside of the command
                .permission("shareitems.use")
                .handler(commandContext -> ShareItem.showOnChat((Player) commandContext.getSender())));

        // Base command builder
        final Command.Builder<CommandSender> builder = manager.commandBuilder("elitemobs", "em");

        manager.command(builder.literal("help")
                .argument(StringArgument.optional("query", StringArgument.StringMode.GREEDY))
                .handler(context -> {
                    minecraftHelp.queryCommands(context.getOrDefault("query", ""), context.getSender());
                }));

        new UserCommands(manager, builder);

    }

}
