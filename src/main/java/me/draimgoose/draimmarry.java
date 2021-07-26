package me.draimgoose;

import me.draimgoose.commands.Command;
import me.draimgoose.internal.Dependencies;
import me.draimgoose.misc.BConfig;
import me.draimgoose.misc.ListQuery;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.logging.Logger;

public abstract class draimmarry extends JavaPlugin {

    public abstract BConfig getBukkitConfig(String file);

    public abstract MPlayer getMPlayer(UUID uuid);

    public abstract MPlayer getMPlayer(Player player);

    public abstract ListQuery getMarriageList(int scale, int page);

    public abstract MData marry(MPlayer player1, MPlayer player2);

    public abstract MData marry(MPlayer player1, MPlayer player2, MPlayer priest);

    public abstract void register(Listener listener);

    public abstract void register(Class<? extends Command> commandClass, Class<? extends Command>... commandClasses);

    public abstract Logger getLogger();

    public abstract Plugin getPlugin();

    public abstract Dependencies dependencies();
}
