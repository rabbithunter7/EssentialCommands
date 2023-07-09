package com.essentialcommands.commands.inventory;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderchestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            ((Player) sender).openInventory(((Player) sender).getEnderChest());

            sender.sendMessage("<EssentialCommands> Opening enderchest!");
            System.out.println(sender.getName() + " has opened their enderchest.");
            return true;
        }
        return false;
    }

}
