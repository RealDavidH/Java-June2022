import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        String res = "Hello, " + name + ". Lovely to see you.";
        return res;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        String currentDate = "It is currently " + date;
        return currentDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if(conversation.contains("Alexis")){
            String snarkyCommment = "Right away sir, she is as smart a pig";
            return snarkyCommment;
        } 
        else if(conversation.contains("Alfred")){
            String res = "At your service. As you wish naturally.";
            return res;
        } else{
            String res = "Right. And with that I shall retire";
            return res;
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

