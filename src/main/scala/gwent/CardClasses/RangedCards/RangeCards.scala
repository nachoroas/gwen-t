package cl.uchile.dcc
package gwent.CardClasses.RangedCards

import gwent.Cards

abstract class RangeCards (name:String,strenght:Int,ability:Int,potition:1) extends Cards { 
  // creare esta funcion cuando tenga para trabajar con el tablero
  // def beplayed : Void =
  def getName(): String = name

  def getStrenght(): Int = strenght
}