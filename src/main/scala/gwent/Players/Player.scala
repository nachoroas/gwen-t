package cl.uchile.dcc
package gwent.Players

import gwent.Board.BoardSide

import cl.uchile.dcc.gwent.CardClasses.WeatherCards
import cl.uchile.dcc.gwent.Controller.Observer.PlayerObserver
import cl.uchile.dcc.gwent.{Cards, Subject}
import cl.uchile.dcc.gwent.Players.NoMoreGemsException

import scala.collection.mutable.ListBuffer

/**
 * The `Player` class represents a player in the game.
 *
 * @constructor Creates a player with a name, a deck of cards and a hand of cards.
 * @param name The name of the player.
 * @param deck The deck of cards for the player.
 * @param hand The hand of cards for the player.
 * @param side The board side assigned to the player.
 *
 */
case class Player (name:String,mazo:Deck,mano:Hand,side:BoardSide) extends Subject[PlayerObserver] {
  //case class because we want to use the equals method
  private var gem=2
  private val observers:ListBuffer[PlayerObserver]=ListBuffer()

  /**
   * Register an observer to receive notifications.
   *
   * @param obs The observer to register.
   */
  def registerObserver(obs: PlayerObserver): Unit={
    observers.append(obs)
  }
  /**
   * Notify all registered observers.
   */
  def notifyObserver(): Unit={
    observers.foreach(_.update(this))
  }

  /**
   * Gets the name of the player.
   *
   * @return The name of the player.
   * @example
   * val deck = new Deck()
   * val hand = new Hand(deck)
   * val player = new Player("bruno", deck, hand)
   * player.getName() // Returns "bruno"
   */
    def getName:String= name

  /**
   * Gets the current number of gems of the player.
   *
   * @return The number of gems.
   * @example
   * val deck = new Deck()
   * val hand = new Hand(deck)
   * val player = new Player("bruno", deck, hand)
   * player.getGemNumber() // Returns 2
   */
    def gemnumber():Int=gem

  /**
   * Decreases the number of gems of the player.
   *
   * @return `true` if the player had enough gems and the number of gems was decreased by 1, `false` otherwise.
   * @throws NoMoreGemsException if the player has no more gems.
   * @example
   * val deck = new Deck()
   * val hand = new Hand(deck)
   * val player = new Player("bruno", deck, hand)
   * player.loseGem() // Does the action if the player had at least 1 gem and decreases the gem count by 1, otherwise throws NoMoreGemsException
   */
    def losegem(): Unit = {
      try {
        if (gem > 1) {
          gem = gem - 1
        }
        else {
          throw new NoMoreGemsException()
        }
      }
      catch{
        case e:NoMoreGemsException => notifyObserver()
      } 
      
    }

  /**
   * Draws a card from the deck and adds it to the player's hand.
   *
   * This function checks if the deck has cards. If the deck is empty, it returns `false`.
   * If there are cards in the deck, the function draws a card and adds it to the hand.
   *
   * @return `true` if a card was drawn and added to the hand, `false` if the deck is empty.
   * @example
   * val a = new Deck()
   * val b = new Hand(a)
   * val x = new Player("bruno", a, b)
   * x.drawCard(a) // Returns false if the deck has no cards
   */
    def DrawCard():Boolean={
        if (mazo.GetLarge()>0 && mano.Largu()<10){
         mano.draw_card(mazo)
            true
        }
        else{
            false
        }
    }

  /**
   * Plays a card from the player's hand on the assigned board side.
   *
   * @param index The position of the card in the hand to play.
   * @return `true` if the card was successfully played, `false` if the hand is empty or the index is out of bounds.
   * @example
   * val deck = new Deck()
   * val hand = new Hand(deck)
   * val player = new Player("bruno", deck, hand)
   * player.playCard(3) // Returns false if the hand has no cards or the index is out of bounds
   */
  def PlayCard(index: Int): Boolean = {
        if (mano.Largu()>0){
            mano.use_card(index,side)
          }
        else{
            false
        }
    }

  /**
   * Plays a specific card from the player's hand on the assigned board side.
   *
   * @param card The card to play.
   */
  def PlayCard(card:Cards):Unit={
    mano.use_card(card,side)
  }

  /**
   * Gets the number of cards in the player's hand.
   *
   * @return The number of cards in the hand.
   * @example
   * val deck = new Deck()
   * val hand = new Hand(deck)
   * val player = new Player("bruno", deck, hand)
   * player.handNumber() // Returns 0 if the hand is empty
   */
    def handnumer():Int=mano.Largu()

  /**
   * Gets the total strength of the player's hand and board side combined.
   *
   * @return The total strength.
   */
    def getTotalStrenght:Int={
      mano.getTotalStrenght+side.getTotalStrenght
    }

  /**
   * Gets the strength of the player's board side.
   *
   * @return The strength of the board side.
   */
    def getSideStrenght:Int={
      side.getTotalStrenght
    }
  /**
   * Gets the weather cards in the player's hand.
   *
   * @return A list of weather cards in the hand.
   */
    def getWeathersCard:ListBuffer[WeatherCards]={
      mano.getWeathersCard
    }

  /**
   * Shuffles the player's deck.
   */
    def ShuffleDeck():Unit={
      mazo.Shuffle()
    }


}
