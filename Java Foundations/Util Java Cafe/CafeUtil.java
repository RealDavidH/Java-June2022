import java.util.ArrayList;

public class CafeUtil{
        public int getStreakGoal(){
            int sum = 0;
            for(int i = 0; i<10; i++){
                sum += i;
            }
            return sum;
        }
        public double getOrderTotal(double[] prices){
            double sum = 0;
            for(double item : prices){
                sum += item;
            }
            return sum;
        }
        public void displayMenu(ArrayList<String> menuItems){
            System.out.println(menuItems);
            for(int i = 0; i < menuItems.size(); i++){
                String item = menuItems.get(i) + " " + i;
                System.out.println(item);
            }
        }
        public void addCustomer(ArrayList<String> customers){
            System.out.println("please enter your name");
            String userName = System.console().readLine();
            System.out.println("Hello, " + userName);
            System.out.println("There are " + customers.size() + " customer(s) ahead of you.");
            customers.add(userName);
            System.out.println(customers);
        }
}
