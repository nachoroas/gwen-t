package cl.uchile.dcc
package gwent.CardClasses.Effects

import gwent.CardClasses.Effects.Evisitor.Evisitor

class TightBondEffect extends Effect {
  override def apply(i: Int): Int = 2*i

  def accept(visitor: Evisitor): Unit = visitor.VisitTightEffect(this)
}
