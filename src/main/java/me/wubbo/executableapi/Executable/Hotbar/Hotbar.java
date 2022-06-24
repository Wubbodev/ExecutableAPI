package me.wubbo.executableapi.Executable.Hotbar;

import me.wubbo.executableapi.Executable.Executable;
import me.wubbo.executableapi.ExecutableAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Hotbar {

    private HashMap<Executable, Integer> executables;
    private HotbarStructure hotbarstructure;

    public Hotbar(HotbarStructure hotbarstructure) {

        this.hotbarstructure = hotbarstructure;
        this.executables = hotbarstructure.getListedStructure();

        ExecutableAPI.getInstance().getHotbars().put(getExecutables().keySet().stream().toList(), this);

    }

    public void giveHotbar(Player p) {
        for (Executable ex : getHotbarStructure().getListedStructure().keySet()) {
            ex.giveExecutable(p.getInventory(), getHotbarStructure().getListedStructure().get(ex));
            ExecutableAPI.getInstance().getInUseHotbars().put(p.getUniqueId(), this);
        }
    }
    public void giveHotbar(List<Player> ps) {
        for (Player p : ps) {
            for (Executable ex : getHotbarStructure().getListedStructure().keySet()) {
                ex.giveExecutable(p.getInventory(), getHotbarStructure().getListedStructure().get(ex));
                ExecutableAPI.getInstance().getInUseHotbars().put(p.getUniqueId(), this);
            }
        }
    }

    public void takeHotbar(Player p) {
        if (p == null) {
            for (UUID id : ExecutableAPI.getInstance().getInUseHotbars().keySet()) {
                Player player = Bukkit.getPlayer(id);
                Hotbar hotbar = ExecutableAPI.getInstance().getInUseHotbars().get(player.getUniqueId());
                for (Executable ex : hotbar.getExecutables().keySet()) {
                    ex.takeExecutable(player.getInventory());
                    ExecutableAPI.getInstance().getInUseHotbars().remove(player.getUniqueId());
                }
            }
        } else {
            for (Executable ex : getExecutables().keySet()) {
                ex.takeExecutable(p.getInventory());
                ExecutableAPI.getInstance().getInUseHotbars().remove(p.getUniqueId());
            }
        }
    }

    public HashMap<Executable, Integer> getExecutables() {
        return executables;
    }
    public HotbarStructure getHotbarStructure() {
        return hotbarstructure;
    }

}
