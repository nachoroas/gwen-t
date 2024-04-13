package cl.uchile.dcc
package model.CardClasses

import model.Cards
import cl.uchile.dcc.Controller.Observer.CardObserver

import cl.uchile.dcc.model.Board.{Board, BoardSide}
import cl.uchile.dcc.model.CardClasses.CardAbilities.{Ability, BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.model.Players.Subject
import cl.uchile.dcc.model.Visitor.Visitor

/**
 * Represents a weather card in the game.
 *
 * @param name    The name of the weather card.
 * @param ability The ability of the weather card.
 */
case class WeatherCards(private val name:String, private val ability:Ability) extends Cards {
  private var Observers:List[CardObserver]=List[CardObserver]()
  //case class because we want to use the equals method

  /**
   * Gets the name of the weather card.
   *
   * @return The name of the weather card.
   * @example
   * val card = WeatherCards("Rain", 1)
   * card.getName  // Returns "Rain"
   */
  def getName:String=name

  /**
   * Plays the weather card on the specified board side.
   *
   * @param Side The board side to play the card on.
   * @example
   * val card = WeatherCards("Rain", 1)
   * card.be_played(boardSide)
   */
  def be_played(Side: BoardSide): Unit = {
    Side.PlayWeatherCard(this)
  }

  /**
   * Gets the ability of the weather card.
   *
   * @return The ability of the weather card.
   * @example
   * val card = WeatherCards("Rain", 1)
   * card.getAbility  // Returns the ability of the card as a string
   */
  def getAbility():String=ability.toString

  /**
   * Accepts a visitor and invokes the appropriate method for the weather card.
   *
   * @param visitor The visitor to accept.
   */
  def accept(visitor:Visitor):Unit={
    visitor.visitWeatherCard(this)
  }

  /**
   * Registers an observer to receive updates from the weather card.
   *
   * @param obs The observer to register.
   */
  def registerObserver(obs: CardObserver): Unit={
    Observers=obs :: Observers
  }
  /**
   * Notifies the registered observers about the ability change of the weather card.
   */
  def notifyObserver(): Unit = {
    for (r <- Observers) {
      ability.notify(r)
      }
    }

  
    
  
}
