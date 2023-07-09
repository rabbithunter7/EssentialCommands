package com.essentialcommands.listeners;

import com.essentialcommands.commands.inventory.managers.InventoryManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.io.IOException;
import java.util.HashMap;

public class Listener implements org.bukkit.event.Listener {

    public static HashMap<String, String> backpacks = new HashMap<String, String>();

    @EventHandler
    public void onInventoryOpEvent(InventoryOpenEvent event) throws IOException {
        if (event.getPlayer().getOpenInventory().countSlots() == 36){

            InventoryManager invMn = new InventoryManager();

            invMn.saveInventory((Player) event.getPlayer().getOpenInventory());
            System.out.println("Added "  + event.getPlayer().getName() + " to hashmap.");
        }
    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) throws IOException {
        if (event.getPlayer().getOpenInventory().countSlots() == 36){

            InventoryManager invMn = new InventoryManager();

            invMn.saveInventory((Player) event.getPlayer().getOpenInventory());
            System.out.println("Saved inventory of player (" + event.getPlayer().getName() + ").");
            System.out.println("Removed " + event.getPlayer().getName() + " to hashmap.");
        }
    }
}
