package io.seanbarker.trackerdeaths;

import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;

public final class Names {

    public static String entity(Entity entity) {
        switch(entity.getType()) {
            case PRIMED_TNT:
                return "TNT";
            case FALLING_BLOCK:
                return "falling " + ((FallingBlock) entity).getMaterial().toString().toLowerCase().replace("_", " ");
            case LIGHTNING:
                return "bolt of lightning";
            case UNKNOWN:
                return "unknown entity";
            default:
                return entity.getType().toString().toLowerCase().replace("_", " ");
        }
    }
    
    public static String getArticle(Entity entity) {
        switch(entity.getType()) {
            case PRIMED_TNT:
                return "";
            case EGG:
            case ENDER_CRYSTAL:
            case ENDER_DRAGON:
            case ENDER_PEARL:
            case ENDER_SIGNAL:
            case ENDERMAN:
            case EXPERIENCE_ORB:
            case IRON_GOLEM:
            case ITEM_FRAME:
            case OCELOT:
            case UNKNOWN:
                return "an";
            default:
                return "a";
        }
    }
    
}
