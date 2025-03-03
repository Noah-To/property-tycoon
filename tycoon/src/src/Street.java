package src;

//Parent class for all the streets on the board
public class Street {

    String color;               //Attribute color
    int position;               //Attribute position
    String owner;

    public Street(){
        this.color = "";
    }

    //Method to receive position of the street
    public int getPosition(){
        return this.position;
    }

    //Method of color identification
    public String getColor(){ return "";}

    //Method of getting an owner
    public void bought(Player player){}

    //Method of losing and owner
    public void sold(){}

    //Method to increase level, if level reached 2 for "Brown" and "Deep blue" and 3 for all other, player can build house
    public void incLevel(){}

    //Decrease level
    public void decLevel(){}

    //Building house
    public void buildHouse(){}

    //Selling house when its needed
    public void sellHouse(){}

    //Calculating cost of rent
    public void costOfRent(){}

    public Player getOwner(){ return null;}

    public int getRent(){return 0;};

    public int getCost(){return 0;}
}
