package src;
import java.util.Random;

//Class for object dice
public class Dice {
    public Dice(){
    }

    //Returns a random number from 1 to 6
    public int score(){
        Random rnd = new Random();
        return rnd.nextInt(0, 6) + 1;
    }
}
