package cl.uchile.dcc
package model.CardClasses

import model.Cards
import cl.uchile.dcc.Controller.Observer.CardObserver

import cl.uchile.dcc.model.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.model.CardClasses.Effects.Evisitor.GetFrozenEffect
import cl.uchile.dcc.model.CardClasses.Effects.{Effect, Frozen,  MoralReinforcementEffect,  TightBondEffect}
import cl.uchile.dcc.model.Players.Subject
import cl.uchile.dcc.model.Visitor.getWeatherCardVisitor

import scala.::
import scala.collection.mutable.ListBuffer

/**
 * The `AbstractUnitClass` is an abstract class representing a unit card with a name, strength, and ability.
 *
 * @param name     The name of the unit card.
 * @param strenght The strength of the unit card.
 * @param ability  The ability of the unit card.
 */
abstract class AbstractUnitClass (protected val name:String,protected val strenght:Int,protected val ability:Ability) extends UnitCard {
  
  var Observers:List[CardObserver]=List[CardObserver]()
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
   * Gets the strength of the unit card, considering any applied effects.
   *
   * @return The strength of the unit card.
   * @example
   * val card = MeleeCards("Soldier", 5, new NoAbility)
   * card.getStrenght  // Returns 5
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
  /**
   * Adds a frozen effect to the unit card.
   *
   * @param effect The frozen effect to add.
   */
  def addEffect(effect:Frozen):Unit={
    effects=effect::effects
  }
  /**
   * Adds a tight bond effect to the unit card.
   *
   * @param effect The tight bond effect to add.
   */
  def addEffect(effect:TightBondEffect):Unit={
    effects=effects :+ effect
  }
  /**
   * Adds a moral reinforcement effect to the unit card.
   *
   * @param effect The moral reinforcement effect to add.
   */
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

  /**
   * Removes the frozen effect from the unit card, if present.
   */
  def removeEffect():Unit= {
    if (effects.nonEmpty) {
      val v = new GetFrozenEffect
      for (r <- effects) {
        r.accept(v)
      }
      if (v.IsFrozen) {
        effects = effects.tail
      }
    }
  }

  /**
   * Gets the ability of the unit card.
   *
   * @return The ability of the unit card as a string.
   * @example
   * val card = new ConcreteUnitClass("Soldier", 5, 1)
   * card.getAbility()  // Returns the ability of the card as a string
   */
  def getAbility(): String = ability.toString
  /**
   * Registers an observer to be notified of changes to the unit card.
   *
   * @param observer The observer to register.
   */
  def registerObserver(obs: CardObserver): Unit = {
    Observers = obs :: Observers
  }
    
}
