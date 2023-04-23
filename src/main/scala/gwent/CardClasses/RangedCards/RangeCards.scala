package cl.uchile.dcc
package gwent.CardClasses.RangedCards

import gwent.Cards

abstract class RangeCards (name:String,strenght:Int,ability:Int,potition:1) extends Cards{
  protected def beplayed:Void ={
  }
  def getName(): String = name

  def getStrenght(): Int = strenght