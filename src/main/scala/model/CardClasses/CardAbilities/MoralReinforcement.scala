package cl.uchile.dcc
package model.CardClasses.CardAbilities

import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

import cl.uchile.dcc.model.CardClasses.Effects.MoralReinforcementEffect
/**
 * The `MoralReinforcement` class represents the ability of the Moral Reinforcement weather card in the Gwent game.
 * It extends the `ComposerAbility` class and provides the implementation to activate the Moral Reinforcement ability on different types of cards.
 */
class MoralReinforcement extends ComposerAbility {
  /**
   * Activates the Moral Reinforcement ability on a list of melee cards, excluding the first card in the list, by adding the MoralReinforcementEffect to each card.
   *
   * @param list The list of melee cards on which to activate the Moral Reinforcement ability.
   */
  override def activateM(list: List[MeleeCards]): Unit = {
    for (r <- list.tail) {
      r.addEffect(new MoralReinforcementEffect)
    }
  }

  /**
   * Activates the Moral Reinforcement ability on a list of range cards, excluding the first card in the list, by adding the MoralReinforcementEffect to each card.
   *
   * @param list The list of range cards on which to activate the Moral Reinforcement ability.
   */
  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list.tail) {
      r.addEffect(new MoralReinforcementEffect)
    }
  }
  /**
   * Activates the Moral Reinforcement ability on a list of siege cards, excluding the first card in the list, by adding the MoralReinforcementEffect to each card.
   *
   * @param list The list of siege cards on which to activate the Moral Reinforcement ability.
   */
  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list.tail) {
      r.addEffect(new MoralReinforcementEffect)
    }
  }
  /**
   * Checks if the given object is equal to this MoralReinforcement instance.
   *
   * @param obj The object to compare for equality.
   * @return True if the object is a MoralReinforcement instance, false otherwise.
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: MoralReinforcement => true
      case _ => false
    }
  }

}
