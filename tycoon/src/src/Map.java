package src;
//classes importing
import src.Brown;
import src.Blue;
import src.Purple;
import src.Orange;
import src.Red;
import src.Yellow;
import src.Green;
import src.DeepBlue;
import src.Station;
import src.Utility;
import src.Tax;
import src.SpecialStreet;

import src.Street;
import src.Player;

import java.io.StringReader;
//Board with all of the info
public class Map {

    //Declaration of all the streets on the board
    SpecialStreet Go = new SpecialStreet(1);

    Brown The_Old_Creek = new Brown(60, 2, 2);
    Brown Gangstas_Paradise = new Brown(60, 4, 4);
    Blue The_Angels_Delight = new Blue(100, 7, 6);

    SpecialStreet Opportunuty_knoks1 = new SpecialStreet(8);

    Blue Potter_Avenue = new Blue(100, 9, 6);
    Blue Granger_Drive = new Blue(120, 10, 8);

    SpecialStreet Prison = new SpecialStreet(11);

    Purple Skywalker_Drive = new Purple(140, 12, 10);
    Purple Wookie_Hole = new Purple(140, 14, 10);
    Purple Rey_Lane = new Purple(160, 15, 12);

    Orange Bishop_Drive = new Orange(180, 17, 14);
    Orange Dunham_Street = new Orange(180, 19, 14);
    Orange Broyles_Lane = new Orange(200, 20, 16);

    SpecialStreet Free_Parking = new SpecialStreet(21);

    Red Yue_Fei_Square = new Red(220, 22, 14);

    SpecialStreet Opportunuty_knoks2 = new SpecialStreet(23);

    Red Mulan_Rouge = new Red(220, 24, 14);
    Red Han_Xin_Gardens = new Red(240, 25, 14);

    Yellow Shatner_Close = new Yellow(260, 27, 14);
    Yellow Picard_Avenue = new Yellow(260, 28, 14);

    Yellow Crusher_Creek = new Yellow(280, 30, 14);

    SpecialStreet Go_to_jail = new SpecialStreet(31);

    Green Sirat_Mews = new Green(300, 32, 14);
    Green Ghengis_Crescent = new Green(300, 33, 14);
    Green Ibis_Close = new Green(320, 35, 14);

    SpecialStreet Opportunuty_knoks3 = new SpecialStreet(37);

    DeepBlue James_Webb_Way = new DeepBlue(350, 38, 14);
    DeepBlue Turning_Heights = new DeepBlue(400, 40, 14);

    Station Brighton_Station = new Station(6);
    Station Hove_Station = new Station(16);
    Station Falmer_Station = new Station(26);
    Station Portslade_Station = new Station(36);

    Utility Tesla_Power_Co = new Utility(13);
    Utility Edison_Water = new Utility(29);

    Tax Income_tax = new Tax(200, 5);
    Tax Super_tax = new Tax(100, 39);

    SpecialStreet Pot_luck1 = new SpecialStreet(3);
    SpecialStreet Pot_luck2 = new SpecialStreet(18);
    SpecialStreet Pot_luck3 = new SpecialStreet(34);

    //Array for position specification and further usage
    Street[] map = {Go, The_Old_Creek, Pot_luck1, Gangstas_Paradise, Income_tax, Brighton_Station, The_Angels_Delight,
                    Opportunuty_knoks1, Potter_Avenue, Granger_Drive, Prison, Skywalker_Drive, Tesla_Power_Co, Wookie_Hole,
                    Rey_Lane, Hove_Station, Bishop_Drive, Pot_luck2, Dunham_Street, Broyles_Lane, Free_Parking,
                    Yue_Fei_Square, Opportunuty_knoks2, Mulan_Rouge, Han_Xin_Gardens, Falmer_Station, Shatner_Close,
                    Picard_Avenue, Edison_Water, Crusher_Creek, Sirat_Mews, Ghengis_Crescent, Pot_luck3, Ibis_Close,
                    Portslade_Station, Opportunuty_knoks3, James_Webb_Way, Super_tax, Turning_Heights};

    //Method that returns object (Street) when its needed
    public Street giveStreet(int position){
        return map[position];
    }

