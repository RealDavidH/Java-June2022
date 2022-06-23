package coffeedore;
import java.util.*;

public class CoffeeKiosk {
	private String name;
	private double total;
	private ArrayList<String> order = new ArrayList<String>();
	public boolean valid = false;
	static HashMap<String, Double> menu = new HashMap<String, Double>() {{
		put("Latte", 4.5); 
		put("Drip Coffee", 2.0);
		put("Muffin", 1.5);
		put("Nanner", 5.0);
		}};
	static double orderTotal;
	
	public CoffeeKiosk(String name) {
		this.name = name;
	}
	
	
	public void addMenuItem(String item, double price) {
		menu.put(item, price);
	}
	
	public void displayMenu() {
		Set<String> items = menu.keySet();
		for(String item : items) {
			System.out.println(String.format("%s --- %f", item, menu.get(item)));
		}
	}
	public String newOrder(String item) {
		if(menu.containsKey(item) ) {
			this.order.add(item);
			orderTotal = orderTotal + menu.get(item);
			this.valid = true;
			return String.format("%s added to order", item);
			
		} else if(menu.containsKey(item.toUpperCase())) {
			this.order.add(item.toUpperCase());
			orderTotal = orderTotal + menu.get(item.toUpperCase());
			this.valid = true;
			return String.format("%s added to order", item.toUpperCase());
			
		} else if(menu.containsKey(item.toLowerCase())) {
			this.order.add(item.toLowerCase());
			orderTotal = orderTotal + menu.get(item.toLowerCase());
			this.valid = true;
			return String.format("%s added to order", item.toLowerCase());
		} else {
			return "Please enter a valid item";
		}
		
	}
	public void displayOrderTotal() {
		System.out.println(String.format("s% your order total is: %f", name, orderTotal));
	}
	
}
