package cl.uchile.dcc
package gwent.CardClasses.SiegeCards

import gwent.Cards

abstract class SiegeCards (name:String,strenght:Int,ability:Int,potition:0) extends Cards {
  protected def beplayed: Void = {
  }
  def getName(): String = name

  def getStrenght(): Int = strenght
}