package am.FroshGames.tNTRun.command;

import am.FroshGames.tNTRun.TNTRun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TNTRunCommand implements CommandExecutor {

    private final TNTRun plugin;

    public TNTRunCommand(TNTRun plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§eUsa /tntrun [start|stop|help]");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "start":
                sender.sendMessage("§a¡Iniciando el TNTRun!");
                // Lógica para iniciar
                return true;
            case "stop":
                sender.sendMessage("§c¡Deteniendo el TNTRun!");
                // Lógica para detener
                return true;
            case "help":
                sender.sendMessage("§6Comandos de TNTRun:");
                sender.sendMessage("§6/tntrun start - Inicia el minijuego");
                sender.sendMessage("§6/tntrun stop - Detiene el minijuego");
                return true;
            default:
                sender.sendMessage("§cComando desconocido. Usa /tntrun [start|stop|help]");
                return true;
        }
    }
}
