package src;

public class Green extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    String color = "brown";
    String owner = "";


    public void Green(int cost, int position, int rent){
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
                if (this.position == 35){
                    this.rent = 28;
                }
                else{
                    this.rent = 26;
                }
                break;

            case 1:
                if (this.position == 35){
                    this.rent = 150;
                }
                else{
                    this.rent = 130;
                }
                break;

            case 2:
                if (this.position == 35){
                    this.rent = 450;
                }
                else{
                    this.rent = 350;
                }
                break;

            case 3:
                if (this.position == 35){
                    this.rent = 1000;
                }
                else{
                    this.rent = 900;
                }
                break;

            case 4:
                if (this.position == 35){
                    this.rent = 1200;
                }
                else{
                    this.rent = 1100;
                }
                break;

            case 5:
                if (this.position == 35){
                    this.rent = 1400;
                }
                else{
                    this.rent = 1275;
                }
                break;

        }
    }

}