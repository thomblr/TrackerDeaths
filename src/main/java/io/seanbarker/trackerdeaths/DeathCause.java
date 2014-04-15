package io.seanbarker.trackerdeaths;

import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import tc.oc.tracker.trackers.base.gravity.Fall;

public enum DeathCause {

    UNKNOWN,      // Any death that isn't tracked by TrackerDeaths
    KILL,         // Direct hit with a sword, etc.
    KNOCK,        // Knocked to their death
    SHOOT,        // Shot to death (direct or gravity kill)
    EXPLODE,      // Explosion
    SPLEEF,       // Spleefed to their death
    FALL,         // Fall damage (not gravity)
    VOID,         // Damage by falling into the void (not gravity)
    CRUSH,        // Crushed by a falling block (e.g. anvil)
    SUFFOCATION,  // Suffocated by sand
    CONTACT,      // Block contact (e.g. cactus)
    DROWN,        // Drowning in water
    STARVATION,   // Starvation
    FIRE,         // Died by fire (Bukkit Fire & Fire tick)
    LAVA,         // Died in lava
    LIGHTNING,    // Struck by lightning
    MAGIC,        // Potion/spell
    POISON,       // Poison
    SUICIDE,      // /kill command
    THORNS,       // Damage by thorns enchantment
    WITHER;       // Wither potion effect
    
    public static DeathCause convert(DamageCause cause) {
        switch(cause) {
            case BLOCK_EXPLOSION:
            case ENTITY_EXPLOSION:
                return EXPLODE;
            case CONTACT:
                return CONTACT;
            case DROWNING:
                return DROWN;
            case ENTITY_ATTACK:
                return KILL;
            case FALL:
                return FALL;
            case FALLING_BLOCK:
                return CRUSH;
            case FIRE:
            case FIRE_TICK:
                return FIRE;
            case LAVA:
                return LAVA;
            case LIGHTNING:
                return LIGHTNING;
            case MAGIC:
                return MAGIC;
            case POISON:
                return POISON;
            case PROJECTILE:
                return SHOOT;
            case STARVATION:
                return STARVATION;
            case SUFFOCATION:
                return SUFFOCATION;
            case SUICIDE:
                return SUICIDE;
            case THORNS:
                return THORNS;
            case VOID:
                return VOID;
            case WITHER:
                return WITHER;
            default:
                return UNKNOWN;
        }
    }
    
    public static DeathCause convert(Fall.Cause cause) {
        switch(cause) {
            case HIT:
                return KNOCK;
            case SHOOT:
                return SHOOT;
            case SPLEEF:
                return SPLEEF;
            default:
                return null;
        }
    }
    
}
