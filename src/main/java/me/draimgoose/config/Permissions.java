package me.draimgoose.config;

import me.draimgoose.internal.MarriagePlugin;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Level;

public enum Permissions {
    ALL("dmarry.*", -1),
    ADMIN("dmarry.admin", 0),
    DEFAULT("dmarry.default", 0),
    UPDATE("dmarry.update", 1),
    CHAT_SPY("dmarry.chatspy", 1),
    MIGRATE("dmarry.migrate", 1),
    RELOAD("dmarry.reload", 1),
    MARRY("dmarry.marry"),
    LIST("dmarry.list"),
    TELEPORT("dmarry.tp"),
    HOME("dmarry.home"),
    SET_HOME("dmarry.sethome"),
    GIFT("dmarry.gift"),
    CHAT("dmarry.chat"),
    SEEN("dmarry.seen"),
    HEAL("dmarry.heal"),
    PVP_TOGGLE("dmarry.pvptoggle"),
    CHAT_COLOR("dmarry.color", 1);

    private static boolean vaultEnabled = false;
    private static Permission permissionService;

    public static boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = Bukkit.getServicesManager().getRegistration(Permission.class);
        if(permissionProvider != null) {
            permissionService = permissionProvider.getProvider();
            vaultEnabled = true;
            MarriagePlugin.getCore().getLogger().log(Level.INFO, "Хук с " + permissionService.getName() + " испольузется плагином Vault!");
        }
        return permissionService != null;
    }

    private final String node;
    private final int parent;

    Permissions(String node) {
        this(node, 2);
    }

    Permissions(String node, int parent) {
        this.node = node;
        this.parent = parent;
    }

    public boolean has(CommandSender sender) {
        if(parent >= 0 && values()[parent].has(sender)) {
            return true;
        }

        return vaultEnabled ? permissionService.has(sender, node) : sender.hasPermission(node);
    }

    public static Permissions getByNode(String node) {
        for(Permissions permission : values()) {
            if(permission.node.equalsIgnoreCase(node)) {
                return permission;
            }
        }

        return null;
    }
}