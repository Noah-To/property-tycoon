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

        Scanner inp = new Scanner(System.in);                       //not needed at all but for logic idea
        //declaring 2 dices
        Dice d1 = new Dice();
        Dice d2 = new Dice();

        //creating 2 decks of cards
        CardDeck Opportunity_knoks = new CardDeck(16);
        CardDeck Pot_luck = new CardDeck(17);

        int id1;        //Integer value of Dice 1
        int id2;        //Integer value of Dice 2

        //instance of class "Map" and class "Bank"
        Map map = new Map();
        Bank bank = new Bank();

        //4 players
        Player p1 = new Player(0, "P1");
        Player p2 = new Player(1, "P2");
        Player p3 = new Player(2, "P3");
        Player p4 = new Player(3, "P4");

        //declaring turn counter.
        //it has value of -1, as we increment its value in the beginning of the loop
        int turn = -1;
        //array of players
        Player[] players = {p1, p2, p3, p4};

        boolean game = true;                //to check. should the game continue. or its finished
        String str = "";                    //sometimes we need to take string to simplify code
        Street street = new Street();       //sometimes we need to take street to simplify code
        Player own = null;                  //sometimes we need to take player to simplify code
        int i = 0;                          //sometimes we need to take integer value to simplify code
        boolean loop = false;               //variable to check is auction possible or not
        int repeat = 0;                     //variable to check how many times double has appeared

        while (game){

            //incrementing "turn" variable
            turn = map.nextTurn(turn);

            //if player already is not in game we start loop again
            if (!players[turn].alive){
                turn = map.nextTurn(turn);
                continue;
            }

            //throwing 2 dices
            id1 = d1.trowDice();
            id2 = d2.trowDice();

            if (id1==id2){

                //if dices are equal, we increment counter
                repeat++;

                //player needs to go to the prison. if double was thrown thrice
                if (repeat == 3){

                    //if player holds the "jail free" card, he/she can continue game for the next turn
                    if (players[turn].inPrison() == -1){
                        players[turn].beImprisoned();
                        players[turn].free();

                        //checking, where exactly card was taken from and returning there
                        if (Pot_luck.lastCard() == null){
                            Pot_luck.returnCard("id16");
                        } else {
                            Opportunity_knoks.returnCard("id17");
                        }

                        //if players holds both of the "jail free" cards he/she returns one to any of the decks
                    } else if (players[turn].inPrison() == -2) {
                        players[turn].beImprisoned();
                        players[turn].free();
                        players[turn].turnSkip();

                        if (Pot_luck.lastCard() == null){
                            Pot_luck.returnCard("id16");
                        } else {
                            Opportunity_knoks.returnCard("id17");
                        }

                        //otherwise, player goes to the prison instantly
                    } else {
                        players[turn].beImprisoned();
                    }

                    //repeat value was set to 0, and loop has started again
                    repeat = 0;
                    continue;
                }

            }

            //if player is in prison
            if (players[turn].imprisoned > 0){
                //player is free if dices are equal
                if (id1 == id2){
                    players[turn].free();
                } else {
                    //otherwise, player has a choice to get out of jail for payment
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


            //move player and receive street, where player is now
            players[turn].move(id1 + id2);
            street = map.giveStreet(players[turn].getPosition()-1);

            //if player is on the street that can not be bought
            if ("".equals(street.getColor())){
                switch (players[turn].getPosition()-1){

                    //try to allow auction
                    case 0:
                        loop = map.looping(turn, loop, players);
                        break;

                    //taking card from the deck
                    //if player receives "jail free" cards, it disapeares from the deck
                    case 2:
                        Pot_luck.takeCard();
                        //Do some stuff                     TO BE DISCUSSED
                        if (Pot_luck.takeCard() == "id16"){
                            players[turn].turnSkip();
                        }
                        Pot_luck.nextCard("id16");
                        break;

                    //player pays taxes
                    case 4:
                        players[turn].pay(200);
                        bank.recieveTaxes(200);
                        break;

                    //taking card from the deck
                    //if player receives "jail free" cards, it disapeares from the deck
                    case 7:
                        Opportunity_knoks.takeCard();
                        //Do some stuff                             TO BE DISCUSSED
                        if (Opportunity_knoks.takeCard() == "id17"){
                            players[turn].turnSkip();
                        }
                        Opportunity_knoks.nextCard("id17");
                        break;

                    case 10:
                        break;

                    //taking card from the deck
                    //if player receives "jail free" cards, it disapeares from the deck
                    case 17:
                        Pot_luck.takeCard();
                        //Do some stuff                     TO BE DISCUSSED
                        if (Pot_luck.takeCard() == "id16"){
                            players[turn].turnSkip();
                        }
                        Pot_luck.nextCard("id16");
                        break;

                    //player takes taxes
                    case 20:
                        players[turn].getRent(bank.returnTaxes());
                        bank.zeroTaxes();
                        break;

                    //taking card from the deck
                    //if player receives "jail free" cards, it disapeares from the deck
                    case 22:
                        Opportunity_knoks.takeCard();
                        //Do some stuff                             TO BE DISCUSSED
                        if (Opportunity_knoks.takeCard() == "id17"){
                            players[turn].turnSkip();
                        }
                        Opportunity_knoks.nextCard("id17");
                        break;

                    //player becomes instantly imprisoned
                    case 30:
                        players[turn].beImprisoned();
                        break;

                    //taking card from the deck
                    //if player receives "jail free" cards, it disapeares from the deck
                    case 33:
                        Pot_luck.takeCard();
                        //Do some stuff                     TO BE DISCUSSED
                        if (Pot_luck.takeCard() == "id16"){
                            players[turn].turnSkip();
                        }
                        Pot_luck.nextCard("id16");
                        break;

                        //taking card from the deck
                        //if player receives "jail free" cards, it disapeares from the deck
                    case 36:
                        Opportunity_knoks.takeCard();
                        //Do some stuff                             TO BE DISCUSSED
                        if (Opportunity_knoks.takeCard() == "id17"){
                            players[turn].turnSkip();
                        }
                        Opportunity_knoks.nextCard("id17");
                        break;

                    //player pays taxes
                    case 38:
                        players[turn].pay(100);
                        bank.recieveTaxes(100);
                        break;

                }

            } else {
                //if street has color

                //check for owner and pay rent
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
                    //allow player to buy street, if it has no owner
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

            //if it was double, we decrement turn value, as it will be incremented in the beginning
            if (repeat > 0){
                turn--;
            }

            //auction stuff
            loop = map.looping(turn, loop, players);

        }

        }

    }