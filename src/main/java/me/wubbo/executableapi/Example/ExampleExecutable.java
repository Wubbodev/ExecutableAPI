package me.wubbo.executableapi.Example;

import me.wubbo.executableapi.Executable.Executable;
import me.wubbo.executableapi.Executable.ExecutableType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExampleExecutable extends Executable {

    public ExampleExecutable(ItemStack item, ExecutableType type) {
        super(item, type);
    }

    //GUI CLICKS DO NOT WORKS IN CREATIVE
    //IN GUI SHIFT CLICK IS TRIGGERED BY BUTTON "SHIFT"
    //IN HAND SHIFT CLICK IS TRIGGERED BY BUTTON "CROUCH BUTTON"

    @Override
    public void executeRightClick(Player p) {
        p.sendMessage("You Right Clicked");
    }

    @Override
    public void executeShiftRightClick(Player p) {
        p.sendMessage("You Shift Right Clicked");
    }

    @Override
    public void executeLeftClick(Player p) {
        p.sendMessage("You Left Clicked");
    }

    @Override
    public void executeShiftLeftClick(Player p) {
        p.sendMessage("You Shift Left Clicked");
    }
}
