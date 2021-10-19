package pl.vertty.plugins.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;

public class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        e.setJoinMessage((String)null);
        final Combat combat = CombatManager.getCombat(p);
        if (combat == null) {
            CombatManager.createCombat(p);
        }
    }

}
