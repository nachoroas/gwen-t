package cl.uchile.dcc
package model.CardClasses.CardAbilities
import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

import cl.uchile.dcc.model.CardClasses.Effects.TightBondEffect

/**
 * The `TightBond` class represents a card ability that triggers a special effect when multiple cards of the same type are played together.
 * It extends the `ComposerAbility` class and provides the implementation for the `activateM`, `activateR`, and `activateS` methods.
 */
class TightBond extends ComposerAbility {
  /**
   * Activates the TightBond effect for a list of melee cards.
   *
   * @param list The list of melee cards to activate the effect on.
   */
  override def activateM(list: List[MeleeCards]): Unit = {
    val exampleCard: MeleeCards = list.head
    val Times = list.count(_ == exampleCard)
    if (Times > 1) {
      function(list, exampleCard)
    }
  }
  /**
   * Activates the TightBond effect for a list of ranged cards.
   *
   * @param list The list of ranged cards to activate the effect on.
   */
  override def activateR(list: List[RangeCards]): Unit = {
    val exampleCard: RangeCards = list.head
    val Times = list.count(_ == exampleCard)
    if (Times > 1) {
      function(list, exampleCard)
    }
  }

  /**
   * Activates the TightBond effect for a list of siege cards.
   *
   * @param list The list of siege cards to activate the effect on.
   */
  override def activateS(list: List[SiegeCards]): Unit = {
    val exampleCard: SiegeCards = list.head
    val Times = list.count(_ == exampleCard)
    if (Times > 1) {
      function(list, exampleCard)
    }
  }
  private def function[T<:UnitCard](list: List[T],card:T):Unit={
    for (r <- list) {
      if (card.equals(r)) {
        r.addEffect(new TightBondEffect())
      }
    }

  }
  /**
   * Checks if the given object is equal to this TightBond instance.
   *
   * @param obj The object to compare for equality.
   * @return True if the object is a TightBond instance, false otherwise.
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: TightBond => true
      case _ => false
    }
  }
}
