
package game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    //saves the cards into an array
    private ArrayList<Card> cards;
    
    //constructor
    public Deck(){
        this.cards = new ArrayList<Card>();
    }
    
    //puts the cards into a deck
   public void createDeck() {
       //every suit will have a value
       for(Suit cardSuit: Suit.values()){
           for(Value cardValue: Value.values()){
               //adds a new card that was made to the deck using the add method
               this.cards.add(new Card(cardSuit,cardValue));
        }
     }
   }
   //method to shuffle all the cards
   public void shuffle(){
       //tempary deck to holds cards
       ArrayList<Card> shuffleDeck = new ArrayList<Card>();
       //gets random number
       Random random = new Random();
       //represnts the random card we get
       int randomCardIndex = 0;
       int origignalSize = this.cards.size();
       for(int i = 0; i < origignalSize; i++ ){
           //generates random numnbers formula
           randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) +0;
           
           shuffleDeck.add(this.cards.get(randomCardIndex));
           this.cards.remove(randomCardIndex);
       }
       //adds the cards back to the deck
       this.cards = shuffleDeck;
       
   }
   
   //prints out the card
   public String toString(){
       String cardListOutput = "";
       for(Card aCard : this.cards){
           cardListOutput += "\n" + aCard.toString();
       }
       return cardListOutput;
   }
   //removes a card from card array
   public void removeCard(int i){
       this.cards.remove(i);
   }
   
   public Card getCard(int i){
       return this.cards.get(i);
   }
   //add card to deck
   public void addCard(Card addCard){
       this.cards.add(addCard);
   }
   //gets card from deck to player
   public void draw(Deck drawing){
       this.cards.add(drawing.getCard(0));
       drawing.removeCard(0);
   }
   //returns size of the deck
   public int deckSize(){
       return this.cards.size();
   }
   //adds all the cards that were use back to the deck
   public void reShuffle(Deck moveTo){
       int thisDeckSize = this.cards.size();
       for(int i = 0;i< thisDeckSize; i++){
           //puts cards into moveTo deck
           moveTo.addCard(this.getCard(i));
       }
       for(int i = 0;i< thisDeckSize; i++){
           this.removeCard(0);
       }
   }
   //gets the value of the each card
   public int cardsValue(){
       int totalValue = 0;
       int aces = 0;
       //checks every card
       for(Card aCard: this.cards){
           //adds the value to each card
           switch(aCard.getValue()){
               case TWO: totalValue += 2; break;
               case THREE: totalValue += 3; break;
               case FOUR: totalValue += 4; break;
               case FIVE: totalValue += 5; break;
               case SIX: totalValue += 6; break;
               case SEVEN: totalValue += 7; break;
               case EIGHT: totalValue += 8; break;
               case NINE: totalValue += 9; break;
               case TEN: totalValue += 10; break;
               case JACK: totalValue += 10; break;
               case QUEEN: totalValue += 10; break;
               case KING: totalValue += 10; break;
               case ACE: aces += 1; break;
               
           }
       }
       
       //checks every in the hand
       for(int i = 0; i <aces; i++){
           //if the value i hand is greater than 10, ace becomes 1
           if(totalValue > 10){
               totalValue += 1;
           }
           // otherwise ace becomes 11
           else{
               totalValue += 11;
           }
       }
       return totalValue;
   }
   
}
