package am.FroshGames.tNTRun.listener;

import am.FroshGames.tNTRun.TNTRun;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TNTRunListener implements Listener {

    private final TNTRun plugin;
    private final FileConfiguration config;

    public TNTRunListener(TNTRun plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getFrom().getBlock().equals(event.getTo().getBlock())) {
            return;
        }

        Player player = event.getPlayer();
        Block blockUnder = player.getLocation().getBlock().getRelative(0, -1, 0);

        Material falseMaterial = Material.SAND;
        if (blockUnder.getType() == falseMaterial) {
            player.sendMessage("\u00a7c¡Has pisado arena! Cuidado...");

            new BukkitRunnable() {
                @Override
                public void run() {
                    blockUnder.setType(Material.AIR);
                    player.sendMessage("\u00a77La arena ha desaparecido...");
                }
            }.runTaskLater(plugin, 20L);
        }
    }
}

