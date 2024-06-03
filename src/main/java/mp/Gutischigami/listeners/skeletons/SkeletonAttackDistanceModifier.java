package mp.Gutischigami.listeners.skeletons;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SkeletonAttackDistanceModifier implements Listener {
    private final JavaPlugin plugin;

    public SkeletonAttackDistanceModifier(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Skeleton && event.getEntity() instanceof Player) {
            Skeleton skeleton = (Skeleton) event.getDamager();
            Player player = (Player) event.getEntity();
            double customAttackRange = 12.0; //Distancia custom de ataque.

            if (skeleton.getLocation().distance(player.getLocation()) > customAttackRange) {
                event.setCancelled(true);
            }
        }
    }
}
