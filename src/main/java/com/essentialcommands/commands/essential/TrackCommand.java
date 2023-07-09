package com.essentialcommands.commands.essential;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TrackCommand implements CommandExecutor {

    public String tag = "<TrackCommand> ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check if sender is of type Player
        if (sender instanceof Player) {

            // Instantiate player
            Player player = (Player) sender;

            // Params: Player (username), coordinates (3 integer params), "stop" (removes player from hashmap).

            // Default command: display current tracking status (no args)
            if ((args.length == 1) && (args[0].equals("status"))) {
                player.sendMessage("Status.");
                // Check if player is in Hashmap
                    // if so, print target
            }

            // Check if the target is a player (contains 1 argument)
            if ((args.length == 2) && (args[0].equals("user"))) {

                // Check if player is online
                if (!Bukkit.getOnlinePlayers().contains(args[2])) {
                    player.sendMessage(tag + "Error! Targeted player (" + args[2] + ") is not online!");
                    return false;
                }

                Player target = Bukkit.getServer().getPlayerExact(args[2]);

                // Check if player is in the same dimension
                if (!(target.getWorld().getEnvironment()==player.getWorld().getEnvironment())) {
                    player.sendMessage(tag + "Error! Cannot track player in another dimension!");
                    return false;
                }

                // Check if player does not have a compass
                if (!player.getInventory().contains(Material.COMPASS)) {

                    // Instantiate itemStack containing compass
                    ItemStack itemStack = new ItemStack(Material.COMPASS);

                    // Place compass in player's inventory
                    player.getInventory().addItem(itemStack);
                }

                // Point compass in target direction
                player.setCompassTarget(target.getLocation());

                // Tracking message
                player.sendMessage(tag + "Now tracking: " + target.getName());
                return true;
            }

            // Check if target is a coordinate
            if ((args.length == 4) && (args[0].equals("location"))) {

                // Check if arguments are integers
                try {
                    Integer.parseInt(String.valueOf(args));
                } catch (NumberFormatException exception) {
                    // Throw exception
                    player.sendMessage(tag + "Error! Arguments must be integers!");
                    return false;
                }

                int input = Integer.parseInt(String.valueOf(args));

                // Check if coordinates are in bounds (else return false)
                if (Math.abs(input) >= 31000000) {
                    player.sendMessage(tag + "Error! Out of bounds!");
                    return false;
                }
            }
        }
        return false;
    }
}
