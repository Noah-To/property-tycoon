package src;

public class Purple extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    String color = "brown";
    String owner = "";


    public void Purple(int cost, int position, int rent){
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
                if (this.position == 15){
                    this.rent = 12;
                }
                else{
                    this.rent = 10;
                }
                break;

            case 1:
                if (this.position == 15){
                    this.rent = 60;
                }
                else{
                    this.rent = 50;
                }
                break;

            case 2:
                if (this.position == 15){
                    this.rent = 180;
                }
                else{
                    this.rent = 150;
                }
                break;

            case 3:
                if (this.position == 15){
                    this.rent = 500;
                }
                else{
                    this.rent = 450;
                }
                break;

            case 4:
                if (this.position == 15){
                    this.rent = 700;
                }
                else{
                    this.rent = 625;
                }
                break;

            case 5:
                if (this.position == 15){
                    this.rent = 900;
                }
                else{
                    this.rent = 750;
                }
                break;

        }
    }

}