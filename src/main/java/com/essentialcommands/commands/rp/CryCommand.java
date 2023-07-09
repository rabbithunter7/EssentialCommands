package com.essentialcommands.commands.rp;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CryCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Bukkit.getServer().broadcastMessage(ChatColor.of("#37CDEB") + sender.getName() + " is crying v_v and needs comfort.");
            return true;
        }
        return false;
    }
}
