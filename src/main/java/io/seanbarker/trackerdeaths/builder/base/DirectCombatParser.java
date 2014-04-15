package io.seanbarker.trackerdeaths.builder.base;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class DirectCombatParser implements DeathParser {

    @Override
    public void parse(Death death) {
        if(death.getDamageEvent() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) death.getDamageEvent();
            Entity damager = event.getDamager();
            death.setKiller(damager);
            if(damager instanceof Player) {
                death.setCredited((Player) damager);
            }
        }
    }

}
