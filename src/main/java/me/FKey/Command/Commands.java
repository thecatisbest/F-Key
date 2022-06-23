package me.FKey.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Commands implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("FKey")) {
            if (!(sender instanceof Player)) {
                //console
                sender.sendMessage("The console cannot run this command");
                return true;
            }
            Player player = (Player) sender;
            if (args.length == 0) {
                // /F-Key
                player.sendMessage(ChatColor.RED + "Use '/FKey help' to view all commands");
                return true;
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aStarting reload... &e(If not working download Plugman plugin)"));
                    player.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "plugman reload F-Key");
                    return true;
                }
                if (args[0].equalsIgnoreCase("help")) {

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[F-Key] commands"));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThank you for using my plugin! (●'◡'●)"));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/FKey reload"));

                    return true;
                }
            }

        }
        return false;
    }
}

