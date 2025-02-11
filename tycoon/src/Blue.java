public class Blue extends Street{

    int cost;
    int position;
    int rent;
    int level = 0;
    int houses = 0;
    String color = "brown";
    String owner = "";


    public void Blue(int cost, int position, int rent){
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
                if (this.position == 10){
                    this.rent = 8;
                }
                else{
                    this.rent = 6;
                }
                break;

            case 1:
                if (this.position == 10){
                    this.rent = 40;
                }
                else{
                    this.rent = 30;
                }
                break;

            case 2:
                if (this.position == 10){
                    this.rent = 120;
                }
                else{
                    this.rent = 90;
                }
                break;

            case 3:
                if (this.position == 10){
                    this.rent = 300;
                }
                else{
                    this.rent = 270;
                }
                break;

            case 4:
                if (this.position == 10){
                    this.rent = 450;
                }
                else{
                    this.rent = 400;
                }
                break;

            case 5:
                if (this.position == 10){
                    this.rent = 600;
                }
                else{
                    this.rent = 550;
                }
                break;

        }

    }
}
