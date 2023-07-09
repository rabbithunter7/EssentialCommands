package com.essentialcommands.commands.inventory;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class TrashBinCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Inventory inventory = Bukkit.getServer().createInventory((InventoryHolder) sender, 9, "<WARNING> TRASH BIN! <WARNING>");

            ((Player) sender).openInventory(inventory);
            sender.sendMessage("<EssentialCommands> Opening TRASH BIN!");
            System.out.println(sender.getName() + " has opened their trash bin.");
            return true;
        }
        return false;
    }

}
