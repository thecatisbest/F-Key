package me.FKey;

import me.FKey.Command.CommandTab;
import me.FKey.Command.Commands;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class fkey extends JavaPlugin implements Listener {

    static String[] commands;
    static Boolean swap;

    @Override
    public void onEnable() {

        System.out.println("F-Key Plugin Enabled!");
        this.getCommand("FKey").setExecutor(new Commands());
        this.getCommand("FKey").setTabCompleter(new CommandTab());
        this.saveDefaultConfig();
        String raw_command = getConfig().getString("commands");
        commands = raw_command.split(";");
        swap = getConfig().getBoolean("cancel_swap");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        System.out.println("F-Key Plugin Disabled!");
    }

    @EventHandler
    public void onPlayerSneak(PlayerSwapHandItemsEvent e) {
        Player player = e.getPlayer();
        if(player.isSneaking()) {
            e.setCancelled(swap);
            for(String command : commands) {
                command = command.replaceAll("%player%", player.getDisplayName());
                player.performCommand(command);
            }
        }
    }
}
