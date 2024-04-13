package cl.uchile.dcc
package model.CardClasses.Effects

import model.CardClasses.Effects.Evisitor.Evisitor
/**
 * The `TightBondEffect` class extends the `Effect` class and represents the Tight Bond effect in the game.
 * It doubles the strength of affected cards.
 */
class TightBondEffect extends Effect {
  /**
   * Applies the Tight Bond effect by doubling the input value.
   *
   * @param i The input value to be modified.
   * @return The modified value after applying the Tight Bond effect.
   */
  override def apply(i: Int): Int = 2*i
  /**
   * Accepts a visitor and allows it to visit this Tight Bond effect.
   *
   * @param visitor The visitor to accept.
   */
  def accept(visitor: Evisitor): Unit = visitor.VisitTightEffect(this)
}
