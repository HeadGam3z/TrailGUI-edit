package jamiesinn.trailgui.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 * TrailGUI-edit's player trail data.
 * 
 * @author Jesse McCullough (HeadGam3z)
 */
public class PlayerTrailData {
	
	private File srcFolder, dataFolder, file;
	private FileConfiguration fileConfig;
	
	/**
	 * Creates a player trail data (ptd) file for the player in the data directory.
	 * 
	 * @param player the player you're making a ptd file for.
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public PlayerTrailData(Player player) {
		this.srcFolder = new File("plugins" + File.separator + "TrailGUI");
		this.dataFolder = new File(srcFolder, "data");
		this.file = new File(dataFolder, player.getUniqueId() + ".ptd"); // clever, right? player trail data (.ptd)
		this.fileConfig = YamlConfiguration.loadConfiguration(file);
		this.addDefaultValues();
	}
	
	/**
	 * Adds default values to the player's ptd file.
	 * 
	 * @author Jesse McCullough (HeadGam3z)
	 */
	private void addDefaultValues() {
		getFile().addDefault("AngryVillager", false);
		getFile().addDefault("Cloud", false);
		getFile().addDefault("Criticals", false);
		getFile().addDefault("DripLava", false);
		getFile().addDefault("DripWater", false);
		getFile().addDefault("Spark", false);
		getFile().addDefault("Spark", false);
		getFile().addDefault("Flame", false);
		getFile().addDefault("HappyVillager", false);
		getFile().addDefault("InstantSpell", false);
		getFile().addDefault("LargeSmoke", false);
		getFile().addDefault("Lava", false);
		getFile().addDefault("MagicCrit", false);
		getFile().addDefault("MobSpell", false);
		getFile().addDefault("MobSpellAmbient", false);
		getFile().addDefault("Note", false);
		getFile().addDefault("Portal", false);
		getFile().addDefault("RedDust", false);
		getFile().addDefault("ColoredRedDust", false);
		getFile().addDefault("Slime", false);
		getFile().addDefault("SnowShovel", false);
		getFile().addDefault("SnowballPoof", false);
		getFile().addDefault("Spell", false);
		getFile().addDefault("Splash", false);
		getFile().addDefault("TownAura", false);
		getFile().addDefault("Wake", false);
		getFile().addDefault("WitchMagic", false);
		getFile().addDefault("Hearts", false);
		getFile().addDefault("EnderSignal", false);
		getFile().addDefault("IconCrack", false);
		getFile().addDefault("BlockBreak", false);
	}
	
