package mp.Gutischigami.listeners.zombies;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ZombieAttackDistanceModifier implements Listener {
    private final JavaPlugin plugin;

    public ZombieAttackDistanceModifier(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Zombie && event.getEntity() instanceof Player) {
            Zombie zombie = (Zombie) event.getDamager();
            Player player = (Player) event.getEntity();
            double customAttackRange = 1.5; // Distancia de ataque personalizada en bloques

            if (zombie.getLocation().distance(player.getLocation()) > customAttackRange) {
                event.setCancelled(true); // Cancela el ataque si está fuera del rango
            }
        }
    }
}
