package me.draimgoose.misc;

import me.draimgoose.internal.MarriageBase;
import me.draimgoose.internal.MarriagePlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class BConfig extends YamlConfiguration {
    private final MarriageBase core;
    private final File file;

    public BConfig(MarriageBase core, File file) {
        this.core = core;
        this.file = file;
        file.getParentFile().mkdirs();
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException e) {
                ;
            }
        }
        reload();
    }

    public void reload() {
        try {
            load(file);
        } catch(Exception e) {
            core.getLogger().log(Level.WARNING, "Ошибка при перезагрузке конфигурации", e);
        }
    }

    public void save() {
        try {
            save(file);
        } catch(Exception e) {
            core.getLogger().log(Level.WARNING, "Ошибка при перезагрузке конфигурации", e);
        }
    }

    @SuppressWarnings("uncheked")
    public <T> T getOrDefault(String key, T def) {
        return contains(key) ? (T) get(key) : def;
    }

    @SuppressWarnings("uncheked")
    public <T> T getOrSet(String key, T def) {
        if(contains(key)) {
            return (T) get(key);
        } else {
            set(key, def);
            return def;
        }
    }

    public <T> T get(String key, Class<T> type) {
        return type.cast(get(key));
    }

    public static void copyFile(InputStream input, File file) {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while((length = input.read(buffer, 0, buffer.length)) != -1) {
                output.write(buffer, 0, length);
            }
        } catch(Exception e) {
            MarriagePlugin.getCore().getLogger().log(Level.WARNING, "Ошибка при копирование файлов", e);
        } finally {
            if(input != null) {
                try {
                    input.close();
                }catch (IOException e1) {
                }
            }
            if(output != null) {
                try {
                    output.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
