import java.util.concurrent.ThreadLocalRandom;

/**
 * A deck of playing cards (of fixed length).
 */
public class Deck {

    // This is a class variable so we don't have to create
    // a new Random object every time we call randomInt.

    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (all null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
		String rtn = this.cards[0].toString();
        for (int i = 1; i < this.cards.length; i++) {
			rtn = rtn + "\n" + this.cards[i].toString();
		}
		return rtn;
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
		for (int i = 0; i < this.cards.length; i++) {
			int RN = ThreadLocalRandom.current().nextInt(i, this.cards.length);
			
			this.swapCards(i, RN);
		}
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    private static int randomInt(int low, int high) {
        return 0;
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    private void swapCards(int i, int j) {
		Card card = this.cards[i];
		this.cards[i] = this.cards[j];
		this.cards[j] = card;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    private int indexLowest(int low, int high) {
        return 0;
    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    private static Deck merge(Deck d1, Deck d2) {
        return null;
    }

    /**
     * Returns a sorted copy of the deck using selection sort.
     */
    public Deck almostMergeSort() {
        return this;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        return this;
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

    /**
     * Helper method for insertion sort.
     */
    private void insert(Card card, int i) {
    }
	
	public static void main(String[] args) {
		Deck test = new Deck();
		test.shuffle();
		
		System.out.print(test);
	}

}