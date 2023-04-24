package cl.uchile.dcc
package gwent.CardClasses.SiegeCards

import gwent.Cards

abstract class SiegeCards (protected val name:String,protected var strenght:Int,protected val ability:Int,protected val potition:2) extends Cards {
  
  // creare esta funcion cuando tenga para trabajar con el tablero
  // def beplayed : Void =
  def getName: String = name

  def getStrenght: Int = strenght

  def loseStrenght(): Unit = {
    strenght = 1
  }
  def be_played() : Boolean=true

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[SiegeCards]) {
      val otherCard = o.asInstanceOf[SiegeCards]
      this.getName == otherCard.getName
    } else false
  }
}