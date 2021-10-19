package pl.vertty.plugins.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeaths(final PlayerDeathEvent e) {
        e.setDeathMessage((String) null);
        final Player p = e.getEntity();
        final Combat combat = CombatManager.getCombat(p);
        if (combat == null) {
            return;
        }
        combat.setLastAttactTime(0L);
        combat.setLastAsystTime(0L);
        combat.setLastAsystPlayer(null);
        combat.setLastAttactkPlayer(null);
    }
}
