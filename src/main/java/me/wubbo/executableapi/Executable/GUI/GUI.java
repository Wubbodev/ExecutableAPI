package me.wubbo.executableapi.Executable.GUI;

import me.wubbo.executableapi.Executable.Executable;
import me.wubbo.executableapi.ExecutableAPI;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class GUI {

    private HashMap<Executable, Integer> executables;
    private GUIStructure guistructure;

    public GUI(GUIStructure guistructure) {

        this.guistructure = guistructure;
        this.executables = guistructure.getListedStructure();

        ExecutableAPI.getInstance().getGUIs().put(getExecutables().keySet().stream().toList(), this);

    }

    public void openGUI(Player p) {
        p.openInventory(getGUIStructure().getInventoryStructure());
        ExecutableAPI.getInstance().getInUseGUI().put(p.getUniqueId(), this);
    }

    public void closeGUI(Player p) {
        p.closeInventory();
        ExecutableAPI.getInstance().getInUseGUI().remove(p.getUniqueId());
    }

    public HashMap<Executable, Integer> getExecutables() {
        return executables;
    }
    public GUIStructure getGUIStructure() {
        return guistructure;
    }

}
