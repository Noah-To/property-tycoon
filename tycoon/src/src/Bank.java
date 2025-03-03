package src;

//This class made for money operations and storage as money can not appear from nowhere
public class Bank {

    int amount = 50000;                 //declaring amount
    int taxes = 0;

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

    public void recieveMoney(int money){
        this.amount += money;
    }

    public void recieveTaxes(int taxes){
        this.taxes += taxes;
    }

    public int returnTaxes(){
        return this.taxes;
    }

    public void zeroTaxes(){ this.taxes = 0;}

}
