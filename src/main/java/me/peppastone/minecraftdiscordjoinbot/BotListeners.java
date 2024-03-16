package me.peppastone.minecraftdiscordjoinbot;

import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotListeners extends ListenerAdapter {
    private boolean hasChannel = false;
    public static MessageChannelUnion channel;

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
