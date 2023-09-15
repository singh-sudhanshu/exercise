package io.java.exercise.systems.deckofcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> deck = new ArrayList<>();

    public List<Card> buildDeck() {
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 0; rank <= 12; rank++) {
                var card = new Card(rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

    public void showDeck(List<Card> deck) {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public static int search(List<Card> cards, Card target) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Card target, List<Card> deck) {
        int low = 0;
        int high = deck.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = deck.get(mid).compareTo(target);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}
