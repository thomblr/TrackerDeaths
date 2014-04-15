package io.seanbarker.trackerdeaths.builder;

import java.util.ArrayList;
import java.util.List;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.builder.base.*;
import io.seanbarker.trackerdeaths.event.PlayerDeathEvent;
import io.seanbarker.trackerdeaths.event.PlayerKillPlayerEvent;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public enum DeathCompiler implements Listener {

    INSTANCE;
    
    private List<DeathParser> parsers;
    
    private DeathCompiler() {
        this.parsers = new ArrayList<>();
        parsers.add(new DefaultParser());
        parsers.add(new DirectCombatParser());
        parsers.add(new ExplosiveParser());
        parsers.add(new AnvilParser());
        parsers.add(new ProjectileParser());
        parsers.add(new DispenserParser());
        parsers.add(new GravityParser());
        parsers.add(new OwnedMobParser());
        parsers.add(new FallDistanceParser());
    }
    
    public void addParser(DeathParser parser) {
        parsers.add(parser);
    }
    
    public void removeParser(DeathParser parser) {
        this.parsers.remove(parser);
    }
    
    public void removeParser(Class<? extends DeathParser> clazz) {
        for(DeathParser parser : parsers) {
            if(parser.getClass() == clazz) {
                parsers.remove(parser);
            }
        }
    }
    
    @EventHandler
    private void onBukkitDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        event.setDeathMessage("");
        Death death = new Death(event);
        for(DeathParser parser : parsers) {
            parser.parse(death);
        }
        
        Bukkit.getServer().getPluginManager().callEvent(new PlayerDeathEvent(death));
        if(death.getCredited() != null) {
            Bukkit.getServer().getPluginManager().callEvent(new PlayerKillPlayerEvent(death));
        }
    }
    
}
