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

    private MinecraftDiscordJoinBot plugin;

    public JoinLeaveListener(MinecraftDiscordJoinBot plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(0, 255, 0));
        eb.setAuthor(plugin.getConfig().getString("server-name"), plugin.getConfig().getString("server-icon"));
        eb.setThumbnail("https://mc-heads.net/body/" + e.getPlayer().getUniqueId() + "/128.png");
        eb.addField(plugin.getConfig().getString("join-title"), plugin.getConfig().getString("join-description").replace("%player%", e.getPlayer().getName()), false);
        if(plugin.getConfig().getBoolean("player-count")){
            String online = "";
            for(Player player : players){
                online += player.getName() + " ";
            }
            eb.addField(players.size() + " Players Online", online, false);
        }
        MessageEmbed embed = eb.build();
        BotListeners.channel.sendMessageEmbeds(embed).queue();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(255, 0, 0));
        eb.setAuthor(plugin.getConfig().getString("server-name"), plugin.getConfig().getString("server-icon"));
        eb.setThumbnail("https://mc-heads.net/body/" + e.getPlayer().getUniqueId() + "/128.png");
        eb.addField(plugin.getConfig().getString("leave-title"), plugin.getConfig().getString("leave-description").replace("%player%", e.getPlayer().getName()), false);
        if(plugin.getConfig().getBoolean("player-count")){
            String online = "";
            for(Player player : players){
                if(!player.getName().equals(e.getPlayer().getName())){
                    online += player.getName() + " ";
                }
            }
            if(online.equals("")){
                online = "Empty";
            }
            eb.addField((players.size() - 1) + " Players Online", online, false);
        }
        MessageEmbed embed = eb.build();
        BotListeners.channel.sendMessageEmbeds(embed).queue();
    }

}
