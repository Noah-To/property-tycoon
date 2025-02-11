package src;

public class Red extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    String color = "brown";
    String owner = "";


    public void Red(int cost, int position, int rent){
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
                if (this.position == 25){
                    this.rent = 20;
                }
                else{
                    this.rent = 18;
                }
                break;

            case 1:
                if (this.position == 25){
                    this.rent = 100;
                }
                else{
                    this.rent = 90;
                }
                break;

            case 2:
                if (this.position == 25){
                    this.rent = 300;
                }
                else{
                    this.rent = 250;
                }
                break;

            case 3:
                if (this.position == 25){
                    this.rent = 750;
                }
                else{
                    this.rent = 700;
                }
                break;

            case 4:
                if (this.position == 25){
                    this.rent = 925;
                }
                else{
                    this.rent = 875;
                }
                break;

            case 5:
                if (this.position == 25){
                    this.rent = 1100;
                }
                else{
                    this.rent = 1050;
                }
                break;

        }
    }

}