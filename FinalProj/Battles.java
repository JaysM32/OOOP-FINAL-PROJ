package FinalProj;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public abstract class Battles implements Player, Enemy{
	
	static Scanner scan = new Scanner(System.in);
	
	// player abilities 
	public static void heal(User userobj) {
		userobj.setHealth(Healpoints);
	}
	
	public static void eat(User userobj) {
		userobj.setEaten(true);
	}
	
	public static void drink(User userobj) {
		userobj.setDrunk(true);
	}
	
	public static void defend(User userobj) {
		userobj.setDefend(true);
	}
	
	public static void recieveattack(User userobj) {
		if (userobj.isDefend()) {
			System.out.println("you blocked the enemy's attack!");
		}else {
			if (userobj.hasDrunk()) {
				if (userobj.getArmor() > 0 ) {
					userobj.setArmor((int)(enemybasedmg + (basedmgred*drinkdefincre)));
				}
				else {
					userobj.setHealth((int)(enemybasedmg + (basedmgred*drinkdefincre)));
				}
			}else {
				if (userobj.getArmor() > 0 ) { 
				userobj.setArmor((int)(enemybasedmg + basedmgred));
				}else {
					userobj.setHealth((int)(enemybasedmg + basedmgred));
				}
			}
		}
	}
	public static int enemyattack (User userobj, int enemyHP) {
		if (userobj.hasEaten()) {
			enemyHP = (int) (enemyHP - (basedmg*eatatkincre));
		}else {
			enemyHP = enemyHP - basedmg;
		}
		return enemyHP;
		
	}

	public static void treasure(User userobj) throws InterruptedException { // no battle only rewards
		System.out.println("-------------------------------------------------------");
		System.out.println("--------------You found a treasure chest!--------------");
		System.out.println("-------------------------------------------------------");
		System.out.println("You received: ");
		System.out.println("- 3 EXP");
		System.out.println("- 15 Gold");
		System.out.println("-------------------------------------------------------");
		TimeUnit.SECONDS.sleep(2);
		userobj.setEXP(3);
		userobj.setGold(15);
		
	}

	
	
	public static void battle(User userobj) throws InterruptedException {// battle ( future update will make use of the player's class ( i ran out of time to make it )
		int enemyHP = 150; // enemy status
		String turn = "enemy"; boolean isdefend = false; // enemy stats 2.0
		int eatCount = 0, drinkCount = 0;
		
		System.out.println("-------------------------------------------------------");
		System.out.println("---------------you encountered an enemy !--------------");
		System.out.println("-------------------------------------------------------");
		TimeUnit.SECONDS.sleep(3);
		while (true){
			if (enemyHP <= 0 ) {
				userobj.setEXP(6);
				userobj.setGold(10);
				break;
			}
			if (turn.equals("enemy")) {
				turn = "player";
			}else {
				turn = "enemy";
			}
			if(drinkCount >= 3) {
				userobj.setDrunk(false);
			}
			if(eatCount >= 3) {
				userobj.setEaten(false);
			}
			if (userobj.hasDrunk()) {
				drinkCount += 1;
			}
			if (userobj.hasEaten()) {
				eatCount += 1;
			}
			
			
			draw.displayStatus(userobj);
			System.out.println("----------------------------------------");
			System.out.println("Current Turn = " + turn);
			System.out.println("----------------------------------------");
			System.out.println("Enemy Health = " + enemyHP);
			System.out.println("Player Health = " + userobj.getHealth());
			System.out.println("PLayer Armor = " + userobj.getArmor());
			System.out.println("----------------------------------------");
			
			if (turn.equals("enemy")) {
				System.out.println("Enemy has dealt damage to you!");
				recieveattack(userobj);
				TimeUnit.SECONDS.sleep(2);
				
			}else {
				System.out.println("1. Attack");
				System.out.println("2. Defend");
				System.out.println("3. Heal");
				System.out.println("4. Flee");
				System.out.println("5. Eat (Dmg Buff)");
				System.out.println("6. Drink (Def Buff)");
				System.out.println("----------------------------------------");
				int battleChoice = scan.nextInt();
				if (battleChoice == 1) { // attack
					System.out.println("Damage dealt");
					enemyHP = enemyattack(userobj, enemyHP);					
				}else if (battleChoice == 2) {
					System.out.println("You decided to defend.");
					defend(userobj);
				}else if (battleChoice == 3) {
					System.out.println("You decided to heal.");
					heal(userobj);
				}else if (battleChoice == 4) {
					int max = 10;
			        int min = 1;
			        int range = max - min + 1;
					int chance = (int)(Math.random()*range)+min;
					if (userobj.Attri.get("LCK").equals("4")) {
						if (chance >= 35) {
							System.out.println("You have escaped.");
							TimeUnit.SECONDS.sleep(1);
							break;
						}else {
							System.out.println("Unable to escape.");
						}
					}else if (userobj.Attri.get("LCK").equals("5")) {
						if (chance >= 45) {
							System.out.println("You have escaped.");
							TimeUnit.SECONDS.sleep(1);
							break;
						}else {
							System.out.println("Unable to escape.");
						}
					}else if (userobj.Attri.get("LCK").equals("6")) {
						if (chance >= 55) {
							System.out.println("You have escaped.");
							TimeUnit.SECONDS.sleep(1);
							break;
						}else {
							System.out.println("Unable to escape.");
						}
					}else {
						System.out.println("Unable to escape.");
					}
				}else if (battleChoice == 5) {
					eat(userobj);
				}else if (battleChoice ==6) {
					drink(userobj);
				}else { 
		        	System.out.println("Error input!");
		        }
			}
		}
		
	}
	
	public static void dungeon(User userobj) throws InterruptedException {// scene sorting / RNG 
		
		System.out.println("You entered the dungeon.");
		while (true) {
			int max = 100; int min = 1; int range = max - min + 1;
			int chance = (int)(Math.random()*range)+min;
			System.out.println("------------The Dungeon---------------");
	        System.out.println("would you like to search deeper ?");
	        System.out.println("1. Yes");
	        System.out.println("2. No");
	        System.out.println("--------------------------------------");
	        int searchChoice = scan.nextInt();
	        if (searchChoice == 1) {
	        	if (chance > 10) {
	        		battle(userobj);
	        	}else {
	        		treasure(userobj);
	        	}
	        }else if (searchChoice == 2) {
	        	break;
	        }else { 
	        	System.out.println("Error input!");
	        }
		}
	}
	
	
	
	public static void main(String[]args) throws InterruptedException {
		User player1 = new User("player1", "Male", "Knight");
		player1.setGold(30);
		
		dungeon(player1);
		
	}
}
