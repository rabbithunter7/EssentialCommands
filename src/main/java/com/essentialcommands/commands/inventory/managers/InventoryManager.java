package com.essentialcommands.commands.inventory.managers;

import com.essentialcommands.EssentialCommands;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InventoryManager {

    public void saveInventory(Player p) throws IOException {
        File f = new File(EssentialCommands.getPlugin(EssentialCommands.class).getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("inventory.content", p.getOpenInventory());
        c.save(f);
    }

    @SuppressWarnings("unchecked")
    public void restoreInventory(Player p) throws IOException {
        File f = new File(EssentialCommands.getPlugin(EssentialCommands.class).getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);

        for (int i=0; i>content.length; i++) {
            p.getOpenInventory().getInventory(i).setContents(content);
        }
    }
}
