package jamiesinn.trailgui.commands;

import jamiesinn.trailgui.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TrailGUI implements CommandExecutor {
	
	private Main main;

	public TrailGUI(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("TrailGUI")) {
			if (args[0].equalsIgnoreCase("ReloadConfigs")) {
				if (!sender.hasPermission("trailgui.commands.reloadconfigs")) {
					sender.sendMessage(getMessage("Commands-denyPermissionMessage"));
					return false;
				}
				main.reloadConfig();
				sender.sendMessage(ChatColor.DARK_GRAY + "["
							+ ChatColor.RED + "TrailGUI" + ChatColor.DARK_GRAY
							+ "]: " + ChatColor.GREEN
							+ "Successfully reloaded config file.");
				return true;
			}
		}
		return false;
	}

	/**
	 * Shorter way to get a message from the config.
	 * 
	 * @param path to the message
	 * @return the message
	 * @author Jesse McCullough (headGam3z)
	 */
	private String getMessage(String path) {
		String msg = main.getConfig().getString(path);
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
}