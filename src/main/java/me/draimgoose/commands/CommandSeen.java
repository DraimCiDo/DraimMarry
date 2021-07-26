package me.draimgoose.commands;

import me.draimgoose.MData;
import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.internal.MarriageCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class CommandSeen extends Command {
    public CommandSeen(draimmarry marriage) {
        super(marriage, "seen");
        setDescription(Message.COMMAND_SEEN.toString());
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        MData marriage = mPlayer.getMarriage();
        if(marriage == null) {
            reply(Message.NOT_MARRIED);
            return;
        }

        MPlayer mp = this.marriage.getMPlayer(marriage.getOtherPlayer(player.getUniqueId()));
        Player partner = Bukkit.getPlayer(marriage.getOtherPlayer(player.getUniqueId()));
        if(partner != null) {
            long time = System.currentTimeMillis() - mp.getLastLogin();
            reply(Message.ONLINE_SINCE, format(time));
        } else {
            long time = System.currentTimeMillis() - mp.getLastLogout();
//            ((MarriageCore) this.marriage).unloadPlayer(marriage.getOtherPlayer(player.getUniqueId()));
            reply(Message.OFFLINE_SINCE, format(time));
        }
    }

    private String format(long ms) {
        long sec = TimeUnit.MILLISECONDS.toSeconds(ms) % 60;
        long min = TimeUnit.MILLISECONDS.toMinutes(ms) % 60;
        long hrs = TimeUnit.MILLISECONDS.toHours(ms) % 24;
        long dys = TimeUnit.MILLISECONDS.toDays(ms);
        if(dys > 0) {
            return String.format("%sdys%shrs", dys, hrs);
        } else if(hrs > 0) {
            return String.format("%shrs%smin", hrs, min);
        } else if(min > 0) {
            return String.format("%smin%ssec", min, sec);
        } else {
            return sec + "sec";
        }
    }
}
