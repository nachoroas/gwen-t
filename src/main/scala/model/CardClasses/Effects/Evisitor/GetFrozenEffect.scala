package cl.uchile.dcc
package model.CardClasses.Effects.Evisitor
import model.CardClasses.Effects.Frozen
/**
 * The `GetFrozenEffect` class extends the `Evisitor` class and represents a specific visitor implementation
 * for determining if a Frozen effect is present.
 */
class GetFrozenEffect extends Evisitor {
  private var frozen: Boolean = false
  /**
   * Visits a Frozen effect and sets the `frozen` flag to `true`.
   *
   * @param frozenEffect The Frozen effect to visit.
   */
  override def VisitFrozenEffect(frozenEffect: Frozen): Unit = {
    frozen = true
    
  }

  /**
   * Checks if a Frozen effect has been encountered.
   *
   * @return `true` if a Frozen effect has been encountered, `false` otherwise.
   */
  def IsFrozen: Boolean = frozen

}
