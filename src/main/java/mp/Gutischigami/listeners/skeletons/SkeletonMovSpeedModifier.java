package mp.Gutischigami.listeners.skeletons;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SkeletonMovSpeedModifier implements Listener {
    private final JavaPlugin plugin;

    public SkeletonMovSpeedModifier(JavaPlugin plugin) {
        this.plugin = plugin;
    }
        @EventHandler
        public void onCreatureSkeletonSpawn(CreatureSpawnEvent event){
            if (event.getEntityType() == EntityType.SKELETON) {
                Skeleton skeleton = (Skeleton) event.getEntity();
                AttributeInstance attribute = skeleton.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                if (attribute != null) {
                    attribute.setBaseValue(1.0);
                }
            }
        }


}
