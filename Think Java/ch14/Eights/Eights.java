import java.util.Scanner;
import java.util.ArrayList;

/**
 * Simulates a game of Crazy Eights.
 * See https://en.wikipedia.org/wiki/Crazy_Eights.
 */
public class Eights {

    private Hand drawPile;
    private Hand discardPile;
    private Scanner in;
	private ArrayList<Player> players;

    /**
     * Initializes the state of the game.
     */
    public Eights(int n) {
        Deck deck = new Deck("Deck");
        deck.shuffle();
		this.players = new ArrayList<Player>();

        // deal cards to each player
        for (int i = n; i > 0; i--) {
			Player temp = new Player(Integer.toString(i));
			deck.deal(temp.getHand(), 5);
			this.players.add(temp);
		}

        // turn one card face up
        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        // put the rest of the deck face down
        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);

        // create the scanner we'll use to wait for the user
        in = new Scanner(System.in);
    }

    /**
     * Returns true if either hand is empty.
     */
    public boolean isDone() {
        for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getHand().isEmpty()) {
				return true;
			}
		}
		return false;
    }

    /**
     * Moves cards from the discard pile to the draw pile and shuffles.
     */
    public void reshuffle() {
        // save the top card
        Card prev = discardPile.popCard();

        // move the rest of the cards
        discardPile.dealAll(drawPile);

        // put the top card back
        discardPile.addCard(prev);

        // shuffle the draw pile
        drawPile.shuffle();
    }
	
	public void reshuffleN() {
		if (drawPile.isEmpty()) reshuffle();
	}

    /**
     * Returns a card from the draw pile.
     */
    public Card drawCard() {
        if (drawPile.isEmpty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    /**
     * Switches players.
     */
    public Player nextPlayer(Player current) {
		if (players.size() <= players.indexOf(current) + 1) {
			return players.get(0);
		} else return players.get(players.indexOf(current) + 1);
    }

    /**
     * Displays the state of the game.
     */
    public void displayState() {
        for (int i = 0; i < players.size(); i++) {
			players.get(i).display();
		}
        discardPile.display();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
        in.nextLine();
    }

    /**
     * One player takes a turn.
     */
    public void takeTurn(Player player) {
        Card prev = discardPile.lastCard();
        Card next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    /**
     * Plays the game.
     */
    public void playGame() {
        Player player = players.get(0);

        // keep playing until there's a winner
        while (!isDone()) {
            displayState();
            takeTurn(player);
            player = nextPlayer(player);
        }

        // display the final score
        for (int i = 0; i < players.size(); i++) {
			players.get(i).displayScore();
		}
    }
	
	public void playGame100() {
        Player player = players.get(0);

        // keep playing until there's a winner
        for (int i = 0; i < 100; i++) {
            displayState();
            takeTurn(player);
            player = nextPlayer(player);
        }

        // display the final score
        for (int i = 0; i < players.size(); i++) {
			players.get(i).displayScore();
		}
    }

    /**
     * Creates the game and runs it.
     */
    public static void main(String[] args) {
        Eights game = new Eights(3);
        game.playGame();
    }

}