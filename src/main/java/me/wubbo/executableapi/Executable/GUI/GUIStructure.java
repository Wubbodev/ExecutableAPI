package me.wubbo.executableapi.Executable.GUI;

import me.wubbo.executableapi.Executable.Executable;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class GUIStructure {

    private HashMap<Executable, Integer> listedstructure;
    private Inventory inventorystructure;

    public GUIStructure(HashMap<Executable, Integer> listedstructure, int size, String name) {

        this.listedstructure = listedstructure;

        inventorystructure = Bukkit.createInventory(null, size, Component.text(name));

        int i = 0;

        for (Executable ex : getListedStructure().keySet()) {
            if (i < inventorystructure.getSize()) {
                i++;
                getInventoryStructure().setItem(listedstructure.get(ex), ex.getItem());
            } else {
                break;
            }
        }

    }

    public HashMap<Executable, Integer> getListedStructure() {
        return listedstructure;
    }
    public Inventory getInventoryStructure() {
        return inventorystructure;
    }

}
