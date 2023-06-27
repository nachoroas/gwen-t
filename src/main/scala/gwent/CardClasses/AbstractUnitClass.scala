package cl.uchile.dcc
package gwent.CardClasses

import gwent.{Cards, Subject}

import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.gwent.CardClasses.Effects.Evisitor.GetFrozenEffect
import cl.uchile.dcc.gwent.CardClasses.Effects.{Effect, Frozen,  MoralReinforcementEffect,  TightBondEffect}
import cl.uchile.dcc.gwent.Controller.Observer.Observer
import cl.uchile.dcc.gwent.Visitor.getWeatherCardVisitor

import scala.::
import scala.collection.mutable.ListBuffer

/**
 * An abstract base class representing a unit card in the game.
 *
 * @param name The name of the unit card.
 * @param strength The strength of the unit card.
 * @param ability The ability of the unit card.
 */
abstract class AbstractUnitClass (protected val name:String,protected val strenght:Int,protected val ability:Ability) extends UnitCard {
  
  var Observers:List[Observer]=List[Observer]()
  private var effects:List[Effect]=List[Effect]()

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

  def getStrenght: Int = {
    var a: Int = strenght
    if (effects.nonEmpty) {
      for (effect <- effects) {
        a = effect(a)
      }
    }
    a
  }

  def addEffect(effect:Frozen):Unit={
    effects=effect::effects
  }
  def addEffect(effect:TightBondEffect):Unit={
    effects=effects :+ effect
  }
  def addEffect(effect:MoralReinforcementEffect):Unit={
    val v = new GetFrozenEffect
    for (r <- effects) {
      r.accept(v)
    }
    if (v.IsFrozen) {
      val a = effects.head
      effects = effect :: effects.tail
      effects = a :: effects
    }
    else {
      effects = effect :: effects
  }

  }
  def removeEffect():Unit={
    effects=effects.tail
  }

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
