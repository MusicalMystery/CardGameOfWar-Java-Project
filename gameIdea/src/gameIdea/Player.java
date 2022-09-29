package gameIdea;

import java.util.ArrayList;

public class Player {

	public String name;
	public int numCards;
	public boolean winner = false;
	ArrayList<Card> ownedCards = new ArrayList<Card>();
	
	public Player() {
		
	}
	
	public void giveCards(ArrayList<Card> cards) {
		this.ownedCards = cards;
	}
	
	public Card drawTopCard() {
		return ownedCards.get(0);
		
	}
	
	public void putCardOnBottom(Card input) {
		ownedCards.add(ownedCards.size(), input);
	}
	
	public void checkIfWinner() {
		if (ownedCards.size() == 52) {
			this.winner = true;
		}
	}
	
}
