package me.draimgoose.commands;

import me.draimgoose.Gender;
import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.config.Settings;

public class CommandGender extends Command {

    public CommandGender(draimmarry marriage) {
        super(marriage, "gender");
        setDescription(Message.COMMAND_GENDER.toString());
        setUsage("<gender>");
        setMinArgs(1);
    }

    @Override
    public void execute() {
        Gender gender;
        try {
            gender = Gender.valueOf(getArg(0).toUpperCase());
        } catch(Exception e) {
            reply(Message.INVALID_GENDER);
            return;
        }

        MPlayer mPlayer = marriage.getMPlayer(player);
        if(mPlayer.getGender() != Gender.UNKNOWN && !Settings.ALLOW_GENDER_CHANGE.value()) {
            reply(Message.GENDER_ALREADY_CHANGED);
        }

        mPlayer.setGender(gender);
        reply(Message.GENDER_SET, gender.toString().toLowerCase());
    }
}
