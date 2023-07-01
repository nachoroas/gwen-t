package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}
import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.gwent.Controller.Observer.CardObserver
import cl.uchile.dcc.gwent.Visitor.Visitor
import cl.uchile.dcc.gwent.Subject

/**
 * Represents a weather card in the game.
 *
 * @param name The name of the weather card.
 * @param ability The ability of the weather card.
 */

case class WeatherCards(private val name:String, private val ability:Ability) extends Cards {
  private var Observers:List[CardObserver]=List[CardObserver]()
  
  /**
   * Gets the name of the weather card.
   *
   * @return The name of the weather card.
   * @example
   * val card = new WeatherCards("Rain", 1)
   * card.getName  // Returns "Rain"
   */
  def getName:String=name

  /**
   * Plays the weather card on the specified board side..
   *
   * @param Board The board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new WeatherCards("Rain", 1)
   * card.be_played(boardSide)  // Returns true or false
   */

  def be_played(Side: BoardSide): Unit = {
    Side.playcard(this)
  }

  /**
   * Determines if the weather card's ability can be used.
   * Note: This method is not yet implemented.
   *
   * @return True if the ability can be used, false otherwise.
   * @example
   * val card = new WeatherCards("Rain", 1)
   * card.UseAbility()  // Returns true or false
   */
  def getAbility():String=ability.toString
  
  def accept(visitor:Visitor):Unit={
    visitor.visitWeatherCard(this)
  }

  def registerObserver(obs: CardObserver): Unit={
    Observers=obs :: Observers
  }

  def notifyObserver(): Unit ={
    for(r<-Observers){
      r.update(ability)
      }
    }
    
  
}
