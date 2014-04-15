package io.seanbarker.trackerdeaths.messages;

import io.seanbarker.trackerdeaths.event.DeathMessageEvent;
import io.seanbarker.trackerdeaths.event.PlayerDeathEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MessageBroadcaster implements Listener {
    
    @EventHandler
    public void onDeath(PlayerDeathEvent death) {
        DeathMessageEvent event = new DeathMessageEvent(death.getDeath());
        Bukkit.getServer().getPluginManager().callEvent(event);
        if(!event.isCancelled()) {
            String message = event.getMessage();
            for(Player player : event.getRecipients()) {
                player.sendMessage(message);
            }
        }
    }
    
}
