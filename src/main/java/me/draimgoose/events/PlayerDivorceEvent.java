package me.draimgoose.events;

import me.draimgoose.MData;
import me.draimgoose.MPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerDivorceEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();

    private MPlayer player;
    private MData marriage;

    public PlayerDivorceEvent(MPlayer player, MData marriage) {
        super(false);
        this.player = player;
        this.marriage = marriage;
    }

    public MPlayer getPlayer() {
        return player;
    }

    public MData getMarriage() {
        return marriage;
    }

    private boolean cancelled = false;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
