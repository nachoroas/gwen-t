package cl.uchile.dcc
package gwent.CardClasses.Effects

import gwent.CardClasses.Effects.Evisitor.Evisitor


trait Effect {
  def apply(i:Int):Int

  def accept(visitor: Evisitor): Unit 

}
