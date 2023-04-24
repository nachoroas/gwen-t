package cl.uchile.dcc
package gwent.CardClasses.SiegeCards

import gwent.Cards

abstract class SiegeCards (name:String,strenght:Int,ability:Int,potition:2) extends Cards {
  
  // creare esta funcion cuando tenga para trabajar con el tablero
  // def beplayed : Void =
  def getName(): String = name

  def getStrenght(): Int = strenght
}