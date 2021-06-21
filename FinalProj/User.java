package FinalProj;



import java.util.ArrayList;
import java.util.Hashtable;



public class User { //user datas and creation.
	private String name, gender, WeapEquip, playerClass;
	private int level, health, armor, mana, EXP, gold, food, drink;
	private boolean defend,eaten,drunk;
	Hashtable<String, String> Attri = new Hashtable<String, String>();
	ArrayList<String> inventory = new ArrayList();
	
	public User(String name, String gender, String playerClass) { // creates the user
		this.name   = name; this.gender = gender; this.playerClass  = playerClass; // user-inputed
		this.level  = 1; this.EXP = 0; this.mana = 100; // level wise
		this.health = 50; this.armor  = 50; this.defend = false;// health wise
		this.gold = 20; this.food = 4; this.drink = 2; // inventory wise
		this.eaten = false; this.drunk = false; //buffs
		
		
		this.inventory.add("Heal");
		this.inventory.add("Eat");
		this.inventory.add("Drink");
		
		if (playerClass == "Knight") {// low dmg compared but tanky
			this.inventory.add("Sword");
			this.WeapEquip = "Sword";
			
			Attri.put("INT", "2");
			Attri.put("STR", "5");
			Attri.put("AGI", "3");
			Attri.put("LCK", "2");
			Attri.put("MGC", "1");
		}else if (playerClass == "Archer") { // agile long-range
			this.inventory.add("Bow");
			this.WeapEquip = "Bow";
			
			Attri.put("INT", "4");
			Attri.put("STR", "2");
			Attri.put("AGI", "4");
			Attri.put("LCK", "2");
			Attri.put("MGC", "1");
		}else if (playerClass == "Mage") { //glass cannon
			this.inventory.add("Staff");
			this.WeapEquip = "Staff";
			
			Attri.put("INT", "5");
			Attri.put("STR", "1");
			Attri.put("AGI", "2");
			Attri.put("LCK", "3");
			Attri.put("MGC", "4");
		}
	}
	
	public boolean hasEaten() {
		return eaten;
	}

	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}

	public boolean hasDrunk() {
		return drunk;
	}

	public void setDrunk(boolean drunk) {
		this.drunk = drunk;
	}

	public int getInventorySize() {
		return inventory.size();
	}
	public ArrayList<String> getInventory() {
		return inventory;
	}
	
	public String getInventorySpecific(int index) {
		return inventory.get(index);
	}

	public void setInventory(String item) {
		this.inventory.add(item);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWeapEquip() {
		return WeapEquip;
	}

	public void setWeapEquip(String weapEquip) {
		WeapEquip = weapEquip;
	}
	
	public String getplayerClass() {
		return playerClass;
	}

	public void setplayerClass(String class1) {
		playerClass = class1;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int sethealth) {
		this.health = this.health + sethealth;
		if( this.health >100) {
			this.health = 100;
		}
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int increasearmor) {
		this.armor += increasearmor;
		if (this.armor > 100 && inventory.contains("Iron Armor")) {
			this.armor = 100;
		}else {
			if(this.armor > 50) {
				this.armor = 50;
			}
		}
	}

	public int getEXP() {
		return EXP;
	}

	public void setEXP(int eXP) {
		EXP = EXP + eXP;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int change) {
		this.gold = gold + change;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getDrink() {
		return drink;
	}

	public void setDrink(int drink) {
		this.drink = drink;
	}

	public boolean isDefend() {
		return defend;
	}

	public void setDefend(boolean defend) {
		this.defend = defend;
	}
	public int getMana() {
		return mana;
	}

	public void setMana(int setmana) {
		this.mana = mana + setmana;
		if(this.mana >100) {
			this.mana = 100;
		}
	}

	public void checkLevel() { // checks the level and level ups the player if necessary
		if (EXP == 100) {
			level++;
			EXP = 0;
			if (level == 5) {
				level = 5;
				System.out.println("Max Level reached");
			}else {
				System.out.println("Level Up!");
			}
		}
		if (level == 2) { 
			if (playerClass == "Knight") {
				Attri.put("INT", "2");
				Attri.put("STR", "6");
				Attri.put("AGI", "4");
				Attri.put("LCK", "3");
				Attri.put("MGC", "2");
			}else if (playerClass == "Archer") {
				Attri.put("INT", "5");
				Attri.put("STR", "2");
				Attri.put("AGI", "5");
				Attri.put("LCK", "3");
				Attri.put("MGC", "2");
			}else if (playerClass == "Mage") {
				Attri.put("INT", "6");
				Attri.put("STR", "2");
				Attri.put("AGI", "2");
				Attri.put("LCK", "4");
				Attri.put("MGC", "5");
			}
		}else if(level == 3 ) {
			if (playerClass == "Knight") {
				Attri.put("INT", "3");
				Attri.put("STR", "7");
				Attri.put("AGI", "5");
				Attri.put("LCK", "4");
				Attri.put("MGC", "2");
			}else if (playerClass == "Archer") {
				Attri.put("INT", "5");
				Attri.put("STR", "3");
				Attri.put("AGI", "6");
				Attri.put("LCK", "4");
				Attri.put("MGC", "2");
			}else if (playerClass == "Mage") {
				Attri.put("INT", "7");
				Attri.put("STR", "2");
				Attri.put("AGI", "3");
				Attri.put("LCK", "5");
				Attri.put("MGC", "6");
			}
		}else if(level == 4 ) {
			if (playerClass == "Knight") {
				Attri.put("INT", "4");
				Attri.put("STR", "8");
				Attri.put("AGI", "6");
				Attri.put("LCK", "5");
				Attri.put("MGC", "3");
			}else if (playerClass == "Archer") {
				Attri.put("INT", "6");
				Attri.put("STR", "4");
				Attri.put("AGI", "8");
				Attri.put("LCK", "5");
				Attri.put("MGC", "3");
			}else if (playerClass == "Mage") {
				Attri.put("INT", "8");
				Attri.put("STR", "3");
				Attri.put("AGI", "4");
				Attri.put("LCK", "6");
				Attri.put("MGC", "7");
			}
		}else if(level == 5 ) {
			if (playerClass == "Knight") {
				Attri.put("INT", "4");
				Attri.put("STR", "9");
				Attri.put("AGI", "6");
				Attri.put("LCK", "5");
				Attri.put("MGC", "2");
			}else if (playerClass == "Archer") {
				Attri.put("INT", "6");
				Attri.put("STR", "4");
				Attri.put("AGI", "9");
				Attri.put("LCK", "6");
				Attri.put("MGC", "2");
			}else if (playerClass == "Mage") {
				Attri.put("INT", "8");
				Attri.put("STR", "3");
				Attri.put("AGI", "4");
				Attri.put("LCK", "6");
				Attri.put("MGC", "8");
		}
		}
	}

	
}
