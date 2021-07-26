package me.draimgoose.commands;

import me.draimgoose.MData;
import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.config.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CommandHeal extends Command {
    public CommandHeal(draimmarry marriage) {
        super(marriage, "heal");
        setExecutionFee(Settings.PRICE_HEAL);
        setDescription(Message.COMMAND_HEAL.toString());
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        MData marriage = mPlayer.getMarriage();

        // Check if marries
        if(marriage == null) {
            reply(Message.NOT_MARRIED);
            return;
        }

        // Verify partner online
        Player partner = Bukkit.getPlayer(marriage.getOtherPlayer(player.getUniqueId()));
        if(partner == null) {
            reply(Message.PARTNER_NOT_ONLINE);
            return;
        }

        // Check health
        if(player.getHealth() < 1.0) {
            reply(Message.NO_HEALTH);
            return;
        }

        // Check health of partner
        double give = Math.min(partner.getMaxHealth() - partner.getHealth(), player.getHealth() - 0.5);
        if(give == 0.0) {
            reply(Message.NO_HEALTH);
            return;
        }

        // Transfer health
        player.setHealth(player.getHealth() - give);
        partner.setHealth(partner.getHealth() + give);

        // Notify both parties
        int hearts = (int) Math.round(give * 0.5);
        reply(Message.HEALTH_GIVEN, hearts);
        reply(partner, Message.HEALTH_TAKEN, hearts);
    }
}
