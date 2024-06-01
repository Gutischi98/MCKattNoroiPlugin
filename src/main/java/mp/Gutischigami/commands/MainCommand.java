package mp.Gutischigami.commands;
import mp.Gutischigami.MiPlugin;
import mp.Gutischigami.util.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainCommand implements CommandExecutor {

    private final MiPlugin plugin;

    public MainCommand(MiPlugin miPlugin) {
        this.plugin = miPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&4Solo puede ser utilizado por un jugador."));
        }
        ;

        //Jugador
        Player player = (Player) sender;


        // /miplugin args[0] args[1] args[2]
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("Bienvenida")) {
                sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&7Bienvenido &a" + player.getName()));

            } else if (args[0].equalsIgnoreCase("fecha")) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = dateFormat.format(new Date());
                sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&7Fecha y hora actual:  &a" + date));

            } else if (args[0].equalsIgnoreCase("get")) {
                subCommandGet(sender, args);

            } else if (args[0].equalsIgnoreCase("reload")) {

            } else {
                help(sender);
            }
        } else {
            help(sender);
        }

        return false;
    }

    public void help(CommandSender sender) {
        sender.sendMessage(MessageUtils.getColoredMessage("&f&l------------ COMANDOS &c&lKattNoroi--------------------"));
        sender.sendMessage(MessageUtils.getColoredMessage("&7 - /kattnoroi bienvenida"));
        sender.sendMessage(MessageUtils.getColoredMessage("&7 - /kattnoroi fecha"));
        sender.sendMessage(MessageUtils.getColoredMessage("&7 - /kattnoroi get"));
        sender.sendMessage(MessageUtils.getColoredMessage("&f&l------------ COMANDOS &c&lKattNoroi--------------------"));
    }

    public void subCommandGet(CommandSender sender, String[] args) {
        if (!sender.hasPermission("kattnoroi.commands.get")) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&cNo tienes permisos para usar este comando"));
            return;
        }

        if (args.length == 1) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&cDebes usar &7/kattnoroi get <autor/version>"));
            return;
        }
        if (args[1].equalsIgnoreCase("autor")) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&7 El autor de este plugin es: &e" + plugin.getDescription().getAuthors()));
        } else if (args[1].equalsIgnoreCase("version")) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&7 La version de este plugin es: &e" + plugin.getDescription().getVersion()));
        } else {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&cDebes usar &7/kattnoroi get <autor/version>"));
        }
    }

    public void subCommandReload(CommandSender sender) {
        if (!sender.hasPermission("kattnoroi.commands.reload")) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&cNo tienes permisos para usar este comando"));
            return;
        }
        plugin.getMainConfigManager().reloadConfig();
        sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix + "&aConfiguración cargada."));
    }
}
