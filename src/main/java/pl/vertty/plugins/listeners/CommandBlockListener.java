package pl.vertty.plugins.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.vertty.plugins.ChatUtil;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.TimeUtil;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;

public class CommandBlockListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommand(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        final String pcmd = e.getMessage();
        final Combat combat = CombatManager.getCombat(p);
        if (!p.hasPermission(LoaderConfig.komendy_permission) && (combat != null && combat.hasFight())) {
            for (final String cmd : LoaderConfig.komendy_pvp) {
                if (pcmd.toLowerCase().contains("/" + cmd)) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.komendy_error);
                    return;
                }
            }
        }
    }

}
