package io.seanbarker.trackerdeaths.builder.base;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

import tc.oc.tracker.Trackers;
import tc.oc.tracker.trackers.ProjectileDistanceTracker;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class ProjectileParser implements DeathParser {

    @Override
    public void parse(Death death) {
        if(death.getKiller() instanceof Projectile) {
            Projectile projectile = (Projectile) death.getKiller();
            Entity shooter = projectile.getShooter();
            if(shooter != null) {
                death.setKiller(shooter);
                if(shooter instanceof Player) {
                    death.setCredited((Player) shooter);
                }
            }
            
            ProjectileDistanceTracker tracker = Trackers.getTracker(ProjectileDistanceTracker.class);
            int distance = (int) Math.round(projectile.getLocation().distance(tracker.getLaunchLocation(projectile)));
            death.addMeta("(" + distance + " block" + (distance != 1 ? "s" : "") + ")");
        }
    }

}
