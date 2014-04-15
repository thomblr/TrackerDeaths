package io.seanbarker.trackerdeaths.builder.base;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import tc.oc.tracker.Trackers;
import tc.oc.tracker.trackers.DispenserTracker;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class DispenserParser implements DeathParser {

    @Override
    public void parse(Death death) {
        if(death.getDamageEvent() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) death.getDamageEvent();
            Entity entity = event.getDamager();
            DispenserTracker tracker = Trackers.getTracker(DispenserTracker.class);
            OfflinePlayer player = tracker.getOwner(entity);
            if(player != null && player.isOnline()) {
                death.setCredited(player.getPlayer());
            }
        }
    }

}
