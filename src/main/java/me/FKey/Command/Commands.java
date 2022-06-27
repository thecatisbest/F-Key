package me.FKey.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;



public class Commands implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("FKey")) {

                if (sender.hasPermission("fkey.Commands.FKey")) {
                    if (args.length == 0) {
                        // /F-Key
                        sender.sendMessage(ChatColor.RED + "Use '/FKey help' to view all commands");
                        return true;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("reload")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aStarting reload... &e(If not working download Plugman plugin)"));
                            sender.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "plugman reload F-Key");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("help")) {

                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[F-Key] commands"));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThank you for using my plugin! : )"));
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/FKey reload"));

                        }
                    }

                } else {
                    sender.sendMessage(ChatColor.RED + "You do not have permission!");
                }
        }
        return true;
    }
}