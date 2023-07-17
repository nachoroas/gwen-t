package cl.uchile.dcc
package gwent.Players

import gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSide
import cl.uchile.dcc.gwent.CardClasses.WeatherCards
import cl.uchile.dcc.gwent.Visitor.{getStrenghtVisitor, getWeatherCardVisitor}

import scala.collection.mutable.ListBuffer

/** A classes representing the hand of card at the moment of playing
 *
 * the hand depends on a deck tot draw cards from it
 *
 * @param Principal_deck the deck where to get the cards
 *
 * @constructor the class is defined with a empty list and its large but has a function to
 *              draw 5 cards from the designated deck and set the large to 5
 *
 * @example
 * {{{
 *   val x = new Deck()
 *   val y = new hand(x)
 * }}}
 */
class Hand (Principal_deck:Deck)  {
  private var mano:List[Cards]=List()
  private var largo:Int=0

  /**
   * Draws a card from the deck and adds it to the hand.
   *
   * This function checks if the deck has cards to draw. If the deck is empty, it returns `false`.
   * If there are cards in the deck, the function draws a card, adds it to the hand, and increments the `largo` by 1.
   *
   * @param Principal_deck The deck from which to draw the card.
   * @return `true` if a card was drawn and added to the hand, `false` if the deck is empty.
   * @example
   * val x = new Deck()
   * val y = new Hand(x)
   * y.draw_card(x) // Returns false if the deck has no cards
   */
  def draw_card(Principal_deck: Deck):Boolean={
    if (Principal_deck.GetLarge()>0) {
      val x = Principal_deck.draw_card()
      mano = x :: mano
      largo = largo + 1
      true
    }
    else{
      false
    }
    }

  /**
   * Uses a card from the hand and plays it on the assigned board side.
   *
   * @param index The position of the card in the hand.
   * @param side  The board side on which to play the card.
   * @return `true` if the card was successfully played, `false` if the index is out of bounds.
   * @example
   * val deck = new Deck()
   * val hand = new Hand(deck)
   * hand.useCard(2, side) // Returns false if the hand has no cards at index 2
   */
   def use_card(index:Int,side:BoardSide):Boolean={
     if (index<largo) {
       val carta = mano(index)
       carta.registerObserver(side)
       carta.be_played(side)
       carta.notifyObserver()
       mano =mano.patch(index, Nil, 1)
       largo=largo-1
       true
     }
     else{
       false
     }
  }

  /**
   * Uses a specific card from the hand and plays it on the assigned board side.
   *
   * @param card The card to play.
   * @param side The board side on which to play the card.
   */
  def use_card(card:Cards,side:BoardSide):Unit={
    var i=0
    var found=false
    //for (r<-mano){
    while(i < (largo) && !found){
      if (mano(i).equals(card)){
        card.registerObserver(side)
        card.be_played(side)
        card.notifyObserver()
        found=true
        mano =mano.patch(i, Nil, 1)
        largo=largo-1
      }
      i=i+1
    }
  }

  /**
   * Returns the weather cards present in the hand.
   *
   * @return A list of weather cards in the hand.
   */
  def getWeathersCard:ListBuffer[WeatherCards]={
    val v=new getWeatherCardVisitor
    for (r<-mano){
      r.accept(v)
    }
    v.getCards
  }

  /**
   * Returns the current size of the hand.
   *
   * @return The number of cards in the hand.
   * @example
   * val deck = new Deck()
   * val hand = new Hand(deck)
   * hand.Largu() // Returns the current size of the hand
   */
  def Largu(): Int = largo

  /**
   * Initializes the hand by drawing 5 cards from the deck.
   *
   * This function draws 5 cards from the given deck and adds them to the hand.
   *
   * @param Principal_deck The deck from which to draw the cards.
   * @example
   * val x = new Deck()
   * val y = new Hand(x)
   * y.incial(x) // Draws 5 cards from the deck and adds them to the hand
   */
  def incial(Principal_deck:Deck): Unit = {
    var x=0
    largo=10
    while(x<10) {
      val y=Principal_deck.draw_card()
      mano = y :: mano
      x=x+1
    }
  }

  /**
   * Returns the total strength of all cards in the hand.
   *
   * @return The total strength of the hand.
   */
  def getTotalStrenght:Int={
    val v= new getStrenghtVisitor
    for (r <- mano){
      r.accept(v)
    }
    v.getResult
  }
}
