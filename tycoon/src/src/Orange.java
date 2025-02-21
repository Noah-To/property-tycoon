package src;

//Look the "Street" class for explanation
public class Orange extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    int house_cost = 100;
    String color = "brown";
    String owner = "";

    public Orange(int cost, int position, int rent){
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
                if (this.position == 20){
                    this.rent = 16;
                }
                else{
                    this.rent = 14;
                }
                break;

            case 1:
                if (this.position == 20){
                    this.rent = 80;
                }
                else{
                    this.rent = 70;
                }
                break;

            case 2:
                if (this.position == 20){
                    this.rent = 220;
                }
                else{
                    this.rent = 200;
                }
                break;

            case 3:
                if (this.position == 20){
                    this.rent = 600;
                }
                else{
                    this.rent = 550;
                }
                break;

            case 4:
                if (this.position == 20){
                    this.rent = 800;
                }
                else{
                    this.rent = 750;
                }
                break;

            case 5:
                if (this.position == 20){
                    this.rent = 1000;
                }
                else{
                    this.rent = 950;
                }
                break;

        }
    }

}