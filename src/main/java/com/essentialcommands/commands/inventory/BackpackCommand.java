package com.essentialcommands.commands.inventory;

import com.essentialcommands.commands.inventory.managers.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.io.IOException;

public class BackpackCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            InventoryManager invMn = new InventoryManager();

            Inventory inventory = Bukkit.getServer().createInventory((InventoryHolder) sender, 36, sender.getName() + "'s Backpack");

            try {
                invMn.restoreInventory((Player) sender);
                System.out.println("Success! Restored player (" + sender.getName() + "'s) inventory.");
            } catch (IOException e) {
                System.out.println("Error! Could not restore player (" + sender.getName() + "'s) inventory.");
                e.printStackTrace();
            }

            ((Player) sender).openInventory(inventory);
            sender.sendMessage("<EssentialCommands> Opening backpack!");
            System.out.println(sender.getName() + " has opened their backpack.");

            return true;
        }
        return false;
    }

}
