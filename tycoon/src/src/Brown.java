package src;

//Look the "Street" class for explanation
public class Brown extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    int house_cost = 50;
    String color = "brown";
    String owner = "";

    public Brown(int cost, int position, int rent){
        this.cost = cost;
        this.position = position;
        this.rent = rent;
    }

    public String getOwner(){
        return this.owner;
    }

    public String getColor(){
        return this.color;
    }

    public void bought(String owner){
        this.owner = owner;
        level++;
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

    public void buildHouse(){
        houses++;
        this.costOfRent();
    }

    public void sellHouse(){
        houses--;
        this.costOfRent();
    }

    public void costOfRent(){

        int h = this.houses;

        switch(h){
            case 0:
                this.rent = 2 * (this.position / 2);
                break;
            case 1:
                this.rent = 10 * (this.position / 2);
                break;
            case 2:
                this.rent = 30 * (this.position / 2);
                break;
            case 3:
                this.rent = 90 * (this.position / 2);
                break;
            case 4:
                this.rent = 160 * (this.position / 2);
                break;
            case 5:
                if (this.position == 4) {
                    this.rent = 450;
                }
                else {
                    this.rent = 250;
                }
                break;
        }

    }
}
