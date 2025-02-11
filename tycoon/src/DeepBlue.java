package src;

public class DeepBlue extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    String color = "brown";
    String owner = "";


    public void DeepBlue(int cost, int position, int rent){
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
                if (this.position == 40){
                    this.rent = 50;
                }
                else{
                    this.rent = 35;
                }
                break;

            case 1:
                if (this.position == 40){
                    this.rent = 200;
                }
                else{
                    this.rent = 175;
                }
                break;

            case 2:
                if (this.position == 40){
                    this.rent = 600;
                }
                else{
                    this.rent = 500;
                }
                break;

            case 3:
                if (this.position == 40){
                    this.rent = 1400;
                }
                else{
                    this.rent = 1100;
                }
                break;

            case 4:
                if (this.position == 40){
                    this.rent = 1700;
                }
                else{
                    this.rent = 1300;
                }
                break;

            case 5:
                if (this.position == 40){
                    this.rent = 2000;
                }
                else{
                    this.rent = 1500;
                }
                break;

        }
    }

}