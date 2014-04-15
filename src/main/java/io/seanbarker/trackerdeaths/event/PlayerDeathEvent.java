package io.seanbarker.trackerdeaths.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import io.seanbarker.trackerdeaths.Death;

public class PlayerDeathEvent extends AbstractDeathEvent {

    public PlayerDeathEvent(Death death) {
        super(death);
    }
    
    public Player getPlayer() {
        return getDeath().getVictim();
    }
    
    private static final HandlerList handlers = new HandlerList();
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
}
