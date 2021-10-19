package pl.vertty.plugins.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import pl.vertty.plugins.LoaderConfig;

public class SpawnManager {

    static Location spawn = new Location(Bukkit.getWorld("world"), LoaderConfig.spawnx, 0, LoaderConfig.spawnz);

    public static Location getLocation() {
        return spawn;
    }

    public static boolean isSpawnNear(final Location loc) {
        if (!loc.getWorld().equals(spawn.getWorld())) {
            return false;
        }
        int distancex = Math.abs(loc.getBlockX() - LoaderConfig.spawnx);
        int distancez = Math.abs(loc.getBlockZ() - LoaderConfig.spawnz);
        return (distancex <= LoaderConfig.spawndistance + 10) && (distancez <= LoaderConfig.spawndistance + 10);
    }

    public static boolean isSpawnLinia(final Location loc) {
        if (!loc.getWorld().equals(spawn.getWorld())) {
            return false;
        }
        int distancex = Math.abs(loc.getBlockX() - LoaderConfig.spawnx);
        int distancez = Math.abs(loc.getBlockZ() - LoaderConfig.spawnz);
        return (distancex <= LoaderConfig.spawndistance) && (distancez <= LoaderConfig.spawndistance);
    }

    public static boolean isSpawnLiniaKnock(final Location loc) {
        if (!loc.getWorld().equals(spawn.getWorld())) {
            return false;
        }
        int distancex = Math.abs(loc.getBlockX() - LoaderConfig.spawnx);
        int distancez = Math.abs(loc.getBlockZ() - LoaderConfig.spawnz);
        return (distancex <= LoaderConfig.spawndistance + 1) && (distancez <= LoaderConfig.spawndistance + 1);
    }
}