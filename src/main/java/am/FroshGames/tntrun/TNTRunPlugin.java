package am.FroshGames.tntrun;

import am.FroshGames.tntrun.Listener.TNTRunListener;
import am.FroshGames.tntrun.command.TNTRunCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public class TNTRunPlugin extends JavaPlugin {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        Bukkit.getPluginManager().registerEvents(new TNTRunListener(this), this);
        this.getCommand("tntrun").setExecutor(new TNTRunCommand(this));

        // Mensaje en la consola al activar el plugin
        getLogger().info("TNTRunPlugin desarrollado por Froshy ha sido activado.");

        // Mensaje de bienvenida para los jugadores
        Bukkit.getScheduler().runTaskLater(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("§aTNTRunPlugin desarrollado por Froshy está en ejecución.");
            }
        }, 20L);
    }

    @Override
    public void onDisable() {
        getLogger().info("TNTRunPlugin desarrollado por Froshy ha sido desactivado.");
    }

    public FileConfiguration getPluginConfig() {
        return config;
    }
}
