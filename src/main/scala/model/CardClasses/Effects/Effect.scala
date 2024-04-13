package cl.uchile.dcc
package model.CardClasses.Effects

import model.CardClasses.Effects.Evisitor.Evisitor


trait Effect {
  def apply(i:Int):Int

  def accept(visitor: Evisitor): Unit 

}
