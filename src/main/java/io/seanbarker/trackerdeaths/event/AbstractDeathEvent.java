package io.seanbarker.trackerdeaths.event;

import io.seanbarker.trackerdeaths.Death;

import org.bukkit.event.Event;

public abstract class AbstractDeathEvent extends Event {

    private Death death;
    
    public AbstractDeathEvent(Death death) {
        this.death = death;
    }
    
    public Death getDeath() {
        return death;
    }
    
}
