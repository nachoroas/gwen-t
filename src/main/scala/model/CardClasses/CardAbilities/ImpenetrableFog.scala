package cl.uchile.dcc
package model.CardClasses.CardAbilities

import model.CardClasses.RangeCards
import cl.uchile.dcc.Controller.Observer.CardObserver

import cl.uchile.dcc.model.CardClasses.Effects.Frozen

/**
 * The `ImpenetrableFog` class represents the ability of the Impenetrable Fog weather card in the Gwent game.
 * It extends the `ComposerAbility` class and provides the implementation to activate the Impenetrable Fog ability on range cards.
 */
class ImpenetrableFog extends ComposerAbility {
  /**
   * Activates the Impenetrable Fog ability on a list of range cards by adding the Frozen effect to each card.
   *
   * @param list The list of range cards on which to activate the Impenetrable Fog ability.
   */
  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list) {
      r.addEffect(new Frozen)
    }
  }

  /**
   * Notifies a card observer about the Impenetrable Fog ability.
   *
   * This method is called to update the observer about the Impenetrable Fog ability being activated.
   *
   * @param r The card observer to notify.
   */
  override def notify(r: CardObserver): Unit = {
    r.update(this)
  }
  /**
   * Checks if the given object is equal to this ImpenetrableFog instance.
   *
   * @param obj The object to compare for equality.
   * @return True if the object is an ImpenetrableFog instance, false otherwise.
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: ImpenetrableFog => true
      case _ => false
    }
  }
}
