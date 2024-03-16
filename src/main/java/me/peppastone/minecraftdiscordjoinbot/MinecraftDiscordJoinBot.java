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
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        JDA bot = JDABuilder.createDefault("MTA1NjY5NjU3NjI0NjAyNjM1MA.GAQHrj.Tf0DBoWRXWJru6muao26hI2JyixPes35l33xzE")
                .setActivity(Activity.listening("your mom"))
                .addEventListeners(new BotListeners())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
