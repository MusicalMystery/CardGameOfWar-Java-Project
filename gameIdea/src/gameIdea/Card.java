package gameIdea;

public class Card {

public int value;
public String symbol;
public String face;

public Card(int val, String sym, String fac) {
	this.value = val;
	this.symbol = sym;
	this.face = fac;
}

public void printCard() {
	System.out.println(symbol + " of " + face);
}

}
