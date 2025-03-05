package src;
import src.Map;
import src.Dice;
import src.Player;
import src.Street;
import src.CardDeck;


import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        Dice d1 = new Dice();
        Dice d2 = new Dice();

        CardDeck Opportunity_knoks = new CardDeck(16);
        CardDeck Pot_luck = new CardDeck(17);

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

            if (id1==id2){

                repeat++;

                if (repeat == 3){

                    if (players[turn].inPrison() == -1){
                        players[turn].beImprisoned();
                        players[turn].free();

                        if (Pot_luck.lastCard() == null){
                            Pot_luck.returnCard("id16");
                        } else {
                            Opportunity_knoks.returnCard("id17");
                        }

                    } else if (players[turn].inPrison() == -2) {
                        players[turn].beImprisoned();
                        players[turn].free();
                        players[turn].turnSkip();

                        if (Pot_luck.lastCard() == null){
                            Pot_luck.returnCard("id16");
                        } else {
                            Opportunity_knoks.returnCard("id17");
                        }

                    } else {
                        players[turn].beImprisoned();
                    }

                    repeat = 0;
                    continue;
                }

            }

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
                        Pot_luck.takeCard();
                        //Do some stuff                     TO BE DISCUSSED
                        if (Pot_luck.takeCard() == "id16"){
                            players[turn].turnSkip();
                        }
                        Pot_luck.nextCard("id16");

                    case 4:
                        players[turn].pay(200);
                        bank.recieveTaxes(200);
                        break;

                    case 7:
                        Opportunity_knoks.takeCard();
                        //Do some stuff                             TO BE DISCUSSED
                        if (Opportunity_knoks.takeCard() == "id17"){
                            players[turn].turnSkip();
                        }
                        Opportunity_knoks.nextCard("id17");

                    case 10:
                        break;

                    case 17:
                        Pot_luck.takeCard();
                        //Do some stuff                     TO BE DISCUSSED
                        if (Pot_luck.takeCard() == "id16"){
                            players[turn].turnSkip();
                        }
                        Pot_luck.nextCard("id16");

                    case 20:
                        players[turn].getRent(bank.returnTaxes());
                        bank.zeroTaxes();
                        break;

                    case 22:
                        Opportunity_knoks.takeCard();
                        //Do some stuff                             TO BE DISCUSSED
                        if (Opportunity_knoks.takeCard() == "id17"){
                            players[turn].turnSkip();
                        }
                        Opportunity_knoks.nextCard("id17");

                    case 30:
                        players[turn].beImprisoned();
                        break;

                    case 33:
                        Pot_luck.takeCard();
                        //Do some stuff                     TO BE DISCUSSED
                        if (Pot_luck.takeCard() == "id16"){
                            players[turn].turnSkip();
                        }
                        Pot_luck.nextCard("id16");

                    case 36:
                        Opportunity_knoks.takeCard();
                        //Do some stuff                             TO BE DISCUSSED
                        if (Opportunity_knoks.takeCard() == "id17"){
                            players[turn].turnSkip();
                        }
                        Opportunity_knoks.nextCard("id17");

                    case 38:
                        players[turn].pay(100);
                        bank.recieveTaxes(100);
                        break;

                }

            } else {

                own = street.getOwner();
                if (own != null && street.getOwner().inPrison() <= 0){
                    players[turn].payRent(street.getRent(), own);
                    /**
                     * If not enough money to pay rent players MUST themselves decide
                     * be discussed betweon which streets houses should be sold and which streets
                     * it should en C# coders how to propose for players variants
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

            if (repeat > 0){
                turn--;
            }

            loop = map.looping(turn, loop, players);

        }

        }

    }