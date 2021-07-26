package me.draimgoose.commands;

import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.config.Permissions;
import me.draimgoose.config.Settings;
import org.bukkit.entity.Player;
public class CommandPriest extends Command {

    public CommandPriest(draimmarry marriage) {
        super(marriage, "priest");
        setDescription("Set whether or not a player should be priest.");
        setUsage("add/remove <player>");
        setMinArgs(2);
        setPermission(Permissions.ADMIN);

        if(!Settings.ENABLE_PRIEST.value()) {
            setHidden(true);
        }
    }

    @Override
    public void execute() {
        String type = getArg(0);
        Player player = getArgAsPlayer(1);
        if(player == null) {
            reply(Message.PLAYER_NOT_FOUND, getArg(1));
            return;
        }

        MPlayer mp = marriage.getMPlayer(player);
        if(type.equalsIgnoreCase("add")) {
            mp.setPriest(true);
            reply(Message.PRIEST_ADDED);
        } else if(type.equalsIgnoreCase("remove")) {
            mp.setPriest(false);
            reply(Message.PRIEST_REMOVED);
        }
    }
}
