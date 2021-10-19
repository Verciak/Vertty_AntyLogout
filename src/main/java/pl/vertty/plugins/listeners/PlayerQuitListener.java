package pl.vertty.plugins.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.vertty.plugins.ChatUtil;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;

public class PlayerQuitListener implements Listener {


    @EventHandler(priority = EventPriority.LOWEST)
    public void onKick(final PlayerKickEvent e) {
        quitGame(e.getPlayer());
        e.setLeaveMessage((String)null);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onQuit(final PlayerQuitEvent e) {
        quitGame(e.getPlayer());
        e.setQuitMessage((String)null);
    }

    public static void quitGame(final Player p) {
        final Combat combat = CombatManager.getCombat(p);
        if (!combat.hasFight()) {
            return;
        }
        p.setHealth(0.0);
        combat.setLastAttactTime(0L);
        combat.setLastAsystTime(0L);
        combat.setLastAsystPlayer(null);
        combat.setLastAttactkPlayer(null);
        ChatUtil.sendMessage(Bukkit.getOnlinePlayers(), LoaderConfig.wiadomosci_chatlogout.replace("{NICK}", p.getName()));
    }

}
