package src;
import src.Bank;

//class player
public class Player {
    int money = 1500;
    int position = 1;
    int imprisoned = 0;
    int move_order;
    String name;

    public Player(int move_order, String name){
        this.move_order = move_order;
        this.name = name;
    }

    //Method fpr position changing
    public int move(int dices){
        if (this.position + dices > 40){
            this.position = this.position + dices - 40;
        } else {
            this.position += dices;
        }
        return this.position;
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
    public String buyStreet(int cost){
        this.money -= cost;
        return this.name;
    }

    //Selling Street
    public void sellStreet(int cost){
        this.money += cost;
    }

    //Buying house
    public void buyHouse(int cost){
        this.money -= cost;
    }

    //Selling House
    public void sellHoue(int cost) {
        this.money += cost;
    }

    //Going to jail (Via card or field 31)
    public void beImprisoned(){
        this.imprisoned = 3;
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
}
