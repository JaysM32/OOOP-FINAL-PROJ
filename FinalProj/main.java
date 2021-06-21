package FinalProj;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {
	
	public static void clear() {// clears the console. havent gotten it to work on console, however.
		System.out.print("\033[H\033[2J");  
		System.out.flush(); 
	}
	
	public static void main ( String []args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			draw.MainMenu();
			int mainmenuChoice = scan.nextInt();
			if ( mainmenuChoice == 1) {
				System.out.println("-----------------------------------");
				System.out.println("Currently Loading");
				System.out.println("-----------------------------------");
				TimeUnit.SECONDS.sleep(2);
				String[] userData;
				userData = userCreation.CreateUser();
				User player1 = new User(userData[0], userData[1], userData[2]);
				System.out.println("-----------------------------------");
				System.out.println("Currently Loading");
				System.out.println("-----------------------------------");
				TimeUnit.SECONDS.sleep(4);
				draw.startstory();
				int startstoryChoice = scan.nextInt();
				if (startstoryChoice == 1) {
					draw.introstory1(player1);
					int Choice2 = scan.nextInt();
					if (Choice2 == 1) {
						Town.Shop(player1);
					}else if (Choice2 == 2) {
						Town.sleep(player1);
					}else { 
						System.out.println("Error input!");
					}
				
					while (true) {
						draw.insidetown();
						int Choice3 = scan.nextInt();
						if (Choice3 == 0) {
							break;
						}else if (Choice3 == 1) {
							Town.Shop(player1);
						}else if (Choice3 == 2) {
							Town.sleep(player1);
						}else if (Choice3 == 3) {
							Battles.dungeon(player1);
						}else { 
							System.out.println("Error input!");
						}
					}
				}else if (startstoryChoice == 2) {
					draw.introstory2();
					break;
				}
			
			}else if (mainmenuChoice == 2) {
				draw.helpmenu();
				try
		        {
		            System.in.read();
		        }  
		        catch(Exception e)
		        {} 
			}else if (mainmenuChoice == 3) {
				System.out.println("Thank You for playing the game!");
			}else {
				System.out.println("Error input!");
			}
		}
	}
}
