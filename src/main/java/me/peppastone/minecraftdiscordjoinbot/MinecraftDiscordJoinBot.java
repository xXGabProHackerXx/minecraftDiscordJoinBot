package me.peppastone.minecraftdiscordjoinbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftDiscordJoinBot extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);
        JDA bot = JDABuilder.createDefault(getConfig().getString("token"))
                .setActivity(Activity.listening("your mom"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        bot.addEventListener(new BotListeners(bot, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
