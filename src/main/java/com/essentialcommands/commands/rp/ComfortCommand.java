package com.essentialcommands.commands.rp;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComfortCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (args.length == 0){
                player.sendMessage("Try /comfort <username> instead.");
                return false;
            }

            if (args.length > 1) {
                player.sendMessage("Too many arguments! Try /comfort <username> instead.");
                return false;
            }

            // Check if player is online
            if ( Bukkit.getServer().getPlayerExact(args[0]) == null ) {
                player.sendMessage("Error! Targeted player (" + args[0] + ") is not online!");
                return false;
            }

            Player target = Bukkit.getServer().getPlayerExact(args[0]);

            target.sendMessage(ChatColor.of("#8250F5") + player.getName() + " comforts you with warm hugs :>");
            player.sendMessage(ChatColor.of("#8250F5") + "You comfort " + target.getName() + " with warm hugs!");
            System.out.println("<ComfortCommand> " + player.getName() + " comforted " + target.getName() + "!");
            return true;
        }

        return false;
    }

}
