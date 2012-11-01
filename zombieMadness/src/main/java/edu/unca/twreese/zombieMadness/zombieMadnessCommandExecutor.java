package edu.unca.twreese.zombieMadness;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.base.Joiner;

/*
 * This is a sample CommandExectuor
 */
public class zombieMadnessCommandExecutor implements CommandExecutor {
    private final zombieMadness plugin;

    /*
     * This command executor needs to know about its plugin from which it came from
     */
    public zombieMadnessCommandExecutor(zombieMadness plugin) {
        this.plugin = plugin;
    }

    /*
     * On command set the sample message
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (!(sender instanceof Player))
    		return false;
        if (args.length > 0) {
            Player p = (Player) sender;
            plugin.zombieMap.put(p, true);
            p.sendMessage("You are now a zombie! Go forth and eat brains!");
            p.setDisplayName("ZOMBIE!!!!");
            return true;
        } else {
            return false;
        }
    }

}
