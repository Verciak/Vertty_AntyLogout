package pl.vertty.plugins.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import pl.vertty.plugins.ChatUtil;
import pl.vertty.plugins.LoaderConfig;
import pl.vertty.plugins.manager.Combat;
import pl.vertty.plugins.manager.CombatManager;

public class InventoryOpenListener implements Listener {

    @EventHandler
    public void FrameEntity(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof ItemFrame) {
            if (e.getDamager() instanceof Player) {
                Player p = (Player) e.getDamager();
                final Combat combat = CombatManager.getCombat(p);
                if (combat != null && combat.hasFight()) {
                    if (LoaderConfig.ITEM_FRAME_STATUS) {
                        ChatUtil.sendMessage(p, LoaderConfig.ITEM_FRAME_MESSAGE);
                        e.setCancelled(true);
                    }
                }
            }
            if (e.getDamager() instanceof Projectile) {
                if (((Projectile) e.getDamager()).getShooter() instanceof Player) {
                    Player p = (Player) ((Projectile) e.getDamager()).getShooter();
                    final Combat combat = CombatManager.getCombat(p);
                    if (combat != null && combat.hasFight()) {
                        if (LoaderConfig.ITEM_FRAME_STATUS) {
                            ChatUtil.sendMessage(p, LoaderConfig.ITEM_FRAME_MESSAGE);
                            e.getDamager().remove();
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void FrameRotate(PlayerInteractEntityEvent e) {
        final Player p = (Player) e.getPlayer();
        final Combat combat = CombatManager.getCombat(p);
        if (combat != null && combat.hasFight()) {
            Entity entity = e.getRightClicked();
            if(entity instanceof HopperMinecart) {
                if (LoaderConfig.HOPPER_MINECART_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.HOPPER_MINECART_MESSAGE);
                }
            }
            if(entity instanceof StorageMinecart) {
                if (LoaderConfig.STORAGE_MINECART_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.STORAGE_MINECART_MESSAGE);
                }
            }
            if (e.getRightClicked().getType().equals(EntityType.ITEM_FRAME)) {
                if (LoaderConfig.ITEM_FRAME_STATUS) {
                    ChatUtil.sendMessage(p, LoaderConfig.ITEM_FRAME_MESSAGE);
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void open(final PlayerInteractEvent e) {
        final Player p = (Player) e.getPlayer();
        final Combat combat = CombatManager.getCombat(p);
        if (combat != null && combat.hasFight()) {
            if (e.getClickedBlock().getType() == Material.ANVIL) {
                if (LoaderConfig.ANVIL_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.ANVIL_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.BEACON) {
                if (LoaderConfig.BEACON_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.BEACON_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.BREWING_STAND) {
                if (LoaderConfig.BREWING_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.BREWING_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.CHEST) {
                if (LoaderConfig.CHEST_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.CHEST_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.DISPENSER) {
                if (LoaderConfig.DISPENSER_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.DISPENSER_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.DROPPER) {
                if (LoaderConfig.DROPPER_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.DROPPER_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE) {
                if (LoaderConfig.ENCHANTING_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.ENCHANTING_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.ENDER_CHEST) {
                if (LoaderConfig.ENDER_CHEST_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.ENDER_CHEST_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.FURNACE) {
                if (LoaderConfig.FURNACE_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.FURNACE_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.HOPPER) {
                if (LoaderConfig.HOPPER_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.HOPPER_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.WORKBENCH) {
                if (LoaderConfig.WORKBENCH_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.WORKBENCH_MESSAGE);
                }
            }
            if (e.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
                if (LoaderConfig.TRAPPED_CHEST_STATUS) {
                    e.setCancelled(true);
                    ChatUtil.sendMessage(p, LoaderConfig.TRAPPED_CHEST_MESSAGE);
                }
            }
        }
    }

}
