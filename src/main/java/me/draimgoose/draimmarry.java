package me.draimgoose;

import me.draimgoose.commands.Command;
import me.draimgoose.internal.Dependencies;
import me.draimgoose.misc.BConfig;
import me.draimgoose.misc.ListQuery;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.UUID;
import java.util.logging.Logger;

public interface draimmarry {

    BConfig getBukkitConfig(String file);

    MPlayer getMPlayer(UUID uuid);

    MPlayer getMPlayer(Player player);

    ListQuery getMarriageList(int scale, int page);

    MData marry(MPlayer player1, MPlayer player2);

    MData marry(MPlayer player1, MPlayer player2, MPlayer priest);

    void register(Listener listener);

    void register(Class<? extends Command> commandClass, Class<? extends Command>... commandClasses);

    Logger getLogger();

    Plugin getPlugin();

    Dependencies dependencies();
}
