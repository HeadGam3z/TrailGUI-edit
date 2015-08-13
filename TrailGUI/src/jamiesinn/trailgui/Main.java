package jamiesinn.trailgui;

import jamiesinn.trailgui.commands.TrailGUI;
import jamiesinn.trailgui.commands.Trails;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main main;
	public static List<String> trailAngryVillager = new ArrayList<String>();
	public static List<String> trailCloud = new ArrayList<String>();
	public static List<String> trailCriticals = new ArrayList<String>();
	public static List<String> trailDripLava = new ArrayList<String>();
	public static List<String> trailDripWater = new ArrayList<String>();
	public static List<String> trailEnchantment = new ArrayList<String>();
	public static List<String> trailSpark = new ArrayList<String>();
	public static List<String> trailFlame = new ArrayList<String>();
	public static List<String> trailHappyVillager = new ArrayList<String>();
	public static List<String> trailInstantSpell = new ArrayList<String>();
	public static List<String> trailLargeSmoke = new ArrayList<String>();
	public static List<String> trailLava = new ArrayList<String>();
	public static List<String> trailMagicCrit = new ArrayList<String>();
	public static List<String> trailMobSpell = new ArrayList<String>();
	public static List<String> trailMobSpellAmbient = new ArrayList<String>();
	public static List<String> trailNote = new ArrayList<String>();
	public static List<String> trailPortal = new ArrayList<String>();
	public static List<String> trailRedDust = new ArrayList<String>();
	public static List<String> trailColoredRedDust = new ArrayList<String>();
	public static List<String> trailSlime = new ArrayList<String>();
	public static List<String> trailSnowShovel = new ArrayList<String>();
	public static List<String> trailSnowballPoof = new ArrayList<String>();
	public static List<String> trailSpell = new ArrayList<String>();
	public static List<String> trailSplash = new ArrayList<String>();
	public static List<String> trailTownAura = new ArrayList<String>();
	public static List<String> trailWake = new ArrayList<String>();
	public static List<String> trailWitchMagic = new ArrayList<String>();
	public static List<String> trailHearts = new ArrayList<String>();
	public static List<String> trailEnderSignal = new ArrayList<String>();
	public static List<String> trailIconCrack = new ArrayList<String>();
	public static List<String> trailBlockBreak = new ArrayList<String>();

	public static Main getPlugin() {
		return main;
	}
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getCommand("Trails").setExecutor(new Trails(this));
		getCommand("TrailGUI").setExecutor(new TrailGUI(this));
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		main = this;
	}

	@Override
	public void onDisable() {
		main = null;
	}
	
}