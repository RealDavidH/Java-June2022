package zookeeper;

public class Gorilla extends Mammal {
	
	public void eatBananas() {
		System.out.println("MMMM banana is good for my health (+10 energy)");
		this.energy += 10;
	}
	public void throwSomething() {
		System.out.println("Ooo aahhh ahh, I throw something at people (-5 energy)");
		this.energy -= 5;
	}
	public void climbTree() {
		System.out.println("I am climbing a tree look at me go! (-10 Energy)");
		this.energy -= 10;
	}
	
}
