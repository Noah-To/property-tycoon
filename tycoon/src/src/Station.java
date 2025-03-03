package src;

//Look the "Street" class for explanation
public class Station extends Street {

    int level = 0;
    int cost = 200;
    int rent = 0;
    int position;
    Player owner = null;
    String color = "station";

    public Station(int position) {
        this.position = position;
    }

    public void bought(Player owner){
        this.owner = owner;
        level++;
    }

    public Player getOwner(){
        return this.owner;
    }

    @Override
    public String getColor() {
        return "Station";
    }

    public void sold(){
        this.owner = null;
        this.level = 0;
    }

    public int getRent(){
        return this.rent;
    }

    public void incLevel(){
        level++;
    }

    public void decLevel(){
        level--;
    }

    public void costOfRent(){
        this.rent = 25 * (2^(level-1));
    }

    public int getCost(){return this.cost;}
}
