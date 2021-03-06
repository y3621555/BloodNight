package de.eldoria.bloodnight.command;

import de.eldoria.bloodnight.command.bloodnight.About;
import de.eldoria.bloodnight.command.bloodnight.CancelNight;
import de.eldoria.bloodnight.command.bloodnight.ForceNight;
import de.eldoria.bloodnight.command.bloodnight.Help;
import de.eldoria.bloodnight.command.bloodnight.ManageMob;
import de.eldoria.bloodnight.command.bloodnight.ManageMobs;
import de.eldoria.bloodnight.command.bloodnight.ManageNight;
import de.eldoria.bloodnight.command.bloodnight.ManageNightSelection;
import de.eldoria.bloodnight.command.bloodnight.ManageWorlds;
import de.eldoria.bloodnight.command.bloodnight.Reload;
import de.eldoria.bloodnight.command.bloodnight.SpawnMob;
import de.eldoria.bloodnight.config.Configuration;
import de.eldoria.bloodnight.core.manager.MobManager;
import de.eldoria.bloodnight.core.manager.NightManager;
import de.eldoria.eldoutilities.simplecommands.EldoCommand;
import org.bukkit.plugin.Plugin;

public class BloodNightCommand extends EldoCommand {

	public BloodNightCommand(Configuration configuration, Plugin plugin,
	                         NightManager nightManager, MobManager mobManager, InventoryListener inventoryListener) {
		super(plugin);
		Help help = new Help(plugin);
		setDefaultCommand(help);
		registerCommand("help", help);
		registerCommand("about", new About(plugin));
		registerCommand("spawnMob", new SpawnMob(plugin, nightManager, mobManager));
		registerCommand("cancelNight", new CancelNight(plugin, nightManager, configuration));
		registerCommand("forceNight", new ForceNight(plugin, nightManager, configuration));
		registerCommand("manageWorlds", new ManageWorlds(plugin, configuration));
		registerCommand("manageMob", new ManageMob(plugin, configuration, inventoryListener));
		registerCommand("manageNight", new ManageNight(plugin, configuration));
		registerCommand("manageMobs", new ManageMobs(plugin, configuration, inventoryListener));
		registerCommand("nightSelection", new ManageNightSelection(plugin, configuration, inventoryListener));
		registerCommand("reload", new Reload(plugin));
	}
}
