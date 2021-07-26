package me.draimgoose;

import org.bukkit.Location;

import java.util.UUID;

public interface MData {

    UUID getPlayer1Id();

    UUID getPlayer2Id();

    UUID getOtherPlayer(UUID me);

    Location getHome();

    void setHome(Location home);

    boolean isHomeSet();

    boolean isPVPEnabled();

    void setPVPEnabled(boolean pvpEnabled);
}
