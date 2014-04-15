package io.seanbarker.trackerdeaths.builder.base;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import tc.oc.tracker.Trackers;
import tc.oc.tracker.trackers.OwnedMobTracker;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class OwnedMobParser implements DeathParser {

    @Override
    public void parse(Death death) {
        if(death.getKiller() instanceof LivingEntity && !(death.getKiller() instanceof Player)) {
            LivingEntity mob = (LivingEntity) death.getKiller();
            OwnedMobTracker tracker = Trackers.getTracker(OwnedMobTracker.class);
            if(tracker.getOwner(mob) != null) {
                Player owner = tracker.getOwner(mob);
                death.setCredited(owner);
            }
        }
    }

}
