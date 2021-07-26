package me.draimgoose;

import java.util.UUID;

public interface MPlayer {

    UUID getUniqueId();

    void requestMarriage(UUID from);

    boolean isMarriageRequested(UUID from);

    Gender getGender();

    void setGender(Gender gender);

    MData getMarriage();

    String getLastName();

    boolean isMarried();

    boolean isInChat();

    boolean isPriest();

    void setLastName(String name);

    void setPriest(boolean priest);

    void setInChat(boolean inChat);

    MPlayer getPartner();

    void divorce();

    long getLastLogin();

    long getLastLogout();

    void setChatSpy(boolean enabled);

    boolean isChatSpy();
}
