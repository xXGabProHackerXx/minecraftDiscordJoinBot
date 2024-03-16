package me.peppastone.minecraftdiscordjoinbot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;
import java.util.List;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
        String online = "";
        for(Player player : players){
            online += player.getName() + " ";
        }
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(0, 255, 0));
        eb.setAuthor("dot bot", "https://cravatar.eu/helmhead/" + e.getPlayer().getName() + "/600.png");
        eb.setThumbnail("https://mc-heads.net/body/" + e.getPlayer().getUniqueId() + "/128.png");
        eb.addField("Player join", e.getPlayer().getName() + " has joined the SMP", false);
        eb.addField("Players online", online, false);
        MessageEmbed embed = eb.build();
        BotListeners.channel.sendMessageEmbeds(embed).queue();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
        String online = "";
        for(Player player : players){
            if(!player.getName().equals(e.getPlayer().getName())){
                online += player.getName() + " ";
            }
        }
        if(online.equals("")){
            online = "noone lol";
        }
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(255, 0, 0));
        eb.setAuthor("dot bot", "https://cravatar.eu/helmhead/" + e.getPlayer().getName() + "/600.png");
        eb.setThumbnail("https://mc-heads.net/body/" + e.getPlayer().getUniqueId() + "/128.png");
        eb.addField("Player leave", e.getPlayer().getName() + " has left the SMP", false);
        eb.addField("Players online", online, false);
        MessageEmbed embed = eb.build();
        BotListeners.channel.sendMessageEmbeds(embed).queue();
    }

}
