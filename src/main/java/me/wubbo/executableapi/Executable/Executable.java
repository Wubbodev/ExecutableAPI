package me.wubbo.executableapi.Executable;

import me.wubbo.executableapi.ExecutableAPI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Executable {

    private ItemStack item;
    private ExecutableType type;

    public Executable(ItemStack item, ExecutableType type) {

        this.item = item;
        this.type = type;

        ExecutableAPI.getInstance().getExecutables().put(getItem(), this);

    }

    public void giveExecutable(Inventory inv, Integer slot) {
        if (slot == null) {
            inv.addItem(item);
        } else {
            inv.setItem(slot, item);
        }
    }
    public void takeExecutable(Inventory inv) {
        inv.remove(item);
    }

    public ItemStack getItem() {
        return item;
    }
    public ExecutableType getExecutableType() {
        return type;
    }

    //GUI CLICKS DO NOT WORKS IN CREATIVE
    //IN GUI SHIFT CLICK IS TRIGGERED BY BUTTON "SHIFT"
    //IN HAND SHIFT CLICK IS TRIGGERED BY BUTTON "CROUCH BUTTON"

    public abstract void executeRightClick(Player p);
    public abstract void executeShiftRightClick(Player p);
    public abstract void executeLeftClick(Player p);
    public abstract void executeShiftLeftClick(Player p);

}
