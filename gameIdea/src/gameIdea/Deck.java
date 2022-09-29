package gameIdea;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
	
	public Random random = new Random();

	public ArrayList<Card> initialDeck = new ArrayList<Card>();

	public ArrayList<Card> shuffledDeck = new ArrayList<Card>();

	public ArrayList<Card> pOneHalf = new ArrayList<Card>();
	public ArrayList<Card> pTwoHalf = new ArrayList<Card>();
	
	public Deck() {
		
		String sym = null;
		String fac = null;
		
		int i = 0;
		
		while ( i < 52){
		
			
			fac = "Clubs";
			
			for(int val = 0; val < 13; val++) {
				if (val < 9) {
					sym = String.valueOf(val + 2);
				} else if (val == 9) {
					sym = "Jack";
				} else if (val == 10) {
					sym = "Queen";
				} else if (val == 11) {
					sym = "King";
				} else if (val == 12) {
					sym = "Ace";
				}
				
				initialDeck.add( new Card(val, sym, fac) ) ;
				i++;
			}
			
			
			fac = "Spades";
			
			for(int val = 0; val < 13; val++) {
				if (val < 9) {
					sym = String.valueOf(val + 2);
				} else if (val == 9) {
					sym = "Jack";
				} else if (val == 10) {
					sym = "Queen";
				} else if (val == 11) {
					sym = "King";
				} else if (val == 12) {
					sym = "Ace";
				}
				
				initialDeck.add( new Card(val, sym, fac) ) ;
				i++;
			}
			
			fac = "Hearts";
			
			for(int val = 0; val < 13; val++) {
				if (val < 9) {
					sym = String.valueOf(val + 2);
				} else if (val == 9) {
					sym = "Jack";
				} else if (val == 10) {
					sym = "Queen";
				} else if (val == 11) {
					sym = "King";
				} else if (val == 12) {
					sym = "Ace";
				}
				
				initialDeck.add( new Card(val, sym, fac) ) ;
				i++;
			}
			
			fac = "Diamonds";
			
			for(int val = 0; val < 13; val++) {
				if (val < 9) {
					sym = String.valueOf(val + 2);
				} else if (val == 9) {
					sym = "Jack";
				} else if (val == 10) {
					sym = "Queen";
				} else if (val == 11) {
					sym = "King";
				} else if (val == 12) {
					sym = "Ace";
				}
				
				initialDeck.add( new Card(val, sym, fac) ) ;
				i++;
			}
		}

		
	}
	public void shuffleDeck() {
		
		int rand;
		
		for (int i = 52; i > 0; i--) {
			rand = random.nextInt(i);
			shuffledDeck.add(initialDeck.get(rand));
			initialDeck.remove(rand);
			
		}
	}
	public void splitDeck() {
		for (int i = 0; i < 26; i++) {
			pOneHalf.add(shuffledDeck.get(i));
		}
		for (int i = 26; i < 52; i++) {
			pTwoHalf.add(shuffledDeck.get(i));
		}
		
	}
	
	
}
