package srv.deathly.deathlypack;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.LockedCategory;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import srv.deathly.deathlypack.events.ListenerClass;

public class Main extends JavaPlugin {
		
	private static final Logger log = Logger.getLogger("Minecraft");
	private static Plugin plugin;

    @Override
    public void onEnable() {
    	
    	plugin = this;
    	
    	registerEvents(this, new ListenerClass());
    	
    	PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
		
		registerItems();
		

    }
    
    @Override
    public void onDisable(){
    	plugin = null;
    	
    	PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
		log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }
    
    public void registerItems(){
		Category category = new LockedCategory(new CustomItem(new MaterialData(Material.DRAGON_EGG), "&4Deathly Tools", "", "&a> Click to open"), 5, Categories.TECH);
		SlimefunItem bStar = new SlimefunItem(Categories.RESOURCES, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_RED + "Enriched Star", "", "&5A super charged nether star."), "ENRICHED_STAR", RecipeType.ANCIENT_ALTAR, new ItemStack[] {SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), new ItemStack(Material.NETHER_STAR), new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND });
		SlimefunItem item = new SlimefunItem(category, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_BLUE + "Simple Packer", "", ChatColor.DARK_PURPLE + "Right Click this to craft inventory", "&4items into blocks!"), "SIMPLE_PACKER", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {SlimefunItems.CARBONADO, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.CARBONADO, new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(bStar.getItem()), new ItemStack(Material.DIAMOND_BLOCK), SlimefunItems.COPPER_INGOT, new ItemStack(Material.WORKBENCH), SlimefunItems.COPPER_INGOT});
		SlimefunItem item2 = new SlimefunItem(category, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_PURPLE + "Auto Packer", "" , ChatColor.DARK_RED + "Automatically packs items if in inventory"), "AUTO_PACKER", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {SlimefunItems.MAGIC_LUMP_3, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.BATTERY, new ItemStack(item.getItem()), SlimefunItems.BATTERY, SlimefunItems.COBALT_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COBALT_INGOT});
		
		bStar.register();
		item.register();
		item2.register();
		
		Research bresearch = new Research(9999, "Enchriched Star", 30); bresearch.addItems(bStar); bresearch.register();
		Research research = new Research(9999, "Simple Packer", 35); research.addItems(item); research.register();
		Research research2 = new Research(9999, "Auto Packer", 45); research2.addItems(item2); research2.register();
	}
    
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners){
    	for (Listener listener : listeners){
    		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    	}
    }
    
    public static Plugin getPlugin() {
    	return plugin;
    	}	
}
