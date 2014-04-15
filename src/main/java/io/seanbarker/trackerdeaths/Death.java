package io.seanbarker.trackerdeaths;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import tc.oc.tracker.trackers.base.gravity.Fall.From;

public class Death {
    
    /**
     * The Bukkit PlayerDeathEvent that
     * this death represents
     */
    private final PlayerDeathEvent bukkit;
    
    /**
     * The player that was killed
     */
    private final Player victim;
    
    /**
     * The damage event that caused death
     */
    private final EntityDamageEvent event;
    
    /**
     * The ascertained cause of the death
     */
    private DeathCause cause;
    
    /**
     * The relative location of where the player was attacked from
     */
    private From from;
    
    /**
     * The relative location of where the player died
     */
    private To to;
    
    /**
     * The entity that is directly responsible for the death
     * 
     * null if the player was not killed by an entity
     */
    private Entity killer;
    
    /**
     * The player that is credited for the death
     * 
     * null if a player is not responsible for the death
     */
    private Player credited;
    
    /**
     * A list of meta strings that will be appended to the end of the death message
     */
    private List<String> meta;
    
    public Death(PlayerDeathEvent event) {
        this.bukkit = event;
        this.victim = event.getEntity();
        this.event = victim.getLastDamageCause();
        this.meta = new ArrayList<>();
    }
    
    public Player getVictim() {
        return victim;
    }
    
    public EntityDamageEvent getDamageEvent() {
        return event;
    }
    
    public DeathCause getCause() {
        return cause;
    }
    
    public From getFrom() {
        return from;
    }
    
    public To getTo() {
        return to;
    }
    
    public Entity getKiller() {
        return killer;
    }
    
    public Player getCredited() {
        return credited;
    }
    
    public List<String> getMeta() {
        return meta;
    }
    
    public void setCause(DeathCause cause) {
        this.cause = cause;
    }
    
    public void setFrom(From from) {
        this.from = from;
    }
    
    public void setTo(To to) {
        this.to = to;
    }
    
    public void setKiller(Entity killer) {
        this.killer = killer;
    }
    
    public void setCredited(Player credited) {
        this.credited = credited;
    }
    
    public void setMeta(List<String> meta) {
        this.meta = meta;
    }
    
    public void addMeta(String meta) {
        this.meta.add(meta);
    }
    
    public void clearMeta() {
        this.meta.clear();
    }
    
    public PlayerDeathEvent getBukkitEvent() {
        return bukkit;
    }
    
    @Override
    public String toString() {
        return "Death{"
             + "Victim: " + victim
             + ", Cause: " + cause
             + ", From: " + from
             + ", To: " + to
             + ", Killer: " + killer
             + ", Credited: " + credited
             + "}";
    }

}
