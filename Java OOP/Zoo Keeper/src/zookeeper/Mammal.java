package zookeeper;

public class Mammal {
	protected int energy;
	
	public Mammal(){
		this.energy = 100;
	}
	
	public int getEnergy(){
		return this.energy;
	}

	public void setEnergy(int energy){
		this.energy = energy;
	}

	public void displayEnergy() {
		System.out.println(this.energy);
	}
}

