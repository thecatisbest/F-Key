package me.FKey;

import me.FKey.Command.CommandTab;
import me.FKey.Command.Commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class fkey extends JavaPlugin implements Listener {

    static String[] commands;
    static Boolean swap;

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aF-Key plugin Enabled!"));

        this.getCommand("FKey").setExecutor(new Commands());
        this.getCommand("FKey").setTabCompleter(new CommandTab());
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        String raw_command = getConfig().getString("commands");
        commands = raw_command.split(";");
        swap = getConfig().getBoolean("cancel_swap");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cF-Key plugin Disabled!"));
    }

    public void onPlayerSneak(PlayerSwapHandItemsEvent e) {
        Player player = e.getPlayer();
        if (player.isSneaking()) {
            e.setCancelled(swap);
            for (String command : commands) {
                command = command.replaceAll("%player%", player.getDisplayName());
                player.performCommand(command);
            }

        }
    }
}
