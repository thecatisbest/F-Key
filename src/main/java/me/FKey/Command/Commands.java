package me.FKey.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

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
                    player.sendMessage(ChatColor.GREEN + "Use " + ChatColor.YELLOW + "/plugman reload F-Key " + ChatColor.GREEN + "if you have this plugin!");
                    return true;
                }
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(ChatColor.AQUA + "[F-Key] commands");
                    player.sendMessage(ChatColor.GREEN + "Thank you for using my plugin! (●'◡'●)");
                    player.sendMessage(ChatColor.YELLOW + "/FKey reload");
                    return true;
                }
            }
        }
        return false;
    }
}

