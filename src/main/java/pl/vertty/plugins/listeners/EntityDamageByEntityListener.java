package pl.vertty.plugins.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.vertty.plugins.ChatUtil;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.TimeUtil;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;

public class EntityDamageByEntityListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.isCancelled()) {
            return;
        }
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player d = ChatUtil.getDamager(e);
        if (d == null) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (p.equals(d)) {
            return;
        }
        final Combat entity = CombatManager.getCombat(p);
        if (entity == null) {
            return;
        }
        if (!entity.hasFight()) {
            ChatUtil.sendMessage(p, LoaderConfig.wiadomosci_chatdamager.replace("{TIME}", String.valueOf(LoaderConfig.wiadomosci_time)));
        }
        entity.setLastAttactTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(LoaderConfig.wiadomosci_time));
        if (entity.getLastAttactkPlayer() != d) {
            entity.setLastAsystPlayer(entity.getLastAttactkPlayer());
            entity.setLastAsystTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(LoaderConfig.wiadomosci_time));
        }
        entity.setLastAttactkPlayer(d);
        if(e.getDamager() instanceof Player) {
            final Combat atacker = CombatManager.getCombat((Player) e.getDamager());
            if (atacker == null) {
                return;
            }
            if (!atacker.hasFight()) {
                ChatUtil.sendMessage(e.getDamager(), LoaderConfig.wiadomosci_chatplayer.replace("{TIME}", String.valueOf(LoaderConfig.wiadomosci_time)));
            }
            atacker.setLastAttactTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(LoaderConfig.wiadomosci_time));
            if (atacker.getLastAttactkPlayer() != d) {
                atacker.setLastAsystPlayer(atacker.getLastAttactkPlayer());
                atacker.setLastAsystTime(System.currentTimeMillis() + TimeUtil.SECOND.getTime(LoaderConfig.wiadomosci_time));
            }
            atacker.setLastAttactkPlayer(d);
        }
    }
}
