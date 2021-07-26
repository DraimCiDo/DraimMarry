package me.draimgoose.config;

import me.draimlib.modules.configuration.mapping.ConfigHeader;
import me.draimlib.modules.configuration.mapping.ConfigOption;

import java.util.Arrays;
import java.util.List;

public class Settings {

    public static final ConfigOption<Integer> REQUEST_EXPIRY = new ConfigOption<>("requestExpiry", 60);
    public static final ConfigOption<Boolean> ENABLE_PRIEST = new ConfigOption<>("enable-priests", false);
    @ConfigHeader("Разрешить несколько раз менять пол игрока.")
    public static final ConfigOption<Boolean> ALLOW_GENDER_CHANGE = new ConfigOption<>("enable-gender-change", true);

    public static final ConfigOption<Integer> COOLDOWN_KISS = new ConfigOption<>("cooldown.kiss", 2);

    @ConfigHeader("Показать цвета пола в списоке женатых игроков.")
    public static final ConfigOption<Boolean> GENDER_IN_LIST = new ConfigOption<>("features.genders-in-list", true);

    @ConfigHeader(path = "chat", value = {
            "Чат, установите формат личных сообщений и статус в чате.",
            "Поддерживаемые теги для чата: {partner}, для лс: {name}, {message}, слежка: {sender}, {receiver}, {message}",
            "Доступные значки: {icon:heart}, {icon:male}, {icon:female}, {icon:genderless}",
            "Если вы используете пользовательский плагин для чата, поместите {marriage_status} в формате и установках force-status-format & force-gender-format на false",
            "Чтобы показать пол в чате, поставьте {marriage_gender} в формате плагина для чата"
    })
    public static final ConfigOption<String> PM_FORMAT = new ConfigOption<>("chat.pm-format", "&4{icon:heart}&c{name}&4{icon:heart} &7{message}");
    public static final ConfigOption<String> CHAT_FORMAT = new ConfigOption<>("chat.status-format", "&c♥ &r");
    public static final ConfigOption<String> CHAT_FORMAT_UNMARRIED = new ConfigOption<>("chat.unmarried-status-format", "");
    public static final ConfigOption<String> CHATSPY_FORMAT = new ConfigOption<>("chat.spy-format", "&8(&5Слежка&8) &7{sender} -> {receiver}&f: {message}");
    public static final ConfigOption<Boolean> FORCE_FORMAT = new ConfigOption<>("chat.force-status-format", true);
    public static final ConfigOption<Boolean> FORCE_GENDER_FORMAT = new ConfigOption<>("chat.force-gender-format", true);
    public static final ConfigOption<String> PREFIX_MALE = new ConfigOption<>("chat.male-prefix", "&b{icon:male} &r");
    public static final ConfigOption<String> PREFIX_FEMALE = new ConfigOption<>("chat.female-prefix", "&d{icon:female} &r");
    public static final ConfigOption<String> PREFIX_GENDERLESS = new ConfigOption<>("chat.genderless-prefix", "");

    @ConfigHeader(path = "kisses", value = {
            "Поцелуи, показывать сердечки, когда 2 женатых игрока сосутся с друг другом.",
            "Количество сердец - это случайное число от минимального до максимального."
    })
    public static final ConfigOption<Boolean> KISSES_ENABLED = new ConfigOption<>("kisses.enabled", true);
    public static final ConfigOption<Integer> KISSES_AMOUNT_MIN = new ConfigOption<>("kisses.amount-min", 4);
    public static final ConfigOption<Integer> KISSES_AMOUNT_MAX = new ConfigOption<>("kisses.amount-max", 8);

    @ConfigHeader(path = "exp-boost", value = "Увеливает полученный опыт, когда женатые игроки находятся рядом друг с другом.")
    public static final ConfigOption<Boolean> EXP_BOOST_ENABLED = new ConfigOption<>("exp-boost.enabled", true);
    public static final ConfigOption<Double> EXP_BOOST_DISTANCE = new ConfigOption<>("exp-boost.distance", 50.0);
    public static final ConfigOption<Double> EXP_BOOST_MULTIPLIER = new ConfigOption<>("exp-boost.multiplier", 1.3);
    @ConfigHeader("Объявлялка суммы бонусного опыта за прогресс, значение false чтобы вырубить к хуям.")
    public static final ConfigOption<Boolean> EXP_BOOST_ANNOUNCE = new ConfigOption<>("exp-boost.announce", true);

//    @ConfigHeader("Automatically trust married players to each others plot.")
//    public static final ConfigOption<Boolean> PLOTSQUARED_AUTO_TRUST = new ConfigOption<>("support.plotsquared-auto-trust", false);

    @ConfigHeader({"Настройки экономии, используется Vault.", "включи 'show-on-help' чтобы показать цены в /marry help"})
    public static final ConfigOption<Boolean> ECONOMY_ENABLED = new ConfigOption<>("economy.enabled", true);
    public static final ConfigOption<Boolean> ECONOMY_SHOW_PRICE = new ConfigOption<>("economy.show-on-help", true);
    public static final ConfigOption<Double> PRICE_MARRY = new ConfigOption<>("economy.marriage-price", 50.0);
    public static final ConfigOption<Double> PRICE_TELEPORT = new ConfigOption<>("economy.teleport-price", 0.0);
    public static final ConfigOption<Double> PRICE_SETHOME = new ConfigOption<>("economy.sethome-price", 100.0);
    public static final ConfigOption<Double> PRICE_HEAL = new ConfigOption<>("economy.heal-price", 25.0);
    public static final ConfigOption<Double> PRICE_DIVORCE = new ConfigOption<>("economy.divorce-price", 0.0);

    @ConfigHeader(path = "updater", value = {
            "Настройки программы обновления, ну или проверка наличия обновлений. Рекомендуем сохранить эту опцию включенной.",
            "Доступные каналы: RELEASE, BETA, ALPHA"
    })
    public static final ConfigOption<Boolean> ENABLE_UPDATE_CHECKER = new ConfigOption<>("updater.enabled", true);
    public static final ConfigOption<Boolean> ENABLE_CHANGELOG = new ConfigOption<>("updater.changelog", true);
    public static final ConfigOption<String> UPDATER_CHANNEL = new ConfigOption<>("updater.channel", "BETA");

    @ConfigHeader("Список команд, которые никто не может использовать, например gift.")
    public static final ConfigOption<List<String>> DISABLED_COMMANDS = new ConfigOption<>("disabled-commands", Arrays.asList("команда1", "енотгей"));
}
