package dev.newplaces.npcore.events;

import org.bukkit.Material;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class BlockPlace extends BlockListener {
    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
        if (isChecked(event.getBlock().getType())) {
            event.setCancelled(true);
            event.getPlayer().sendRawMessage("&cЭтот блок не разрешен!".replace("&", "§"));
            PlayerInventory inventory = event.getPlayer().getInventory();
            for (ItemStack itemStack : inventory.getContents()) {
                if (itemStack != null) {
                    if (isChecked(itemStack.getType())) {
                        inventory.remove(itemStack);
                    }
                }
            }
        }
    }
    private boolean isChecked(Material material) {
        switch (material) {
            case BEDROCK:
            case PORTAL:
            case WATER:
            case LAVA:
            case MOB_SPAWNER:
            case FIRE:
            case LOCKED_CHEST:
                return true;
        }
        return false;
    }
}
