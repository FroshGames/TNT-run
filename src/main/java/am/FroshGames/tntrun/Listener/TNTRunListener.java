package am.FroshGames.tntrun.Listener;

import am.FroshGames.tntrun.TNTRunPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class TNTRunListener implements Listener {
    private final TNTRunPlugin plugin;

    public TNTRunListener(TNTRunPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block block = player.getLocation().subtract(0, 1, 0).getBlock();
        Block belowBlock = player.getLocation().subtract(0, 2, 0).getBlock();

        if (block.getType() == Material.SAND && belowBlock.getType() == Material.TNT) {
            FileConfiguration config = plugin.getPluginConfig();
            int tntDelay = config.getInt("tnt-activation-delay", 20);

            new BukkitRunnable() {
                @Override
                public void run() {
                    belowBlock.setType(Material.AIR);
                    belowBlock.getWorld().spawn(belowBlock.getLocation(), org.bukkit.entity.TNTPrimed.class, tnt -> {
                        tnt.setFuseTicks(40);
                    });
                    player.playSound(player.getLocation(), Sound.ENTITY_TNT_PRIMED, 1.0f, 1.0f);
                }
            }.runTaskLater(plugin, tntDelay);
        }
    }
}
