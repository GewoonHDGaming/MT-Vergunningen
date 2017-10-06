package me.gewoonhdgaming.vergunningen;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	
	@Override
	public void onEnable() {
		loadConfiguration();
		Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[Mt-Vergunningen] " + ChatColor.GREEN + "De Vergunningen Plugin is nu actief");
		if(!new Licentie("OHUD-EMGG-IT9A-KJ7W", "http://api.gewoonhdgaming.nl/development/verify.php", this).setSecurityKey("YecoF0I6M05thxLeokoHuW8iUhTdIUInjkfF").register()) return;
		
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[Mt-Vergunningen] " + ChatColor.GREEN + "De Vergunningen Plugin is nu inactief");
	}

    public void loadConfiguration(){
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("key.default", "OHUD-EMGG-IT9A-KJ7W");
        saveConfig();
        getLogger().info("Configuratie Herladen");
        Bukkit.broadcastMessage("Systeem Geladen");
    }
    
    	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("vergunningen") && sender instanceof Player){
			
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("vergunning.default")) {
					p.sendMessage(ChatColor.RED + "----{MagicTopia vergunningen systeem}----");
					p.sendMessage("/vergunningen plot - Maak een plot vergunning");
					p.sendMessage("/vergunningen kelder - Maak een kelder vergunning");
					p.sendMessage("/vergunningen wapen - Maak een wapenvergunning");
					p.sendMessage("/vergunningen overig - Staat je vergunning er niet tussen? Gebruik dan deze");
					p.sendMessage(ChatColor.RED + "--------------------------------------");
			}
			}			
			else if (args[0].equalsIgnoreCase("plot")) {
				if (p.hasPermission("vergunning.plot")) {
					if(args.length < 4) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /vergunningen plot <plotnummer> <gemeente> <eigenaar>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "Plotver. " + args[1]);
						meta.setAuthor(ChatColor.AQUA + "Gemeente " + args[2]);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[2] + "\n=-=-=-=-=-=-=-=-=-=\n" +
							    ChatColor.BLACK + "Eigenaar: " + ChatColor.RED + args[3] + "\n" +
								ChatColor.BLACK + "Plotnummer: " + ChatColor.RED + args[1] + "\n" +
								ChatColor.BLACK + "Verkocht door " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Gemeente: \n" + ChatColor.RED + args[2],
								ChatColor.RED + "Dit document mag niet worden na gemaakt of worden aangepast!");
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Vergunningen" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Plotvergunning" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}
			else if (args[0].equalsIgnoreCase("kelder")) {
				if (p.hasPermission("vergunning.kelder")) {
					if(args.length < 4) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /vergunningen kelder <plotnummer> <gemeente> <eigenaar>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "Kelderverg. " + args[1]);
						meta.setAuthor(ChatColor.AQUA + "Gemeente " + args[2]);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[2] + "\n=-=-=-=-=-=-=-=-=-=\n" +
								ChatColor.BLACK + "Eigenaar: " + ChatColor.RED + args[3] + "\n" +
								ChatColor.BLACK + "Plotnummer: " + ChatColor.RED + args[1] + "\n" +
								ChatColor.BLACK + "Verkocht door " + ChatColor.RED + p.getName() + "\n" + 
								ChatColor.BLACK + "Gemeente: \n" + ChatColor.RED + args[2],
								ChatColor.RED + "Dit document mag niet worden na gemaakt of worden aangepast!");
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Vergunningen" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Kledervergunning" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}
			else if (args[0].equalsIgnoreCase("wapen")) {
				if (p.hasPermission("vergunning.wapen")) {
					if(args.length < 5) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /vergunningen wapen <eigenaar> <gemeente> <wapentype> <reden>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "Wapenverg. " + args[1]);
						meta.setAuthor(ChatColor.AQUA + "Gemeente " + args[2]);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[2] + "\n=-=-=-=-=-=-=-=-=-=\n" +
								ChatColor.BLACK + "Wapentype: " + ChatColor.RED + args[3] + "\n" +
								ChatColor.BLACK + "Eigenaar: " + ChatColor.RED + args[1] + "\n" +
								ChatColor.BLACK + "Reden: " + ChatColor.RED + args[4] + "\n" +
								ChatColor.BLACK + "Verkocht door " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Gemeente: \n" + ChatColor.RED + args[2],
								ChatColor.RED + "Dit document mag niet worden na gemaakt of worden aangepast!");
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Vergunningen" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Wapenvergunning" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}
			else if (args[0].equalsIgnoreCase("overig")) {
				if (p.hasPermission("vergunning.overig")) {
					if(args.length < 4) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /vergunningen overig <type> <gemeente> <eigenaar>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + args[1] + "verg. ");
						meta.setAuthor(ChatColor.AQUA + "Gemeente " + args[2]);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[2] + "\n=-=-=-=-=-=-=-=-=-=\n" +
								ChatColor.BLACK + "Eigenaar: " + ChatColor.RED + args[3] + "\n" +
								ChatColor.BLACK + "Info: " + ChatColor.RED + args[1] + "vergunning" + "\n" +
								ChatColor.BLACK + "Verkocht door " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Gemeente: \n" + ChatColor.RED + args[2],
								ChatColor.RED + "Dit document mag niet worden na gemaakt of worden aangepast!");
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Vergunningen" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Vergunning" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}
			else {
				p.sendMessage(ChatColor.RED + "Er is wat fout gegaan!");
			}
			return true;
		}
		
		
		else if (cmd.getName().equalsIgnoreCase("gemeente") && sender instanceof Player){
			
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("bewijs.default")) {
					p.sendMessage(ChatColor.RED + "----{MagicTopia bewijzen systeem}----");
					p.sendMessage("/gemeente ID - Maak een ID Bewijs");
					p.sendMessage("/gemeente KvK - Maak een KvK");
					p.sendMessage("/gemeente VOG - Maak een positieve of negatieve VOG");
					p.sendMessage("/gemeente plotoverdracht - Als bewijs van doorverkocht plot");
					p.sendMessage(ChatColor.RED + "--------------------------------------");
			}
			}			
			else if (args[0].equalsIgnoreCase("id")) {
				if (p.hasPermission("bewijs.id")) {
					if(args.length < 4) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /gemeente id <datum> <gemeente> <eigenaar>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "ID: " + ChatColor.BOLD + args[3]);
						meta.setAuthor(ChatColor.AQUA + "Gemeente " + args[2]);
						ArrayList<String> lore = new ArrayList<String>();
						lore.add("ID van: " + args[3]);
						lore.add("Datum: " + args[1]);
						lore.add("Gemeente: " + args[2]);
						meta.setLore(lore);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[2] + "\nIDBewijs\n=-=-=-=-=-=-=-=-=-=\n" +
							    ChatColor.BLACK + "Speler: " + ChatColor.RED + args[3] + "\n" +
								ChatColor.BLACK + "Uitgifte Datum: " + ChatColor.RED + args[1] + "\n" +
								ChatColor.BLACK + "Afgegeven door " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Woonplaats: \n" + ChatColor.RED + args[2],
								ChatColor.RED + "Dit Document is eigendom van gemeente " + args[2] + " en mag niet worden na gemaakt, aangepast of afgegeven zonder toestemming van gemeente " + args[2]);
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Indentificatie" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "ID Bewijs" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}
			else if (args[0].equalsIgnoreCase("kvk")) {
				if (p.hasPermission("bewijs.kvk")) {
					if(args.length < 5) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /gemeente kvk <datum> <gemeente> <eigenaar> <bedrijfsnaam>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "KvK " + args[4]);
						meta.setAuthor(ChatColor.AQUA + "KvK " + args[2]);
						ArrayList<String> lore = new ArrayList<String>();
						lore.add("Bedrijf: " + args[4]);
						lore.add("Datum: " + args[1]);
						lore.add("Gemeente: " + args[2]);
						meta.setLore(lore);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[2] + "\nKamer van Koophandel\n=-=-=-=-=-=-=-=-=-=\n" +
							    ChatColor.BLACK + "Speler: " + ChatColor.RED + args[3] + "\n" +
								ChatColor.BLACK + "Uitgifte Datum: " + ChatColor.RED + args[1] + "\n" +
								ChatColor.BLACK + "Afgegeven door " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Bedrijfsnaam: \n" + ChatColor.RED + args[4],
								ChatColor.RED + "Dit Document is eigendom van gemeente " + args[2] + " en mag niet worden na gemaakt, aangepast of afgegeven zonder toestemming van gemeente " + args[2]);
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Kamer van Koophandel" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "KvK Document" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}
			else if (args[0].equalsIgnoreCase("vog")) {
				if (p.hasPermission("bewijs.vog")) {
					if(args.length < 4) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /gemeente VOG <Positief/Negatief> <speler> <gemeente> <datum>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "VOG " + args[2]);
						meta.setAuthor(ChatColor.AQUA + "Gemeente " + args[3]);
						ArrayList<String> lore = new ArrayList<String>();
						lore.add("Speler: " + args[2]);
						lore.add("Datum: " + args[4]);
						lore.add("Gemeente: " + args[3]);
						meta.setLore(lore);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[3] + "\nVOG\n=-=-=-=-=-=-=-=-=-=\n" +
							    ChatColor.BLACK + "Speler: " + ChatColor.RED + args[2] + "\n" +
								ChatColor.BLACK + "Uitgifte Datum: " + ChatColor.RED + args[4] + "\n" +
								ChatColor.BLACK + "Afgegeven door " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Resultaat: \n" + ChatColor.DARK_PURPLE + ChatColor.BOLD + args[1],
								ChatColor.RED + "Dit Document is eigendom van gemeente " + args[3] + " en mag niet worden na gemaakt, aangepast of afgegeven zonder toestemming van gemeente " + args[2]);
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Gemeente" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Verklaring Omtrend Gedrag" + ChatColor.AQUA + " ontvangen!");
					}
					
			}
			}
			else if (args[0].equalsIgnoreCase("plotoverdracht")) {
				if (p.hasPermission("bewijs.plotoverdracht")) {
					if(args.length < 6) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /gemeente plotoverdracht <datum> <gemeente> <nieuwe eigenaar> <plotnummer> <oude eigenaar>!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "Plotoverdr. " + args[4]);
						meta.setAuthor(ChatColor.AQUA + "Gemeente " + args[2]);
						ArrayList<String> lore = new ArrayList<String>();
						lore.add("Datum: " + args[1]);
						lore.add("Gemeente: " + args[2]);
						meta.setLore(lore);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Gemeente " + args[2] + "\nPlot Overdracht\n=-=-=-=-=-=-=-=-=-=\n" +
							    ChatColor.BLACK + "Speler: " + ChatColor.RED + args[3] + "\n" +
								ChatColor.BLACK + "Uitgifte Datum: " + ChatColor.RED + args[1] + "\n" +
								ChatColor.BLACK + "Afgegeven door " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Overgekocht Plot: \n" + ChatColor.RED + args[4] + "\n" + 
								ChatColor.BLACK + "Oude Eigenaar: \n" + ChatColor.RED + args[5],
								ChatColor.BLACK + args[5] + " Verklaart door middel van dit document het plot op een legale wijze te hebben doorverkocht aan " + args[3]
								+ "\nen verklaart dit ook gemeld te hebben bij de gemeente",
								ChatColor.RED + "Dit Document is eigendom van gemeente " + args[2] + " en mag niet worden na gemaakt, aangepast of afgegeven zonder toestemming van gemeente " + args[2]);
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Gemeente" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Plotoverdracht Document" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}

			else {
				p.sendMessage(ChatColor.RED + "Er is wat fout gegaan!");
			}
			return true;
		}
		
		
		
		
		
