package me.draimgoose.commands;

import me.draimgoose.draimmarry;
import me.draimgoose.config.Permissions;
import me.draimgoose.internal.MarriageCore;
import me.draimgoose.internal.data.DataManager;
import me.draimgoose.internal.data.Driver;
import org.bukkit.Bukkit;

public class CommandMigrate extends Command {
    public CommandMigrate(draimmarry marriage) {
        super(marriage, "migrate");
        setMinArgs(2);
        setHidden(true);
        setPermission(Permissions.ADMIN);
    }

    @Override
    public void execute() {
        MarriageCore core = ((MarriageCore) marriage);
        Driver driver;
        final DataManager newDatabase = core.getDataManager();
        if(getArg(0).equalsIgnoreCase("sqlite") && getArg(1).equalsIgnoreCase("mysql")) {
            driver = Driver.SQLITE;
        } else if(getArg(0).equalsIgnoreCase("mysql") && getArg(1).equalsIgnoreCase("sqlite")) {
            driver = Driver.MYSQL;
        } else {
            reply("&7Используйте: /marry migrate <старая бд> <новая бд>");
            return;
        }

        final boolean fastMode = getArgLength() <= 2 || !getArg(2).equalsIgnoreCase("false");
        final DataManager oldDatabase = new DataManager(core, driver);

        reply("&7Запуск процесса миграции (может занять некоторое время)");
        Bukkit.getScheduler().runTaskAsynchronously(marriage.getPlugin(), new Runnable() {
            @Override
            public void run() {
                boolean success = oldDatabase.migrateTo(newDatabase, !fastMode);
                oldDatabase.close(); // Disconnect from old db
                reply(success ? "&aУспешно перенесена база данных!" : "&7Что-то пошло не так во время миграции, проверьте логи.");
            }
        });
    }
}
