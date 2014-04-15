package io.seanbarker.trackerdeaths.builder.base;

import io.seanbarker.trackerdeaths.Death;
import io.seanbarker.trackerdeaths.DeathCause;
import io.seanbarker.trackerdeaths.builder.DeathParser;

public class DefaultParser implements DeathParser {

    @Override
    public void parse(Death death) {
        DeathCause cause = DeathCause.convert(death.getDamageEvent().getCause());
        if(cause != null) {
            death.setCause(cause);
        }
    }
    
}
