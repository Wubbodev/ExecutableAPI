package me.wubbo.executableapi;

import me.wubbo.executableapi.Executable.Executable;
import me.wubbo.executableapi.Executable.GUI.GUI;
import me.wubbo.executableapi.Executable.Hotbar.Hotbar;
import me.wubbo.executableapi.Utils.EventUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public final class ExecutableAPI extends JavaPlugin {

    private static ExecutableAPI instance;

    private HashMap<ItemStack, Executable> executables = new HashMap<>();
    private HashMap<List<Executable>, Hotbar> hotbars = new HashMap<>();
    private HashMap<List<Executable>, GUI> GUIs = new HashMap<>();

    private HashMap<UUID, Hotbar> inusehotbars = new HashMap<>();
    private HashMap<UUID, GUI> inuseGUI = new HashMap<>();

    @Override
    public void onEnable() {

        instance = this;

        new EventUtils().setEvents();

        getLogger().log(Level.ALL, "ExecutableAPI V1.0 Has Been Enabled");

    }

    @Override
    public void onDisable() {
        getLogger().log(Level.ALL, "ExecutableAPI V1.0 Has Been Disabled");
    }

    public Executable isExecutable(ItemStack item) {
        return getExecutables().getOrDefault(item, null);
    }

    public HashMap<ItemStack, Executable> getExecutables() {
        return executables;
    }

    public HashMap<List<Executable>, Hotbar> getHotbars() {
        return hotbars;
    }

    public HashMap<List<Executable>, GUI> getGUIs() {
        return GUIs;
    }

    public HashMap<UUID, Hotbar> getInUseHotbars() {
        return inusehotbars;
    }

    public HashMap<UUID, GUI> getInUseGUI() {
        return inuseGUI;
    }

    public static ExecutableAPI getInstance() {
        return instance;
    }
}
