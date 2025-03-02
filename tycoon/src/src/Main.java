package src;
import com.sun.source.tree.WhileLoopTree;
import src.Map;
import src.Dice;
import src.Player;
import src.Street;

public class Main {
    public static void main(String[] args) {

        Dice d1 = new Dice();
        Dice d2 = new Dice();

        Map map = new Map();

        Player p1 = new Player(0, "P1");
        Player p2 = new Player(1, "P2");
        Player p3 = new Player(2, "P3");
        Player p4 = new Player(3, "P4");

        int move = 0;
        Player[] players = {p1, p2, p3, p4};

        Boolean game = true;
        String street = "";
        Player own = null;

        while (game){
            players[move].move(d1.trowDice()+ d2.trowDice());
            if ("".equals(map.giveStreet(players[move].getPosition()).getColor())){
                d1.trowDice();
            } else {
                own = map.giveStreet(players[move].getPosition()).getOwner();
                if (own != null){
                    players[move].payRent(map.map[players[move].getPosition()].getRent(), own);
                } else {
                    
                }
                street = map.giveStreet(players[move].getPosition()).getColor();
            }

        }
        }
    }