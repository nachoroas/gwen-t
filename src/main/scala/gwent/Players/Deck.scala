package cl.uchile.dcc
package gwent.Players
import cl.uchile.dcc.gwent.CardClasses.CardAbilities.{BitingFrost, ClearWeather, ImpenetrableFog, NoAbility, TorrentialRain}
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
  def initiator(): Unit = {
    val Carta1 = MeleeCards("a", 1, new NoAbility)
    val Carta2 = MeleeCards("b", 2, new NoAbility)
    val Carta3 = MeleeCards("c", 3, new NoAbility)
    val Carta4 = MeleeCards("d", 4, new NoAbility)
    val Carta5 = MeleeCards("e", 5, new NoAbility)
    val Carta6 = MeleeCards("f", 6, new NoAbility)
    val Carta7 = MeleeCards("g", 7, new NoAbility)
    val Carta8 = RangeCards("h", 8, new NoAbility)
    val Carta9 = RangeCards("i", 9, new NoAbility)
    val Carta10 = RangeCards("j", 8, new NoAbility)
    val Carta11 = RangeCards("k", 7, new NoAbility)
    val Carta12 = RangeCards("l", 6, new NoAbility)
    val Carta13 = RangeCards("m", 5, new NoAbility)
    val Carta14 = RangeCards("n", 4, new NoAbility)
    val Carta15 = SiegeCards("o", 3, new NoAbility)
    val Carta16 = SiegeCards("p", 2, new NoAbility)
    val Carta17 = SiegeCards("q", 1, new NoAbility)
    val Carta18 = SiegeCards("r", 11, new NoAbility)
    val Carta19 = SiegeCards("s", 13, new NoAbility)
    val Carta20 = SiegeCards("t", 6, new NoAbility)
    val Carta21 = SiegeCards("u", 3, new NoAbility)
    val Carta22 = WeatherCards("v", new BitingFrost)
    val Carta23 = WeatherCards("x", new ImpenetrableFog)
    val Carta24 = WeatherCards("y", new TorrentialRain)
    val Carta25 = WeatherCards("z", new ClearWeather)

    mazo = Carta1 :: mazo
    mazo = Carta2 :: mazo
    mazo = Carta3 :: mazo
    mazo = Carta4 :: mazo
    mazo = Carta5 :: mazo
    mazo = Carta6 :: mazo
    mazo = Carta7 :: mazo
    mazo = Carta8 :: mazo
    mazo = Carta9 :: mazo
    mazo = Carta10 :: mazo
    mazo = Carta11 :: mazo
    mazo = Carta12 :: mazo
    mazo = Carta13 :: mazo
    mazo = Carta14 :: mazo
    mazo = Carta15 :: mazo
    mazo = Carta16 :: mazo
    mazo = Carta17 :: mazo
    mazo = Carta18 :: mazo
    mazo = Carta19 :: mazo
    mazo = Carta20 :: mazo
    mazo = Carta21 :: mazo
    mazo = Carta22 :: mazo
    mazo = Carta23 :: mazo
    mazo = Carta24 :: mazo
    mazo = Carta25 :: mazo
    mazo = Random.shuffle(mazo)
    large = 25
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
  
  def addCard(card:Cards):Unit={
    mazo = card :: mazo
    large= large+1
  }
  def Shuffle():Unit={
    mazo = Random.shuffle(mazo)
  }


}
