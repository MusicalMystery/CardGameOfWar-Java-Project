package gameIdea;

import java.util.Scanner;


public class MainGame {

final int deckSize = 52;
	
	

	public static void main(String[] args) {
		
	//Initialize Game here
		
		Deck mainDeck = new Deck();
		
	//Shuffle the deck
		
		mainDeck.shuffleDeck();
		
	//Split the deck
		
		mainDeck.splitDeck();
		
	//Create Players and give them each one half of the shuffled deck
		
		Player player1 = new Player();
		Player player2 = new Player();
		player1.giveCards(mainDeck.pOneHalf);
		player2.giveCards(mainDeck.pTwoHalf);
		
	//Create a scanner to input the players' names
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Player 1 type your name and press Enter: ");
		
		player1.name = reader.nextLine();
	//player1.name = "PlayerOne";
		
		System.out.print("Player 2 type your name and press Enter: ");
		
		player2.name = reader.nextLine();
	//player2.name = "PlayerTwo";
		
	//Create an announcement for the beginning of the game
		
		System.out.println();
		System.out.println(player1.name + " versus " + player2.name);
		System.out.println("Let the game begin!");
		System.out.println("(Press 'y' followed by 'Enter' to play rounds)");
		
	//this String "y" is simply the "y" that has to be typed to play each round of the game
		String y = null;
		
		
	//The main bulk of the game is here, encapsulated in a while loop that will repeat until one player is detected as a winner
		
		while (player1.winner == false && player2.winner == false) {
		
			
	//The player types in "y" and then "Enter" and the program compares the card in the 0th spot of each players ownedCards
			
			y = reader.nextLine();
			
		
			System.out.println();
			
			System.out.print(player1.name + " drew a ");
			player1.ownedCards.get(0).printCard();
			
			System.out.print(player2.name + " drew a ");
			player2.ownedCards.get(0).printCard();
			
			
	//if player1 wins (Meaning their 0th of ownedCards is higher than player2's) then do this
			
			if (player1.drawTopCard().value > player2.drawTopCard().value) {
				
				
			player1.putCardOnBottom(player1.drawTopCard());
			player1.putCardOnBottom(player2.drawTopCard());
				
			player1.ownedCards.remove(0);
			player2.ownedCards.remove(0);
			
			System.out.println(player1.name + " wins the round!");
			
			} else 
				
	//if player2 wins (Meaning their 0th of ownedCards is higher than player1's) then do this
				
				if (player1.drawTopCard().value < player2.drawTopCard().value) {
				
				player2.putCardOnBottom(player2.drawTopCard());
				player2.putCardOnBottom(player1.drawTopCard());
					
				player2.ownedCards.remove(0);
				player1.ownedCards.remove(0);
				
				System.out.println(player2.name + " wins the round!");

	//if there's a tie then do this
				
			} else if (player1.drawTopCard().value == player2.drawTopCard().value) {
				
				if (player2.ownedCards.size() == 1) {
					System.out.println("A tie! But it looks like " + player2.name + " doesn't have any more cards");
					player1.putCardOnBottom(player2.ownedCards.get(0));
					player2.ownedCards.remove(0);
				} else if (player1.ownedCards.size() == 1) {
					System.out.println("A tie! But it looks like " + player1.name + " doesn't have any more cards");
					player2.putCardOnBottom(player1.ownedCards.get(0));
					player1.ownedCards.remove(0);
				} else {
				
				
				System.out.println("A tie?  We can't have that!  Draw another card!");
				
				
				int i  = 1;
				
				System.out.print(player1.name + " drew a ");
				player1.ownedCards.get(i).printCard();
				
				System.out.print(player2.name + " drew a ");
				player2.ownedCards.get(i).printCard();
				
	//if there's another tie then do this
				
				while (player1.ownedCards.get(i).value == player2.ownedCards.get(i).value) { //Had a trouble spot here where I had to write code to fix an exception when a player has no more cards but is faced with a tie
					
					if (player1.ownedCards.size() == i + 1) { //if player1 ties but has no more cards
						System.out.println("TIE AGAIN! But " + player1.name + " doesn't have any more cards!");
						
						for (int j = i; j >=0; j--) {
							player2.putCardOnBottom(player2.ownedCards.get(j));
							player2.putCardOnBottom(player1.ownedCards.get(j));
						}
						
						for (int j = i; j >=0; j--) {
							player1.ownedCards.remove(j);
							player2.ownedCards.remove(j);
							}

						break;
						
						
					} else if (player2.ownedCards.size() == i + 1) { //if player2 ties but has no more cards
						System.out.println("TIE AGAIN! But " + player2.name + " doesn't have any more cards!");

						
						for (int j = i; j >=0; j--) {
							player1.putCardOnBottom(player1.ownedCards.get(j));
							player1.putCardOnBottom(player2.ownedCards.get(j));
						}
						for (int j = i; j >=0; j--) {
							player2.ownedCards.remove(j);
							player1.ownedCards.remove(j);
							}
					
						break;
						
					} else {
					
					System.out.println("TIE AGAIN! NO WAY! Draw another card!");
					
					i++;
					
					System.out.print(player1.name + " drew a ");
					player1.ownedCards.get(i).printCard();
					
					System.out.print(player2.name + " drew a ");
					player2.ownedCards.get(i).printCard();
					
					}
				}

				if (player1.ownedCards.size() == 0) {
					player2.winner = true;
				} else if (player2.ownedCards.size() == 0) {
					player1.winner = true;
				} else
				
				
	//beyond this point the cards are different values and now the winner just needs to take all the cards that were drawn
				
	//if player1 wins
				if (player1.ownedCards.get(i).value > player2.ownedCards.get(i).value) {
					
				for (int j = i; j >=0; j--) {
					player1.putCardOnBottom(player1.ownedCards.get(j));
					player1.putCardOnBottom(player2.ownedCards.get(j));
				}
				
				for (int j = i; j >=0; j--) {
					player1.ownedCards.remove(j);
					player2.ownedCards.remove(j);
				}
				
				System.out.println(player1.name + " wins the round!");

				
	//if player2 wins
			} else if (player2.ownedCards.get(i).value > player1.ownedCards.get(i).value) {
				
			for (int j = i; j >=0; j--) {
				player2.putCardOnBottom(player2.ownedCards.get(j));
				player2.putCardOnBottom(player1.ownedCards.get(j));
			}
			
			for (int j = i; j >=0; j--) {
				player1.ownedCards.remove(j);
				player2.ownedCards.remove(j);
				}
			
			System.out.println(player2.name + " wins the round!");

			
				}
			}
			
		}
			
	//This code determines if either player has run out of cards.  If a player has run out of cards, this ends the initial while loop and proceeds to the final step of announcing the winner
		
		if (player1.ownedCards.size() == 0) {
			player2.winner = true;
		} else if (player2.ownedCards.size() == 0) {
			player1.winner = true;
		}
			
	//this code runs if neither player has won yet, and simply states how many cards each player has and then restarts the initial while loop to start the next round
		
		System.out.println();
		System.out.println(player1.name + " has " + player1.ownedCards.size() + " cards");
		System.out.println(player2.name + " has " + player2.ownedCards.size() + " cards");

		}

		System.out.println();

		//This code announces who is the winner
		
		if (player1.winner == true) {
			System.out.println(player1.name + " WINS THE GAME!");
		} else if (player2.winner == true) {
			System.out.println(player2.name + " WINS THE GAME!");
		} 

	}

}
