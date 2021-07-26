package me.draimgoose;

import me.draimgoose.internal.MarriagePlugin;

public class draimmarryAPI {
    private static final int API_VERSION = 1;

    public static draimmarry getInstance() {
        return MarriagePlugin.getCore();
    }

    public static int getAPIVersion() {
        return API_VERSION;
    }

    public static String getPluginVersion() {
        return MarriagePlugin.getInstance().getDescription().getVersion();
    }

    public static String getName() {
        return "DraimMarry API v" + API_VERSION + " (плагин v" + getPluginVersion() + ")";
    }
}