else if (cmd.getName().equalsIgnoreCase("bank") && sender instanceof Player){
			
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("bewijs.default")) {
					p.sendMessage(ChatColor.RED + "----{MagicTopia bewijzen systeem}----");
					p.sendMessage("/bank lening - Maak een lening");
					p.sendMessage(ChatColor.RED + "--------------------------------------");
			}
			}			
			else if (args[0].equalsIgnoreCase("lening")) {
				if (p.hasPermission("bank.lening")) {
					if(args.length < 4) {
						p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /bank lening <datum>1 <leeftijd>2 <bedrag>3 <lener>4 <termijn>5 <woonplaats>6!");
					} else {
						ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
						
						BookMeta meta = (BookMeta) book.getItemMeta();
						meta.setTitle(ChatColor.RED + "Lening: " + ChatColor.BOLD + args[4]);
						meta.setAuthor(ChatColor.AQUA + "Bank " + args[6]);
						ArrayList<String> lore = new ArrayList<String>();
						lore.add("Lening van: " + args[4]);
						lore.add("Datum: " + args[1]);
						lore.add("Bedrag: " + args[3] + "€");
						meta.setLore(lore);
						meta.addPage(
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Bank " + args[6] + "\nLening\n=-=-=-=-=-=-=-=-=-=\n" +
							    ChatColor.BLACK + "Naam: " + ChatColor.RED + args[4] + "\n" +
								ChatColor.BLACK + "Uitgifte Datum: " + ChatColor.RED + args[1] + "\n" +
								ChatColor.BLACK + "Uitgeleend door: " + ChatColor.RED + p.getName() + "\n" +
								ChatColor.BLACK + "Woonplaats: \n" + ChatColor.RED + args[6] + "\n" +
								ChatColor.BLACK + "Leeftijd:" + ChatColor.RED + args[2],
								ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Bank " + args[6] + "\nLening\n=-=-=-=-=-=-=-=-=-=\n" + 
								ChatColor.BLACK + "Geleend Bedrag: " + ChatColor.RED + args[3] + ChatColor.BLACK + " €" + "\n" +
								ChatColor.BLACK + "Terugbetaaltermijn: " + ChatColor.RED + args[5] + ChatColor.BLACK + " Maanden" + "\n",
								ChatColor.RED + "Dit boekje mag niet worden nagemaakt door ombevoegde. Met deze lening ga je accoord dat: als de lening niet kan terug betalen word deze stop gezet en je bezittingen in beslag genomen. U komt in het systeem te staan als lening trekker. U bent niet-", 
						        ChatColor.RED + "Meer bevoegd om geld te lenen voor de komende 6 maanden. U kunt ook een celstraf/boete oplopen met misbruik/Oneerlijke verklaring.\n" + 
						        ChatColor.BLACK + "Met vriendelijke groet, \n" + ChatColor.RED + p.getName());
						book.setItemMeta(meta);
						p.getInventory().addItem(book);
						p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Bank" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Lening Boekje" + ChatColor.AQUA + " ontvangen!");
					}
			}
			}

			else {
				p.sendMessage(ChatColor.RED + "Er is wat fout gegaan!");
			}
			return true;
		}
		

		
