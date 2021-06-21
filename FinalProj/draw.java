package FinalProj;

public class draw { // draws the UI / Text
	
	public static void MainMenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("     --------   CLOUD RPG 2.0   --------       ");
		System.out.println("-----------------------------------------------");
		System.out.println("   A Text-Based RPG created by Jayson Mikael   ");
		System.out.println("           Created using Java ");
		System.out.println("-----------------------------------------------");
		System.out.println("1. Play");
		System.out.println("2. Help");
		System.out.println("3. Exit");
		System.out.println("-----------------------------------------------");
	}
	
	public static void displayStatus(User userobj) {
		System.out.println("-----------------------------------------------");
		System.out.println("Name : " + userobj.getName());
		System.out.println("level : " +userobj.getLevel());
		System.out.println("Exp : " +userobj.getEXP());
		System.out.println("Current Equipped Weapon = " + userobj.getWeapEquip());
		System.out.println("-----------------------------------------------");
	}
	
	public static void helpmenu() {
		System.out.println("-----------------------------------------------");
		System.out.println("       --------   CLOUD RPG   --------         ");
		System.out.println("-----------------------------------------------");
		System.out.println("   A Text-Based RPG created by Jayson Mikael   ");
		System.out.println("           Created using Java ");
		System.out.println("-----------------------------------------------");
		System.out.println("Follow each command in order to continue");
		System.out.println("usually by either inputing numbers or specific ");
		System.out.println("words");
		System.out.println("This is created as i am unable to draw for the ");
		System.out.println("sake of my life");
		System.out.println("-----------------------------------------------");
		System.out.println("press 'enter' to continue");
	}
	
	public static void startstory() {
		System.out.println("-----------------------------------------------");
		System.out.println("current location: Forest");
		System.out.println("you are currently running away from what it \n"
							+ "seems to be a bear. ");
		System.out.println("you're tired and your sword and armor has taken");
		System.out.println("some damage. ");
		System.out.println("In front, you see a town with guards on the entrance.");
		System.out.println("-----------------------------------------------");
		System.out.println("your current choices ");
		System.out.println("1. run torwards the town and ask help from the guard");
		System.out.println("2. fight the bear");
	}
	
	public static void introstory1(User userobj) {
		System.out.println("-----------------------------------------------");
		System.out.println("You ran straight to the entrance and the guards");
		System.out.println("sees the bear and helps you. ");
		System.out.println("The bear decided to ran away after seeing the guards");
		System.out.println("You are now safe");
		System.out.println("Guard1 = 'What is your name, adventurer ? '");
		System.out.println(userobj.getName() +  "= my name is " + userobj.getName() + ".");
		System.out.println("guard2 = 'You might want to head inside and take a break.'");
		System.out.println("you head inside...");
		System.out.println("Inside you saw a shop, the blacksmith and the inn.");
		System.out.println("-----------------------------------------------");
		System.out.println("Where will you go ?");
		System.out.println("1. Shop ( unlock upgrades )");
		System.out.println("2. Inn ( sleep )");
		System.out.println("-----------------------------------------------");
	}
	
	public static void introstory2() {
		System.out.println("-----------------------------------------------");
		System.out.println("you decided to fight the bear. the bear was very strong \n"+
    		"but you still had some fight left inside. you fought the bear,\n" +
    		"yet the bear was overwhelming you. in the end, you werent able to " +
    		"defeat the bear, and you died. ");
		System.out.println("-----------------------------------------------");
		System.out.println("                 Game Over");
	}
	
	public static void insidetown() {
		System.out.println("You are currently in the town. ");
		System.out.println("-----------------------------------------------");
		System.out.println("Where will you go ?");
		System.out.println("0. Exit to Main Menu");
		System.out.println("1. Shop ( unlock upgrades )");
		System.out.println("2. Inn ( sleep )");
		System.out.println("3. Dungeon ( battles )");
		System.out.print("-----------------------------------------------");
	}
}
