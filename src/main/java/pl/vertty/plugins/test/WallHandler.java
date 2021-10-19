package pl.vertty.plugins.test;


import org.bukkit.Location;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.manager.SpawnManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class WallHandler {

    public static Set<Location> locations = ConcurrentHashMap.newKeySet();

    public static void load(){
        Location center = SpawnManager.getLocation();
        int radius = LoaderConfig.spawndistance;
        int cX = center.getBlockX();
        int cZ = center.getBlockZ();
        int minX = Math.min(cX + radius, cX - radius);
        int maxX = Math.max(cX + radius, cX - radius);
        int minZ = Math.min(cZ + radius, cZ - radius);
        int maxZ = Math.max(cZ + radius, cZ - radius);
        Location x1 = new Location(center.getWorld(), minX, 1, minZ);
        Location x2 = new Location(center.getWorld(), maxX, 256, minZ);
        Location z1 = new Location(center.getWorld(), minX, 256, maxZ);
        Location z2 = new Location(center.getWorld(), maxX, 1, maxZ);

        locations.addAll(getLocs(x1, x2));
        locations.addAll(getLocs(x1, z1));
        locations.addAll(getLocs(z2, x2));
        locations.addAll(getLocs(z2, z1));
    }


    public static List<Location> getLocs(Location first, Location second) {
        List<Location> locs = new ArrayList<>();
        int topBlockX = (Math.max(first.getBlockX(), second.getBlockX()));
        int bottomBlockX = (Math.min(first.getBlockX(), second.getBlockX()));
        int topBlockY = (Math.max(first.getBlockY(), second.getBlockY()));
        int bottomBlockY = (Math.min(first.getBlockY(), second.getBlockY()));
        int topBlockZ = (Math.max(first.getBlockZ(), second.getBlockZ()));
        int bottomBlockZ = (Math.min(first.getBlockZ(), second.getBlockZ()));
        for(int x = bottomBlockX; x <= topBlockX; x++)
        {
            for(int z = bottomBlockZ; z <= topBlockZ; z++)
            {
                for(int y = bottomBlockY; y <= topBlockY; y++)
                {
                    locs.add(new Location(first.getWorld(), x,y,z));
                }
            }
        }
        return locs;
    }

}