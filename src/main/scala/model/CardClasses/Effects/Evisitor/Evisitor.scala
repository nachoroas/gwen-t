package cl.uchile.dcc
package model.CardClasses.Effects.Evisitor

import model.CardClasses.Effects.{Frozen,  MoralReinforcementEffect, TightBondEffect}
/**
 * The `Evisitor` class represents a visitor pattern implementation for visiting different effects.
 * It provides methods to visit and perform operations on specific effect types.
 */
class Evisitor {
  
  def VisitFrozenEffect(frozenEffect: Frozen): Unit = {
    // Empty implementation, meant to be overridden if needed
    
  }
  def VisitMoralEffect(moralEffect: MoralReinforcementEffect): Unit = {
    // Empty implementation, meant to be overridden if needed

  }
  def VisitTightEffect(tightEffect: TightBondEffect): Unit = {
    // Empty implementation, meant to be overridden if needed

  }

}
