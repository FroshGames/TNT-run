package am.FroshGames.tntrun.command;

import am.FroshGames.tntrun.TNTRunPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class TNTRunCommand implements CommandExecutor {
    private final TNTRunPlugin plugin;

    public TNTRunCommand(TNTRunPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser usado por jugadores.");
            return true;
        }

        if (args.length == 1) {
            try {
                int delay = Integer.parseInt(args[0]);
                FileConfiguration config = plugin.getPluginConfig();
                config.set("tnt-activation-delay", delay);
                plugin.saveConfig();
                sender.sendMessage("Delay de TNT actualizado a " + delay + " ticks.");
            } catch (NumberFormatException e) {
                sender.sendMessage("Por favor, ingresa un número válido.");
            }
            return true;
        }

        sender.sendMessage("Uso: /tntrun <delay>");
        return false;
    }
}
// Pluguin echo por Froshy
