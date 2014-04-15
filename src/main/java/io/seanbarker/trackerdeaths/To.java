package io.seanbarker.trackerdeaths;

import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

/**
 * Represents the possible destinations of an attack
 */
public enum To {

    VOID, GROUND, LAVA;
    
    public static To convert(DamageCause cause) {
        switch(cause) {
            case VOID:
                return VOID;
            case FALL:
            case SUICIDE:
                return GROUND;
            case LAVA:
            case FIRE_TICK:
                return LAVA;
            default:
                return null;
        }
    }
    
}
