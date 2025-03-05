package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    String[] deck;

    public CardDeck(int numCards){

        this.deck = new String[numCards];

        for (int i = 0; i < numCards; i++){
            deck[i] = "id" + Integer.toString(i+1);
        }

        List<String> list = new ArrayList<>(Arrays.asList(deck));
        Collections.shuffle(list);
        deck = list.toArray(new String[0]);
    }

    public void nextCard(String jailFree){

        String temp;

        temp = deck[deck.length-1];

        if (jailFree == this.deck[0]){
            deck[deck.length-1] = null;
        } else {
            deck[deck.length-1] = deck[1];
        }

        for (int i = 0; i < this.deck.length-3; i++){
            deck[i] = deck[i+1];
        }

        deck[deck.length-2] = temp;

    }

    public String takeCard(){
        return deck[0];
    }

    public String lastCard(){
        return deck[deck.length -1];
    }

    public void returnCard(String cardID){
        deck[deck.length-1] = cardID;
    }
}
