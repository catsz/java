/**
 * Simulates a simple card game.
 */
public class War {

    public static void main(String[] args) {

        // create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        // divide the deck into piles
        Pile p1 = new Pile();
        p1.addDeck(deck.subdeck(0, 25));
        Pile p2 = new Pile();
        p2.addDeck(deck.subdeck(26, 51));

        // while both piles are not empty
        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();

            // compare the cards
            int diff = c1.getRank() - c2.getRank();
            if (diff > 0) {
				System.out.println("Player one won a duel. cards were: \n player 1: " + c1 + "\n player 2: " + c2);
				System.out.println("Remaining cards: \n player one: " + p1.size() + "\n player two: " + p2.size());
                p1.addCard(c1);
                p1.addCard(c2);
            } else if (diff < 0) {
				System.out.println("Player two won a duel. cards were: \n player 1: " + c1 + "\n player 2: " + c2);
				System.out.println("Remaining cards: \n player one: " + p1.size() + "\n player two: " + p2.size());
                p2.addCard(c1);
                p2.addCard(c2);
            } else {
				Deck d1 = new Deck(0);
				System.out.println("Remaining cards: \n player one: " + p1.size() + "\n player two: " + p2.size());
				System.out.println("There was a tie with cards: " + c1 + " and " + c2);
				while (true) {
					if (p1.size() < 5) {
						p1.empty();
						break;
					} else if (p2.size() < 5) {
						p2.empty();
						break;
					}
					
					Deck d2 = new Deck(0);
					if (d1.isEmpty()) {
						d2 = new Deck(10);
						for (int i = 0; i < 3; i++) {
							d2.set(i, p1.popCard());
						}
						for (int i = 2; i < 6; i++) {
							d2.set(i, p2.popCard());
						}
					} else {
						d2 = new Deck(d1, 10);
						for (int i = d1.length; i < (3 + d1.length); i++) {
							d2.set(i, p1.popCard());
						}
						for (int i = d1.length + 2; i < 6 + d1.length; i++) {
							d2.set(i, p2.popCard());
						}
					}
					Card c3 = p1.popCard();
					Card c4 = p2.popCard();
					d2.set(d1.length + 6, c1);
					d2.set(d1.length + 7, c2);
					d2.set(d1.length + 8, c3);
					d2.set(d1.length + 9, c4);
					
					if (d1.length < d2.length) {
						d1 = d2;
					}
					int diff2 = c3.getRank() - c4.getRank();
					if (diff2 > 0) {
						p1.addDeck(d2);
						break;
					} else if (diff2 < 0) {
						p2.addDeck(d2);
						break;
					}
					
					System.out.println("Remaining cards: \n player one: " + p1.size() + "\n player two: " + p2.size());
					System.out.println("There was a tie with cards: " + c3 + " and " + c4);
				}
            }
        }

        // display the winner
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

}