package com.songoda.epicvouchers.commands;

import com.songoda.core.commands.AbstractCommand;
import com.songoda.epicvouchers.EpicVouchers;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CommandEpicVouchers extends AbstractCommand {

    final EpicVouchers instance;

    public CommandEpicVouchers(EpicVouchers instance) {
        super(false, "EpicVouchers");
        this.instance = instance;
    }

    @Override
    protected ReturnType runCommand(CommandSender sender, String... args) {
        sender.sendMessage("");
        instance.getLocale().newMessage("&7Version " + instance.getDescription().getVersion()
                + " Created with <3 by &5&l&oSongoda").sendPrefixedMessage(sender);

        for (AbstractCommand command : instance.getCommandManager().getAllCommands()) {
            if (command.getPermissionNode() == null || sender.hasPermission(command.getPermissionNode())) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8 - &a" + command.getSyntax() + "&7 - " + command.getDescription()));
            }
        }
        sender.sendMessage("");

        return ReturnType.SUCCESS;
    }

    @Override
    protected List<String> onTab(CommandSender sender, String... args) {
        return null;
    }

    @Override
    public String getPermissionNode() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/EpicVouchers";
    }

    @Override
    public String getDescription() {
        return "Displays this page.";
    }
}
