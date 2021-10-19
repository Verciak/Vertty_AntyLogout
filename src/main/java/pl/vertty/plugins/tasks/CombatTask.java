package pl.vertty.plugins.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.vertty.plugins.ChatUtil;
import pl.vertty.plugins.DataUtil;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;

public class CombatTask extends BukkitRunnable {
    public void run() {
        for (final Player p : Bukkit.getOnlinePlayers()) {
            final Combat u = CombatManager.getCombat(p);
            if (u == null) {
                continue;
            }
            if (u.hasFight()) {
                if(LoaderConfig.wiadomosci_actionbar = true){
                    ChatUtil.sendActionBar(p, ChatUtil.fixColor(LoaderConfig.wiadomosci_actionbarpvp.replace("{TIME}", (DataUtil.secondsToString(u.getLastAttactTime()).isEmpty() ? "0s" : (DataUtil.secondsToString(u.getLastAttactTime()))))));
                }
            }
            else {
                if (!u.wasFight() || u.hasFight()) {
                    continue;
                }
                ChatUtil.sendActionBar(p, ChatUtil.fixColor(LoaderConfig.wiadomosci_actionbarendpvp));
                ChatUtil.sendMessage(p, ChatUtil.fixColor(LoaderConfig.wiadomosci_actionbarendpvpchat));
                u.setLastAttactkPlayer(null);
                u.setLastAsystPlayer(null);
            }
        }
    }
}
