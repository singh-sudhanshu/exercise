package io.java.exercise.systems.deckofcards;

public class CardApp {

    public static void main(String[] args) {

        var deck = new Deck();
        var deckWithCards = deck.buildDeck();
        deck.showDeck(deckWithCards);
        deckWithCards.sort(Card::compareTo);
        System.out.println("Sorted------>\n" + deckWithCards);
    }
}
