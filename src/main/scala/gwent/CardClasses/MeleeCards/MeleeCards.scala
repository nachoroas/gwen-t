package cl.uchile.dcc
package gwent.CardClasses.MeleeCards

import gwent.Cards

abstract class MeleeCards (protected val name:String,protected var strenght:Int,protected val ability:Int,protected val position:0) extends Cards{
  
  // creare esta funcion cuando tenga para trabajar con el tablero
  // def beplayed : Void =
  def getName(): String = name

  def getStrenght(): Int = strenght
  
  def loseStrenght():Unit={
    strenght=1
  }
  def be_played() : Boolean=true
}
