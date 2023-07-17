package cl.uchile.dcc
package gwent.CardClasses.Effects

import gwent.CardClasses.Effects.Evisitor.Evisitor

class MoralReinforcementEffect extends Effect {
  override def apply(i: Int): Int =i+1

  def accept(visitor: Evisitor): Unit = visitor.VisitMoralEffect(this)
}
