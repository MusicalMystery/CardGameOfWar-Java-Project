Java "War" Game Documentation

Objective:

One player eventually has all the cards,
by following the rules of "War", and wins.

Process (Main method in the MainGame class):

"Shuffle" deck and split between both players.
							
Each players draws a card from the top of their stack	

Whichever player draws a higher value wins the other 
person's card and places both cards at the bottom of 
their stack.

If players draw cards of equal value they both draw 
another card from the top of their stacks.  Repeat this 
step until one player gets a higher card.

Whichever player finally gets 52 cards wins.

Items:

A Card Class ->					 	make a "Card" class
							holds values "value"(2 - 14), "symbol"(1,2,3,or Q,J,K), "face"(Diamonds, Clubs, Hearts...)
							"Card" class should have a constructor, and "getter" and "setter" methods for all the values.
							constructor should look like -> public Card (int val, String sym, String fac) and uses the "setter" methods
							
An entire deck of cards minus jokers, so 52 cards. ->	make a "Deck" class
							include an ArrayList<Card> "initialDeck", "shuffledDeck", "pOneHalf", and "pTwoHalf"
							in the constructor create and add the 52 unique Card objects to initialDeck in a convenient order
							make a method "shuffledDeck" that uses for loops to copy a random Card from initialDeck, and add it to shuffledDeck, then remove that Card from initialDeck
							make a method "splitDeck" that copies one half of shuffledDeck to pOneHalf and the other half to pTwoHalf
														

2 players -> 						make a "Player" class
							has a String name, int numCards, bool winner, ArrayList ownedCards
							make a method "giveCards(ArrayList half)" that sets ownedCards equal to the "half" which will be a half of the deck called from Class "Deck"
							make a method "Card drawTopCard()" that returns the Card that is in the 0th position in "ownedCards"
							
							make a method "putCardOnBottom" that takes a card as an input and puts it in the last position of ownedCards
							make a method "checkIfWinner" checks if player has 52 cards and changes boolean winner to true
							
										


Main ->							Make class "Main"

							before main():
							make final int deckSize = 52
							
							inside of main():
							create a Deck "mainDeck"
							mainDeck.shuffleDeck();
							mainDeck.splitDeck();
							
							welcome message
							prompt to name player 1, then create Player playerOne
							prompt to name player 2, then create Player playerTwo
							give player1 pOneHalf using method giveCards
							give player2 pTwoHalf using method giveCards
							message like: "Let the game begin! Press enter to start"
							
							make a loop that will include lots of if statements and other loops, that will play each turn, check who wins the round, 
							check if each player needs to draw another card, and if a player has won.

							When a player wins write a victory message and end the program.		
