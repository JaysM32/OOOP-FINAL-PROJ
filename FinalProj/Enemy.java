package FinalProj;

public interface Enemy<User> { // enenmy stats that are fixed and cannot be changed. 
	int enemybasedmg = -25;

	int enemyattack(User userobj, int enemyHP); // enemy recives the attack

}
