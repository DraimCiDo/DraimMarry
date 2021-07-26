package me.draimgoose.internal;

import com.google.common.collect.Lists;
import com.google.common.reflect.ClassPath;
import me.draimgoose.draimmarry;
import me.draimgoose.commands.Command;
import me.draimgoose.misc.BConfig;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class MarriageBase implements draimmarry {
    protected final MarriagePlugin plugin;
    private final ClassPath classPath;
    private MarriageCommandExecutor commandExecutor;

    public MarriageBase(MarriagePlugin plugin) {
        this.plugin = plugin;
        try {
            this.classPath = ClassPath.from(getClass().getClassLoader());
        } catch(IOException e) {
            throw new RuntimeException("Не удалось инициализировать путь к классу!", e);
        }
    }

    void enable() {
        this.commandExecutor = new MarriageCommandExecutor(this);
        plugin.getCommand("marry").setExecutor(commandExecutor);
    }

    @Override
    public void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    @Override
    public void register(Class<? extends Command> commandClass, Class<? extends Command>... commandClasses) {
        commandExecutor.register(commandClass);
        for(Class<? extends Command> cmdclass : commandClasses) {
            commandExecutor.register(cmdclass);
        }
    }

    @Override
    public BConfig getBukkitConfig(String fileName) {
        File file = new File(plugin.getDataFolder(), fileName);
        return new BConfig(this, file);
    }

    @Override
    public Logger getLogger() {
        return plugin.getLogger();
    }

    @Override
    public MarriagePlugin getPlugin() {
        return plugin;
    }

    public MarriageCommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    @SuppressWarnings("unchecked")
    protected <T> List<Class<? extends T>> findClasses(String pkg, Class<T> type, Object... params) {
        List<Class<? extends T>> list = Lists.newArrayList();
        for(ClassPath.ClassInfo info : classPath.getTopLevelClassesRecursive(pkg)) {
            try {
                Class<?> clazz = Class.forName(info.getName());
                if(type.isAssignableFrom(clazz) && !type.equals(clazz)) {
                    list.add((Class<? extends T>) clazz);
                }
            } catch(Exception e) {
                plugin.getLogger().log(Level.WARNING, "Не удалось запустить класс", e);
            }
        }

        return list;
    }

    protected <T> List<T> findObjects(String pkg, Class<T> type, Object... params) {
        List<T> list = Lists.newArrayList();
        for(Class<? extends T> clazz : findClasses(pkg, type)) {
            try {
                list.add(type.cast(clazz.getConstructors()[0].newInstance(params)));
            } catch(Exception e) {
                plugin.getLogger().log(Level.WARNING, "Не удалось создать класс", e);
            }
        }

        return list;
    }
}
