package me.wubbo.executableapi.Executable.Hotbar;

import me.wubbo.executableapi.Executable.Executable;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class HotbarStructure {

    private HashMap<Executable, Integer> listedstructure;
    private Inventory inventorystructure;

    public HotbarStructure(HashMap<Executable, Integer> listedstructure) {

        this.listedstructure = listedstructure;

        inventorystructure = Bukkit.createInventory(null, 9, Component.text("Hotbar"));

        int i = 0;

        for (Executable ex : getListedStructure().keySet()) {
            if (i < 9) {
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
