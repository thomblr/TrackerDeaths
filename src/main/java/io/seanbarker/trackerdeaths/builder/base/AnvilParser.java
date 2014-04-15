package io.seanbarker.trackerdeaths.builder.base;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.FallingBlock;

import tc.oc.tracker.Trackers;
import tc.oc.tracker.trackers.AnvilTracker;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class AnvilParser implements DeathParser {

    @Override
    public void parse(Death death) {
        if(death.getKiller() instanceof FallingBlock) {
            FallingBlock f = (FallingBlock) death.getKiller();
            AnvilTracker tracker = Trackers.getTracker(AnvilTracker.class);
            OfflinePlayer player = tracker.getOwner(f);
            if(player != null && player.isOnline()) {
                death.setCredited(player.getPlayer());
            }
        }
    }
    
}
