package cl.uchile.dcc
package gwent.Players
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import cl.uchile.dcc.gwent.Cards

import scala.util.Random


/** A class representing a Deck.
 *
 * The deck is defined with a list for the cards and a large for the list
 *
 * @constructor the class is defined with a empty list but has a function to
 *              create a deck with the 25 cards already defined in other classes
 *
 * @example
 * {{{
 *   val deck = new Deck()
 *   deck.initiator()
 *   deck.GerLarge=25
 *   deck.draw_card= //here goes the first card in the deck
 * }}}
 */

class Deck (){
  private var mazo:List[Cards]=List()
  private var large:Int=0

  /** Creates 25 cards and adds them to the deck
   *
   * this funtion creates 25 cards alteady defined in other classes, after that
   * add the cards to the list in the deck and sets the large of the deck in 25
   * and also this funtion shuffles the deck
   * @param void
   *
   * @return the deck already shuffled and with 25 cards
   *
   * @example
   * {{{
   *   val deck =new Deck()
   *   deck.initiator()
   *   now the deck is shuffled and with 25 cards
   * }}}
   */
   def initiator()={
    val Carta1 =new MeleeCards("a",1,0)
    val Carta2 =new MeleeCards("b",2,0)
    val Carta3 =new MeleeCards("c",3,0)
    val Carta4 =new MeleeCards("d",4,0)
    val Carta5 =new MeleeCards("e",5,0)
    val Carta6 = new MeleeCards("f",6,0)
    val Carta7 = new MeleeCards("g",7,0)
    val Carta8 = new RangeCards("h",8,0)
    val Carta9 = new RangeCards("i",9,0)
    val Carta10 = new RangeCards("j",8,0)
    val Carta11 = new RangeCards("k",7,0)
    val Carta12 = new RangeCards("l",6,0)
    val Carta13 = new RangeCards("m",5,0)
    val Carta14 = new RangeCards("n",4,0)
    val Carta15 = new SiegeCards("o",3,0)
    val Carta16 = new SiegeCards("p",2,0)
    val Carta17 = new SiegeCards("q",1,0)
    val Carta18 = new SiegeCards("r",11,0)
    val Carta19 = new SiegeCards("s",13,0)
    val Carta20 = new SiegeCards("t",6,0)
    val Carta21 = new SiegeCards("u",3,0)
    val Carta22 = new WeatherCards("v",1)
    val Carta23 = new WeatherCards("x",2)
    val Carta24 = new WeatherCards("y",3)
    val Carta25 = new WeatherCards("z",4)
    
    mazo= Carta1 :: mazo
    mazo= Carta2 :: mazo
    mazo= Carta3 :: mazo
    mazo= Carta4 :: mazo
    mazo= Carta5 :: mazo
    mazo= Carta6 :: mazo
    mazo= Carta7 :: mazo
    mazo= Carta8 :: mazo
    mazo= Carta9 :: mazo
    mazo= Carta10 :: mazo
    mazo= Carta11 :: mazo
    mazo= Carta12 :: mazo
    mazo= Carta13 :: mazo
    mazo= Carta14 :: mazo
    mazo= Carta15 :: mazo
    mazo= Carta16 :: mazo
    mazo= Carta17 :: mazo
    mazo= Carta18 :: mazo
    mazo= Carta19 :: mazo
    mazo= Carta20 :: mazo
    mazo= Carta21 :: mazo
    mazo= Carta22 :: mazo
    mazo= Carta23 :: mazo
    mazo= Carta24 :: mazo
    mazo= Carta25 :: mazo
    mazo=Random.shuffle(mazo)
    large=25
  }

  /** Draws a card from the deck
   *
   * this funtion draws the first card of the deck, saves it in a variable called "carta"
   * then reduces the large of the deck by deleting its first card also discount 1 to te variable large
   *
   * @param void no parameters
   *
   * @return the first card
   *
   * @example
   * {{{
   *   val x= Deck.draw_card()
   *   now x is the first card and Deck has a large discounted by 1
   * }}}
   */
  def draw_card():Cards={
    // here i don't check if it there is cards to draw because the previous funtion
    // only call this if it has at least 1 card
    val carta=mazo.head
    mazo=mazo.tail
    large=large-1
    carta
  }

  /** gets the large of the class
   *
   * @param void no parameters
   *
   * @return the large of the class (and the list)
   *
   *  @example
   *  {{{
   *    val x = new Deck()
   *    x.GetLarge()=0
   *  }}}
   */
  def GetLarge():Int=large


}
