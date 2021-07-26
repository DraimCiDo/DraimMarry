package me.draimgoose.events;

import me.draimgoose.MPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerMarryEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();

    private MPlayer requesing;
    private MPlayer requested;
    private MPlayer priest;
    private boolean cancelled = false;

    public PlayerMarryEvent(MPlayer requesing, MPlayer requested, MPlayer priest) {
        super(false);
        this.requesing = requesing;
        this.requested = requested;
        this.priest = priest;
    }

    public MPlayer getRequesing() {
        return requesing;
    }

    public MPlayer getRequested() {
        return requested;
    }

    public MPlayer getPriest() {
        return priest;
    }

    public boolean isFromPriest() {
        return priest != null;
    }

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

