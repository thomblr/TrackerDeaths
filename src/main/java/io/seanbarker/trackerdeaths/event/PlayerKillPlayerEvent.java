package io.seanbarker.trackerdeaths.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import io.seanbarker.trackerdeaths.Death;

public class PlayerKillPlayerEvent extends AbstractDeathEvent {

    public PlayerKillPlayerEvent(Death death) {
        super(death);
    }
    
    public Player getVictim() {
        return getDeath().getVictim();
    }
    
    public Player getCredited() {
        return getDeath().getCredited();
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
