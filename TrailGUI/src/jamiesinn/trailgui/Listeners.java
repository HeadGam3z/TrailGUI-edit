package jamiesinn.trailgui;

import jamiesinn.trailgui.Libraries.ParticleEffect;
import jamiesinn.trailgui.files.PlayerTrailData;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {
	
	private Main main;
	public static ArrayList<String> cooldownAngryVillager = new ArrayList<String>();
	public static ArrayList<String> cooldownEnderSignal = new ArrayList<String>();
	public static ArrayList<String> cooldownHearts = new ArrayList<String>();
	public static ArrayList<String> cooldownNote = new ArrayList<String>();

	public Listeners(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onEntityDamageByEntity1(EntityDamageByEntityEvent event) {
		if (Main.getPlugin().getConfig().getBoolean("removeTrailOnPlayerHit")) {
			if (((event.getDamager() instanceof Player))
					&& ((event.getEntity() instanceof Player))) {
				Player hit = (Player) event.getEntity();

				Methodes.clearTrails(hit);
			}
		}
	}

	/**
	 * Handles a player clicking on an effect in the TrailGUI.
	 * 
	 * @param event InventoryClickEvent
	 * @author Jesse McCullough (HeadGam3z)
	 */
	@EventHandler
	public void onInventoryClick1(InventoryClickEvent event) {
		String name = getMessage("pageOneInventoryName"); // works for this too.
		if (!event.getInventory().getTitle().contains(name)) {
			return;
		}
		event.setCancelled(true);
		ItemStack effect = event.getCurrentItem();
		if (effect == null || effect.getType() == Material.AIR) {
			return;
		}
		Player player = (Player) event.getWhoClicked();
		boolean closeOnDeny = getBoolean("closeInventoryOnDenyPermission");
		if (getBoolean("oneTrailAtATime") && !effect.equals(Methodes.itemNextPage())) {
			Methodes.clearTrails(player);
			System.out.println("cleared");
		}
		PlayerTrailData playerEffects = new PlayerTrailData(player); // to get the latest changes of clearing trails, I moved it
		if (effect.equals(Methodes.itemAngryVillager())) {
			if (!player.hasPermission("trailgui.inventory.angryvillager")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasAngryVillager();
			playerEffects.setAngryVillager(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("AngryVillager"));
			} else {
				player.sendMessage(getSelectTrail("AngryVillager"));
			}
		} else if (effect.equals(Methodes.itemCloud())) {
			if (!player.hasPermission("trailgui.inventory.cloud")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasCloud();
			playerEffects.setCloud(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Cloud"));
			} else {
				player.sendMessage(getSelectTrail("Cloud"));
			}
		} else if (effect.equals(Methodes.itemCriticals())) {
			if (!player.hasPermission("trailgui.inventory.criticals")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasCriticals();
			playerEffects.setCriticals(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Criticals"));
			} else {
				player.sendMessage(getSelectTrail("Criticals"));
			}
		} else if (effect.equals(Methodes.itemDripLava())) {
			if (!player.hasPermission("trailgui.inventory.driplava")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasDripLava();
			playerEffects.setDripLava(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("DripLava"));
			} else {
				player.sendMessage(getSelectTrail("DripLava"));
			}
		} else if (effect.equals(Methodes.itemDripWater())) {
			if (!player.hasPermission("trailgui.inventory.dripwater")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasDripWater();
			playerEffects.setDripWater(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("DripWater"));
			} else {
				player.sendMessage(getSelectTrail("DripWater"));
			}
		} else if (effect.equals(Methodes.itemEnchantment())) {
			if (!player.hasPermission("trailgui.inventory.enchantment")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasEnchantment();
			playerEffects.setEnchantment(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Enchantment"));
			} else {
				player.sendMessage(getSelectTrail("Enchantment"));
			}
		} else if (effect.equals(Methodes.itemSpark())) {
			if (!player.hasPermission("trailgui.inventory.spark")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasSpark();
			playerEffects.setSpark(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Spark"));
			} else {
				player.sendMessage(getSelectTrail("Spark"));
			}
		} else if (effect.equals(Methodes.itemFlame())) {
			if (!player.hasPermission("trailgui.inventory.flame")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasFlame();
			playerEffects.setFlame(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Flame"));
			} else {
				player.sendMessage(getSelectTrail("Flame"));
			}
		} else if (effect.equals(Methodes.itemHappyVillager())) {
			if (!player.hasPermission("trailgui.inventory.happyvillager")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasHappyVillager();
			playerEffects.setHappyVillager(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("HappyVillager"));
			} else {
				player.sendMessage(getSelectTrail("HappyVillager"));
			}
		} else if (effect.equals(Methodes.itemInstantSpell())) {
			if (!player.hasPermission("trailgui.inventory.instantspell")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasInstantSpell();
			playerEffects.setInstantSpell(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("InstantSpell"));
			} else {
				player.sendMessage(getSelectTrail("InstantSpell"));
			}
		} else if (effect.equals(Methodes.itemLargeSmoke())) {
			if (!player.hasPermission("trailgui.inventory.largesmoke")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasLargeSmoke();
			playerEffects.setLargeSmoke(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("LargeSmoke"));
			} else {
				player.sendMessage(getSelectTrail("LargeSmoke"));
			}
		} else if (effect.equals(Methodes.itemLava())) {
			if (!player.hasPermission("trailgui.inventory.lava")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasLava();
			playerEffects.setLava(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Lava"));
			} else {
				player.sendMessage(getSelectTrail("Lava"));
			}
		} else if (effect.equals(Methodes.itemMagicCrit())) {
			if (!player.hasPermission("trailgui.inventory.magiccrit")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasMagicCrit();
			playerEffects.setMagicCrit(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("MagicCrit"));
			} else {
				player.sendMessage(getSelectTrail("MagicCrit"));
			}
		} else if (effect.equals(Methodes.itemMobSpell())) {
			if (!player.hasPermission("trailgui.inventory.mobspell")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasMobSpell();
			playerEffects.setMobSpell(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("MobSpell"));
			} else {
				player.sendMessage(getSelectTrail("MobSpell"));
			}
		} else if (effect.equals(Methodes.itemMobSpellAmbient())) {
			if (!player.hasPermission("trailgui.inventory.mobspellambient")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasMobSpellAmbient();
			playerEffects.setMobSpellAmbient(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("MobSpellAmbient"));
			} else {
				player.sendMessage(getSelectTrail("MobSpellAmbient"));
			}
		} else if (effect.equals(Methodes.itemNote())) {
			if (!player.hasPermission("trailgui.inventory.note")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasNote();
			playerEffects.setNote(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Note"));
			} else {
				player.sendMessage(getSelectTrail("Note"));
			}
		} else if (effect.equals(Methodes.itemPortal())) {
			if (!player.hasPermission("trailgui.inventory.portal")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasPortal();
			playerEffects.setPortal(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Portal"));
			} else {
				player.sendMessage(getSelectTrail("Portal"));
			}
		} else if (effect.equals(Methodes.itemRedDust())) {
			if (!player.hasPermission("trailgui.inventory.reddust")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasRedDust();
			playerEffects.setRedDust(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("RedDust"));
			} else {
				player.sendMessage(getSelectTrail("RedDust"));
			}
		} else if (effect.equals(Methodes.itemColoredRedDust())) {
			if (!player.hasPermission("trailgui.inventory.coloredreddust")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasColoredRedDust();
			playerEffects.setColoredRedDust(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("ColoredRedDust"));
			} else {
				player.sendMessage(getSelectTrail("ColoredRedDust"));
			}
		} else if (effect.equals(Methodes.itemSlime())) {
			if (!player.hasPermission("trailgui.inventory.slime")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasSlime();
			playerEffects.setSlime(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Slime"));
			} else {
				player.sendMessage(getSelectTrail("Slime"));
			}
		} else if (effect.equals(Methodes.itemSnowShovel())) {
			if (!player.hasPermission("trailgui.inventory.snowshovel")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasSnowShovel();
			playerEffects.setSnowShovel(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("SnowShovel"));
			} else {
				player.sendMessage(getSelectTrail("SnowShovel"));
			}
		} else if (effect.equals(Methodes.itemSnowballPoof())) {
			if (!player.hasPermission("trailgui.inventory.snowballpoof")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasSnowballPoof();
			playerEffects.setSnowballPoof(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("SnowballPoof"));
			} else {
				player.sendMessage(getSelectTrail("SnowballPoof"));
			}
		} else if (effect.equals(Methodes.itemSpell())) {
			if (!player.hasPermission("trailgui.inventory.spell")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasSpell();
			playerEffects.setSpell(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Spell"));
			} else {
				player.sendMessage(getSelectTrail("Spell"));
			}
		} else if (effect.equals(Methodes.itemSplash())) {
			if (!player.hasPermission("trailgui.inventory.splash")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasSplash();
			playerEffects.setSplash(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Splash"));
			} else {
				player.sendMessage(getSelectTrail("Splash"));
			}
		} else if (effect.equals(Methodes.itemTownAura())) {
			if (!player.hasPermission("trailgui.inventory.townaura")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasTownAura();
			playerEffects.setTownAura(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("TownAura"));
			} else {
				player.sendMessage(getSelectTrail("TownAura"));
			}
		} else if (effect.equals(Methodes.itemWake())) {
			if (!player.hasPermission("trailgui.inventory.wake")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasWake();
			playerEffects.setWake(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Wake"));
			} else {
				player.sendMessage(getSelectTrail("Wake"));
			}
		} else if (effect.equals(Methodes.itemWitchMagic())) {
			if (!player.hasPermission("trailgui.inventory.witchmagic")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasWitchMagic();
			playerEffects.setWitchMagic(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("WitchMagic"));
			} else {
				player.sendMessage(getSelectTrail("WitchMagic"));
			}
		} else if (effect.equals(Methodes.itemHearts())) {
			if (!player.hasPermission("trailgui.inventory.hearts")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasHearts();
			playerEffects.setHearts(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("Hearts"));
			} else {
				player.sendMessage(getSelectTrail("Hearts"));
			}
		} else if (effect.equals(Methodes.itemEnderSignal())) {
			if (!player.hasPermission("trailgui.inventory.endersignal")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasEnderSignal();
			playerEffects.setEnderSignal(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("EnderSignal"));
			} else {
				player.sendMessage(getSelectTrail("EnderSignal"));
			}
		} else if (effect.equals(Methodes.itemIconCrack())) {
			if (!player.hasPermission("trailgui.inventory.iconcrack")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasIconCrack();
			playerEffects.setIconCrack(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("IconCrack"));
			} else {
				player.sendMessage(getSelectTrail("IconCrack"));
			}
		} else if (effect.equals(Methodes.itemBlockBreak())) {
			if (!player.hasPermission("trailgui.inventory.blockbreak")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			boolean value = playerEffects.hasBlockBreak();
			playerEffects.setBlockBreak(!value);
			playerEffects.saveFile();
			if (value) {
				player.sendMessage(getRemoveTrail("BlockBreak"));
			} else {
				player.sendMessage(getSelectTrail("BlockBreak"));
			}
		} else if (effect.equals(Methodes.itemRemoveTrails())) {
			if (!player.hasPermission("trailgui.inventory.clearall")) {
				player.sendMessage(getNoPermission());
				if (closeOnDeny) {
					player.closeInventory();
				}
				return;
			}
			String msg = main.getConfig().getString("RemoveTrails-message");
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
		}
		if (getBoolean("closeInventoryAferSelect")) { // guy misspelled.
			player.closeInventory();
		}
	}

	// I'm not touching this. ever. - head.
	@EventHandler
	public void onPlayerMove1(PlayerMoveEvent event) {
		if ((Main.getPlugin().getConfig().getBoolean("disabledWhenSpinning"))
				&& (event.getFrom().getX() == event.getTo().getX())
				&& (event.getFrom().getY() == event.getTo().getY())
				&& (event.getFrom().getZ() == event.getTo().getZ())) {
			return;
		}
		final Player player = event.getPlayer();
		for (String string : this.main.getConfig().getStringList(
				"disabledWorlds")) {
			string.replace("[", "");
			string.replace("]", "");
			if (string.equals(player.getWorld().getName())) {
				return;
			}
		}
		if (Main.trailCloud.contains(player.getUniqueId().toString())) {
			ParticleEffect.CLOUD.display(
					0.0F,
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Cloud-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Cloud-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Cloud-range"));
		}
		if (Main.trailAngryVillager.contains(player.getUniqueId().toString())) {
			if (cooldownAngryVillager.contains(player.getUniqueId().toString())) {
				return;
			}
			ParticleEffect.VILLAGER_ANGRY.display(
					0.0F,
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("AngryVillager-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"AngryVillager-displayLocation"), 0.0D),
					this.main.getConfig().getInt("AngryVillager-range"));
			cooldownAngryVillager.add(player.getUniqueId().toString());

			Bukkit.getServer().getScheduler()
					.scheduleSyncDelayedTask(this.main, new Runnable() {
						public void run() {
							Listeners.cooldownAngryVillager.remove(player
									.getUniqueId().toString());
						}
					}, this.main.getConfig().getInt("AngryVillager-cooldown"));
		}
		if (Main.trailCriticals.contains(player.getUniqueId().toString())) {
			ParticleEffect.CRIT.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Criticals-speed"),
					this.main.getConfig().getInt("Criticals-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Criticals-displayLocation"), 0.0D),
					this.main.getConfig().getInt("Criticals-range"));
		}
		if (Main.trailDripLava.contains(player.getUniqueId().toString())) {
			ParticleEffect.DRIP_LAVA.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("DripLava-speed"),
					this.main.getConfig().getInt("DripLava-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"DripLava-displayLocation"), 0.0D),
					this.main.getConfig().getInt("DripLava-range"));
		}
		if (Main.trailDripWater.contains(player.getUniqueId().toString())) {
			ParticleEffect.DRIP_WATER.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("DripWater-speed"),
					this.main.getConfig().getInt("DripWater-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"DripWater-displayLocation"), 0.0D),
					this.main.getConfig().getInt("DripWater-range"));
		}
		if (Main.trailEnchantment.contains(player.getUniqueId().toString())) {
			ParticleEffect.ENCHANTMENT_TABLE.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Enchantment-speed"),
					this.main.getConfig().getInt("Enchantment-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Enchantment-displayLocation"), 0.0D),
					this.main.getConfig().getInt("Enchantment-range"));
		}
		if (Main.trailSpark.contains(player.getUniqueId().toString())) {
			ParticleEffect.FIREWORKS_SPARK.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Spark-speed"),
					this.main.getConfig().getInt("Spark-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Spark-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Spark-range"));
		}
		if (Main.trailFlame.contains(player.getUniqueId().toString())) {
			ParticleEffect.FLAME.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Flame-speed"),
					this.main.getConfig().getInt("Flame-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Flame-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Flame-range"));
		}
		if (Main.trailHappyVillager.contains(player.getUniqueId().toString())) {
			ParticleEffect.VILLAGER_HAPPY.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("HappyVillager-speed"),
					this.main.getConfig().getInt("HappyVillager-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"HappyVillager-displayLocation"), 0.0D),
					this.main.getConfig().getInt("HappyVillager-range"));
		}
		if (Main.trailInstantSpell.contains(player.getUniqueId().toString())) {
			ParticleEffect.SPELL_INSTANT.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("InstantSpell-speed"),
					this.main.getConfig().getInt("InstantSpell-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"InstantSpell-displayLocation"), 0.0D),
					this.main.getConfig().getInt("InstantSpell-range"));
		}
		if (Main.trailLargeSmoke.contains(player.getUniqueId().toString())) {
			ParticleEffect.SMOKE_LARGE.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("LargeSmoke-speed"),
					this.main.getConfig().getInt("LargeSmoke-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"LargeSmoke-displayLocation"), 0.0D),
					this.main.getConfig().getInt("LargeSmoke-range"));
		}
		if (Main.trailLava.contains(player.getUniqueId().toString())) {
			ParticleEffect.LAVA.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Lava-speed"),
					this.main.getConfig().getInt("Lava-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Lava-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Lava-range"));
		}
		if (Main.trailMagicCrit.contains(player.getUniqueId().toString())) {
			ParticleEffect.CRIT_MAGIC.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("MagicCrit-speed"),
					this.main.getConfig().getInt("MagicCrit-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"MagicCrit-displayLocation"), 0.0D),
					this.main.getConfig().getInt("MagicCrit-range"));
		}
		if (Main.trailMobSpell.contains(player.getUniqueId().toString())) {
			ParticleEffect.SPELL_MOB.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("MobSpell-speed"),
					this.main.getConfig().getInt("MobSpell-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"MobSpell-displayLocation"), 0.0D),
					this.main.getConfig().getInt("MobSpell-range"));
		}
		if (Main.trailMobSpellAmbient.contains(player.getUniqueId().toString())) {
			ParticleEffect.SPELL_MOB_AMBIENT.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("MobSpellAmbient-speed"),
					this.main.getConfig().getInt("MobSpellAmbient-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"MobSpellAmbient-displayLocation"), 0.0D),
					this.main.getConfig().getInt("MobSpellAmbient-range"));
		}
		if (Main.trailNote.contains(player.getUniqueId().toString())) {
			if (cooldownNote.contains(player.getUniqueId().toString())) {
				return;
			}
			ParticleEffect.NOTE.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Note-speed"),
					this.main.getConfig().getInt("Note-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Note-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Note-range"));
			cooldownNote.add(player.getUniqueId().toString());

			Bukkit.getServer().getScheduler()
					.scheduleSyncDelayedTask(this.main, new Runnable() {
						public void run() {
							Listeners.cooldownNote.remove(player.getUniqueId()
									.toString());
						}
					}, this.main.getConfig().getInt("Note-cooldown"));
		}
		if (Main.trailPortal.contains(player.getUniqueId().toString())) {
			ParticleEffect.PORTAL.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Portal-speed"),
					this.main.getConfig().getInt("Portal-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Portal-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Portal-range"));
		}
		if (Main.trailRedDust.contains(player.getUniqueId().toString())) {
			ParticleEffect.REDSTONE.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("RedDust-speed"),
					this.main.getConfig().getInt("RedDust-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"RedDust-displayLocation"), 0.0D),
					this.main.getConfig().getInt("RedDust-range"));
		}
		if (Main.trailColoredRedDust.contains(player.getUniqueId().toString())) {
			ParticleEffect.REDSTONE.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("ColoredRedDust-speed"),
					this.main.getConfig().getInt("ColoredRedDust-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"ColoredRedDust-displayLocation"), 0.0D),
					this.main.getConfig().getInt("ColoredRedDust-range"));
		}
		if (Main.trailSlime.contains(player.getUniqueId().toString())) {
			ParticleEffect.SLIME.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Slime-speed"),
					this.main.getConfig().getInt("Slime-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Slime-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Slime-range"));
		}
		if (Main.trailSnowShovel.contains(player.getUniqueId().toString())) {
			ParticleEffect.SNOW_SHOVEL.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("SnowShovel-speed"),
					this.main.getConfig().getInt("SnowShovel-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"SnowShovel-displayLocation"), 0.0D),
					this.main.getConfig().getInt("SnowShovel-range"));
		}
		if (Main.trailSnowballPoof.contains(player.getUniqueId().toString())) {
			ParticleEffect.SNOWBALL.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("SnowballPoof-speed"),
					this.main.getConfig().getInt("SnowballPoof-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"SnowballPoof-displayLocation"), 0.0D),
					this.main.getConfig().getInt("SnowballPoof-range"));
		}
		if (Main.trailSpell.contains(player.getUniqueId().toString())) {
			ParticleEffect.SPELL.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Spell-speed"),
					this.main.getConfig().getInt("Spell-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Spell-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Spell-range"));
		}
		if (Main.trailSplash.contains(player.getUniqueId().toString())) {
			ParticleEffect.WATER_SPLASH.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Splash-speed"),
					this.main.getConfig().getInt("Splash-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Splash-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Splash-range"));
		}
		if (Main.trailTownAura.contains(player.getUniqueId().toString())) {
			ParticleEffect.TOWN_AURA.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("TownAura-speed"),
					this.main.getConfig().getInt("TownAura-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"TownAura-displayLocation"), 0.0D),
					this.main.getConfig().getInt("TownAura-range"));
		}
		if (Main.trailWake.contains(player.getUniqueId().toString())) {
			ParticleEffect.WATER_WAKE.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Wake-speed"),
					this.main.getConfig().getInt("Wake-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Wake-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Wake-range"));
		}
		if (Main.trailWitchMagic.contains(player.getUniqueId().toString())) {
			ParticleEffect.SPELL_WITCH.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("WitchMagic-speed"),
					this.main.getConfig().getInt("WitchMagic-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"WitchMagic-displayLocation"), 0.0D),
					this.main.getConfig().getInt("WitchMagic-range"));
		}
		if (Main.trailHearts.contains(player.getUniqueId().toString())) {
			if (cooldownHearts.contains(player.getUniqueId().toString())) {
				return;
			}
			ParticleEffect.HEART.display(
					0.0F,
					0.0F,
					0.0F,
					this.main.getConfig().getInt("Hearts-speed"),
					this.main.getConfig().getInt("Hearts-amount"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"Hearts-displayLocation"), 0.0D), this.main
							.getConfig().getInt("Hearts-range"));
			cooldownHearts.add(player.getUniqueId().toString());

			Bukkit.getServer().getScheduler()
					.scheduleSyncDelayedTask(this.main, new Runnable() {
						public void run() {
							Listeners.cooldownHearts.remove(player
									.getUniqueId().toString());
						}
					}, this.main.getConfig().getInt("Hearts-cooldown"));
		}
		if (Main.trailEnderSignal.contains(player.getUniqueId().toString())) {
			if (cooldownEnderSignal.contains(player.getUniqueId().toString())) {
				return;
			}
			player.getWorld().playEffect(player.getLocation(),
					Effect.ENDER_SIGNAL, 1);
			cooldownEnderSignal.add(player.getUniqueId().toString());

			Bukkit.getServer().getScheduler()
					.scheduleSyncDelayedTask(this.main, new Runnable() {
						public void run() {
							Listeners.cooldownEnderSignal.remove(player
									.getUniqueId().toString());
						}
					}, this.main.getConfig().getInt("EnderSignal-cooldown"));
		}
		if (Main.trailIconCrack.contains(player.getUniqueId().toString())) {
			ParticleEffect.ItemData data = new ParticleEffect.ItemData(
					Material.valueOf(this.main.getConfig()
							.getString("IconCrack-itemType").toUpperCase()),
					(byte) 0);
			ParticleEffect.ITEM_CRACK.display(
					data,
					player.getLocation().getDirection(),
					this.main.getConfig().getInt("IconCrack-speed"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"IconCrack-displayLocation"), 0.0D),
					this.main.getConfig().getInt("IconCrack-range"));
		}

		if (Main.trailBlockBreak.contains(player.getUniqueId().toString())) {
			ParticleEffect.BlockData data = new ParticleEffect.BlockData(
					Material.valueOf(this.main.getConfig()
							.getString("BlockBreak-itemType").toUpperCase()),
					(byte) 0);
			ParticleEffect.BLOCK_CRACK.display(
					data,
					player.getLocation().getDirection(),
					this.main.getConfig().getInt("BlockBreak-speed"),
					player.getLocation().add(
							0.0D,
							this.main.getConfig().getDouble(
									"BlockBreak-displayLocation"), 0.0D),
					this.main.getConfig().getInt("BlockBreak-range"));
		}
	}

	/**
	 * Gets the no permission message.
	 * 
	 * @return no permission message
	 * @author Jesse McCullough (HeadGam3z)
	 */
	private String getNoPermission() {
		return getMessage("GUI-denyPermissionMessage");
	}
	
	/**
	 * Gets the remove trail message.
	 * 
	 * @param trail the trail
	 * @return remove trail message
	 * @author Jesse McCullough (HeadGam3z)
	 */
	private String getRemoveTrail(String trail) {
		return getMessage("GUI-removeTrailMessage")
				.replace("%TrailName%", trail);
	}
	
	/**
	 * Gets the select trail message.
	 * 
	 * @param trail the trail
	 * @return select trail message
	 * @author Jesse McCullough (HeadGam3z)
	 */
	private String getSelectTrail(String trail) {
		return getMessage("GUI-selectTrailMessage")
				.replaceAll("%TrailName%", trail);
	}
	
	/**
	 * Shorter way to get a boolean from the config.
	 * 
	 * @param path to the boolean
	 * @return true or false
	 * @author Jesse McCullough (headGam3z)
	 */
	private boolean getBoolean(String path) {
		return main.getConfig().getBoolean(path);
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
	
	// Player Join Listener
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Methodes.restoreTrails(player);
	}

}
