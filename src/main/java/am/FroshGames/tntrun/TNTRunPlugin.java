package am.FroshGames.tntrun;

import am.FroshGames.tntrun.Listener.TNTRunListener;
import am.FroshGames.tntrun.command.TNTRunCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTRunPlugin extends JavaPlugin {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        Bukkit.getPluginManager().registerEvents(new TNTRunListener(this), this);
        this.getCommand("tntrun").setExecutor(new TNTRunCommand(this));
    }

    @Override
    public void onDisable() {
        // Código para ejecutar al deshabilitar el plugin (si es necesario)
    }

    public FileConfiguration getPluginConfig() {
        return config;
    }
}
