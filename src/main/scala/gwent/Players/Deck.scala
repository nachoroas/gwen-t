package cl.uchile.dcc
package gwent.Players
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}
import cl.uchile.dcc.gwent.Cards

import scala.util.Random


/**
 * The `Deck` class represents a deck of cards.
 *
 * @constructor Creates an empty deck.
 */

class Deck (){
  private var mazo:List[Cards]=List()
  private var large:Int=0

  /**
   * Initializes the deck with 25 predefined cards and shuffles them.
   *
   * This function creates 25 cards of different types and adds them to the deck.
   * It also sets the large of the deck to 25 and shuffles the cards.
   *
   * @return The initialized and shuffled deck with 25 cards.
   * @example
   * val deck = new Deck()
   * deck.initiator()
   * // The deck is now shuffled and contains 25 cards
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

  /**
   * Draws a card from the deck.
   *
   * This function draws the first card from the deck, removes it from the deck,
   * and updates the large of the deck.
   *
   * @return The first card from the deck.
   * @example
   * val x = deck.draw_card()
   * // 'x' now contains the first card, and the deck has one card less
   */
  def draw_card():Cards={
    // here i don't check if it there is cards to draw because the previous funtion
    // only call this if it has at least 1 card
    val carta=mazo.head
    mazo=mazo.tail
    large=large-1
    carta
  }

  /**
   * Gets the number of cards in the deck.
   *
   * @return The number of cards in the deck.
   * @example
   * val x = new Deck()
   * x.getLarge() // Returns 0 if the deck is empty
   */
  def GetLarge():Int=large


}
