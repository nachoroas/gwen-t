package cl.uchile.dcc
package gwent.CardClasses.Effects.Evisitor
import gwent.CardClasses.Effects.Frozen

class GetFrozenEffect extends Evisitor {
  private var frozen: Boolean = false

  override def VisitFrozenEffect(frozenEffect: Frozen): Unit = {
    frozen = true
    
  }
  def IsFrozen: Boolean = frozen

}
