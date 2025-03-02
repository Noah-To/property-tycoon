package src;

//Look the "Street" class for explanation
public class Tax extends Street{
    int rent;
    Player owner = null;
    int position;

    public Tax(int rent, int position){
        this.position = position;
        this.rent = rent;
    }

    public Player getOwner() {
        return null;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }
}
