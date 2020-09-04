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
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
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
	
	public static int[] suitHist(Card[] that) {
		int[] rtn = new int[4];
		
		for (int i = 0; i < that.length; i++) {
			rtn[that[i].suit]++;
		}
		return rtn;
	}
	
	public static boolean hasFlush(Card[] that) {
		int[] thatHist = Card.suitHist(that);
		
		for (int i = 0; i < thatHist.length; i++) {
			if (thatHist[i] <= 5) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Card[] test = {
			new Card(1, 2), new Card(1, 3), new Card(3, 1), new Card(1, 1), new Card(3, 1), new Card(3, 1), new Card(3, 1), new Card(3, 1)
		};
		int[] test1 = Card.suitHist(test);
		
		for (int i = 0; i < test1.length; i++) {
			System.out.println(test1[i]);
		}
		
		System.out.print(Card.hasFlush(test));
	}

}