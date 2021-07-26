package me.draimgoose.commands;

import me.draimgoose.MData;
import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.config.Settings;
public class CommandSethome extends Command {

    public CommandSethome(draimmarry marriage) {
        super(marriage, "sethome");
        setExecutionFee(Settings.PRICE_SETHOME);
        setDescription(Message.COMMAND_SETHOME.toString());
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        MData marriage = mPlayer.getMarriage();
        if(marriage == null) {
            reply(Message.NOT_MARRIED);
            return;
        }

        if(!payFee()) return;
        marriage.setHome(player.getLocation().clone());
        reply(Message.HOME_SET);
    }
}
