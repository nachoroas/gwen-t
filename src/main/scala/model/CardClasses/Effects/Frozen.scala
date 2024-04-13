package cl.uchile.dcc
package model.CardClasses.Effects

import model.CardClasses.Effects.Evisitor.Evisitor

/**
 * The `Frozen` class extends the `Effect` class and represents the Frozen effect in the game.
 * It reduces the strength of affected cards to 1.
 */
class Frozen extends Effect {
  /**
   * Applies the Frozen effect by reducing the input value to 1.
   *
   * @param i The input value to be modified.
   * @return The modified value after applying the Frozen effect.
   */
  override def apply(i: Int): Int = 1
  /**
   * Accepts a visitor and allows it to visit this Frozen effect.
   *
   * @param visitor The visitor to accept.
   */
  def accept(visitor: Evisitor): Unit = visitor.VisitFrozenEffect(this)
}
