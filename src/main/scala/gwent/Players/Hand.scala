package cl.uchile.dcc
package gwent.Players

import gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSide

/** A classes representing the hand of card at the moment of playing
 *
 * the hand depends on a deck tot draw cards from it
 *
 * @param Principal_deck the deck where to get the cards
 *
 * @constructor the class is defined with a empty list and its large but has a funtion to
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

  /** Draws cards from the deck
   *
   * this function checks if the deck has card to draw if not it returns false
   * if yes the function draws the card, adds it to the hand and increases the large by 1
   *
   * @param Principal_deck the deck where to get the cards
   * @return true or false depending if it could draw a card or not
   *
   * @example
   * val x=new deck()
   * val y=new hand(x)
   * y.draw_card(x)=false //the deck has no card
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

  /**It "uses" a card from the hand, but for this homework i dont have it implemented
   * so it return true if it can and false if not
   *
   * @param index the position of the card
   * @return true or false
   *
   * @example
   * val x=new deck()
   * val y=new hand(x)
   * y.use_card(2)=false //hand have no cards
   */
   def use_card(index:Int,side:BoardSide):Boolean={
     if (index<largo) {
       val carta = mano(index)
       carta.be_played(side)
       mano =mano.patch(index, Nil, 1)
       largo=largo-1
       true
     }
     else{
       false
     }
  }

  /** gets the large of the class
   *
   * @param void no parameters
   * @return the large of the class (and the list)
   * @example
   * {{{
   *    val x = new Deck()
   *    val y=new hand(x)
   *    y.Largu()=0
   *   }}}
   */
  def Largu(): Int = largo

  /** Adds 5 cards from the deck to the hand
   *
   * this function draws from and already created deck and uses a method from deck to draw cards
   *
   * @param Principal_deck to draw cards from
   *
   * @return this function don't return anything but the hand gets 5 cards and a large of 5
   *
   * @example
   * {{{
   *    val x = new Deck()
   *    val y=new hand(x)
   *    y.inicial(x)
   * }}}
   */
  def incial(Principal_deck:Deck): Unit = {
    var x=0
    largo=5
    while(x<5) {
      val y=Principal_deck.draw_card()
      mano = y :: mano
      x=x+1
    }
  }
}
