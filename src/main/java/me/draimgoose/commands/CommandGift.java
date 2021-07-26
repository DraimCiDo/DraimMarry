package me.draimgoose.commands;

import me.draimgoose.MData;
import me.draimgoose.MPlayer;
import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandGift extends Command {

    public CommandGift(draimmarry marriage) {
        super(marriage, "gift");
        setDescription(Message.COMMAND_GIFT.toString());
    }

    @Override
    public void execute() {
        MPlayer mPlayer = marriage.getMPlayer(player);
        MData marriage = mPlayer.getMarriage();
        if(marriage == null) {
            reply(Message.NOT_MARRIED);
            return;
        }

        Player partner = Bukkit.getPlayer(marriage.getOtherPlayer(player.getUniqueId()));
        if(partner == null) {
            reply(Message.PARTNER_NOT_ONLINE);
            return;
        }

        ItemStack item = player.getItemInHand();
        if(item == null || item.getType() == Material.AIR) {
            reply(Message.NO_ITEM);
            return;
        }

        if(partner.getInventory().firstEmpty() == -1) {
            reply(Message.PARTNER_INVENTORY_FULL);
            return;
        }

        partner.getInventory().addItem(item.clone());
        player.setItemInHand(null);
        reply(Message.ITEM_GIFTED, item.getAmount(), item.getType().toString().toLowerCase());
        reply(partner, Message.GIFT_RECEIVED, item.getAmount(), item.getType().toString().toLowerCase());
    }
}

