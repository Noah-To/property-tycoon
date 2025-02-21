package src;

//Look the "Street" class for explanation
public class Tax extends Street{
    int rent;
    String owner = "Bank";
    int position;

    public Tax(int rent, int position){
        this.position = position;
        this.rent = rent;
    }
}
