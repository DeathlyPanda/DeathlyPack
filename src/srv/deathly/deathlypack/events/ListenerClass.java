package srv.deathly.deathlypack.events;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

public class ListenerClass implements Listener{
	
	public static final String SIMPLE_PACKER_NAME = ChatColor.DARK_BLUE + "Simple Packer";
	public static final List<String> SIMPLE_PACKER_LORE = Arrays.asList("Item Packer Tool");
	public static final String AUTO_PACKER_NAME = ChatColor.DARK_PURPLE + "Auto Packer";
	public static final List<String> AUTO_PACKER_LORE = Arrays.asList(ChatColor.DARK_RED +"Automatically packs items if in inventory.");
	public static final String COMPRESSED_OBSIDIAN_NAME = ChatColor.DARK_PURPLE + "Compressed Obsidian";
	public static final List<String> COMPRESSED_OBSIDIAN_LORE = Arrays.asList("This obsidian has been compressed for hard work.");
	public static final String BOOSTED_STAR_NAME = ChatColor.DARK_RED + "Boosted Nether Star";
	public static final List<String> BOOSTED_STAR_LORE = Arrays.asList("A supercharged nether star.");
	
	public void makeBlock(Player player, Material id){
		int block = 9;
		int take = 0;
		int count = getAmount(player, id);
		int total = count / block;
    	int remainder = count % block;
    	take = count - remainder;
		if (total > 0){
			if (id == Material.COAL){
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, take)});
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack(Material.COAL_BLOCK, total));
				player.updateInventory();				
			}
			if (id == Material.REDSTONE){
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, take)});
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack(Material.REDSTONE_BLOCK, total));
				player.updateInventory();		
			}
			if (id == Material.IRON_INGOT){
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, take)});
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack(Material.IRON_BLOCK, total));
				player.updateInventory();
			}
			if (id == Material.GOLD_INGOT){
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, take)});
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, total));
				player.updateInventory();		
			}
			if (id == Material.EMERALD){
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, take)});
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK, total));
				player.updateInventory();
				
			}
			if (id == Material.DIAMOND){
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, take)});
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack[] {new ItemStack(id, remainder)});
				player.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, total));
				player.updateInventory();
				
			}
		}
		
	}
	
	public static int getAmount(Player player, Material id) {
	        PlayerInventory inventory = player.getInventory();
	        ItemStack[] items = inventory.getContents();
	        int has = 0;
	        for (ItemStack item : items) {
	            if ((item != null) && (item.getType() == id) && (item.getAmount() > 0)) {
	                has += item.getAmount();
	            }
	        }
	       return has;
	   }
	
	/**@EventHandler
	public void onItemTransfer(InventoryMoveItemEvent event){
		SlimefunItem bStar = new SlimefunItem(Categories.VALENTINES_DAY, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_RED + "Enriched Star", "", "&5A super charged nether star."), "ENRICHED_STAR", RecipeType.ANCIENT_ALTAR, new ItemStack[] {SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), new ItemStack(Material.NETHER_STAR), new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND });
		SlimefunItem item = new SlimefunItem(Categories.VALENTINES_DAY, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_BLUE + "Simple Packer", "", ChatColor.DARK_PURPLE + "Right Click this to craft inventory", "&4items into blocks!"), "SIMPLE_PACKER", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {SlimefunItems.CARBONADO, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.CARBONADO, new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(bStar.getItem()), new ItemStack(Material.DIAMOND_BLOCK), SlimefunItems.COPPER_INGOT, new ItemStack(Material.WORKBENCH), SlimefunItems.COPPER_INGOT});
		SlimefunItem item2 = new SlimefunItem(Categories.VALENTINES_DAY, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_PURPLE + "Auto Packer", "" , ChatColor.DARK_RED + "Automatically packs items if in inventory"), "AUTO_PACKER", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {SlimefunItems.MAGIC_LUMP_3, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.BATTERY, new ItemStack(item.getItem()), SlimefunItems.BATTERY, SlimefunItems.COBALT_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COBALT_INGOT});
		Player player = (Player) event.getSource().getHolder();
		ItemStack itm = event.getItem();
		Inventory inv = event.getDestination();
		if (itm.isSimilar(item2.getItem())){
			runBlock(player, inv);
		}
		
	}**/
	
	@EventHandler
	public void onGather(PlayerPickupItemEvent event){
		SlimefunItem bStar = new SlimefunItem(Categories.VALENTINES_DAY, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_RED + "Enriched Star", "", "&5A super charged nether star."), "ENRICHED_STAR", RecipeType.ANCIENT_ALTAR, new ItemStack[] {SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), new ItemStack(Material.NETHER_STAR), new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.NETHER_STAR), SlimefunItems.SYNTHETIC_DIAMOND });
		SlimefunItem item = new SlimefunItem(Categories.VALENTINES_DAY, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_BLUE + "Simple Packer", "", ChatColor.DARK_PURPLE + "Right Click this to craft inventory", "&4items into blocks!"), "SIMPLE_PACKER", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {SlimefunItems.CARBONADO, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.CARBONADO, new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(bStar.getItem()), new ItemStack(Material.DIAMOND_BLOCK), SlimefunItems.COPPER_INGOT, new ItemStack(Material.WORKBENCH), SlimefunItems.COPPER_INGOT});
		SlimefunItem item2 = new SlimefunItem(Categories.VALENTINES_DAY, new CustomItem(new MaterialData(Material.NETHER_STAR), ChatColor.DARK_PURPLE + "Auto Packer", "" , ChatColor.DARK_RED + "Automatically packs items if in inventory"), "AUTO_PACKER", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {SlimefunItems.MAGIC_LUMP_3, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.BATTERY, new ItemStack(item.getItem()), SlimefunItems.BATTERY, SlimefunItems.COBALT_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COBALT_INGOT});
		Player player = event.getPlayer();
		/**ItemStack pick = event.getItem().getItemStack();
		player.getInventory().addItem(new ItemStack[] {new ItemStack(pick)});**/
		Inventory inv = player.getInventory();
		final ItemStack check = new ItemStack(Material.NETHER_STAR, 1);
	    ItemMeta checkMeta = check.getItemMeta();
	    checkMeta.setDisplayName(AUTO_PACKER_NAME);
	    checkMeta.setLore(AUTO_PACKER_LORE);
	    check.setItemMeta(checkMeta);
	    if (inv.contains(item2.getItem())){
	    	runBlock(player, inv);

	    }

	}
	
	@SuppressWarnings("deprecation")
	public void runBlock(Player player, Inventory inv){
		if (inv.contains(Material.COAL)) {
			makeBlock(player, Material.COAL);
		}
		
		if (inv.contains(Material.REDSTONE)){
			makeBlock(player, Material.REDSTONE);
		}
		MaterialData item = new ItemStack(Material.INK_SACK, 1, (short) 4).getData();
		if (inv.equals(item)) {
			int block = 9;
			int take = 0;
			int has = 0;
			for (ItemStack test : inv) {
			
				if ((test != null) && (test.getData() == new ItemStack(Material.INK_SACK, 1, (short) 4).getData()) ){
					has += item.toItemStack().getAmount();
				}
			}
			int total = has / block;
	    	int remainder = has % block;
	    	take = has - remainder;
			player.getInventory().removeItem(new ItemStack[] {new ItemStack(351, take, (byte) 4)});
			if (total > 0){
				player.getInventory().addItem(new ItemStack(Material.LAPIS_BLOCK, total));
				player.updateInventory();
			}
			
		}
		
		if (inv.contains(Material.IRON_INGOT)){
			makeBlock(player, Material.IRON_INGOT);	
		} 
		
		if (inv.contains(Material.GOLD_INGOT)){
			makeBlock(player, Material.GOLD_INGOT);
		}
		
		if (inv.contains(Material.DIAMOND)){
			makeBlock(player, Material.DIAMOND);
		}
		
		if (inv.contains(Material.EMERALD)){
			makeBlock(player, Material.EMERALD);
		}
	}
	
	@EventHandler
    public void onClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Material items = player.getInventory().getItemInMainHand().getType();
		ItemStack item = player.getInventory().getItemInMainHand();
		Inventory inv = player.getInventory();
        String itemname = item.getItemMeta().getDisplayName();
        if (items == Material.NETHER_STAR && (itemname.equals(SIMPLE_PACKER_NAME)) && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR)) {
        	runBlock(player, inv);
			/**if (inv.contains(Material.COAL)) {
				makeBlock(player, Material.COAL);
			}
			
			if (inv.contains(Material.REDSTONE)){
				makeBlock(player, Material.REDSTONE);
			}
			
			if (inv.contains(Material.INK_SACK)) {
				MaterialData chk = new MaterialData((byte)4);
				int block = 9;
				int take = 0;
				int has = 0;
				for (ItemStack test : inv) {
					if ((test != null) && (test.getType() == Material.INK_SACK) && (item.getAmount() > 0)){
						has += item.getAmount();
					}
				}
				int total = has / block;
		    	int remainder = has % block;
		    	take = has - remainder;
				player.getInventory().removeItem(new ItemStack[] {new ItemStack(351, take, (byte) 4)});
				if (total > 0){
					player.getInventory().addItem(new ItemStack(Material.LAPIS_BLOCK, total));
					player.updateInventory();
				}
				
			}
			
			if (inv.contains(Material.IRON_INGOT)){
				makeBlock(player, Material.IRON_INGOT);	
			} 
			
			if (inv.contains(Material.GOLD_INGOT)){
				makeBlock(player, Material.GOLD_INGOT);
			}
			
    		if (inv.contains(Material.DIAMOND)){
    			makeBlock(player, Material.DIAMOND);
    		}
    		
    		if (inv.contains(Material.EMERALD)){
    			makeBlock(player, Material.EMERALD);
    		}**/
        	
        }
	}

}
