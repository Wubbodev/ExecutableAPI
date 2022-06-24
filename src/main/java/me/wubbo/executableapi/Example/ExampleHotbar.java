package me.wubbo.executableapi.Example;

import me.wubbo.executableapi.Executable.Executable;
import me.wubbo.executableapi.Executable.ExecutableType;
import me.wubbo.executableapi.Executable.Hotbar.Hotbar;
import me.wubbo.executableapi.Executable.Hotbar.HotbarStructure;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ExampleHotbar {

    private Hotbar hotbar;

    public ExampleHotbar() {
        createHotbar();
    }

    public void createHotbar() {

        HashMap<Executable, Integer> executables = new HashMap<>();
        executables.put(new ExampleExecutable(new ItemStack(Material.STONE), ExecutableType.HAND), 0);
        executables.put(new ExampleExecutable(new ItemStack(Material.WOODEN_HOE), ExecutableType.HAND), 4);
        executables.put(new ExampleExecutable(new ItemStack(Material.NETHERITE_BOOTS), ExecutableType.HAND), 7);

        hotbar = new Hotbar(new HotbarStructure(executables));

    }

    public Hotbar getHotbar() {
        return hotbar;
    }

}
