package src;
import src.Bank;

//class player
public class Player {
    int money = 1500;                   //amount of money player has, initially its 1500
    int position = 1;                   //current position of the player
    int imprisoned = 0;                 //is player imprisoned or not, and if, for how may turns
    int move_order;                     //order in which player will take turn
    String name;                        //how players decide to show up on the board
    Boolean alive = true;               //maintaining of possibility player to play
    int loop = 0;                       //loops count

    public Player(int move_order, String name){
        this.move_order = move_order;
        this.name = name;
    }

    //Method fpr position changing
    public void move(int dices){
        if (this.position + dices > 40){
            this.position = this.position + dices - 40;
            loop++;
        } else {
            this.position += dices;
        }
        //return this.position;
    }

    //Paying rent for bank or player
    public void payRent(int rent, Player player){
        this.money -= rent;
        player.getRent(rent);
    }

    //Receiving money for rent
    public void getRent(int rent){
        this.money += rent;
    }

    //Buying street
    public void pay(int cost){
        this.money -= cost;
    }

    //Selling Street
    public void sellStreet(int cost){
        this.money += cost;
    }

    //Selling House
    public void sellHoue(int cost) {
        this.money += cost;
    }

    //Going to jail (Via card or field 31)
    public void beImprisoned(){
        if (this.imprisoned < 0){
            this.imprisoned++;
        } else {
            this.imprisoned = 3;
        }
        this.position = 11;
    }

    //When you unsuccessful of getting out from the jail
    public void turnSkip(){
        this.imprisoned -= 1;
    }

    //When you can get out of jail via double on the dices or via payment
    public void free(){
        this.imprisoned = 0;
    }

    //Getting info about is player in jail or not
    public int inPrison(){
        return this.imprisoned;
    }

    public int getPosition(){
        return this.position;
    }

    public int getMoney(){return this.money;}
}
