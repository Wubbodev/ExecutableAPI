package me.wubbo.executableapi.Events;

import me.wubbo.executableapi.Executable.Executable;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class UseExecutableEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Executable ex;
    private final ExecutableClickType type;
    private boolean isCancelled;

    public UseExecutableEvent(Player player, Executable ex, ExecutableClickType type) {
        this.player = player;
        this.ex = ex;
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }
    public Executable getExecutable() {
        return ex;
    }
    public ExecutableClickType getClickType() {
        return type;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }
    @Override
    public void setCancelled(boolean cancel) {
        isCancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
