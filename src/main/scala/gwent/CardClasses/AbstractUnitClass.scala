package cl.uchile.dcc
package gwent.CardClasses

import gwent.{Cards, Subject}

import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.gwent.CardClasses.UnitCardStates.CardState
import cl.uchile.dcc.gwent.Controller.Observer.Observer

/**
 * An abstract base class representing a unit card in the game.
 *
 * @param name The name of the unit card.
 * @param strength The strength of the unit card.
 * @param ability The ability of the unit card.
 */
abstract class AbstractUnitClass (protected val name:String,protected val strenght:Int,protected val ability:Ability) extends UnitCard {
  
  var State:CardState = new CardState(this)
  var Observers:List[Observer]=List[Observer]()
  private var mutableStrenght:Int=strenght

  /**
   * Gets the name of the unit card.
   *
   * @return The name of the unit card.
   * @example
   * val card = new ConcreteUnitClass("Soldier", 5, 0)
   * card.getName  // Returns "Soldier"
   */
  def getName: String = name

  /**
   * Gets the strength of the unit card.
   *
   * @return The strength of the unit card.
   * @example
   * val card = new ConcreteUnitClass("Soldier", 5, 0)
   * card.getStrength  // Returns 5
   */
  def getStrenght: Int = strenght //mutable.strenght
  
  def restoreStrenght():Unit={
    mutableStrenght=strenght
  }
  def setStrenght(n:Int):Unit={
    mutableStrenght=n
  }
  
  def getActualStrenght:Int= State.getStrenght //

  /**
   * Uses the ability of the unit card.
   * Note: This method is not yet implemented
   *
   * @return True if the card has an ability, false otherwise.
   * @example
   * val card = new ConcreteUnitClass("Soldier", 5, 1)
   * card.UseAbility()  // Returns true
   */
  def getAbility(): String = ability.toString

  def registerObserver(obs: Observer): Unit = {
    Observers = obs :: Observers
  }
    
}
