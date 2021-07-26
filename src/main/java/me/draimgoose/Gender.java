package me.draimgoose;

import me.draimgoose.config.Settings;

public enum Gender {

    MALE,
    FEMALE,
    UNKNOWN;

    public String getChatPrefix() {
        switch (this) {
            case MALE:
                return Settings.PREFIX_MALE.value();
            case FEMALE:
                return Settings.PREFIX_FEMALE.value();
            default:
                return Settings.PREFIX_GENDERLESS.value();
        }
    }
}
