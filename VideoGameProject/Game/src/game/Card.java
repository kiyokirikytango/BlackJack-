
package game;


public class Card {
    
    //every card will have a suit and value
    private Suit suit; 
    private Value value;
    
    //constructor
    public Card(Suit suit, Value value)
    {
       this.value = value;
       this.suit = suit;
    }
    //to string to print the suit and value together
    public String toString(){
        return this.suit.toString() + " " + this.value.toString();
    }
    
    //checks the value of the card to see how much the card gets
    public Value getValue(){
        return this.value;
    }
}
