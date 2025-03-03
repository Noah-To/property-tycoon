package src;
import com.sun.source.tree.WhileLoopTree;
import src.Map;
import src.Dice;
import src.Player;
import src.Street;


import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        Dice d1 = new Dice();
        Dice d2 = new Dice();

        int id1;        //Integer value of Dice 1
        int id2;        //Integer value of Dice 2

        Map map = new Map();
        Bank bank = new Bank();

        Player p1 = new Player(0, "P1");
        Player p2 = new Player(1, "P2");
        Player p3 = new Player(2, "P3");
        Player p4 = new Player(3, "P4");

        int turn = -1;
        Player[] players = {p1, p2, p3, p4};

        boolean game = true;
        String str = "";
        Street street = new Street();
        Player own = null;
        int i = 0;
        boolean loop = false;
        int repeat = 0;

        while (game){

            turn = map.nextTurn(turn);

            if (!players[turn].alive){
                turn = map.nextTurn(turn);
                continue;
            }

            id1 = d1.trowDice();
            id2 = d2.trowDice();


            if (players[turn].imprisoned > 0){
                if (id1 == id2){
                    players[turn].free();
                } else {
                    System.out.println("Getting out of jail? Y/N");          //asking player for buying street
                    str = inp.next();
                    if ("N".equals(str)){
                        players[turn].turnSkip();
                        continue;
                    } else {
                        players[turn].pay(50);
                        bank.recieveTaxes(50);
                        players[turn].free();
                        continue;
                    }
                }
            }

            players[turn].move(id1 + id2);
            street = map.giveStreet(players[turn].getPosition()-1);

            if ("".equals(street.getColor())){
                switch (players[turn].getPosition()-1){

                    case 0:
                        loop = map.looping(turn, loop, players);
                        break;

                    case 2:
                        //take card

                    case 4:
                        players[turn].pay(200);
                        bank.recieveTaxes(200);
                        break;

                    case 7:
                        //take card

                    case 10:
                        break;

                    case 17:
                        //take card

                    case 20:
                        players[turn].getRent(bank.returnTaxes());
                        bank.zeroTaxes();
                        break;

                    case 22:
                        //take card

                    case 30:
                        players[turn].beImprisoned();
                        break;

                    case 33:
                        //take card

                    case 36:
                        //take card

                    case 38:
                        players[turn].pay(100);
                        bank.recieveTaxes(100);
                        break;

                }

            } else {

                own = street.getOwner();
                if (own != null){
                    players[turn].payRent(street.getRent(), own);
                    /**
                     * If not enough money to pay rent players MUST themselves decide
                     *  on which streets houses should be sold and which streets
                     *  it should be discussed between C# coders how to propose for players variants
                     *
                     */


                } else {
                    if (players[turn].getMoney() >= street.getCost()){

                        System.out.println("Buy street? Y/N");          //asking player for buying street
                        str = inp.next();

                        if (Objects.equals(str, "Y")){
                            players[turn].pay(street.getCost());
                            street.bought(players[turn]);
                            map.levelling(street);
                        } else {
                            if(loop){
                                /**
                                 * Auction needs to be created excluding the one
                                 * who withdrawn the possibility to buy street
                                 * and also everyone, who did not do the bet
                                 */
                            }
                        }
                    }


                }
            }

            if (id1==id2){

                repeat++;
                turn--;

                if (repeat == 3){
                    players[turn].beImprisoned();
                    repeat = 0;
                    turn++;
                }

            }

            loop = map.looping(turn, loop, players);

        }

        }

    }