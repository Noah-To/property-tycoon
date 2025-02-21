package src;

//Look the "Street" class for explanation
public class Station extends Street {

    int level = 0;
    int cost = 200;
    int rent = 0;
    int position;
    String owner = "";

    public Station(int position) {
        this.position = position;
    }

    public void bought(String owner){
        this.owner = owner;
        level++;
    }

    public String getOwner(){
        return this.owner;
    }

    public void sold(){
        this.owner = "";
        this.level = 0;
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
}
