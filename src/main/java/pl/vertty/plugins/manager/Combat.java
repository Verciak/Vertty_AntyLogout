package pl.vertty.plugins.manager;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Combat
{
    private Player player;
    private long lastAttactTime;
    private Player lastAttactkPlayer;
    private long lastAsystTime;
    private Player lastAsystPlayer;


    public Set<Location> wallLocations = ConcurrentHashMap.newKeySet();

    public Combat(Player p) {
        this.player = p;
        this.lastAttactTime = 0L;
        this.lastAttactkPlayer = null;
        this.lastAsystPlayer = null;
        this.lastAsystTime = 0L;
    }

    public void removeWall(Location l){
        this.wallLocations.remove(l);
    }

    public void addLocation(Location l){
        this.wallLocations.add(l);
    }

    public Set<Location> getWallLocations(){
        return this.wallLocations;
    }



    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getLastAttactTime() {
        return lastAttactTime;
    }

    public void setLastAttactTime(long lastAttactTime) {
        this.lastAttactTime = lastAttactTime;
    }

    public Player getLastAttactkPlayer() {
        return lastAttactkPlayer;
    }

    public void setLastAttactkPlayer(Player lastAttactkPlayer) {
        this.lastAttactkPlayer = lastAttactkPlayer;
    }

    public long getLastAsystTime() {
        return lastAsystTime;
    }

    public void setLastAsystTime(long lastAsystTime) {
        this.lastAsystTime = lastAsystTime;
    }

    public Player getLastAsystPlayer() {
        return lastAsystPlayer;
    }

    public void setLastAsystPlayer(Player lastAsystPlayer) {
        this.lastAsystPlayer = lastAsystPlayer;
    }

    public boolean hasFight() {
        return this.getLastAttactTime() > System.currentTimeMillis();
    }

    public boolean wasFight() {
        return this.getLastAttactkPlayer() != null;
    }

}

