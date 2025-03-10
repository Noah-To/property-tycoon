package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    String[] deck;

    public CardDeck(int numCards){

        //create new array of Strings, each string associated with one card
        this.deck = new String[numCards];

        //filling array with strings "id1", "id2", "id3",...
        for (int i = 0; i < numCards; i++){
            deck[i] = "id" + Integer.toString(i+1);
        }

        //shuffle array to make random position of the strings -> cards
        List<String> list = new ArrayList<>(Arrays.asList(deck));
        Collections.shuffle(list);
        deck = list.toArray(new String[0]);
    }

    //this method shifts all cards in the deck by 1 ahead, placing the first card in the back of the deck
    //receiving as the parameter value of the string associated with the card of "Get out of jail"
    //as the player must hold the card "get out of jail" the value of a corresponding string becomes null
    public void nextCard(String jailFree){

        String temp;

        //saving the value of the last element in the array (card deck) if it is not an empty value
        //otherwise it will store first value of the array
        if (deck[deck.length-1] == null){
            temp = deck[0];
        } else {
            temp = deck[deck.length-1];
        }


        //checking is the first card to be taken is "jail free" and if it -> last element in the array will become null;
        //else, first element will replace last element
        if (jailFree.equals(this.deck[0])){
            deck[deck.length-1] = null;
        } else if (deck[deck.length-1] != null){
            deck[deck.length-1] = deck[0];
        }

        //shifting all the elements on 1 position ahead to the position n-2 in the array
        for (int i = 0; i < this.deck.length-3; i++){
            deck[i] = deck[i+1];
        }

        //position n-1 becomes rewritten by the temporary value saved earlier
        deck[deck.length-2] = temp;

    }

    //returns id of the first card in the deck
    public String takeCard(){
        return deck[0];
    }

    //returns id of the last card in the deck
    //method is needed to check is the value "null" to check is the card "jail free" still in the deck
    public String lastCard(){
        return deck[deck.length -1];
    }

    //method is needed to return "jail free" card back to the deck
    public void returnCard(String cardID){
        deck[deck.length-1] = cardID;
    }
}
