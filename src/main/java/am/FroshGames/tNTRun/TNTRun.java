package am.FroshGames.tNTRun;

import am.FroshGames.tNTRun.command.TNTRunCommand;
import am.FroshGames.tNTRun.listener.TNTRunListener;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTRun extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Registro del comando
        if (getCommand("tntrun") != null) {
            getCommand("tntrun").setExecutor(new TNTRunCommand(this));
        }
        getServer().getPluginManager().registerEvents(new TNTRunListener(this), this);

        getLogger().info("TNTRun se ha habilitado correctamente.");
    }

    @Override
    public void onDisable() {
        getLogger().info("TNTRun se ha deshabilitado.");
    }
}