package mp.Gutischigami.listeners.creepers;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CreeperAttackDistanceModifier implements Listener {
    private final JavaPlugin plugin;

    public CreeperAttackDistanceModifier(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Zombie && event.getEntity() instanceof Player) {
            Creeper creeper = (Creeper) event.getDamager();
            Player player = (Player) event.getEntity();
            double customAttackRange = 2.0; // Distancia de ataque personalizada en bloques.

            if (creeper.getLocation().distance(player.getLocation()) > customAttackRange) {
                event.setCancelled(true); // Cancela el ataque si está fuera del rango especificado.
            }
        }
    }
}
