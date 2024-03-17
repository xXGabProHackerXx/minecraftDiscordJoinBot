package me.peppastone.minecraftdiscordjoinbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotListeners extends ListenerAdapter {
    private boolean hasChannel = false;
    public static MessageChannelUnion channel;
    private MinecraftDiscordJoinBot plugin;
    private JDA jda;

    public BotListeners(JDA jda, MinecraftDiscordJoinBot plugin){
        this.jda = jda;
        this.plugin = plugin;
    }

    @Override
    public void onReady(ReadyEvent event){
        try{
            channel = (MessageChannelUnion) jda.getGuildChannelById(plugin.getConfig().getString("channel-id"));
            hasChannel = true;
        } catch (Exception e){
            //this should work every time and if it doesnt meh just spam exclamation marks in the channel u want
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){

        if(!hasChannel){
            if(event.getMessage().getContentRaw().contains("!!!")){
                hasChannel = true;
                channel = event.getChannel();
            }
        }
    }
}
