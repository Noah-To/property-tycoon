package src;

public class Utility extends Street {

    int level = 0;
    int cost = 200;
    int rent = 0;
    int position;
    String owner = "";

    public Utility(int position) {
        this.position = position;
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

    public void costOfRent(int dice){
        if (level == 1){
            rent = dice * 4;
        }
        else if (level == 2){
            rent = dice * 10;
        }
    }
}