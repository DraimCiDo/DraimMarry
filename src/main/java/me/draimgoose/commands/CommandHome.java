package me.draimgoose.commands;

import me.draimgoose.MData;
import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import org.bukkit.Location;

public class CommandHome extends Command {

    public CommandHome(draimmarry marriage) {
        super(marriage, "home");
        setDescription(Message.COMMAND_HOME.toString());
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        MData marriage = mPlayer.getMarriage();
        if(marriage == null) {
            reply(Message.NOT_MARRIED);
            return;
        }

        Location home = marriage.getHome();
        if(home == null) {
            reply(Message.HOME_NOT_SET);
            return;
        }

        player.teleport(home);
        reply(Message.HOME_TELEPORT);
    }
}
