package io.java.exercise.systems.deckofcards;

import java.util.Objects;

/**
 * Represents the card in the deck with its suit and rank
 * This is an immutable class
 */
public final class Card {

    private final Integer rank;
    private final Integer suit;

    /**
     * SUITS and RANKS are static final because they need to be constant and shared.
     * This way they don't need to be created everytime in toString method and get garbage collected
     */
    private static final String[] SUITS = {"Club", "Diamond", "Heart", "Spade"};
    private static final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Card(Integer rank, Integer suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    public boolean equals(Card that) {
        return Objects.equals(this.suit, that.suit)
                && Objects.equals(this.rank, that.rank);
    }

    /**
     * compareTo returns 1 if this wins, -1 if that wins, and 0 if they are equivalent.
     * It compares suits first. If the suits are the same, it compares ranks.
     * If the ranks are also the same, it returns 0.
     * Will be used to searching
     *
     * @param that is the target object
     * @return int
     */
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }
}
