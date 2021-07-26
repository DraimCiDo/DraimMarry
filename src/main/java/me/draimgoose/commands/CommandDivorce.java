package me.draimgoose.commands;


import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.config.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CommandDivorce extends Command {

    public CommandDivorce(draimmarry marriage) {
        super(marriage, "divorce");
        setDescription(Message.COMMAND_DIVORCE.toString());
        setExecutionFee(Settings.PRICE_DIVORCE);
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        MPlayer partner = mPlayer.getPartner();
        if (partner == null) {
            reply(Message.NOT_MARRIED);
            return;
        }

        if (!payFee()) return;
        mPlayer.divorce();

        // Clear metadata
        player.removeMetadata("marriedTo", marriage.getPlugin());
        Player target = Bukkit.getPlayer(partner.getUniqueId());
        if (target != null) {
            target.removeMetadata("marriedTo", marriage.getPlugin());
        }

        broadcast(Message.DIVORCED, player.getName(), Bukkit.getOfflinePlayer(partner.getUniqueId()).getName());
    }
}
