package mp.Gutischigami.listeners.zombies;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ZombieMovSpeedModifier implements Listener {
    private final JavaPlugin plugin;

    public ZombieMovSpeedModifier(JavaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureZombieSpawn(CreatureSpawnEvent event){
        if (event.getEntityType() == EntityType.ZOMBIE) {
            Zombie zombie = (Zombie) event.getEntity();
            AttributeInstance attribute = zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
            if (attribute != null) {
                attribute.setBaseValue(0.23 * 1.5);
            }
        }
    }
}