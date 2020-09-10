

public class Genius extends Player {
	
	
	public Genius(String name) {
		super(name);
	}
	
	@Override
	public Card play(Eights eights, Card prev) {
		Card card = super.searchFor8(prev);
		if (card == null) {
			card = super.searchForHRank(eights, prev);
		} 
		if (card == null) {
			card = super.drawForMatch(eights, prev);
		}
		return card;
	}
}