package io.seanbarker.trackerdeaths.builder.base;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.DeathCause;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class FallDistanceParser implements DeathParser {

    @Override
    public void parse(Death death) {
        if(death.getCause() == DeathCause.FALL) {
            int distance = (int) Math.round(death.getVictim().getFallDistance());
            death.addMeta("(" + distance + " block" + (distance != 1 ? "s" : "") + ")");
        }
    }
    
}
