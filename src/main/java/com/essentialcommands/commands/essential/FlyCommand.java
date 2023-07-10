package com.essentialcommands.commands.essential;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            // Instantiate player
            Player player = (Player) sender;

            // Set the player's flight permissions
            if (((Player) sender).getAllowFlight()==true) { // Check if flight is true
                ((Player) sender).setAllowFlight(false); // If so, set it to false
                System.out.println(player.getName() + " has toggled fly OFF!");
                player.sendMessage("Flight toggled OFF!");
            }
            else {
                ((Player) sender).setAllowFlight(true); // otherwise, set it to true
                System.out.println(player.getName() + " has toggled fly ON!");
                player.sendMessage("Flight toggled ON!");
            }
        }

        return true;
    }
}
