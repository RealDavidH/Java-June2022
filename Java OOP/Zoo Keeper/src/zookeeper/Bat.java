package zookeeper;

public class Bat extends Mammal {
	

	public Bat(){
		super();
		this.energy = 300;
	}
	
	public void fly() {
		System.out.println("I am a bat and I am flying (-50 energy)");
		this.energy -= 50;
	}
	public void eatHumans() {
		System.out.println("I am a bat and I am eating yummy Humans(+25 energy)");
	}
	public void attackTown() {
		System.out.println("RAWR I AM A BAT AND I AM ATTACKING THE TOWN! (-100 energy)");
		this.energy -= 100;
	}
}
