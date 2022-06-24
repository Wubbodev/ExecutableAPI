package me.wubbo.executableapi.Example;

import me.wubbo.executableapi.Executable.Executable;
import me.wubbo.executableapi.Executable.ExecutableType;
import me.wubbo.executableapi.Executable.GUI.GUI;
import me.wubbo.executableapi.Executable.GUI.GUIStructure;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ExampleGUI {

    private GUI gui;

    public ExampleGUI() {
        createGUI();
    }

    public void createGUI() {

        HashMap<Executable, Integer> executables = new HashMap<>();
        executables.put(new ExampleExecutable(new ItemStack(Material.STONE), ExecutableType.HAND), 14);
        executables.put(new ExampleExecutable(new ItemStack(Material.WOODEN_HOE), ExecutableType.HAND), 53);
        executables.put(new ExampleExecutable(new ItemStack(Material.NETHERITE_BOOTS), ExecutableType.HAND), 32);

        gui = new GUI(new GUIStructure(executables, 54, "Example GUI"));

    }

    public GUI getGUI() {
        return gui;
    }

}
