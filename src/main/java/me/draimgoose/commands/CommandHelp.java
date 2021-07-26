package me.draimgoose.commands;

import me.draimgoose.draimmarry;
import me.draimgoose.config.Message;
import me.draimgoose.internal.MarriageBase;
import me.draimgoose.internal.MarriageCommandExecutor;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import org.bukkit.Bukkit;

public class CommandHelp extends Command {

    public CommandHelp(draimmarry marriage) {
        super(marriage, "help");
        setMinArgs(-1);
        setHidden(true);
        setPermission(null);
        setAllowConsole(true);
    }

    @Override
    public void execute() {
        MarriageCommandExecutor commandExecutor = ((MarriageBase) marriage).getCommandExecutor();
		reply("Автор: &aDraimGooSe");
        reply("Версия: &c" + marriage.getPlugin().getDescription().getVersion());
        reply("&2&m---------&2< &cСвадьбы &2>&2&m---------"); // Play around with the amount of dashes later
        for(Command command : commandExecutor.getSubCommands()) {
            if(command.isHidden()) {
                continue;
            }

            String alias = command instanceof CommandMarry ? "" : command.getAliases()[0] + " ";
            String text = "&a/marry " + alias + command.getUsage() + " &f- &7" + command.getDescription();
            if(command.getExecutionFee() == 0.0 || !Bukkit.getVersion().contains("Spigot") || !marriage.dependencies().isEconomyEnabled() || player == null) {
                reply(text);
                continue;
            }
            if(player.spigot() == null) {
                reply(text);
                continue;
            }
            ComponentBuilder builder = new ComponentBuilder("/marry " + alias + command.getUsage()).color(ChatColor.GREEN)
                    .event(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("Стоимость: "
                            + marriage.dependencies().getEconomyService().format(command.getExecutionFee())).create()))
                    .append(" - ").color(ChatColor.WHITE)
                    .event(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("Стоимость: "
                            + marriage.dependencies().getEconomyService().format(command.getExecutionFee())).create()))
                    .append(command.getDescription()).color(ChatColor.GRAY)
                    .event(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder("Стоимость: "
                            + marriage.dependencies().getEconomyService().format(command.getExecutionFee())).create()));
            player.spigot().sendMessage(builder.create());
        }

        String status = Message.SINGLE.toString();
        if(player != null && player.hasMetadata("marriedTo")) {
            String partner = player.getMetadata("marriedTo").get(0).asString();
            status = String.format(Message.MARRIED_TO.toString(), partner);
        }
        reply(Message.STATUS, status);
        reply("&2&m--------------------------------------------"); // Play around with the amount of dashes later
    }
}