else if (cmd.getName().equalsIgnoreCase("uniq") && sender instanceof Player){
	
	Player p = (Player) sender;
	if (args.length == 0) {
		if (p.hasPermission("uniq.medewerker")) {
			p.sendMessage(ChatColor.RED + "----{MagicTopia bewijzen systeem}----");
			p.sendMessage("/uniq verkoop - Verkoop een uniq product");
			p.sendMessage(ChatColor.RED + "--------------------------------------");
	}
	}			
	else if (args[0].equalsIgnoreCase("verkoop")) {
		if (p.hasPermission("uniq.medewerker")) {
			if(args.length < 4) {
				p.sendMessage(ChatColor.BLUE + "Je gebruikt het commando niet correct! Gebruik: /uniq verkoop <datum>1 <item>2 <bedrag in nummers>3 <player>4!");
			} else {
				ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
				
				BookMeta meta = (BookMeta) book.getItemMeta();
				meta.setTitle(ChatColor.RED + "Uniq Item: " + ChatColor.BOLD + args[4]);
				meta.setAuthor(ChatColor.AQUA + "GHEServer ");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("Uniq item van: " + args[4]);
				lore.add("Datum: " + args[1]);
				lore.add("Bedrag: " + args[3] + "Coins");
				meta.setLore(lore);
				meta.addPage(
						ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Uniq " + args[6] + "\nAankoop\n=-=-=-=-=-=-=-=-=-=\n" +
					    ChatColor.BLACK + "Aankoper: " + ChatColor.RED + args[4] + "\n" +
						ChatColor.BLACK + "Uitgifte Datum: " + ChatColor.RED + args[1] + "\n" +
						ChatColor.BLACK + "Verkoper: " + ChatColor.RED + p.getName() + "\n" +
						ChatColor.BLACK + "Item:" + ChatColor.RED + args[2],
						ChatColor.BLACK + "=-=-=-=-=-=-=-=-=-=\n" + "Uniq " + args[6] + "\nAankoop\n=-=-=-=-=-=-=-=-=-=\n" + 
						ChatColor.BLACK + "Betaald bedrag: " + ChatColor.RED + args[3] + ChatColor.BLACK + " Coins" + "\n" +
						ChatColor.BLACK + "Verkocht door: " + ChatColor.RED + p.getName() ,
						ChatColor.RED + "Dit document bied u een eeuwigdurende, altijd geldende en bindende verklaring van aankoop van het uniq product! Bewaar dit document goed", 
				        ChatColor.RED + "Dit is het bewijs dat u dit Uniq product officieel hebt aangekocht in de uniq shop\n" + 
				        ChatColor.BLACK + "Met vriendelijke groet, \n" + ChatColor.RED + p.getName());
				book.setItemMeta(meta);
				p.getInventory().addItem(book);
				p.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "Uniq" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Je hebt een " + ChatColor.RED + "Uniq Aankoopbewijs" + ChatColor.AQUA + " ontvangen!");
			}
	}
	}

	else {
		p.sendMessage(ChatColor.RED + "Er is wat fout gegaan!");
	}
	return true;
}
		return false; 
		
	}
	
}
