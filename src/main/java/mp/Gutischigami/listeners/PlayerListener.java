package mp.Gutischigami.listeners;
import mp.Gutischigami.MiPlugin;
import mp.Gutischigami.config.MainConfigManager;
import mp.Gutischigami.util.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;
import java.util.ArrayList;
import java.util.List;


// Se crea la clase PlayerListener que implementa el Listener de los eventos que ocurren en el servidor.
public class PlayerListener implements Listener {



    //Se crea la variable plugin.
    private MiPlugin plugin;
    //Se genera el constructor para el plugin.
    public PlayerListener(MiPlugin plugin){
        this.plugin = plugin;
    }


    //Metodo que modera el chat.
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        MainConfigManager mainConfigManager = plugin.getMainConfigManager();
        //crear la variable server.
        if (message.toLowerCase().contains("kike")){
            Bukkit.getServer().broadcastMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&cOye tonto, no escribai eso aweonao."));

        } else if (message.toLowerCase().contains("conchetumare")) {
            Bukkit.getServer().broadcastMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&cOrdinario."));
        }
    }

    //Metodo que saluda al jugador y lo transporta al lobby al momento de entrar.
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        List<String> message = new ArrayList<>();
        message.add(ChatColor.AQUA + "------------------------");
        message.add("");
        message.add(ChatColor.WHITE + "Bienvenido! " + ChatColor.DARK_PURPLE + player.getName() + ChatColor.WHITE + " al servidor");
        message.add(ChatColor.BLUE + "Pasalo joya");
        message.add("");
        message.add(ChatColor.AQUA + "------------------------");

        for (String m : message){
            Bukkit.getServer().broadcastMessage(m);
        }
        //MainConfigManager mainConfigManager = plugin.getMainConfigManager();
        //if (mainConfigManager.isWelcomeMessageEnable()){
           // List<String> message = mainConfigManager.getWelcomeMessageMessage();
           // for (String m : message){
                //player.sendMessage(MessageUtils.getColoredMessage(m.replace("%Player%", player.getName())));
          //  }
      //  }
        //Bukkit.getServer().broadcastMessage("/title @a title [\"\",{\"text\":\"a\",\"obfuscated\":true},\" \",{\"text\":\"[\",\"color\":\"dark_purple\"},\" \",{\"text\":\"Bienvenido\",\"bold\":true,\"color\":\"aqua\"},\" \",{\"text\":\"]\",\"color\":\"dark_purple\"},\" \",{\"text\":\"a\",\"obfuscated\":true}]");
       // Location location = new Location(Bukkit.getWorld("KattNoroi"), -548.453, 133, 558.398, -90, 3);
       // player.teleport(location);
    }

    //Metodo que evita que los jugadores rompan bloques.
   // @EventHandler
    //public void onBlockBreak(BlockBreakEvent event){
       // Player player = event.getPlayer();
       // if (player.getWorld().getName().equals("KattNoroi") && !player.hasPermission("miplugin.admin")){
          //  event.setCancelled(true);
          //  player.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + " &cComo te le ocurre romper bloques aquí aweonao."));
      //  }
   // }
}

