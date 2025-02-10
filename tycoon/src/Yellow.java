package src;

public class Yellow extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    String color = "brown";
    String owner = "";


    public void Yellow(int cost, int position, int rent){
        this.cost = cost;
        this.position = position;
        this.rent = rent;
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

        h = this.houses;

        switch(h){

            case 0:
                if (this.position == 30){
                    this.rent = 24;
                }
                else{
                    this.rent = 22;
                }
                break;

            case 1:
                if (this.position == 30){
                    this.rent = 120;
                }
                else{
                    this.rent = 110;
                }
                break;

            case 2:
                if (this.position == 30){
                    this.rent = 360;
                }
                else{
                    this.rent = 330;
                }
                break;

            case 3:
                if (this.position == 30){
                    this.rent = 850;
                }
                else{
                    this.rent = 800;
                }
                break;

            case 4:
                if (this.position == 30){
                    this.rent = 1025;
                }
                else{
                    this.rent = 975;
                }
                break;

            case 5:
                if (this.position == 30){
                    this.rent = 1200;
                }
                else{
                    this.rent = 1150;
                }
                break;

        }
    }

}