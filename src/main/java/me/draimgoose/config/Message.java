package me.draimgoose.config;

import me.draimgoose.draimmarry;
import me.draimgoose.misc.BConfig;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public enum Message {
    PLAYER_NOT_FOUND("&7Игрок с ником &6%s &7не найден!"),
    TARGET_ALREADY_MARRIED("&7Игрок &6%s &7уже женат на ком-то!"),
    ALREADY_MARRIED("&7Ты уже замужем за кем-то!"),
    MARRIED("&6%s &7и &6%s &7только что поженились!"),
    MARRIAGE_REQUESTED("&7Игрок &6%s &7предложил вам вспутить в брак, используйте &8/&2marry %s &7,чтобы принять."),
    REQUEST_SENT("&7Вы сделали предложение игроку &6%s!"),
    NOT_MARRIED("&7В настоящее время вы ни с кем не женаты!"),
    DIVORCED("&6%s &7и &6%s &7развелись!"),
    HOME_TELEPORT("&7Вас телепортировали в ваш брачный дом!"),
    HOME_NOT_SET("&7В настоящее время у вас нет брачного дома!"),
    NO_ITEM("&7Вы не держите в руках предмет для подарка!"),
    ITEM_GIFTED("&7Вы подарили &e%s %s &7своему партнеру!"),
    GIFT_RECEIVED("&7Вы получили &e%s %s &7в качестве подарка от вашего партнера!"),
    PARTNER_NOT_ONLINE("&7Ваш партнер в настоящее время не в сети!"),
    FETCHING_LIST("&7Получение списка браков..."),
    HOME_SET("&7Вы создали дом для своего брака!"),
    INVALID_FORMAT("&7Аргумент не может быть проанализирован до целого числа!"),
    INVALID_GENDER("&7Это недопустимый пол! Выберите \"мужчина\" или \"женщина\""),
    GENDER_SET("&7Ваш пол был установлен на &6%s!"),
    MARRY_SELF("&7Вы не можете вступить в брак с собой"),
    NEGATIVE_NUMBER("&7Вы должны ввести положительное число!"),
    PRIEST_ADDED("&7Установлен игрок как священик, теперь он может женить других игроков!"),
    PRIEST_REMOVED("&7Убран игрок как священик, теперь он больше не может жениться на других игроках!"),
    TELEPORTED("&7Вы были телепортированы в местоположение вашего партнера!"),
    TELEPORTED_2("&7Ваш партнер только что телепортировался к вам!"),
    ONLINE_SINCE("&7Ваш партнер был &2ОНАЙЛН &6%s"),
    OFFLINE_SINCE("&7Ваш партнер находится в &cОФФЛАЙНЕ &6%s"),
    NOT_A_PRIEST("&7Вам не разрешается вступать в брак с 2 игроками!"),
    COOLDOWN("&7Вы не можете выполнять это действие слишком часто!"),
    UPDATE_AVAILABLE("&8(DraimMarry&8) &7Вышло обновление! %s\nПропишите &7/&2marry update &7чтобы обновиться"),
    PAID_FEE("&6%s &7было удалено с вашего баланса."),
    INSUFFICIENT_MONEY("&7У вас недостаточно средств, это стоит &6%s"),
    PARTNER_FEE("&7Ваш партнер не смог оплатить брачный взнос!"),
    MARRIED_TO("&7женат на &6%s"),
    CHAT_ENABLED("&7Теперь вы находитесь в режиме брачного чата!"),
    CHAT_DISABLED("&7Вы больше не находитесь в режиме брачного чата!"),
    CHAT_SPY_ENABLED("&7Теперь вы следите за брачным чатом!"),
    CHAT_SPY_DISABLED("&7Вы больше не следите за брачным чатом!"),
    NO_HEALTH("&7У вас недостаточно здоровья, чтобы поделиться им!"),
    FULL_HEALTH("&7У вашего партнера уже есть полное здоровье!"),
    HEALTH_GIVEN("&7Вы исцелили партнера на &c%s &7сердец"),
    HEALTH_TAKEN("&7Вы были исцелены вашим партнером на &c%s &7сердец!"),
    PVP_ENABLED("&7Вы включили pvp со своим партнером!"),
    PVP_DISABLED("&7Вы отключили pvp со своим партнером!"),
    PARTNER_PVP("&7Ваш партнер изменил правила pvp."),
    BONUS_EXP("&7Вы получили &6%s&7 опыта за прокачку от вашего партнера!"),
    CONFIG_RELOAD("&7Параметры конфигурации были перезагружены, пожалуйста, обратите внимание, что некоторые настройки могут не применяться до перезагрузки."),
    GENDER_ALREADY_CHANGED("&7Вы уже указали свой пол, вы можете сделать это только один раз."),
    TELEPORT_UNSAFE("&7Место, в которое вы пытаетесь телепортироваться, небезопасно или затруднено"),
    PARTNER_INVENTORY_FULL("&7Инвентарь вашего партнера полон!"),

    // COMMANDS
    COMMAND_MARRY("Запросите брак с другим игроком"),
    COMMAND_MARRY_PRIEST("Пожените 2-ух игроков друг с другом"),
    COMMAND_CHAT("Включите режим чата только для партнеров"),
    COMMAND_DIVORCE("Развестись со своим нынешним партнером"),
    COMMAND_GENDER("Указать свой пол"),
    COMMAND_GIFT("Подарите предметы, которые у вас в данный момент находится в руке"),
    COMMAND_HOME("Телепортирация в свой брачный дом"),
    COMMAND_LIST("Просмотр списка всех женатых игроков"),
    COMMAND_SEEN("Проверьте, когда ваш партнер в последний раз был в сети"),
    COMMAND_SETHOME("Создать дом для себя и своего партнера"),
    COMMAND_TELEPORT("Телепортируйтесь к своему партнеру"),
    COMMAND_HEAL("Передать свое здоровье вашему партнеру"),
    COMMAND_PVP("Включите/отключите ПвП со своим партнером"),

    // WORDS
    STATUS("&aСтатус: %s"),
    SINGLE("&fодинок"),
    ON_OFF("вкл/выкл");

    private final String defaultMessage;
    private String message;

    Message(String def) {
        this.defaultMessage = def;
        this.message = def; // Use default if not loaded yet
    }

    private void reload(BConfig config) {
        this.message = config.getOrSet(name().toLowerCase(), defaultMessage);
    }

    @Override
    public String toString() {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public void send(Player player, Object... params) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format(message, params)));
    }

    public static void reloadAll(draimmarry marriage) {
        BConfig config = marriage.getBukkitConfig("messages.yml");
        for(Message message : values()) {
            message.reload(config);
        }

        config.save();
    }
}