    //this method levels up streets when player buys another street of the same color he/she already holds
    //taking as an input parameter street player has bought we can get all the info we need
    public void levelling(Street street){
        //taking color from the street
        String color = street.getColor();

        //integer value to show how many times we need to increase level of the street taken as input parameter
        //to satisfy levels of streets with same color
        int levels = 0;

        switch (color){

            //compare color
            case "brown":
                //compare owner of the input street and other street with same color
                //make sure we are taking 2 different streets
                if (street.getOwner() == map[1].getOwner() && street != map[1]){
                    //if streets are different we increment value of the times needed to increase level of the current street
                    levels++;
                    map[1].incLevel();
                } else if (street.getOwner() == map[3].getOwner() && street != map[3]) {
                    levels++;
                    map[3].incLevel();
                }
                break;

            //same applies further
                case "blue":
                if (street.getOwner() == map[6].getOwner() && street != map[6]){
                    levels++;
                    map[6].incLevel();
                } else if (street.getOwner() == map[8].getOwner() && street != map[8]) {
                    levels++;
                    map[8].incLevel();
                } else if (street.getOwner() == map[9].getOwner() && street != map[9]) {
                    levels++;
                    map[9].incLevel();
                }
                break;

            case "purple":
                if (street.getOwner() == map[11].getOwner() && street != map[11]){
                    levels++;
                    map[11].incLevel();
                } else if (street.getOwner() == map[13].getOwner() && street != map[13]) {
                    levels++;
                    map[13].incLevel();
                } else if (street.getOwner() == map[13].getOwner() && street != map[13]) {
                    levels++;
                    map[14].incLevel();
                }
                break;

            case "orange":
                if (street.getOwner() == map[16].getOwner() && street != map[16]){
                    levels++;
                    map[16].incLevel();
                } else if (street.getOwner() == map[18].getOwner() && street != map[18]) {
                    levels++;
                    map[18].incLevel();
                } else if (street.getOwner() == map[19].getOwner() && street != map[19]) {
                    levels++;
                    map[19].incLevel();
                }
                break;

            case "red":
                if (street.getOwner() == map[21].getOwner() && street != map[21]){
                    levels++;
                    map[21].incLevel();
                } else if (street.getOwner() == map[23].getOwner() && street != map[23]) {
                    levels++;
                    map[23].incLevel();
                } else if (street.getOwner() == map[24].getOwner() && street != map[24]) {
                    levels++;
                    map[24].incLevel();
                }
                break;

            case "yellow":
                if (street.getOwner() == map[26].getOwner() && street != map[26]){
                    levels++;
                    map[26].incLevel();
                } else if (street.getOwner() == map[27].getOwner() && street != map[27]) {
                    levels++;
                    map[27].incLevel();
                } else if (street.getOwner() == map[29].getOwner() && street != map[29]) {
                    levels++;
                    map[29].incLevel();
                }
                break;

            case "green":
                if (street.getOwner() == map[31].getOwner() && street != map[31]){
                    levels++;
                    map[31].incLevel();
                } else if (street.getOwner() == map[32].getOwner() && street != map[32]) {
                    levels++;
                    map[32].incLevel();
                } else if (street.getOwner() == map[34].getOwner() && street != map[34]) {
                    levels++;
                    map[34].incLevel();
                }
                break;

            case "deep blue":
                if (street.getOwner() == map[37].getOwner() && street != map[37]){
                    levels++;
                    map[37].incLevel();
                } else if (street.getOwner() == map[39].getOwner() && street != map[39]) {
                    levels++;
                    map[39].incLevel();
                }
                break;

            case "station":
                if (street.getOwner() == map[6].getOwner() && street != map[6]){
                    levels++;
                    map[6].incLevel();
                } else if (street.getOwner() == map[16].getOwner() && street != map[16]) {
                    levels++;
                    map[16].incLevel();
                } else if (street.getOwner() == map[26].getOwner() && street != map[26]){
                    levels++;
                    map[26].incLevel();
                } else if (street.getOwner() == map[36].getOwner() && street != map[36]) {
                    levels++;
                    map[36].incLevel();
                }
                break;

            case "utility":
                if (street.getOwner() == map[13].getOwner() && street != map[13]){
                    levels++;
                    map[13].incLevel();
                } else if (street.getOwner() == map[29].getOwner() && street != map[29]) {
                    levels++;
                    map[29].incLevel();
                }
                break;
        }

        //here, we increase level of the current street as many times, as was counted other streets with same color and owner
        for (int i=0; i <levels; i++){
            street.incLevel();
        }
    }

    //method is needed to maintain loop of the game flow, as turn order represented through array of players
    //if value becoming 4, it drops down to 0, as array counts [0, 1, 2, 3]
    public int nextTurn(int nowTurn){
        int turn = nowTurn;
        turn++;
        if (turn == 4){
            turn = 0;
        }
        return turn;
    }

    //method needed to check is auction is possible, and it is possible if all players has completed at least 1 loop
    //input parameters: "turn" which turn is it, "loop" to identify is the loop already completed, array of "players"
    public boolean looping(int turn, boolean loop1, Player[] players){
        int i;
        boolean loop = loop1;

        //if the 3rd player did not complete loop - no use of every time do the for loop
        //if we know, that the loop was completed, it has no sense, to check completeness of it again
        if (turn == 3 && !loop){
            //checking is the value of loops of particular player > 0 and if not we do net enter the for loop
            if (players[turn].loop != 0){
                //now we check other players
                for (i=0; i < 3; i++){
                    if (players[i].loop == 0){
                        break;
                    }
                }
                //if all 3 others completed loop, we return "true"
                if (i == 3){
                    loop = true;
                }
            }
        }

        return loop;
    }

}
