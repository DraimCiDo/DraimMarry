package me.draimgoose.commands;

import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.config.Permissions;

public class CommandChatSpy extends Command {
    public CommandChatSpy(draimmarry marriage) {
        super(marriage, "chatspy");
        setDescription("Enable admin chat spy.");
        setPermission(Permissions.CHAT_SPY);
        setHidden(true);
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        boolean mode = !mPlayer.isChatSpy();
        mPlayer.setChatSpy(mode);
        reply(mode ? Message.CHAT_SPY_ENABLED : Message.CHAT_SPY_DISABLED);
    }
}
