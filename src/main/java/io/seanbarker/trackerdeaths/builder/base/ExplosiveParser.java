package io.seanbarker.trackerdeaths.builder.base;

import org.bukkit.entity.TNTPrimed;

import tc.oc.tracker.Trackers;
import tc.oc.tracker.trackers.ExplosiveTracker;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class ExplosiveParser implements DeathParser {

    @Override
    public void parse(Death death) {
        if(death.getKiller() instanceof TNTPrimed) {
            TNTPrimed tnt = (TNTPrimed) death.getKiller();
            ExplosiveTracker tracker = Trackers.getTracker(ExplosiveTracker.class);
            if(tracker.getOwner(tnt) != null) {
                death.setCredited(tracker.getOwner(tnt));
            }
        }
    }
    
}
