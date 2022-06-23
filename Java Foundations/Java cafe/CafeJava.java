public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        double latte = 4;
        double cappuccino = 5.25;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder1){
            System.out.println(customer1 + readyMessage);
        } else {
            System.out.println(customer1 + pendingMessage);
        }
        if(isReadyOrder2){
            String total = displayTotalMessage + cappuccino;
            System.out.println(customer2 + readyMessage);
            System.out.println(total);
        } else{
            System.out.println(customer2 + pendingMessage);
        }
        if(isReadyOrder3){
            isReadyOrder3 = false;
            System.out.println(customer3 + pendingMessage);
        } else {
            isReadyOrder3 = true;
            String total = displayTotalMessage + (latte + latte);
            System.out.println(customer3 + readyMessage);
            System.out.println(total);
        }
        String newTotal = displayTotalMessage + (latte - dripCoffee);
        System.out.println(customer4 + ", " + newTotal);
    }
}
