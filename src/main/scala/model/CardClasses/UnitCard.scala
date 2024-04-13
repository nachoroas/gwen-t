package cl.uchile.dcc
package model.CardClasses

import model.Cards

import cl.uchile.dcc.model.CardClasses.Effects.{Frozen, MoralReinforcementEffect, TightBondEffect}

trait UnitCard extends Cards{
  def getStrenght:Int

  def addEffect(effect:Frozen):Unit

  def addEffect(effect:TightBondEffect):Unit

  def addEffect(effect:MoralReinforcementEffect):Unit
  
  def removeEffect():Unit

}
