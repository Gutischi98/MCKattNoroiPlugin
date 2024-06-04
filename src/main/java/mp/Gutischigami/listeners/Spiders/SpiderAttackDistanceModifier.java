package mp.Gutischigami.listeners.Spiders;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpiderAttackDistanceModifier implements Listener {
    private final JavaPlugin plugin;

    public SpiderAttackDistanceModifier(JavaPlugin plugin) {
        this.plugin = plugin;
    }

   @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Spider && event.getEntity() instanceof Player) {
            Spider spider = (Spider) event.getDamager();
            Player player = (Player) event.getEntity();
            double customAttackRange = 1.5;

            if (spider.getLocation().distance(player.getLocation()) > customAttackRange){
                event.setCancelled(true);
            }
        }
   }
}
