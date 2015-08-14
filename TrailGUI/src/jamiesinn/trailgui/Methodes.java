package jamiesinn.trailgui;

import jamiesinn.trailgui.files.PlayerTrailData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Methodes {
	
	/**
	 * Clears a player's trails.
	 * 
	 * @param player the player
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public static void clearTrails(Player player) {
		PlayerTrailData playerEffects = new PlayerTrailData(player);
		playerEffects.setAngryVillager(false);
		playerEffects.setCloud(false);
		playerEffects.setColoredRedDust(false);
		playerEffects.setCriticals(false);
		playerEffects.setDripLava(false);
		playerEffects.setDripWater(false);
		playerEffects.setEnchantment(false);
		playerEffects.setEnderSignal(false);
		playerEffects.setFlame(false);
		playerEffects.setHappyVillager(false);
		playerEffects.setHearts(false);
		playerEffects.setIconCrack(false);
		playerEffects.setInstantSpell(false);
		playerEffects.setLargeSmoke(false);
		playerEffects.setLava(false);
		playerEffects.setMagicCrit(false);
		playerEffects.setMobSpell(false);
		playerEffects.setMobSpellAmbient(false);
		playerEffects.setNote(false);
		playerEffects.setPortal(false);
		playerEffects.setRedDust(false);
		playerEffects.setSlime(false);
		playerEffects.setSnowballPoof(false);
		playerEffects.setSnowShovel(false);
		playerEffects.setSpark(false);
		playerEffects.setSpell(false);
		playerEffects.setSplash(false);
		playerEffects.setTownAura(false);
		playerEffects.setWake(false);
		playerEffects.setWitchMagic(false);
		playerEffects.saveFile();
	}

	/**
	 * Restores a player's trails from their ptd file.
	 * 
	 * @param player the player
	 * @author Jesse McCullough (HeadGam3z)
	 */
	public static void restoreTrails(Player player) {
		PlayerTrailData playerEffects = new PlayerTrailData(player);
		if (playerEffects.hasAngryVillager()) {
			playerEffects.setAngryVillager(true);
		}
		if (playerEffects.hasBlockBreak()) {
			playerEffects.setBlockBreak(true);
		}
		if (playerEffects.hasCloud()) {
			playerEffects.setCloud(true);
		}
		if (playerEffects.hasColoredRedDust()) {
			playerEffects.setColoredRedDust(true);
		}
		if (playerEffects.hasCriticals()) {
			playerEffects.setCriticals(true);
		}
		if (playerEffects.hasDripLava()) {
			playerEffects.setDripLava(true);
		}
		if (playerEffects.hasDripWater()) {
			playerEffects.setDripWater(true);
		}
		if (playerEffects.hasEnderSignal()) {
			playerEffects.setEnderSignal(true);
		}
		if (playerEffects.hasFlame()) {
			playerEffects.setFlame(true);
		}
		if (playerEffects.hasHappyVillager()) {
			playerEffects.setHappyVillager(true);
		}
		if (playerEffects.hasHearts()) {
			playerEffects.setHearts(true);
		}
		if (playerEffects.hasIconCrack()) {
			playerEffects.setIconCrack(true);
		}
		if (playerEffects.hasInstantSpell()) {
			playerEffects.setInstantSpell(true);
		}
		if (playerEffects.hasLargeSmoke()) {
			playerEffects.setLargeSmoke(true);
		}
		if (playerEffects.hasLava()) {
			playerEffects.setLava(true);
		}
		if (playerEffects.hasMagicCrit()) {
			playerEffects.setMagicCrit(true);
		}
		if (playerEffects.hasMobSpell()) {
			playerEffects.setMobSpell(true);
		}
		if (playerEffects.hasMobSpellAmbient()) {
			playerEffects.setMobSpellAmbient(true);
		}
		if (playerEffects.hasNote()) {
			playerEffects.setNote(true);
		}
		if (playerEffects.hasPortal()) {
			playerEffects.setPortal(true);
		}
		if (playerEffects.hasRedDust()) {
			playerEffects.setRedDust(true);
		}
		if (playerEffects.hasSlime()) {
			playerEffects.setSlime(true);
		}
		if (playerEffects.hasSnowballPoof()) {
			playerEffects.setSnowballPoof(true);
		}
		if (playerEffects.hasSnowShovel()) {
			playerEffects.setSnowShovel(true);
		}
		if (playerEffects.hasSpark()) {
			playerEffects.setSpark(true);
		}
		if (playerEffects.hasSpell()) {
			playerEffects.setSpell(true);
		}
		if (playerEffects.hasSplash()) {
			playerEffects.setSplash(true);
		}
		if (playerEffects.hasTownAura()) {
			playerEffects.setTownAura(true);
		}
		if (playerEffects.hasWake()) {
			playerEffects.setWake(true);
		}
		if (playerEffects.hasWitchMagic()) {
			playerEffects.setWitchMagic(true);
		}
		if (playerEffects.hasEnchantment()) {
			playerEffects.setEnchantment(true);
		}
		playerEffects.saveFile();
	}
		

	public static boolean checkPerms(String trail, Player p) {
		return p.hasPermission("trailgui.inventory." + trail);
	}

	public static void openGUI1(Player player) {
		Inventory inv1 = Bukkit.createInventory(null, 45,
				Main.getPlugin().getConfig().getString("pageOneInventoryName")
						.replaceAll("&", "§"));

		if (checkPerms("angryvillager", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("AngryVillager-inventorySlot"),
					itemAngryVillager());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("AngryVillager-inventorySlot"),
					itemNoPerms());
		if (checkPerms("cloud", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Cloud-inventorySlot"),
					itemCloud());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Cloud-inventorySlot"),
					itemNoPerms());
		if (checkPerms("criticals", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("Criticals-inventorySlot"), itemCriticals());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("Criticals-inventorySlot"), itemNoPerms());
		if (checkPerms("driplava", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("DripLava-inventorySlot"), itemDripLava());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("DripLava-inventorySlot"), itemNoPerms());
		if (checkPerms("dripwater", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("DripWater-inventorySlot"), itemDripWater());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("DripWater-inventorySlot"), itemNoPerms());
		if (checkPerms("enchantment", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("Enchantment-inventorySlot"),
					itemEnchantment());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("Enchantment-inventorySlot"), itemNoPerms());
		if (checkPerms("spark", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Spark-inventorySlot"),
					itemSpark());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Spark-inventorySlot"),
					itemNoPerms());
		if (checkPerms("flame", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Flame-inventorySlot"),
					itemFlame());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Flame-inventorySlot"),
					itemNoPerms());
		if (checkPerms("happyvillager", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("HappyVillager-inventorySlot"),
					itemHappyVillager());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("HappyVillager-inventorySlot"),
					itemNoPerms());
		if (checkPerms("instantspell", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("InstantSpell-inventorySlot"),
					itemInstantSpell());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("InstantSpell-inventorySlot"),
					itemNoPerms());
		if (checkPerms("largesmoke", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("LargeSmoke-inventorySlot"),
					itemLargeSmoke());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("LargeSmoke-inventorySlot"), itemNoPerms());
		if (checkPerms("lava", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Lava-inventorySlot"),
					itemLava());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Lava-inventorySlot"),
					itemNoPerms());
		if (checkPerms("magiccrit", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("MagicCrit-inventorySlot"), itemMagicCrit());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("MagicCrit-inventorySlot"), itemNoPerms());
		if (checkPerms("mobspell", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("MobSpell-inventorySlot"), itemMobSpell());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("MobSpell-inventorySlot"), itemNoPerms());
		if (checkPerms("mobspellambient", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("MobSpellAmbient-inventorySlot"),
					itemMobSpellAmbient());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("MobSpellAmbient-inventorySlot"),
					itemNoPerms());
		if (checkPerms("note", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Note-inventorySlot"),
					itemNote());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Note-inventorySlot"),
					itemNoPerms());
		if (checkPerms("portal", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Portal-inventorySlot"),
					itemPortal());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Portal-inventorySlot"),
					itemNoPerms());
		if (checkPerms("reddust", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("RedDust-inventorySlot"), itemRedDust());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("RedDust-inventorySlot"), itemNoPerms());
		if (checkPerms("coloredreddust", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("ColoredRedDust-inventorySlot"),
					itemColoredRedDust());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("ColoredRedDust-inventorySlot"),
					itemNoPerms());
		if (checkPerms("slime", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Slime-inventorySlot"),
					itemSlime());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Slime-inventorySlot"),
					itemNoPerms());
		if (checkPerms("snowshovel", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("SnowShovel-inventorySlot"),
					itemSnowShovel());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("SnowShovel-inventorySlot"), itemNoPerms());
		if (checkPerms("snowballpoof", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("SnowballPoof-inventorySlot"),
					itemSnowballPoof());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("SnowballPoof-inventorySlot"),
					itemNoPerms());
		if (checkPerms("spell", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Spell-inventorySlot"),
					itemSpell());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Spell-inventorySlot"),
					itemNoPerms());
		if (checkPerms("splash", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Splash-inventorySlot"),
					itemSplash());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Splash-inventorySlot"),
					itemNoPerms());
		if (checkPerms("townaura", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("TownAura-inventorySlot"), itemTownAura());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("TownAura-inventorySlot"), itemNoPerms());
		if (checkPerms("wake", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Wake-inventorySlot"),
					itemWake());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Wake-inventorySlot"),
					itemNoPerms());
		if (checkPerms("witchmagic", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("WitchMagic-inventorySlot"),
					itemWitchMagic());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("WitchMagic-inventorySlot"), itemNoPerms());
		if (checkPerms("hearts", player))
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Hearts-inventorySlot"),
					itemHearts());
		else
			inv1.setItem(
					Main.getPlugin().getConfig().getInt("Hearts-inventorySlot"),
					itemNoPerms());
		if (checkPerms("endersignal", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("EnderSignal-inventorySlot"),
					itemEnderSignal());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("EnderSignal-inventorySlot"), itemNoPerms());
		if (checkPerms("iconcrack", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("IconCrack-inventorySlot"), itemIconCrack());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("IconCrack-inventorySlot"), itemNoPerms());
		if (checkPerms("blockbreak", player))
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("BlockBreak-inventorySlot"),
					itemBlockBreak());
		else
			inv1.setItem(
					Main.getPlugin().getConfig()
							.getInt("BlockBreak-inventorySlot"), itemNoPerms());

		inv1.setItem(
				Main.getPlugin().getConfig()
						.getInt("RemoveTrails-inventorySlot"),
				itemRemoveTrails());

		player.openInventory(inv1);
	}

	public static void openGUI2(Player player) {
		Inventory inv2 = Bukkit.createInventory(null, 45,
				Main.getPlugin().getConfig().getString("pageTwoInventoryName")
						.replaceAll("&", "§"));

		inv2.setItem(
				Main.getPlugin().getConfig()
						.getInt("RemoveTrails-inventorySlot"),
				itemRemoveTrails());
		inv2.setItem(
				Main.getPlugin().getConfig()
						.getInt("PreviousPage-inventorySlot"),
				itemPreviousPage());

		player.openInventory(inv2);
	}

	// region Item's for Inventory Slots
	public static ItemStack itemNoPerms() {
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "You do not have this trail!");
		i.setItemMeta(meta);
		return i;

	}

	public static ItemStack itemAngryVillager() {
		ItemStack itemAngryVillager = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("AngryVillager-itemType")
				.toUpperCase()), 1);
		ItemMeta metaAngryVillager = itemAngryVillager.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("AngryVillager-itemName");
		String name2 = name1.replaceAll("&", "§");

		metaAngryVillager.setDisplayName(name2);
		if (Main.getPlugin().getConfig()
				.getBoolean("AngryVillager-loreEnabled")) {
			List<String> loreAngryVillager = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("AngryVillager-loreLineOne")
					.replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("AngryVillager-loreLineTwo")
					.replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("AngryVillager-loreLineThree")
					.replaceAll("&", "§");

			loreAngryVillager.add(loreLine1);
			loreAngryVillager.add(loreLine2);
			loreAngryVillager.add(loreLine3);

			metaAngryVillager.setLore(loreAngryVillager);
		}
		itemAngryVillager.setItemMeta(metaAngryVillager);
		return itemAngryVillager;
	}

	public static ItemStack itemCloud() {
		ItemStack itemCloud = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Cloud-itemType").toUpperCase()), 1);
		ItemMeta metaCloud = itemCloud.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Cloud-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Cloud-loreEnabled")) {
			List<String> loreCloud = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Cloud-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Cloud-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Cloud-loreLineThree").replaceAll("&", "§");

			loreCloud.add(loreLine1);
			loreCloud.add(loreLine2);
			loreCloud.add(loreLine3);

			metaCloud.setLore(loreCloud);
		}
		metaCloud.setDisplayName(name2);
		itemCloud.setItemMeta(metaCloud);
		return itemCloud;
	}

	public static ItemStack itemCriticals() {
		ItemStack itemCriticals = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("Criticals-itemType")
				.toUpperCase()), 1);
		ItemMeta metaCriticals = itemCriticals.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("Criticals-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Criticals-loreEnabled")) {
			List<String> loreCriticals = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Criticals-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Criticals-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Criticals-loreLineThree").replaceAll("&", "§");

			loreCriticals.add(loreLine1);
			loreCriticals.add(loreLine2);
			loreCriticals.add(loreLine3);

			metaCriticals.setLore(loreCriticals);
		}
		metaCriticals.setDisplayName(name2);
		itemCriticals.setItemMeta(metaCriticals);
		return itemCriticals;
	}

	public static ItemStack itemDripLava() {
		ItemStack itemDripLava = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("DripLava-itemType")
				.toUpperCase()), 1);
		ItemMeta metaDripLava = itemDripLava.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("DripLava-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("DripLava-loreEnabled")) {
			List<String> loreDripLava = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("DripLava-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("DripLava-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("DripLava-loreLineThree").replaceAll("&", "§");

			loreDripLava.add(loreLine1);
			loreDripLava.add(loreLine2);
			loreDripLava.add(loreLine3);

			metaDripLava.setLore(loreDripLava);
		}
		metaDripLava.setDisplayName(name2);
		itemDripLava.setItemMeta(metaDripLava);
		return itemDripLava;
	}

	public static ItemStack itemDripWater() {
		ItemStack itemDripWater = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("DripWater-itemType")
				.toUpperCase()), 1);
		ItemMeta metaDripWater = itemDripWater.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("DripWater-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("DripWater-loreEnabled")) {
			List<String> loreDripWater = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("DripWater-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("DripWater-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("DripWater-loreLineThree").replaceAll("&", "§");

			loreDripWater.add(loreLine1);
			loreDripWater.add(loreLine2);
			loreDripWater.add(loreLine3);

			metaDripWater.setLore(loreDripWater);
		}
		metaDripWater.setDisplayName(name2);
		itemDripWater.setItemMeta(metaDripWater);
		return itemDripWater;
	}

	public static ItemStack itemEnchantment() {
		ItemStack itemEnchantment = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("Enchantment-itemType")
				.toUpperCase()), 1);
		ItemMeta metaEnchantment = itemEnchantment.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("Enchantment-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Enchantment-loreEnabled")) {
			List<String> loreEnchantment = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Enchantment-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Enchantment-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Enchantment-loreLineThree")
					.replaceAll("&", "§");

			loreEnchantment.add(loreLine1);
			loreEnchantment.add(loreLine2);
			loreEnchantment.add(loreLine3);

			metaEnchantment.setLore(loreEnchantment);
		}
		metaEnchantment.setDisplayName(name2);
		itemEnchantment.setItemMeta(metaEnchantment);
		return itemEnchantment;
	}

	public static ItemStack itemSpark() {
		ItemStack itemSpark = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Spark-itemType").toUpperCase()), 1);
		ItemMeta metaSpark = itemSpark.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Spark-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Spark-loreEnabled")) {
			List<String> loreSpark = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Spark-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Spark-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Spark-loreLineThree").replaceAll("&", "§");

			loreSpark.add(loreLine1);
			loreSpark.add(loreLine2);
			loreSpark.add(loreLine3);

			metaSpark.setLore(loreSpark);
		}
		metaSpark.setDisplayName(name2);
		itemSpark.setItemMeta(metaSpark);
		return itemSpark;
	}

	public static ItemStack itemFlame() {
		ItemStack itemFlame = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Flame-itemType").toUpperCase()), 1);
		ItemMeta metaFlame = itemFlame.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Flame-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Flame-loreEnabled")) {
			List<String> loreFlame = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Flame-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Flame-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Flame-loreLineThree").replaceAll("&", "§");

			loreFlame.add(loreLine1);
			loreFlame.add(loreLine2);
			loreFlame.add(loreLine3);

			metaFlame.setLore(loreFlame);
		}
		metaFlame.setDisplayName(name2);
		itemFlame.setItemMeta(metaFlame);
		return itemFlame;
	}

	public static ItemStack itemHappyVillager() {
		ItemStack itemHappyVillager = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("HappyVillager-itemType")
				.toUpperCase()), 1);
		ItemMeta metaHappyVillager = itemHappyVillager.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("HappyVillager-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig()
				.getBoolean("HappyVillager-loreEnabled")) {
			List<String> loreHappyVillager = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("HappyVillager-loreLineOne")
					.replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("HappyVillager-loreLineTwo")
					.replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("HappyVillager-loreLineThree")
					.replaceAll("&", "§");

			loreHappyVillager.add(loreLine1);
			loreHappyVillager.add(loreLine2);
			loreHappyVillager.add(loreLine3);

			metaHappyVillager.setLore(loreHappyVillager);
		}
		metaHappyVillager.setDisplayName(name2);
		itemHappyVillager.setItemMeta(metaHappyVillager);
		return itemHappyVillager;
	}

	public static ItemStack itemInstantSpell() {
		ItemStack itemInstantSpell = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("InstantSpell-itemType")
				.toUpperCase()), 1);
		ItemMeta metaInstantSpell = itemInstantSpell.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("InstantSpell-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("InstantSpell-loreEnabled")) {
			List<String> loreInstantSpell = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("InstantSpell-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("InstantSpell-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("InstantSpell-loreLineThree")
					.replaceAll("&", "§");

			loreInstantSpell.add(loreLine1);
			loreInstantSpell.add(loreLine2);
			loreInstantSpell.add(loreLine3);

			metaInstantSpell.setLore(loreInstantSpell);
		}
		metaInstantSpell.setDisplayName(name2);
		itemInstantSpell.setItemMeta(metaInstantSpell);
		return itemInstantSpell;
	}

	public static ItemStack itemLargeSmoke() {
		ItemStack itemLargeSmoke = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("LargeSmoke-itemType")
				.toUpperCase()), 1);
		ItemMeta metaLargeSmoke = itemLargeSmoke.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("LargeSmoke-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("LargeSmoke-loreEnabled")) {
			List<String> loreLargeSmoke = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("LargeSmoke-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("LargeSmoke-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("LargeSmoke-loreLineThree").replaceAll("&", "§");

			loreLargeSmoke.add(loreLine1);
			loreLargeSmoke.add(loreLine2);
			loreLargeSmoke.add(loreLine3);

			metaLargeSmoke.setLore(loreLargeSmoke);
		}
		metaLargeSmoke.setDisplayName(name2);
		itemLargeSmoke.setItemMeta(metaLargeSmoke);
		return itemLargeSmoke;
	}

	public static ItemStack itemLava() {
		ItemStack itemLava = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Lava-itemType").toUpperCase()), 1);
		ItemMeta metaLava = itemLava.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Lava-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Lava-loreEnabled")) {
			List<String> loreLava = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Lava-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Lava-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Lava-loreLineThree").replaceAll("&", "§");

			loreLava.add(loreLine1);
			loreLava.add(loreLine2);
			loreLava.add(loreLine3);

			metaLava.setLore(loreLava);
		}
		metaLava.setDisplayName(name2);
		itemLava.setItemMeta(metaLava);
		return itemLava;
	}

	public static ItemStack itemMagicCrit() {
		ItemStack itemMagicCrit = new ItemStack(Material.POTION, 1);
		ItemMeta metaMagicCrit = itemMagicCrit.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("MagicCrit-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("MagicCrit-loreEnabled")) {
			List<String> loreMagicCrit = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("MagicCrit-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("MagicCrit-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("MagicCrit-loreLineThree").replaceAll("&", "§");

			loreMagicCrit.add(loreLine1);
			loreMagicCrit.add(loreLine2);
			loreMagicCrit.add(loreLine3);

			metaMagicCrit.setLore(loreMagicCrit);
		}
		metaMagicCrit.setDisplayName(name2);
		itemMagicCrit.setItemMeta(metaMagicCrit);
		return itemMagicCrit;
	}

	public static ItemStack itemMobSpell() {
		ItemStack itemMobSpell = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("MobSpell-itemType")
				.toUpperCase()), 1);
		ItemMeta metaMobSpell = itemMobSpell.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("MobSpell-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("MobSpell-loreEnabled")) {
			List<String> loreMobSpell = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("MobSpell-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("MobSpell-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("MobSpell-loreLineThree").replaceAll("&", "§");

			loreMobSpell.add(loreLine1);
			loreMobSpell.add(loreLine2);
			loreMobSpell.add(loreLine3);

			metaMobSpell.setLore(loreMobSpell);
		}
		metaMobSpell.setDisplayName(name2);
		itemMobSpell.setItemMeta(metaMobSpell);
		return itemMobSpell;
	}

	public static ItemStack itemMobSpellAmbient() {
		ItemStack itemMobSpellAmbient = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("MobSpellAmbient-itemType")
				.toUpperCase()), 1);
		ItemMeta metaMobSpellAmbient = itemMobSpellAmbient.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("MobSpellAmbient-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig()
				.getBoolean("MobSpellAmbient-loreEnabled")) {
			List<String> loreMobSpellAmbient = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("MobSpellAmbient-loreLineOne")
					.replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("MobSpellAmbient-loreLineTwo")
					.replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("MobSpellAmbient-loreLineThree")
					.replaceAll("&", "§");

			loreMobSpellAmbient.add(loreLine1);
			loreMobSpellAmbient.add(loreLine2);
			loreMobSpellAmbient.add(loreLine3);

			metaMobSpellAmbient.setLore(loreMobSpellAmbient);
		}
		metaMobSpellAmbient.setDisplayName(name2);
		itemMobSpellAmbient.setItemMeta(metaMobSpellAmbient);
		return itemMobSpellAmbient;
	}

	public static ItemStack itemNote() {
		ItemStack itemNote = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Note-itemType").toUpperCase()), 1);
		ItemMeta metaNote = itemNote.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Note-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Note-loreEnabled")) {
			List<String> loreNote = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Note-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Note-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Note-loreLineThree").replaceAll("&", "§");

			loreNote.add(loreLine1);
			loreNote.add(loreLine2);
			loreNote.add(loreLine3);

			metaNote.setLore(loreNote);
		}
		metaNote.setDisplayName(name2);
		itemNote.setItemMeta(metaNote);
		return itemNote;
	}

	public static ItemStack itemPortal() {
		ItemStack itemPortal = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Portal-itemType").toUpperCase()), 1);
		ItemMeta metaPortal = itemPortal.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("Portal-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Portal-loreEnabled")) {
			List<String> lorePortal = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Portal-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Portal-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Portal-loreLineThree").replaceAll("&", "§");

			lorePortal.add(loreLine1);
			lorePortal.add(loreLine2);
			lorePortal.add(loreLine3);

			metaPortal.setLore(lorePortal);
		}
		metaPortal.setDisplayName(name2);
		itemPortal.setItemMeta(metaPortal);
		return itemPortal;
	}

	public static ItemStack itemRedDust() {
		ItemStack itemRedDust = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("RedDust-itemType").toUpperCase()), 1);
		ItemMeta metaRedDust = itemRedDust.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("RedDust-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("RedDust-loreEnabled")) {
			List<String> loreRedDust = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("RedDust-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("RedDust-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("RedDust-loreLineThree").replaceAll("&", "§");

			loreRedDust.add(loreLine1);
			loreRedDust.add(loreLine2);
			loreRedDust.add(loreLine3);

			metaRedDust.setLore(loreRedDust);
		}
		metaRedDust.setDisplayName(name2);
		itemRedDust.setItemMeta(metaRedDust);
		return itemRedDust;
	}

	public static ItemStack itemColoredRedDust() {
		ItemStack itemColoredRedDust = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("ColoredRedDust-itemType")
				.toUpperCase()), 1);
		ItemMeta metaColoredRedDust = itemColoredRedDust.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("ColoredRedDust-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig()
				.getBoolean("ColoredRedDust-loreEnabled")) {
			List<String> loreColoredRedDust = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("ColoredRedDust-loreLineOne")
					.replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("ColoredRedDust-loreLineTwo")
					.replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("ColoredRedDust-loreLineThree")
					.replaceAll("&", "§");

			loreColoredRedDust.add(loreLine1);
			loreColoredRedDust.add(loreLine2);
			loreColoredRedDust.add(loreLine3);

			metaColoredRedDust.setLore(loreColoredRedDust);
		}
		metaColoredRedDust.setDisplayName(name2);
		itemColoredRedDust.setItemMeta(metaColoredRedDust);
		return itemColoredRedDust;
	}

	public static ItemStack itemSlime() {
		ItemStack itemSlime = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Slime-itemType").toUpperCase()), 1);
		ItemMeta metaSlime = itemSlime.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Slime-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Slime-loreEnabled")) {
			List<String> loreSlime = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Slime-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Slime-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Slime-loreLineThree").replaceAll("&", "§");

			loreSlime.add(loreLine1);
			loreSlime.add(loreLine2);
			loreSlime.add(loreLine3);

			metaSlime.setLore(loreSlime);
		}
		metaSlime.setDisplayName(name2);
		itemSlime.setItemMeta(metaSlime);
		return itemSlime;
	}

	public static ItemStack itemSnowShovel() {
		ItemStack itemSnowShovel = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("SnowShovel-itemType")
				.toUpperCase()), 1);
		ItemMeta metaSnowShovel = itemSnowShovel.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("SnowShovel-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("SnowShovel-loreEnabled")) {
			List<String> loreSnowShovel = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("SnowShovel-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("SnowShovel-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("SnowShovel-loreLineThree").replaceAll("&", "§");

			loreSnowShovel.add(loreLine1);
			loreSnowShovel.add(loreLine2);
			loreSnowShovel.add(loreLine3);

			metaSnowShovel.setLore(loreSnowShovel);
		}
		metaSnowShovel.setDisplayName(name2);
		itemSnowShovel.setItemMeta(metaSnowShovel);
		return itemSnowShovel;
	}

	public static ItemStack itemSnowballPoof() {
		ItemStack itemSnowballPoof = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("SnowballPoof-itemType")
				.toUpperCase()), 1);
		ItemMeta metaSnowballPoof = itemSnowballPoof.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("SnowballPoof-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("SnowballPoof-loreEnabled")) {
			List<String> loreSnowballPoof = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("SnowballPoof-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("SnowballPoof-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("SnowballPoof-loreLineThree")
					.replaceAll("&", "§");

			loreSnowballPoof.add(loreLine1);
			loreSnowballPoof.add(loreLine2);
			loreSnowballPoof.add(loreLine3);

			metaSnowballPoof.setLore(loreSnowballPoof);
		}
		metaSnowballPoof.setDisplayName(name2);
		itemSnowballPoof.setItemMeta(metaSnowballPoof);
		return itemSnowballPoof;
	}

	public static ItemStack itemSpell() {
		ItemStack itemSpell = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Spell-itemType").toUpperCase()), 1);
		ItemMeta metaSpell = itemSpell.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Spell-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Spell-loreEnabled")) {
			List<String> loreSpell = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Spell-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Spell-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Spell-loreLineThree").replaceAll("&", "§");

			loreSpell.add(loreLine1);
			loreSpell.add(loreLine2);
			loreSpell.add(loreLine3);

			metaSpell.setLore(loreSpell);
		}
		metaSpell.setDisplayName(name2);
		itemSpell.setItemMeta(metaSpell);
		return itemSpell;
	}

	public static ItemStack itemSplash() {
		ItemStack itemSplash = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Splash-itemType").toUpperCase()), 1);
		ItemMeta metaSplash = itemSplash.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("Splash-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Splash-loreEnabled")) {
			List<String> loreSplash = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Splash-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Splash-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Splash-loreLineThree").replaceAll("&", "§");

			loreSplash.add(loreLine1);
			loreSplash.add(loreLine2);
			loreSplash.add(loreLine3);

			metaSplash.setLore(loreSplash);
		}
		metaSplash.setDisplayName(name2);
		itemSplash.setItemMeta(metaSplash);
		return itemSplash;
	}

	public static ItemStack itemTownAura() {
		ItemStack itemTownAura = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("TownAura-itemType")
				.toUpperCase()), 1);
		ItemMeta metaTownAura = itemTownAura.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("TownAura-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("TownAura-loreEnabled")) {
			List<String> loreTownAura = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("TownAura-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("TownAura-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("TownAura-loreLineThree").replaceAll("&", "§");

			loreTownAura.add(loreLine1);
			loreTownAura.add(loreLine2);
			loreTownAura.add(loreLine3);

			metaTownAura.setLore(loreTownAura);
		}
		metaTownAura.setDisplayName(name2);
		itemTownAura.setItemMeta(metaTownAura);
		return itemTownAura;
	}

	public static ItemStack itemWake() {
		ItemStack itemWake = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Wake-itemType").toUpperCase()), 1);
		ItemMeta metaWake = itemWake.getItemMeta();

		String name1 = Main.getPlugin().getConfig().getString("Wake-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Wake-loreEnabled")) {
			List<String> loreWake = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Wake-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Wake-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Wake-loreLineThree").replaceAll("&", "§");

			loreWake.add(loreLine1);
			loreWake.add(loreLine2);
			loreWake.add(loreLine3);

			metaWake.setLore(loreWake);
		}
		metaWake.setDisplayName(name2);
		itemWake.setItemMeta(metaWake);
		return itemWake;
	}

	public static ItemStack itemWitchMagic() {
		ItemStack itemWitchMagic = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("WitchMagic-itemType")
				.toUpperCase()), 1);
		ItemMeta metaWitchMagic = itemWitchMagic.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("WitchMagic-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("WitchMagic-loreEnabled")) {
			List<String> loreWitchMagic = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("WitchMagic-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("WitchMagic-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("WitchMagic-loreLineThree").replaceAll("&", "§");

			loreWitchMagic.add(loreLine1);
			loreWitchMagic.add(loreLine2);
			loreWitchMagic.add(loreLine3);

			metaWitchMagic.setLore(loreWitchMagic);
		}
		metaWitchMagic.setDisplayName(name2);
		itemWitchMagic.setItemMeta(metaWitchMagic);
		return itemWitchMagic;
	}

	public static ItemStack itemHearts() {
		ItemStack itemHearts = new ItemStack(Material.valueOf(Main.getPlugin()
				.getConfig().getString("Hearts-itemType").toUpperCase()), 1);
		ItemMeta metaHearts = itemHearts.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("Hearts-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("Hearts-loreEnabled")) {
			List<String> loreHearts = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("Hearts-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("Hearts-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("Hearts-loreLineThree").replaceAll("&", "§");

			loreHearts.add(loreLine1);
			loreHearts.add(loreLine2);
			loreHearts.add(loreLine3);

			metaHearts.setLore(loreHearts);
		}
		metaHearts.setDisplayName(name2);
		itemHearts.setItemMeta(metaHearts);
		return itemHearts;
	}

	public static ItemStack itemNextPage() {
		ItemStack itemNextPage = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("NextPage-itemType")
				.toUpperCase()), 1);
		ItemMeta metaNextPage = itemNextPage.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("NextPage-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("NextPage-loreEnabled")) {
			List<String> loreNextPage = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("NextPage-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("NextPage-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("NextPage-loreLineThree").replaceAll("&", "§");

			loreNextPage.add(loreLine1);
			loreNextPage.add(loreLine2);
			loreNextPage.add(loreLine3);

			metaNextPage.setLore(loreNextPage);
		}
		metaNextPage.setDisplayName(name2);
		itemNextPage.setItemMeta(metaNextPage);
		return itemNextPage;
	}

	public static ItemStack itemPreviousPage() {
		ItemStack itemPreviousPage = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("PreviousPage-itemType")
				.toUpperCase()), 1);
		ItemMeta metaPreviousPage = itemPreviousPage.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("PreviousPage-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("PreviousPage-loreEnabled")) {
			List<String> lorePreviousPage = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("PreviousPage-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("PreviousPage-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("PreviousPage-loreLineThree")
					.replaceAll("&", "§");

			lorePreviousPage.add(loreLine1);
			lorePreviousPage.add(loreLine2);
			lorePreviousPage.add(loreLine3);

			metaPreviousPage.setLore(lorePreviousPage);
		}
		metaPreviousPage.setDisplayName(name2);
		itemPreviousPage.setItemMeta(metaPreviousPage);
		return itemPreviousPage;
	}

	public static ItemStack itemRemoveTrails() {
		ItemStack itemRemoveTrails = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("RemoveTrails-itemType")
				.toUpperCase()), 1);
		ItemMeta metaRemoveTrails = itemRemoveTrails.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("RemoveTrails-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("RemoveTrails-loreEnabled")) {
			List<String> loreRemoveTrail = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("RemoveTrails-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("RemoveTrails-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("RemoveTrails-loreLineThree")
					.replaceAll("&", "§");

			loreRemoveTrail.add(loreLine1);
			loreRemoveTrail.add(loreLine2);
			loreRemoveTrail.add(loreLine3);

			metaRemoveTrails.setLore(loreRemoveTrail);
		}
		metaRemoveTrails.setDisplayName(name2);
		itemRemoveTrails.setItemMeta(metaRemoveTrails);
		return itemRemoveTrails;
	}

	public static ItemStack itemEnderSignal() {
		ItemStack itemEnderSignal = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("EnderSignal-itemType")
				.toUpperCase()), 1);
		ItemMeta metaEnderSignal = itemEnderSignal.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("EnderSignal-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("EnderSignal-loreEnabled")) {
			List<String> loreEnderSignal = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("EnderSignal-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("EnderSignal-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("EnderSignal-loreLineThree")
					.replaceAll("&", "§");

			loreEnderSignal.add(loreLine1);
			loreEnderSignal.add(loreLine2);
			loreEnderSignal.add(loreLine3);

			metaEnderSignal.setLore(loreEnderSignal);
		}
		metaEnderSignal.setDisplayName(name2);
		itemEnderSignal.setItemMeta(metaEnderSignal);
		return itemEnderSignal;
	}

	public static ItemStack itemIconCrack() {
		ItemStack itemIconCrack = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("IconCrack-itemType")
				.toUpperCase()), 1);
		ItemMeta metaIconCrack = itemIconCrack.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("IconCrack-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("IconCrack-loreEnabled")) {
			List<String> loreIconCrack = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("IconCrack-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("IconCrack-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("IconCrack-loreLineThree").replaceAll("&", "§");

			loreIconCrack.add(loreLine1);
			loreIconCrack.add(loreLine2);
			loreIconCrack.add(loreLine3);

			metaIconCrack.setLore(loreIconCrack);
		}
		metaIconCrack.setDisplayName(name2);
		itemIconCrack.setItemMeta(metaIconCrack);
		return itemIconCrack;
	}

	public static ItemStack itemBlockBreak() {
		ItemStack itemBlockBreak = new ItemStack(Material.valueOf(Main
				.getPlugin().getConfig().getString("BlockBreak-itemType")
				.toUpperCase()), 1);
		ItemMeta metaBlockBreak = itemBlockBreak.getItemMeta();

		String name1 = Main.getPlugin().getConfig()
				.getString("BlockBreak-itemName");
		String name2 = name1.replaceAll("&", "§");
		if (Main.getPlugin().getConfig().getBoolean("BlockBreak-loreEnabled")) {
			List<String> loreBlockBreak = new ArrayList<String>();

			String loreLine1 = Main.getPlugin().getConfig()
					.getString("BlockBreak-loreLineOne").replaceAll("&", "§");
			String loreLine2 = Main.getPlugin().getConfig()
					.getString("BlockBreak-loreLineTwo").replaceAll("&", "§");
			String loreLine3 = Main.getPlugin().getConfig()
					.getString("BlockBreak-loreLineThree").replaceAll("&", "§");

			loreBlockBreak.add(loreLine1);
			loreBlockBreak.add(loreLine2);
			loreBlockBreak.add(loreLine3);

			metaBlockBreak.setLore(loreBlockBreak);
		}
		metaBlockBreak.setDisplayName(name2);
		itemBlockBreak.setItemMeta(metaBlockBreak);
		return itemBlockBreak;
	}
	// endregion
}
