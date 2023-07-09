package com.essentialcommands.commands.rp;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KissCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if (args.length == 0){
                player.sendMessage("Try /kiss <username> instead.");
                return false;
            }

            if (args.length > 1) {
                player.sendMessage("Too many arguments! Try /kiss <username> instead.");
                return false;
            }

            // Check if player is online
            if ( Bukkit.getServer().getPlayerExact(args[0]) == null ) {
                player.sendMessage("Error! Targeted player (" + args[0] + ") is not online!");
                return false;
            }

            Player target = Bukkit.getServer().getPlayerExact(args[0]);

            target.sendMessage(ChatColor.of("#F836FF") + "Mwaahh! " + player.getName() + " has blown you a kiss! :3");
            player.sendMessage(ChatColor.of("#F836FF") + "You blew " + target.getName() + " a kiss!");
            System.out.println("<KissCommand> " + player.getName() + " blew " + target.getName() + " a kiss!");
            return true;
        }

        return false;
    }
}
