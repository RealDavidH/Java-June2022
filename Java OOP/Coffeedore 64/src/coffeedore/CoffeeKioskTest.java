package coffeedore;

public class CoffeeKioskTest {

	public static void main(String[] args) {
		System.out.println("Please enter your name to start your order");
		String name = System.console().readLine();
		CoffeeKiosk user = new CoffeeKiosk(name);
		while(!user.valid) {
			user.displayMenu();
			System.out.println("Please Order an item");
			user.newOrder(System.console().readLine());
		}
		user.displayMenu();
		
	}

}
