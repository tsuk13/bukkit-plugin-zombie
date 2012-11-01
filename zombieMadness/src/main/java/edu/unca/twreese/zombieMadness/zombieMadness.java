package edu.unca.twreese.zombieMadness;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * This is the main class of the sample plug-in
 */
public class zombieMadness extends JavaPlugin {
	HashMap<Player, Boolean> zombieMap = new HashMap<Player, Boolean>();
    /*
     * This is called when your plug-in is enabled
     */
    @Override
    public void onEnable() {
        // save the configuration file
        saveDefaultConfig();
        
        // Create the SampleListener
        new zombieMadnessListener(this);
        
        // set the command executor for sample
        this.getCommand("zombie").setExecutor(new zombieMadnessCommandExecutor(this));
    }
    
    /*
     * This is called when your plug-in shuts down
     */
    @Override
    public void onDisable() {
        
    }

}
