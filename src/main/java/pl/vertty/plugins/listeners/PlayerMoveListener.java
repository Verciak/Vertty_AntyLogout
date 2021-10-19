package pl.vertty.plugins.listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import pl.vertty.plugins.ChatUtil;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;
import pl.vertty.plugins.manager.SpawnManager;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerTeleport(final PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL) && e.getTo().getX() <= LoaderConfig.spawnx && e.getTo().getX() >= -LoaderConfig.spawnx && e.getTo().getZ() <= LoaderConfig.spawnz && e.getTo().getZ() >= -LoaderConfig.spawnz) {
            e.setCancelled(true);
            e.getPlayer().getInventory().addItem(new ItemStack(Material.ENDER_PEARL,1));
        }
    }

    @EventHandler
    private void onPlayerMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Combat user = CombatManager.getCombat(p);
        final Player i = e.getPlayer();
        if (LoaderConfig.spawn_status) {
            if (user.hasFight()) {

                    int distancex = Math.abs(e.getTo().getBlockX() - LoaderConfig.spawnx);
                    int distancez = Math.abs(e.getTo().getBlockZ() - LoaderConfig.spawnz);

                    if(distancex <= LoaderConfig.spawndistance + 5) {
                        p.sendBlockChange(new Location(p.getWorld(), distancex - 5, p.getLocation().getY(), distancez - 5), Material.DIAMOND_BLOCK, (byte) 0);
                    }

                if (!p.hasPermission(LoaderConfig.spawn_permission)) {
                    if (SpawnManager.isSpawnLinia(e.getTo()) && !SpawnManager.isSpawnLinia(e.getFrom())) {
                        p.setVelocity(p.getVelocity().normalize());
                        p.setVelocity(e.getTo().toVector().subtract(e.getFrom().toVector()).multiply(-1.2).setY(0.4));
                        e.setCancelled(true);
                        if (LoaderConfig.spawn_efekt) {
                            p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
                        }
                        return;
                    }
                }
            }
        }
    }
}
