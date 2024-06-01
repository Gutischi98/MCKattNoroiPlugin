package mp.Gutischigami.config;
import mp.Gutischigami.MiPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.List;

public class MainConfigManager {
    private CustomConfig configFile;
    private MiPlugin plugin;
    private boolean welcomeMessageEnable;
    private List<String> welcomeMessageMessage;
    private String preventKikeMessage;
    private String preventCtmMessage;


    public MainConfigManager(MiPlugin plugin){
        this.plugin = plugin;
        configFile = new CustomConfig("GutiConfig.yml", null, plugin);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration config = configFile.getConfig();
        welcomeMessageEnable = config.getBoolean("GutiConfig.welcome_message.enable");
        welcomeMessageMessage = config.getStringList("GutiConfig.welcome_message.message");
        preventKikeMessage = config.getString("GutiConfig.messages.preventKike");
        preventCtmMessage = config.getString("GutiConfig.message.preventCtm");
    }

    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }

    public boolean isWelcomeMessageEnable() {
        return welcomeMessageEnable;
    }

    public List<String> getWelcomeMessageMessage() {
        return welcomeMessageMessage;
    }

    public String getPreventKikeMessage() {
        return preventKikeMessage;
    }

    public String getPreventCtmMessage() {
        return preventCtmMessage;
    }
}
