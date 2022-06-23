import java.util.Random;
import java.util.ArrayList;


public class Puzzling {
    Random randMachine = new Random();
    public ArrayList<Integer> rollTenRolls(){
        int i = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while(i < 10){
            array.add(randMachine.nextInt(20 - 1 + 1) + 1);
            i++;
        }
        return array;
    }
    public char getRandomLetter(){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int i = randMachine.nextInt(25 - 0 + 1);
        char letter = alphabet[i];
        return letter;
    }
    public String generatePassword(int length){
        int i = 0;
        String password = "";
        while(i < length){
            password = password + getRandomLetter();
            i++;
        }
        return password;
    }
}
