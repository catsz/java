import java.util.concurrent.ThreadLocalRandom;

/**
 * A deck of playing cards (of fixed length).
 */
public class Deck {

    // This is a class variable so we don't have to create
    // a new Random object every time we call randomInt.

    private Card[] cards;
	public final int length;
	
    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
		this.length = this.cards.length;
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
		this.length = this.cards.length;
    }
	
	public Deck(Deck d, int n) {
		this.cards = new Card[d.length + n];
		
		for (int i = 0; i < d.length; i++) {
			this.set(i, d.getCards()[i]);
		}
		this.length = this.cards.length;
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
		for (int i = 0; i < this.cards.length; i++) {
			int lowest = this.indexLowest(i, this.cards.length);
			this.swapCards(i, lowest);
		}
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    private int indexLowest(int low, int high) {
		Card lowest = this.cards[low];
		int rtn = low;
		for (int i = low + 1; i < high; i++) {
			if (this.cards[i].compareTo(lowest) == -1) {
				lowest = this.cards[i];
				rtn = i;
			}
		}
		return rtn;
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
        Deck d3 = new Deck(d1.length + d2.length);
		
		int i = 0;
		int j = 0;
		
		for (int k = 0; k < d3.length; k++) {
			if (i >= d1.length) {
				d3.set(k, d2.getCards()[j]);
				j++;
			} else if (j >= d2.length) {
				d3.set(k, d1.getCards()[i]);
				i++;
			} else {
				if (d1.getCards()[i].compareTo(d2.getCards()[j]) == -1) {
					d3.set(k, d1.getCards()[i]);
					i++;
				} else {
					d3.set(k, d2.getCards()[j]);
					j++;
				}
			}
		}
		return d3;
    }

    /**
     * Returns a sorted copy of the deck using selection sort.
     */
    public Deck almostMergeSort() {
		Deck d1;
		Deck d2;
		d1 = this.subdeck(0, (this.length / 2) - 1);
		d2 = this.subdeck((this.length / 2), this.length - 1);
		
		d1.selectionSort();
		d2.selectionSort();
		
		return Deck.merge(d1, d2);
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
		if (this.length <= 1) {
			return this;
		}
		Deck d1 = this.subdeck(0, (this.length / 2) - 1);
		Deck d2 = this.subdeck((this.length / 2), this.length - 1);
			
		d1 = d1.mergeSort();
		d2 = d2.mergeSort();
		return Deck.merge(d1, d2);
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
		for (int i = 1; i < this.length; i++) {
			this.insert(this.getCards()[i], i);
		}
    }

    /**
     * Helper method for insertion sort.
     */
    private void insert(Card card, int i) {
		for (int k = i - 1; k >= 0; k--) {
			if (card.compareTo(this.cards[k]) == -1) {
				this.swapCards(k, k + 1);
			} else break;
		}
    }
	
	public boolean isEmpty() {
		return this.cards.length == 0;
	}
	
	public void set(int index, Card card) {
		this.cards[index] = card;
	}
	
	public void fill() {
		for (int i = 0; i < this.length; i++) {
			this.cards[i] = new Card(Card.getRank(i), Card.getSuit(i));
		}
	}
	
	public static void main(String[] args) {
		Deck test = new Deck();
		test.shuffle();
		System.out.println(test + "\n");
		test.insertionSort();
		
		System.out.print(test);
		
	}

}