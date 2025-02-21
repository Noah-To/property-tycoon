package src;

//This class made for money operations and storage as money can not appear from nowhere
public class Bank {

    int amount = 50000;                 //declaring amount
    public Bank(){}

    //Method for receiving money from player for operation
    public void getMoney(int money){
        amount += money;
    }

    //Method for giving money to player
    public void giveMoney(int money){
        if (amount - money > 0){
            amount -= money;
        }
    }

}
