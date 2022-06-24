package me.wubbo.executableapi.Listener;

import me.wubbo.executableapi.Events.ExecutableClickType;
import me.wubbo.executableapi.Events.UseExecutableEvent;
import me.wubbo.executableapi.Example.ExampleGUI;
import me.wubbo.executableapi.Executable.Executable;
import me.wubbo.executableapi.Executable.GUI.GUI;
import me.wubbo.executableapi.ExecutableAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class InteractionEvents implements Listener {

    @EventHandler
    public void onInteractItem(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        ItemStack item = e.getItem();
        Executable ex = ExecutableAPI.getInstance().isExecutable(item);

        if (ex != null) {
            if (e.getAction().isRightClick()) {
                if (p.isSneaking()) {
                    ex.executeShiftRightClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.SHIFTRIGHTCLICK));
                } else {
                    ex.executeRightClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.RIGHTCLICK));
                }
            } else if (e.getAction().isLeftClick()) {
                if (p.isSneaking()) {
                    ex.executeShiftLeftClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.SHIFTLEFTCLICK));
                } else {
                    ex.executeLeftClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.LEFTCLICK));
                }
            }
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onInteractInventory(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        Executable ex = ExecutableAPI.getInstance().isExecutable(item);

        if (ex != null) {
            if (e.isRightClick()) {
                if (e.isShiftClick()) {
                    ex.executeShiftRightClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.SHIFTRIGHTCLICK));
                } else {
                    ex.executeRightClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.RIGHTCLICK));
                }
            } else if (e.isLeftClick()) {
                if (e.isShiftClick()) {
                    ex.executeShiftLeftClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.SHIFTLEFTCLICK));
                } else {
                    ex.executeLeftClick(p);
                    Bukkit.getServer().getPluginManager().callEvent(new UseExecutableEvent(p, ex, ExecutableClickType.LEFTCLICK));
                }
            }
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onDragEvent(InventoryDragEvent e) {

        ItemStack item = e.getCursor();
        Executable ex = ExecutableAPI.getInstance().isExecutable(item);

        if (ex != null) {
            e.setCancelled(true);
        }

    }

    public void registerEvent() {
        Bukkit.getPluginManager().registerEvents(new InteractionEvents(), ExecutableAPI.getInstance());
    }

}
