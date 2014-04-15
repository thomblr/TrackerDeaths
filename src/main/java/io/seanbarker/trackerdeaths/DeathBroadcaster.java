package io.seanbarker.trackerdeaths;

import io.seanbarker.trackerdeaths.event.PlayerDeathEvent;
import io.seanbarker.trackerdeaths.messages.DeathMessageBuilder;
import io.seanbarker.trackerdeaths.messages.SimpleDeathMessageBuilder;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DeathBroadcaster implements Listener {
    
    private DeathMessageBuilder builder;
    
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        String message = getBuilder().getMessage(event.getDeath());
        for(Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }
    
    private DeathMessageBuilder getBuilder() {
        if(builder == null) {
            builder = new SimpleDeathMessageBuilder();            
        }
        
        return builder;
    }
    
}
