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

    //Array for position specification and futher usage
    Street[] map = {Go, The_Old_Creek, Pot_luck1, Gangstas_Paradise, Income_tax, Brighton_Station, The_Angels_Delight,
                    Opportunuty_knoks1, Potter_Avenue, Granger_Drive, Prison, Skywalker_Drive, Tesla_Power_Co, Wookie_Hole,
                    Rey_Lane, Hove_Station, Bishop_Drive, Pot_luck2, Dunham_Street, Broyles_Lane, Free_Parking,
                    Yue_Fei_Square, Opportunuty_knoks2, Mulan_Rouge, Han_Xin_Gardens, Falmer_Station, Shatner_Close,
                    Picard_Avenue, Edison_Water, Crusher_Creek, Sirat_Mews, Ghengis_Crescent, Pot_luck3, Ibis_Close,
                    Portslade_Station, Opportunuty_knoks3, James_Webb_Way, Super_tax, Turning_Heights};

    //Method that returns object (Strret) when its needed
    public Street giveStreet(int position){
        return map[position];
    }

}
