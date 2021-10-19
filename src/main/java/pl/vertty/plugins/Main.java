package pl.vertty.plugins;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pl.vertty.plugins.listeners.*;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;
import pl.vertty.plugins.tasks.CombatTask;
import pl.vertty.plugins.test.WallHandler;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private static Main inst;
    public FileConfiguration Config;
    public Logger log = Bukkit.getLogger();

    public static Main getInst() {
        return Main.inst;
    }


    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        for (final Player p : Bukkit.getOnlinePlayers()) {
            CombatManager.removeCombat(p);
        }
    }

    @Override
    public void onEnable() {
        inst = this;
        LoaderConfig.load();
        for (Player p : Bukkit.getOnlinePlayers()) {
            final Combat c = CombatManager.getCombat(p);
            if (c == null) {
                CombatManager.createCombat(p);
            }
        }
        new CombatTask().runTaskTimerAsynchronously(this, 40L, 20L);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
        Bukkit.getPluginManager().registerEvents(new CommandBlockListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryOpenListener(), this);
        WallHandler.load();
    }
}
