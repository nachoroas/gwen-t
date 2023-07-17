package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.CardClasses.Effects.{Frozen, MoralReinforcementEffect, TightBondEffect}

trait UnitCard extends Cards{
  def getStrenght:Int

  def addEffect(effect:Frozen):Unit

  def addEffect(effect:TightBondEffect):Unit

  def addEffect(effect:MoralReinforcementEffect):Unit
  
  def removeEffect():Unit

}
