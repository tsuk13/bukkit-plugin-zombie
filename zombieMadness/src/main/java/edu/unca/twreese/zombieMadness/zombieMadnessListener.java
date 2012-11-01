package edu.unca.twreese.zombieMadness;

import java.text.MessageFormat;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/*
 * This is a sample event listener
 */
public class zombieMadnessListener implements Listener {
    private final zombieMadness plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public zombieMadnessListener(zombieMadness plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }

    /*
     * Send the sample message to all players that join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.zombieMap.put(event.getPlayer(), false);
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        final EntityType entityType = event.getRightClicked().getType();
        if(entityType.getTypeId() == EntityType.PLAYER.getTypeId()){
        	if(plugin.zombieMap.get(event.getPlayer())){
        		Player p = (Player)event.getRightClicked();
        		plugin.zombieMap.put(p, true);
                p.sendMessage("You are now a zombie! Go forth and eat brains!");
                p.setDisplayName("ZOMBIE!!!!");
                event.getPlayer().setFoodLevel(20);
                event.getPlayer().sendMessage("You Feasted");
        	}	
        }
     }
}

