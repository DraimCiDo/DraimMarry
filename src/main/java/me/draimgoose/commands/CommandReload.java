package me.draimgoose.commands;

import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.config.Permissions;
import me.draimgoose.config.Settings;
import me.draimgoose.internal.MarriagePlugin;
import me.draimlib.modules.configuration.ConfigurationModule;
public class CommandReload extends Command {

    public CommandReload(draimmarry marriage) {
        super(marriage, "reload");

        // Command options
        setDescription("Перезагрузить параметры конфигурации");
        setPermission(Permissions.RELOAD);
        setAllowConsole(true);
        setHidden(true);
    }

    @Override
    public void execute() {
        MarriagePlugin plugin = (MarriagePlugin) marriage.getPlugin();
        ConfigurationModule module = plugin.getModule(ConfigurationModule.class);
        module.reloadSettings(Settings.class, false);
        reply(Message.CONFIG_RELOAD);
    }
}

