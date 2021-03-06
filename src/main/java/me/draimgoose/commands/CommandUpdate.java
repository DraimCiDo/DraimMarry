package me.draimgoose.commands;

import me.draimgoose.draimmarry;
import me.draimgoose.config.Settings;
import me.draimgoose.internal.MarriageCore;
import com.lenis0012.updater.api.Updater;
import com.lenis0012.updater.api.Version;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public class CommandUpdate extends Command {

    public CommandUpdate(draimmarry marriage) {
        super(marriage, "update");
        setHidden(true);
    }

    @Override
    public void execute() {
        final Updater updater = ((MarriageCore) marriage).getUpdater();
        final Version version = updater.getNewVersion();
        if(version == null) {
            reply("&7Программа обновления не включена!");
            return;
        }

        reply("&7Скачивание " + version.getName() + "...");
        Bukkit.getScheduler().runTaskAsynchronously(marriage.getPlugin(), new Runnable() {
            @Override
            public void run() {
                String message = updater.downloadVersion();
                final String response = message == null ? "&7Обновление прошло успешно, будет активно при перезагрузке." : "&cОшибка: &c" + message;
                Bukkit.getScheduler().runTask(marriage.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        reply(response);
                        if(!Settings.ENABLE_CHANGELOG.value()) {
                            return;
                        }

                        ItemStack changelog = updater.getChangelog();
                        if(changelog == null) {
                            reply("&7Список изменений недоступен для этой версии.");
                            return;
                        }

                        ItemStack inHand = player.getItemInHand();
                        player.setItemInHand(changelog);
                        if(inHand != null) {
                            player.getInventory().addItem(inHand);
                        }

                        reply("&lDraimGooSe> &bПроверьте мой список изменений!");
                        player.updateInventory();
                    }
                });
            }
        });
    }
}
