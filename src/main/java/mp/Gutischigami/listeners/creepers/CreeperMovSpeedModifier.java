package mp.Gutischigami.listeners.creepers;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class CreeperMovSpeedModifier  implements Listener {
    private final JavaPlugin plugin;

    public CreeperMovSpeedModifier(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureCreeperSpawn(CreatureSpawnEvent event){
        if (event.getEntityType() == EntityType.ZOMBIE) {
            Creeper creeper = (Creeper) event.getEntity();
            AttributeInstance attribute = creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
            if (attribute != null) {
                attribute.setBaseValue(1.0);
            }
        }
    }
}
