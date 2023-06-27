package cl.uchile.dcc
package gwent.CardClasses.Effects

import gwent.CardClasses.Effects.Evisitor.Evisitor

class Frozen extends Effect {
  override def apply(i: Int): Int = 1

  def accept(visitor: Evisitor): Unit = visitor.VisitFrozenEffect(this)
}
