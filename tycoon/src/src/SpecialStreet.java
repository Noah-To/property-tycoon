package src;

//Streets with no owners
public class SpecialStreet extends Street{
    int position;

    public SpecialStreet(int position){this.position = position;}

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }
}
