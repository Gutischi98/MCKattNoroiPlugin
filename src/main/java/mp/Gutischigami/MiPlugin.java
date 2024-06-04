package mp.Gutischigami;
import mp.Gutischigami.commands.MainCommand;
import mp.Gutischigami.config.MainConfigManager;
import mp.Gutischigami.listeners.Spiders.SpiderAttackDistanceModifier;
import mp.Gutischigami.listeners.creepers.CreeperAttackDistanceModifier;
import mp.Gutischigami.listeners.PlayerListener;
import mp.Gutischigami.listeners.creepers.CreeperMovSpeedModifier;
import mp.Gutischigami.listeners.skeletons.SkeletonAttackDistanceModifier;
import mp.Gutischigami.listeners.skeletons.SkeletonMovSpeedModifier;
import mp.Gutischigami.listeners.zombies.ZombieAttackDistanceModifier;
import mp.Gutischigami.listeners.zombies.ZombieMovSpeedModifier;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

//Se crea la clase MiPlugin (esta se debe llamar como se llama el plugin, además esta hereda de JavaPlugin.)
public class MiPlugin extends JavaPlugin {

    public static String prefix = "&6[&eKattNoroi] ";
    private final String version = getDescription().getVersion();
    private MainConfigManager mainConfigManager;

    public void onEnable() {
        registerCommands();
        registerEvents();
        mainConfigManager = new MainConfigManager(this);
        getServer().getPluginManager().registerEvents(new ZombieAttackDistanceModifier(this), this);
        getServer().getPluginManager().registerEvents(new CreeperAttackDistanceModifier(this), this);
        getServer().getPluginManager().registerEvents(new SkeletonAttackDistanceModifier(this), this);
        getServer().getPluginManager().registerEvents(new SpiderAttackDistanceModifier(this), this);
        getServer().getPluginManager().registerEvents(new ZombieMovSpeedModifier(this), this);
        getServer().getPluginManager().registerEvents(new CreeperMovSpeedModifier(this), this);
        getServer().getPluginManager().registerEvents(new SkeletonMovSpeedModifier(this), this);


        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "ha sido iniciado, Version " + version )
        );
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', prefix + "ha sido desactivado " + version)
        );
    }


    public void registerCommands(){
        this.getCommand("kattnoroi").setExecutor(new MainCommand(this));
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerListener(this),this);
    }

    public MainConfigManager getMainConfigManager() {
        return mainConfigManager;
    }
}
