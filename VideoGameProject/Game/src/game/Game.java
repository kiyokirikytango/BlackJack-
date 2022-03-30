/*
Riky Hernandez
Soft Skills 16 

 */
package game;

import java.util.Scanner;


public class Game {

    
    public static void main(String[] args) {
        
        //gets user inputs
    Scanner input = new Scanner(System.in);
        char choice;
      
        System.out.println("-------------BlackJack!----------");
        System.out.println("\n");
        System.out.println("The way to win is to get as close to 21 or get 21");
        System.out.println("If you pass 21,you lose");
        System.out.println("If dealer gets a higher number than you, you lose");
        System.out.println("ACE is one if the other card is 10, otherwise it would be 11");
        System.out.println("JACK, QUEEN, KING is 10");
        
        System.out.println("\n");
        
        //creates the deck,adds the 52 cards
        Deck playingDeck = new Deck();
        playingDeck.createDeck();
        //shuffles the cards using method in deck
        playingDeck.shuffle();
        
        //creates a deck(hand) for player
        Deck player = new Deck();
        //creates a deck(hand) for dealer 
        Deck dealer = new Deck();
        
        //user chooses to start the game or not
        System.out.println("Want to play (Y/N)");
        choice = input.next().charAt(0);
        
         System.out.println("\n");
         
         //the actual game lol
         //the game goes until theres a winner/loser/tie
         //then the game asks the user if they want to play again
       while((choice == 'Y') || (choice =='y')){
           //for when the round is over
           boolean end = false;
           
           //the player gets two card from the deck 
           player.draw(playingDeck);
           player.draw(playingDeck);
           
           //the player gets two card from the deck 
           dealer.draw(playingDeck);
           dealer.draw(playingDeck);
           
           //while loop for the hit
           while(true){
               //dysplays what the user has in his hand
               System.out.print("Your cards:");
               System.out.print(player.toString());
               System.out.print("\n");
               //displays sum of the cards in hand
               System.out.println("You have: " + player.cardsValue());
               
               //displays only one of the dealers card
               System.out.println("Dealers has: " + dealer.getCard(0).toString() + " and face down card");
               
               //asking the player what they wants to do
               System.out.println("(1)Hit or (2)stand");
               int response = input.nextInt();
               
               //hit option
               if(response == 1){
                   //draws another card to their hand and displays what they drew
                   player.draw(playingDeck);
                           System.out.println("You drew: " + player.getCard(player.deckSize()-1).toString());
                           //if player gets a value above 21 they lose
                           if(player.cardsValue() > 21){
                               System.out.println("BUST! You have: " + player.cardsValue());
                               end = true;
                               break;
                           }
               }
               //gets out of the hit loop,
              if(response == 2){
                  break;
              }
           }
           //reveals all of the dealers card they had in hand
           System.out.println("Dealer cards: " + dealer.toString());
           
           //checks to see if the dealers value is greater to see if they win
           if((dealer.cardsValue()>player.cardsValue())&& end == false){
               System.out.println("Dealer wins!");
               //ends the round
               end = true;
           }
           //checks to see if the dealer wants to draw
           while((dealer.cardsValue()<17)&& end == false){
               //dealer draws a card
               dealer.draw(playingDeck);
               //displays all the dealers cards in its hand
               System.out.println("Dealer draws: " + dealer.getCard(dealer.deckSize()-1).toString());
           }
           
           //displays dealer value in his hand
           System.out.println("Dealer has: " + dealer.cardsValue());
           
           //checks to see if the dealer got above 21
           if((dealer.cardsValue() > 21) && end == false){
               System.out.println("Dealer busts! You Win!");
               //ends the round
               end = true;
           }
           
           //checks to see if the dealer and the player got the same amount
           if((dealer.cardsValue() == player.cardsValue()) && end == false){
               System.out.println("Tie!");
               //ends the round
               end = true;
           }
           
           //checks to see if the player got more than the dealer
           if((player.cardsValue() > dealer.cardsValue())&& end == false){
               System.out.println("You Win!");
               //ends the round
               end = true;
           }
           
           //after dealer draws more cards,and the dealer didnt bust or tie, and player didnt win
           //dealer wins
           else if(end == false){
               System.out.println("You lose!");
               //ends the round
               end = true;
           }
           
           //moves all the cards back to the deck
           player.reShuffle(playingDeck);
           dealer.reShuffle(playingDeck);
           
          //after round is over they are asked if they want to play again
           System.out.println("Want to play again?(Y/N)");
        choice = input.next().charAt(0);
            
       }
       
       System.out.print("\n");
      //prints if user choose "n" or "N" which stops the loop 
     System.out.println("GAME OVER!!");
    }
    
}
