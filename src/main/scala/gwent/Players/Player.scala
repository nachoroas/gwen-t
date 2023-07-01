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
 * @constructor Create a new player with the given name, deck, hand, and board side.
 * @param name The name of the player.
 * @param mazo The deck of cards for the player.
 * @param mano The hand of cards for the player.
 * @param side The board side assigned to the player.
 */
case class Player (name:String,mazo:Deck,mano:Hand,side:BoardSide) extends Subject[PlayerObserver] {
  private var gem=2
  private val observers:ListBuffer[PlayerObserver]=ListBuffer()

  def registerObserver(obs: PlayerObserver): Unit={
    observers.append(obs)
  }

  def notifyObserver(): Unit={
    observers.foreach(_.update(this))
  }

  /**
   * Gets the name of the player.
   *
   * @return The name of the player.
   * @example
   * val a = new Deck()
   * val b = new Hand(a)
   * val x = new Player("bruno", a, b)
   * x.getName() // Returns "bruno"
   */
    def getName:String= name

  /**
   * Gets the current number of gems of the player.
   *
   * @return The number of gems.
   * @example
   * val a = new Deck()
   * val b = new Hand(a)
   * val x = new Player("bruno", a, b)
   * x.getGemNumber() // Returns 2
   */
    def gemnumber():Int=gem

  /**
   * Decreases the number of gems of the player.
   *
   * @return `true` if the player had enough gems and the number of gems was decreased by 1, `false` otherwise.
   * @example
   * val a = new Deck()
   * val b = new Hand(a)
   * val x = new Player("bruno", a, b)
   * x.loseGem() // Returns true if the player had at least 1 gem and decreases the gem count by 1, otherwise returns false
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
   * val a = new Deck()
   * val b = new Hand(a)
   * val x = new Player("bruno", a, b)
   * x.playCard(3) // Returns false if the hand has no cards or the index is out of bounds
   */

    def PlayCard(index: Int): Boolean = {
        if (mano.Largu()>0){
            mano.use_card(index,side)
          }
        else{
            false
        }
    }
  def PlayCard(card:Cards):Unit={
    mano.use_card(card,side)
  }

  /**
   * Gets the number of cards in the player's hand.
   *
   * @return The number of cards in the hand.
   * @example
   * val a = new Deck()
   * val b = new Hand(a)
   * val x = new Player("bruno", a, b)
   * x.handNumber() // Returns 0 if the hand is empty
   */
    def handnumer():Int=mano.Largu()
  
    def getTotalStrenght:Int={
      mano.getTotalStrenght+side.getTotalStrenght
    }
    def getSideStrenght:Int={
      side.getTotalStrenght
    }

    def getWeathersCard:ListBuffer[WeatherCards]={
      mano.getWeathersCard
    }
    def ShuffleDeck():Unit={
      mazo.Shuffle()
    }


}
