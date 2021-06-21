package FinalProj;

public interface Player<User> {// player's fixed stats and abilities. 
	int Healpoints = 40;
	int basedmg = 20;
	int basedmgred = 2;
	double eatatkincre = 2;
	double drinkdefincre = 1.5;
	
	void heal(User userobj); // heals the user 
	void eat(User userobj); // increase damage dealt
	void drink(User userobj); // increase damage reduction 
	void defend(User userobj); // ignore next damage
	void receiveattack(User userobj); // deal damage
	
}
