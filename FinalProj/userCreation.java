package FinalProj;

import java.util.Scanner;

public class userCreation { // creates the user


	public static String[] CreateUser() {
		Scanner scan = new Scanner(System.in);
		
		String name,gender,Class;
		
		while (true) {
		System.out.println("------------------------------------------------");
		System.out.println("Please input a name.");
		name = scan.next();
		System.out.println("Pick a gender. ( Female or Male )\n( write exactly as shown ): ");
		gender = scan.next();
		System.out.println("Pick a class ( Knight / Archer / Mage )\n( write exactly as shown ):");
		Class = scan.next();
		
		System.out.println("Are you sure ? ( Please check for typos ) (Y/N)");
		String sure = scan.next();
		
		//System.out.println(sure.toUpperCase());
		
		if(sure.toUpperCase().equals("Y")) {
			break;
			}
		}
		
		String[] returns = new String[3];
		returns[0] = name;
		returns[1] = gender;
		returns[2] = Class;
		
		return returns;
	}
	
	
}
