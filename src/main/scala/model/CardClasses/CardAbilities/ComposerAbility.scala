package cl.uchile.dcc
package model.CardClasses.CardAbilities

import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

import cl.uchile.dcc.Controller.Observer.CardObserver

/**
 * The `ComposerAbility` class is an abstract class that represents a compositional ability in the Gwent game.
 * It extends the `Ability` class and provides methods to activate abilities on different types of cards.
 */
class ComposerAbility extends Ability {

  /**
   * Activates the compositional ability on a list of melee cards.
   *
   * This method is meant to be overridden by subclasses to provide specific implementations.
   *
   * @param list The list of melee cards on which to activate the ability.
   */
  def activateM(list:List[MeleeCards]): Unit = {
    // Empty implementation, meant to be overridden
  }

  /**
   * Activates the compositional ability on a list of ranged cards.
   *
   * This method is meant to be overridden by subclasses to provide specific implementations.
   *
   * @param list The list of ranged cards on which to activate the ability.
   */
  def activateR(list: List[RangeCards]): Unit = {
    // Empty implementation, meant to be overridden
  }

  /**
   * Activates the compositional ability on a list of siege cards.
   *
   * This method is meant to be overridden by subclasses to provide specific implementations.
   *
   * @param list The list of siege cards on which to activate the ability.
   */
  def activateS(list: List[SiegeCards]): Unit = {
    // Empty implementation, meant to be overridden
  }
  /**
   * Notifies a card observer about the compositional ability.
   *
   * This method is meant to be overridden by subclasses to provide specific implementations.
   *
   * @param r The card observer to notify.
   */
  def notify(r: CardObserver): Unit={
    // Empty implementation, meant to be overridden
}

  /**
   * Returns a string representation of the compositional ability.
   *
   * This method returns the simple name of the class.
   *
   * @return A string representation of the compositional ability.
   */
  override def toString: String = getClass.getSimpleName


}
