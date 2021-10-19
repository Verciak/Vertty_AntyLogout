package pl.vertty.plugins.listeners;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;
import pl.vertty.plugins.manager.SpawnManager;
import pl.vertty.plugins.test.WallHandler;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerTeleport(final PlayerTeleportEvent e) {
        if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)) {
            if (e.getTo().getX() <= LoaderConfig.spawndistance && e.getTo().getX() >= -LoaderConfig.spawndistance && e.getTo().getZ() <= LoaderConfig.spawndistance && e.getTo().getZ() >= -LoaderConfig.spawndistance) {
                e.setCancelled(true);
                e.getPlayer().getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 1));
            }
        }
    }

    @EventHandler
    private void onPlayerMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Combat user = CombatManager.getCombat(p);
        final Player i = e.getPlayer();
        if (LoaderConfig.spawn_status) {
            if (user.hasFight()) {
                if (!p.hasPermission(LoaderConfig.spawn_permission)) {
                    if (SpawnManager.isSpawnLiniaKnock(e.getTo()) && !SpawnManager.isSpawnLiniaKnock(e.getFrom())) {
                        p.setVelocity(p.getVelocity().normalize());
                        p.setVelocity(e.getTo().toVector().subtract(e.getFrom().toVector()).multiply(-2.2).setY(0.2));
                        e.setCancelled(true);
                        if (LoaderConfig.spawn_efekt) {
                            p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
                        }
                        return;
                    }
                }
                Set<Location> actualLocs = user.getWallLocations();
                for (Location l : actualLocs) {
                    if (l.distance(p.getLocation()) > 5) {
                        user.removeWall(l);
                        Block b = p.getWorld().getBlockAt(l);
                        p.sendBlockChange(l, b.getType(), b.getData());
                    }
                }
                if (SpawnManager.isSpawnNear(p.getLocation())) {
                    if (LoaderConfig.spawn_sciana_status) {
                        Set<Location> getSpawnLocs = WallHandler.locations;
                        for (Location l : getSpawnLocs) {
                            if (!p.hasPermission(LoaderConfig.spawn_permission)) {
                                if (l.distance(p.getLocation()) <= 5) {
                                    if (l.getBlock().getType() == Material.AIR) {
                                        user.addLocation(l);
                                        p.sendBlockChange(l, LoaderConfig.sciana_id, (byte) LoaderConfig.sciana_data);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}