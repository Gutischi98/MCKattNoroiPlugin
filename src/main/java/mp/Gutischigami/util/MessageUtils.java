package mp.Gutischigami.util;
import org.bukkit.ChatColor;

// Esta clase pública genera la utilidad para poder usar el chat color sin tener que escribir el código completo.

public class MessageUtils {
    public static String getColoredMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}

