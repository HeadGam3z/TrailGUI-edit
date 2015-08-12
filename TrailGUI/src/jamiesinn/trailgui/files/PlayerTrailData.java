package jamiesinn.trailgui.files;

import jamiesinn.trailgui.Main;

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
	private String uuid;
	
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
		this.uuid = player.getUniqueId().toString();
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
		getFile().addDefault("Enchantment", false);
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
		if (!hasAngryVillager() == value) {
			getFile().set("AngryVillager", value);
		}
		if (value) {
			Main.trailAngryVillager.add(uuid);
		} else {
			Main.trailAngryVillager.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has AngryVillager set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasAngryVillager() {
		return getFile().getBoolean("AngryVillager");
	}
	
	/**
	 * Sets the player's Cloud value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setCloud(boolean value) {
		if (!hasCloud() == value) {
			getFile().set("Cloud", value);
		}
		if (value) {
			Main.trailCloud.add(uuid);
		} else {
			Main.trailCloud.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Cloud set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasCloud() {
		return getFile().getBoolean("Cloud");
	}
	
	/**
	 * Sets the player's Criticals value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setCriticals(boolean value) {
		if (!hasCriticals() == value) {
			getFile().set("Criticals", value);
		}
		if (value) {
			Main.trailCriticals.add(uuid);
		} else {
			Main.trailCriticals.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Criticals set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasCriticals() {
		return getFile().getBoolean("Criticals");
	}
	
	/**
	 * Sets the player's DripLava value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setDripLava(boolean value) {
		if (!hasDripLava() == value) {
			getFile().set("DripLava", value);
		}
		if (value) {
			Main.trailDripLava.add(uuid);
		} else {
			Main.trailDripLava.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has DripLava set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasDripLava() {
		return getFile().getBoolean("DripLava");
	}
	
	/**
	 * Sets the player's DripWater value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setDripWater(boolean value) {
		if (!hasDripWater() == value) {
			getFile().set("DripWater", value);
		}
		if (value) {
			Main.trailDripWater.add(uuid);
		} else {
			Main.trailDripWater.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has DripWater set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasDripWater() {
		return getFile().getBoolean("DripWater");
	}
	
	/**
	 * Sets the player's Spark value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSpark(boolean value) {
		if (!hasSpark() == value) {
			getFile().set("Spark", value);
		}
		if (value) {
			Main.trailSpark.add(uuid);
		} else {
			Main.trailSpark.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Spark set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasSpark() {
		return getFile().getBoolean("Spark");
	}
	
	/**
	 * Sets the player's Flame value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setFlame(boolean value) {
		if (!hasFlame() == value) {
			getFile().set("Flame", value);
		}
		if (value) {
			Main.trailFlame.add(uuid);
		} else {
			Main.trailFlame.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Flame set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasFlame() {
		return getFile().getBoolean("Flame");
	}
	
	/**
	 * Sets the player's HappyVillager value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setHappyVillager(boolean value) {
		if (!hasHappyVillager() == value) {
			getFile().set("HappyVillager", value);
		}
		if (value) {
			Main.trailHappyVillager.add(uuid);
		} else {
			Main.trailHappyVillager.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has HappyVillager set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasHappyVillager() {
		return getFile().getBoolean("HappyVillager");
	}
	
	/**
	 * Sets the player's InstantSpell value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setInstantSpell(boolean value) {
		if (!hasInstantSpell() == value) {
			getFile().set("InstantSpell", value);
		}
		if (value) {
			Main.trailInstantSpell.add(uuid);
		} else {
			Main.trailInstantSpell.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has InstantSpell set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasInstantSpell() {
		return getFile().getBoolean("InstantSpell");
	}
	
	/**
	 * Sets the player's LargeSmoke value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setLargeSmoke(boolean value) {
		if (!hasLargeSmoke() == value) {
			getFile().set("LargeSmoke", value);
		}
		if (value) {
			Main.trailLargeSmoke.add(uuid);
		} else {
			Main.trailLargeSmoke.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has LargeSmoke set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasLargeSmoke() {
		return getFile().getBoolean("LargeSmoke");
	}
	
	/**
	 * Sets the player's Lava value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setLava(boolean value) {
		if (!hasLava() == value) {
			getFile().set("Lava", value);
		}
		if (value) {
			Main.trailLava.add(uuid);
		} else {
			Main.trailLava.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Lava set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasLava() {
		return getFile().getBoolean("Lava");
	}
	
	/**
	 * Sets the player's MagicCrit value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setMagicCrit(boolean value) {
		if (!hasMagicCrit() == value) {
			getFile().set("MagicCrit", value);
		}
		if (value) {
			Main.trailMagicCrit.add(uuid);
		} else {
			Main.trailMagicCrit.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has MagicCrit set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasMagicCrit() {
		return getFile().getBoolean("MagicCrit");
	}
	
	/**
	 * Sets the player's MobSpell value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setMobSpell(boolean value) {
		if (!hasMobSpell() == value) {
			getFile().set("MobSpell", value);
		}
		if (value) {
			Main.trailMobSpell.add(uuid);
		} else {
			Main.trailMobSpell.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has MobSpell set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasMobSpell() {
		return getFile().getBoolean("MobSpell");
	}
	
	/**
	 * Sets the player's MobSpellAmbient value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setMobSpellAmbient(boolean value) {
		if (!hasMobSpellAmbient() == value) {
			getFile().set("MobSpellAmbient", value);
		}
		if (value) {
			Main.trailMobSpellAmbient.add(uuid);
		} else {
			Main.trailMobSpellAmbient.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has MobSpellAmbient set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasMobSpellAmbient() {
		return getFile().getBoolean("MobSpellAmbient");
	}
	
	/**
	 * Sets the player's Note value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setNote(boolean value) {
		if (!hasNote() == value) {
			getFile().set("Note", value);
		}
		if (value) {
			Main.trailNote.add(uuid);
		} else {
			Main.trailNote.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Note set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasNote() {
		return getFile().getBoolean("Note");
	}
	
	/**
	 * Sets the player's Portal value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setPortal(boolean value) {
		if (!hasPortal() == value) {
			getFile().set("Portal", value);
		}
		if (value) {
			Main.trailPortal.add(uuid);
		} else {
			Main.trailPortal.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Portal set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasPortal() {
		return getFile().getBoolean("Portal");
	}
	
	/**
	 * Sets the player's RedDust value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setRedDust(boolean value) {
		if (!hasRedDust() == value) {
			getFile().set("RedDust", value);
		}
		if (value) {
			Main.trailRedDust.add(uuid);
		} else {
			Main.trailRedDust.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has RedDust set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasRedDust() {
		return getFile().getBoolean("RedDust");
	}
	
	/**
	 * Sets the player's ColoredRedDust value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setColoredRedDust(boolean value) {
		if (!hasColoredRedDust() == value) {
			getFile().set("ColoredRedDust", value);
		}
		if (value) {
			Main.trailColoredRedDust.add(uuid);
		} else {
			Main.trailColoredRedDust.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has ColoredRedDust set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasColoredRedDust() {
		return getFile().getBoolean("ColoredRedDust");
	}
	
	/**
	 * Sets the player's Slime value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSlime(boolean value) {
		if (!hasSlime() == value) {
			getFile().set("Slime", value);
		}
		if (value) {
			Main.trailSlime.add(uuid);
		} else {
			Main.trailSlime.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Slime set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasSlime() {
		return getFile().getBoolean("Slime");
	}
	
	/**
	 * Sets the player's SnowShovel value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSnowShovel(boolean value) {
		if (!hasSnowShovel() == value) {
			getFile().set("SnowShovel", value);
		}
		if (value) {
			Main.trailSnowShovel.add(uuid);
		} else {
			Main.trailSnowShovel.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has SnowShovel set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasSnowShovel() {
		return getFile().getBoolean("SnowShovel");
	}
	
	/**
	 * Sets the player's SnowballPoof value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSnowballPoof(boolean value) {
		if (!hasSnowballPoof() == value) {
			getFile().set("SnowballPoof", value);
		}
		if (value) {
			Main.trailSnowballPoof.add(uuid);
		} else {
			Main.trailSnowballPoof.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has SnowballPoof set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasSnowballPoof() {
		return getFile().getBoolean("SnowballPoof");
	}
	
	/**
	 * Sets the player's Spell value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSpell(boolean value) {
		if (!hasSpell() == value) {
			getFile().set("Spell", value);
		}
		if (value) {
			Main.trailSpell.add(uuid);
		} else {
			Main.trailSpell.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Spell set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasSpell() {
		return getFile().getBoolean("Spell");
	}
	
	/**
	 * Sets the player's Splash value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setSplash(boolean value) {
		if (!hasSplash() == value) {
			getFile().set("Splash", value);
		}
		if (value) {
			Main.trailSplash.add(uuid);
		} else {
			Main.trailSplash.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Splash set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasSplash() {
		return getFile().getBoolean("Splash");
	}
	
	/**
	 * Sets the player's TownAura value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setTownAura(boolean value) {
		if (!hasTownAura() == value) {
			getFile().set("TownAura", value);
		}
		if (value) {
			Main.trailTownAura.add(uuid);
		} else {
			Main.trailTownAura.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has TownAura set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasTownAura() {
		return getFile().getBoolean("TownAura");
	}
	
	/**
	 * Sets the player's Wake value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setWake(boolean value) {
		if (!hasWake() == value) {
			getFile().set("Wake", value);
		}
		if (value) {
			Main.trailWake.add(uuid);
		} else {
			Main.trailWake.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Wake set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasWake() {
		return getFile().getBoolean("Wake");
	}
	
	/**
	 * Sets the player's WitchMagic value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setWitchMagic(boolean value) {
		if (!hasWitchMagic() == value) {
			getFile().set("WitchMagic", value);
		}
		if (value) {
			Main.trailWitchMagic.add(uuid);
		} else {
			Main.trailWitchMagic.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has WitchMagic set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasWitchMagic() {
		return getFile().getBoolean("WitchMagic");
	}
	
	/**
	 * Sets the player's Hearts value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setHearts(boolean value) {
		if (!hasHearts() == value) {
			getFile().set("Hearts", value);
		}
		if (value) {
			Main.trailHearts.add(uuid);
		} else {
			Main.trailHearts.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Hearts set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasHearts() {
		return getFile().getBoolean("Hearts");
	}
	
	/**
	 * Sets the player's EnderSignal value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setEnderSignal(boolean value) {
		if (!hasEnderSignal() == value) {
			getFile().set("EnderSignal", value);
		}
		if (value) {
			Main.trailEnderSignal.add(uuid);
		} else {
			Main.trailEnderSignal.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has EnderSignal set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasEnderSignal() {
		return getFile().getBoolean("EnderSignal");
	}
	
	/**
	 * Sets the player's IconCrack value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setIconCrack(boolean value) {
		if (!hasIconCrack() == value) {
			getFile().set("IconCrack", value);
		}
		if (value) {
			Main.trailIconCrack.add(uuid);
		} else {
			Main.trailIconCrack.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has IconCrack set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasIconCrack() {
		return getFile().getBoolean("IconCrack");
	}
	
	/**
	 * Sets the player's BlockBreak value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setBlockBreak(boolean value) {
		if (!hasBlockBreak() == value) {
			getFile().set("BlockBreak", value);
		}
		if (value) {
			Main.trailBlockBreak.add(uuid);
		} else {
			Main.trailBlockBreak.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has BlockBreak set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasBlockBreak() {
		return getFile().getBoolean("BlockBreak");
	}
	
	/**
	 * Sets the player's Enchantment value.
	 * 
	 * @param value true or false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public void setEnchantment(boolean value) {
		if (!hasEnchantment() == value) {
			getFile().set("Enchantment", value);
		}
		if (value) {
			Main.trailEnchantment.add(uuid);
		} else {
			Main.trailEnchantment.remove(uuid);
		}
	}
	
	/**
	 * Checks if the player has Enchantment set to true.
	 * 
	 * @return true if true, otherwise false
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public boolean hasEnchantment() {
		return getFile().getBoolean("Enchantment");
	}
	
}
