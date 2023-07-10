package com.essentialcommands;

import com.essentialcommands.commands.essential.FlyCommand;
import com.essentialcommands.commands.inventory.EnderchestCommand;
import com.essentialcommands.commands.inventory.TrashBinCommand;
import com.essentialcommands.commands.rp.ComfortCommand;
import com.essentialcommands.commands.rp.CryCommand;
import com.essentialcommands.commands.rp.KissCommand;
import com.essentialcommands.listeners.Listener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialCommands extends JavaPlugin {

    @Override
    public void onEnable() {

        // getServer().getPluginManager().registerEvents(new Listeners(this), this);
        // Register commands
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("kiss").setExecutor(new KissCommand());
        this.getCommand("cry").setExecutor(new CryCommand());
        this.getCommand("comfort").setExecutor(new ComfortCommand());
        this.getCommand("enderchest").setExecutor(new EnderchestCommand());
        this.getCommand("trash").setExecutor(new TrashBinCommand());

        // Register Listeners
        getServer().getPluginManager().registerEvents(new Listener(), this);

        // Successful starting message
        Bukkit.getServer().getConsoleSender().sendMessage("EssentialCommands v1.0 has started successfully!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
