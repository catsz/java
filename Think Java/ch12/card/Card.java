/**
 * A standard playing card.
 */
public class Card {

    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;

    private final int suit;

    /**
     * Constructs a card of the given rank and suit.
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns a negative integer if this card comes before
     * the given card, zero if the two cards are equal, or
     * a positive integer if this card comes after the card.
     */
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank && this.rank != 1 || that.rank == 1) {
            return -1;
        }
        if (this.rank == 1 || this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    /**
     * Returns true if the given card has the same
     * rank AND same suit; otherwise returns false.
     */
    public boolean equals(Card that) {
        return this.rank == that.rank
            && this.suit == that.suit;
    }

    /**
     * Gets the card's rank.
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Gets the card's suit.
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * Returns the card's index in a sorted deck of 52 cards.
     */
    public int position() {
        return this.suit * 13 + this.rank - 1;
    }

    /**
     * Returns a string representation of the card.
     */
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
	
	//gets the rank from the position in a full deck of cards
	public static int getRank(int pos) {
		if (pos < 13) {
			return pos + 1;
		} else {
			int rtn1 = pos % 13;
			return rtn1 + 1;
		}
	}
	
	//gets the suit from the position in a full deck of cards
	public static int getSuit(int pos) {
		if (pos < 13) {
			return 0;
		} else {
			return pos / 13;
		}
	}
	
	//makes a full deck of cards
	public static Card[] makeDeck() {
		Card[] cards = new Card[52];
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card(getRank(i), getSuit(i));
		}
		return cards;
	}
	
	public static void main(String[] args) {
		Card test = new Card(5, 0);
		Card test1 = new Card(1, 0);
		
		System.out.print(test.compareTo(test1));
	}

}