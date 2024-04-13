package cl.uchile.dcc
package model.CardClasses.CardAbilities
import model.CardClasses.{SiegeCards, UnitCard}
import cl.uchile.dcc.Controller.Observer.CardObserver

import cl.uchile.dcc.model.CardClasses.Effects.Frozen
/**
 * The `TorrentialRain` class represents a card ability that applies the Frozen effect to all siege cards on the board.
 * It extends the `ComposerAbility` class and provides the implementation for the `activateS` method.
 */
class TorrentialRain extends ComposerAbility {
  /**
   * Activates the TorrentialRain ability by applying the Frozen effect to all siege cards in the provided list.
   *
   * @param list The list of siege cards to activate the ability on.
   */
  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list) {
      r.addEffect(new Frozen)
    }
  }
  /**
   * Notifies the given card observer about the TorrentialRain ability.
   *
   * @param r The card observer to notify.
   */
  override def notify(r: CardObserver): Unit = {
    r.update(this)
  }
  /**
   * Checks if the given object is equal to this TorrentialRain instance.
   *
   * @param obj The object to compare for equality.
   * @return True if the object is a TorrentialRain instance, false otherwise.
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: TorrentialRain => true
      case _ => false
    }
  }

}
