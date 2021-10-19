package pl.vertty.plugins;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pl.vertty.plugins.listeners.*;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;
import pl.vertty.plugins.tasks.CombatTask;

public class Main extends JavaPlugin {

    private static Main inst;

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
    }
}
