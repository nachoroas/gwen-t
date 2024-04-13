package cl.uchile.dcc
package model.CardClasses.Effects

import model.CardClasses.Effects.Evisitor.Evisitor
/**
 * The `MoralReinforcementEffect` class extends the `Effect` class and represents the Moral Reinforcement effect in the game.
 * It increases the strength of affected cards by 1.
 */
class MoralReinforcementEffect extends Effect {
  /**
   * Applies the Moral Reinforcement effect by increasing the input value by 1.
   *
   * @param i The input value to be modified.
   * @return The modified value after applying the Moral Reinforcement effect.
   */
  override def apply(i: Int): Int =i+1
  /**
   * Accepts a visitor and allows it to visit this Moral Reinforcement effect.
   *
   * @param visitor The visitor to accept.
   */
  def accept(visitor: Evisitor): Unit = visitor.VisitMoralEffect(this)
}
