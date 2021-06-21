package FinalProj;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Town {
	
	static Scanner scan = new Scanner(System.in);
	
	private static String[] shoplist = 
			{"Iron Sword", "Diamond Sword", 
			"Compound Bow", "Crossbow",
			"Upgraded Staff", "Holy Staff",
			"Armor Repair ( Type 'Repair' )","Iron Armor"};
	private static int[] shopPrice = 
			{15, 35,
			20, 35, 
			25, 55,
			20, 7}; // each price correspond to the same place/index with the item. 
	
	
	
	public static void inventory ( User userobj ) { // displays unlocked upgrades / items / abilities
		System.out.println("-----------Unlocked-----------");
		System.out.println("------------------------------");
		System.out.println("Gold = " + userobj.getGold());
	    for (int count = 0; count<userobj.getInventorySize(); count++){
	    	int index = count +1;
			System.out.println(index +". "+  userobj.getInventorySpecific(count));
	    }
	    System.out.println("------------------------------");
	        
	}
	
	public static void sleep(User userobj) throws InterruptedException { // sleeps at the inn. heals the user to max health and its mana. 
		System.out.println("You decided to take a sleep at the nearby inn.");
	    System.out.println("Health is healed to full ");
	    System.out.println("Mana are restored");
	    System.out.println("----------------------------------------------");
	    System.out.println("Cost : 5 gold coins");
	    
	    userobj.setGold(-5);
	    userobj.setHealth(100);
	    userobj.setMana(100);
	    
	    System.out.println("Balance : "+ userobj.getGold());
	    System.out.println("----------------------------------------------");
	    TimeUnit.SECONDS.sleep(3);
	    
	    while (true){
	    	System.out.println("----------------------------------------------");
	    	System.out.println("would you like to change inventory settings ? ");
	    	System.out.println("1. Yes");
	    	System.out.println("2. No ( exit inn )");
	    	System.out.println("----------------------------------------------");
	    	int innChoice = scan.nextInt();
	    	scan.nextLine();
	    	
	    	if(innChoice == 1) {
	    		draw.displayStatus(userobj);
	    		inventory(userobj);

	    		System.out.println("----------------------------------------------");
	    		System.out.println("What would you like to do ?");
	    		System.out.println("1. Change weapon");
	    		System.out.println("2. Exit inn");
	    		System.out.println("----------------------------------------------");
	    		int innChoice2 = Integer.parseInt(scan.nextLine());;
	    		
	    		if (innChoice2 == 1) {// change weapons 
	    			while (true) {
	    			System.out.println("change to : ");
	    			if (userobj.getplayerClass().equals("Knight")) {
	    				if (userobj.getInventory().contains("Iron Sword") && userobj.getInventory().contains("Diamond Sword")) {
	    				System.out.println("Iron Sword || Diamond Sword");
	    				}else if (userobj.getInventory().contains("Iron Sword")) {
	    					System.out.println("Iron Sword");
	    				}else if (userobj.getInventory().contains("Diamond Sword")) {
	    					System.out.println("Diamond Sword");
	    				}else {
	    					System.out.println("Nothing can currently be upgraded ");
	    					break;
	    				}
	    				
	    				System.out.println("Please input Exactly as shown: ");
	    				String changeTo = scan.nextLine();
	    				
	    				if (userobj.getInventory().contains(changeTo)) {
	    					userobj.setWeapEquip(changeTo);
	    					System.out.println("changed to " +changeTo);
	    					break;
	    				}else { 
	    					System.out.println("unavailable / not in inventory");
	    				}		
	    			}
	    			else if(userobj.getplayerClass().equals("Archer")) {
	    				if (userobj.getInventory().contains("Compound Bow") && userobj.getInventory().contains("Crossbow")) {
	    					System.out.println("Compound Bow || Crossbow");
	    				}else if (userobj.getInventory().contains("Compound Bow")) {
	    					System.out.println("Compound Bow");
	    				}else if (userobj.getInventory().contains("Crossbow")) {
	    					System.out.println("Crossbow");
	    				}else {
	    					System.out.println("Nothing can currently be upgraded ");
	    					break;
	    				}
	    				
	    				System.out.println("Please input Exactly as shown: ");
	    				String changeTo = scan.nextLine();
	    				if (userobj.getInventory().contains(changeTo)) {
	    					userobj.setWeapEquip(changeTo);
	    					System.out.println("changed to " +changeTo);
	    					break;
	    				}else { 
	    					System.out.println("unavailable / not in inventory");
	    				}
	    			}
	    			else if(userobj.getplayerClass().equals("Mage")) {
	    				if (userobj.getInventory().contains("Upgraded Staff") && userobj.getInventory().contains("Holy Staff")) {
	    					System.out.println("Upgraded Staff || Holy Staff");
	    				}else if (userobj.getInventory().contains("Upgraded Staff")) {
	    					System.out.println("Upgraded Staff");
	    				}else if (userobj.getInventory().contains("Holy Staff")) {
	    					System.out.println("Holy Staff");
	    				}else {
	    					System.out.println("Nothing can currently be upgraded ");
	    					break;
	    				}
	    				
	    				System.out.println("Please input Exactly as shown: ");
	    				String changeTo = scan.nextLine();
	    				if (userobj.getInventory().contains(changeTo)) {
	    					userobj.setWeapEquip(changeTo);
	    					System.out.println("changed to " +changeTo);
	    					break;
	    				}else { 
	    					System.out.println("unavailable / not in inventory");
	    				}
	    			}
	    			}
	    			
	    		}else if (innChoice2 == 2) {
	    			break;
	    		}else {
	    			System.out.print("Incorrect Input !");
	    		}
	    		
	    	}else if (innChoice == 2) {
	    		break;
	    	}else { 
	    		System.out.print("Incorrect Input !");
	    	}
	    }
	}
	
	
	public static void Shop(User userobj) { //unlock upgrades
		while (true) {
			System.out.println("----------Ethereal Fowl Shop-------------");
			System.out.println("-----------------------------------------");
			System.out.println("Your Class : " + userobj.getplayerClass());
	        System.out.println("Your current gold amount : " + userobj.getGold());
	        System.out.println("-----------------------------------------");
	        System.out.println("The Upgrades available are: ");
	        System.out.println("Upgrades : Price");
	        for ( int items = 0; items<shoplist.length; items++) {
	        	System.out.println(shoplist[items] + " : " + shopPrice[items]);
	        }
	        System.out.println("-----------------------------------------");
	        System.out.println("What would you like to purchase ?");
	        System.out.println("input 'exit' to exit the shop");
	        System.out.println("input the EXACT NAME in the list : ");
	        String shopChoice1 = scan.nextLine();

	        if (shopChoice1.equals("Iron Sword")) {
	        	if (userobj.getplayerClass() == "Knight") {
	        		if (userobj.getGold() >= shopPrice[0]) {
	        			if (userobj.inventory.contains("Iron Sword")) {
	        				System.out.println("Already Unlocked");
	        			}else {
	        				userobj.setInventory("Iron Sword");
	        				userobj.setGold(-15);
	        				System.out.println("Iron Sword unlocked!");
	        				System.out.println("-----------------------------------------");
	        			}
	        		}else {
	        			System.out.println("Not enough Gold!");
	        		}
	        	}else {
	        		System.out.println("Selected item is not compatible with your Class");
	        	}
	        }else if (shopChoice1.equals("Diamond Sword")) {
	        	if (userobj.getplayerClass() == "Knight") {
	        		if (userobj.getGold() >= shopPrice[1]) {
	        			if (userobj.inventory.contains("Diamond Sword")) {
	        				System.out.println("Already Unlocked");
	        			}else { 
	        				userobj.setInventory("Diamond Sword");
	        				userobj.setGold(-35);
	        				System.out.println("Diamond Sword unlocked!");
	        				System.out.println("-----------------------------------------");
	        			}
	        		}else {
	        			System.out.println("Not enough Gold!");
	        		}
	        	}else {
	        		System.out.println("Selected item is not compatible with your Class");
	        	}
	        }else if (shopChoice1.equals("Compound Bow")) {
	        	if (userobj.getplayerClass() == "Archer") {
	        		if (userobj.getGold() >= shopPrice[2]) {
	        			if (userobj.inventory.contains("Compound Bow")) {
	        				System.out.println("Already Unlocked");
	        			}else { 
	        				userobj.setInventory("Compound Bow");
	        				userobj.setGold(-20);
	        				System.out.println("Compound Bow unlocked!");
	        				System.out.println("-----------------------------------------");
	        			}
	        		}else {
	        			System.out.println("Not enough Gold!");
	        		}
	        	}else {
	        		System.out.println("Selected item is not compatible with your Class");
	        	}
	        }else if (shopChoice1.equals("Crossbow")) {
	        	if (userobj.getplayerClass() == "Archer") {
	        		if (userobj.getGold() >= shopPrice[3]) {
	        			if (userobj.inventory.contains("Crossbow")) {
	        				System.out.println("Already Unlocked");
	        			}else { 
	        				userobj.setInventory("Crossbow");
	        				userobj.setGold(-35);
	        				System.out.println("Crossbow unlocked!");
	        				System.out.println("-----------------------------------------");
	        			}
	        		}else {
	        			System.out.println("Not enough Gold!");
	        		}
	        	}else {
	        		System.out.println("Selected item is not compatible with your Class");
	        	}
	        }else if (shopChoice1.equals("Upgraded Staff")) {
	        	if (userobj.getplayerClass() == "Mage") {
	        		if (userobj.getGold() >= shopPrice[4]) {
	        			if (userobj.inventory.contains("Upgraded Staff")) {
	        				System.out.println("Already Unlocked");
	        			}else { 
	        				userobj.setInventory("Upgraded Staff");
	        				userobj.setGold(-25);
	        				System.out.println("Upgraded Staff unlocked!");
	        				System.out.println("-----------------------------------------");
	        			}
	        		}else {
	        			System.out.println("Not enough Gold!");
	        		}
	        	}else {
	        		System.out.println("Selected item is not compatible with your Class");
	        	}
	        }else if (shopChoice1.equals("Holy Staff")) {
	        	if (userobj.getplayerClass() == "Mage") {
	        		if (userobj.getGold() >= shopPrice[5]) {
	        			if (userobj.inventory.contains("Diamond Sword")) {
	        				System.out.println("Already Unlocked");
	        			}else { 
	        				userobj.setInventory("Holy Staff");
	        				userobj.setGold(-55);
	        				System.out.println("Holy Staff unlocked!");
	        				System.out.println("-----------------------------------------");
	        			}
	        		}else {
	        			System.out.println("Not enough Gold!");
	        		}
	        	}else {
	        		System.out.println("Selected item is not compatible with your Class");
	        	}
	        }else if (shopChoice1.equals("Repair")) {
	        	if (userobj.getGold() >= shopPrice[6]) {
	        		if (userobj.inventory.contains("Iron Armor")){
	        			userobj.setArmor(100);}
	        		else {
	        			userobj.setArmor(50);
	        		}
	        		userobj.setGold(-20);
	        		System.out.println("Armor refreshed!");
	    	        System.out.println("-----------------------------------------");
	        	}else {
	        		System.out.println("Not enough Gold!");
	        	}
	        }else if (shopChoice1.equals("Iron Armor")) {
	        	if (userobj.getGold() >= shopPrice[7]) {
	        		if (userobj.inventory.contains("Iron Armor")) {
        				System.out.println("Already Unlocked");
        			}else { 
        				userobj.setInventory("Iron Armor");
        				userobj.setArmor(100);
        				userobj.setGold(-7);
        				System.out.println("Iron Armor Purchased and automatically equipped!");
        				System.out.println("-----------------------------------------");
        			}
	        	}else {
	        		System.out.println("Not enough Gold!");
	        	}
	        }else if (shopChoice1.equals("exit")) {
	        	break;
	        }else { 
	        	System.out.println("Error input!");
	        }
	        
		}
		
	}
	
	/*
	public static void main(String[]args) throws InterruptedException {
		User player1 = new User("player1", "Male", "Knight");
		player1.setGold(30);
		player1.setInventory("Iron Sword");
		
		sleep(player1);
		
	}*/
}