	/**
	 * Gets the file.
	 * 
	 * @return the file
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public FileConfiguration getFile() {
		if (fileConfig == null) {
			reloadFile();
		}
		return fileConfig;
	}
	
	/**
	 * Saves the file.
	 * 
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void saveFile() {
		if (fileConfig == null) {
			reloadFile();
		}
		try {
			fileConfig.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reloads the file.
	 *
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void reloadFile() {
		if (!srcFolder.exists()) {
			srcFolder.mkdir();
		}
		if (!dataFolder.exists()) {
			dataFolder.mkdir();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		fileConfig = YamlConfiguration.loadConfiguration(file);
	}

	/**
	 * Sets the player's AngryVillager value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setAngryVillager(boolean value) {
		getFile().set("AngryVillager", value);
	}
	
	/**
	 * Gets the player's AngryVillager value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getAngryVillager() {
		return getFile().getBoolean("AngryVillager");
	}
	
	/**
	 * Sets the player's Cloud value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setCloud(boolean value) {
		getFile().set("Cloud", value);
	}
	
	/**
	 * Gets the player's Cloud value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getCloud() {
		return getFile().getBoolean("Cloud");
	}
	
	/**
	 * Sets the player's Criticals value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setCriticals(boolean value) {
		getFile().set("Criticals", value);
	}
	
	/**
	 * Gets the player's Criticals value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getCriticals() {
		return getFile().getBoolean("Criticals");
	}
	
	/**
	 * Sets the player's DripLava value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setDripLava(boolean value) {
		getFile().set("DripLava", value);
	}
	
	/**
	 * Gets the player's DripLava value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getDripLava() {
		return getFile().getBoolean("DripLava");
	}
	
	/**
	 * Sets the player's DripWater value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setDripWater(boolean value) {
		getFile().set("DripWater", value);
	}
	
	/**
	 * Gets the player's DripWater value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getDripWater() {
		return getFile().getBoolean("DripWater");
	}
	
	/**
	 * Sets the player's Spark value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSpark(boolean value) {
		getFile().set("Spark", value);
	}
	
	/**
	 * Gets the player's Spark value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getSpark() {
		return getFile().getBoolean("Spark");
	}
	
	/**
	 * Sets the player's Flame value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setFlame(boolean value) {
		getFile().set("Flame", value);
	}
	
	/**
	 * Gets the player's Flame value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getFlame() {
		return getFile().getBoolean("Flame");
	}
	
	/**
	 * Sets the player's HappyVillager value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setHappyVillager(boolean value) {
		getFile().set("HappyVillager", value);
	}
	
	/**
	 * Gets the player's HappyVillager value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getHappyVillager() {
		return getFile().getBoolean("HappyVillager");
	}
	
	/**
	 * Sets the player's InstantSpell value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setInstantSpell(boolean value) {
		getFile().set("InstantSpell", value);
	}
	
	/**
	 * Gets the player's InstantSpell value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getInstantSpell() {
		return getFile().getBoolean("InstantSpell");
	}
	
	/**
	 * Sets the player's LargeSmoke value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setLargeSmoke(boolean value) {
		getFile().set("LargeSmoke", value);
	}
	
	/**
	 * Gets the player's LargeSmoke value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getLargeSmoke() {
		return getFile().getBoolean("LargeSmoke");
	}
	
	/**
	 * Sets the player's Lava value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setLava(boolean value) {
		getFile().set("Lava", value);
	}
	
	/**
	 * Gets the player's Lava value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getLava() {
		return getFile().getBoolean("Lava");
	}
	
	/**
	 * Sets the player's MagicCrit value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setMagicCrit(boolean value) {
		getFile().set("MagicCrit", value);
	}
	
	/**
	 * Gets the player's MagicCrit value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getMagicCrit() {
		return getFile().getBoolean("MagicCrit");
	}
	
	/**
	 * Sets the player's MobSpell value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setMobSpell(boolean value) {
		getFile().set("MobSpell", value);
	}
	
	/**
	 * Gets the player's MobSpell value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getMobSpell() {
		return getFile().getBoolean("MobSpell");
	}
	
	/**
	 * Sets the player's MobSpellAmbient value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setMobSpellAmbient(boolean value) {
		getFile().set("MobSpellAmbient", value);
	}
	
	/**
	 * Gets the player's MobSpellAmbient value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getMobSpellAmbient() {
		return getFile().getBoolean("MobSpellAmbient");
	}
	
	/**
	 * Sets the player's Note value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setNote(boolean value) {
		getFile().set("Note", value);
	}
	
	/**
	 * Gets the player's Note value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getNote() {
		return getFile().getBoolean("Note");
	}
	
	/**
	 * Sets the player's Portal value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setPortal(boolean value) {
		getFile().set("Portal", value);
	}
	
	/**
	 * Gets the player's Portal value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getPortal() {
		return getFile().getBoolean("Portal");
	}
	
	/**
	 * Sets the player's RedDust value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setRedDust(boolean value) {
		getFile().set("RedDust", value);
	}
	
	/**
	 * Gets the player's RedDust value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getRedDust() {
		return getFile().getBoolean("RedDust");
	}
	
	/**
	 * Sets the player's ColoredRedDust value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setColoredRedDust(boolean value) {
		getFile().set("ColoredRedDust", value);
	}
	
	/**
	 * Gets the player's ColoredRedDust value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getColoredRedDust() {
		return getFile().getBoolean("ColoredRedDust");
	}
	
	/**
	 * Sets the player's Slime value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSlime(boolean value) {
		getFile().set("Slime", value);
	}
	
	/**
	 * Gets the player's Slime value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getSlime() {
		return getFile().getBoolean("Slime");
	}
	
	/**
	 * Sets the player's SnowShovel value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSnowShovel(boolean value) {
		getFile().set("SnowShovel", value);
	}
	
	/**
	 * Gets the player's SnowShovel value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getSnowShovel() {
		return getFile().getBoolean("SnowShovel");
	}
	
	/**
	 * Sets the player's SnowballPoof value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSnowballPoof(boolean value) {
		getFile().set("SnowballPoof", value);
	}
	
	/**
	 * Gets the player's SnowballPoof value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getSnowballPoof() {
		return getFile().getBoolean("SnowballPoof");
	}
	
	/**
	 * Sets the player's Spell value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSpell(boolean value) {
		getFile().set("Spell", value);
	}
	
	/**
	 * Gets the player's Spell value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getSpell() {
		return getFile().getBoolean("Spell");
	}
	
	/**
	 * Sets the player's Splash value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSplash(boolean value) {
		getFile().set("Splash", value);
	}
	
	/**
	 * Gets the player's Splash value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getSplash() {
		return getFile().getBoolean("Splash");
	}
	
	/**
	 * Sets the player's TownAura value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setTownAura(boolean value) {
		getFile().set("TownAura", value);
	}
	
	/**
	 * Gets the player's TownAura value.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean getTownAura() {
		return getFile().getBoolean("TownAura");
	}
	
}
