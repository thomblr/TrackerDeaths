package io.seanbarker.trackerdeaths.builder.base;

import org.bukkit.entity.Player;

import tc.oc.tracker.Trackers;
import tc.oc.tracker.trackers.base.gravity.Fall;
import tc.oc.tracker.trackers.base.gravity.SimpleGravityKillTracker;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.DeathCause;
import io.seanbarker.trackerdeaths.To;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class GravityParser implements DeathParser {

    @Override
    public void parse(Death death) {
        Player victim = death.getVictim();
        SimpleGravityKillTracker tracker = Trackers.getTracker(SimpleGravityKillTracker.class);
        Fall fall = tracker.getCausingFall(victim, death.getDamageEvent().getCause());
        if(fall != null) {
            death.setFrom(fall.from);
            death.setTo(To.convert(death.getDamageEvent().getCause()));
            death.setCause(DeathCause.convert(fall.cause));
            death.setKiller(fall.attacker);
            if(fall.attacker instanceof Player) {
                death.setCredited((Player) fall.attacker);
            }
        }
    }

}
