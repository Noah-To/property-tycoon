package src;

//Look the "Street" class for explanation
public class Utility extends Street {

    int level = 0;
    int cost = 200;
    int rent = 0;
    int position;
    Player owner = null;
    String color = "utility";

    public Utility(int position) {
        this.position = position;
    }

    public void bought(Player owner){
        this.owner = owner;
        level++;
    }

    public Player getOwner(){
        return this.owner;
    }

    public void sold(){
        this.owner = null;
        this.level = 0;
    }

    @Override
    public String getColor() {
        return "Utility";
    }

    public void incLevel(){
        level++;
    }

    public void decLevel(){
        level--;
    }

    public int getRent(){
        return this.rent;
    }

    public int getCost(){return this.cost;}

    public void costOfRent(int dice){
        if (level == 1){
            rent = dice * 4;
        }
        else if (level == 2){
            rent = dice * 10;
        }
    }
}