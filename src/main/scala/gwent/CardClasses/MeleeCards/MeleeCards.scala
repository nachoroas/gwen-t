package cl.uchile.dcc
package gwent.CardClasses.MeleeCards

import gwent.Cards

abstract class MeleeCards (protected val name:String,protected var strenght:Int,protected val ability:Int,protected val position:0) extends Cards{
  
  def getName: String = name

  def getStrenght: Int = strenght
  
  def loseStrenght():Unit={
    strenght=1
  }
  def be_played() : Boolean=true

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[MeleeCards]) {
      val otherCard = o.asInstanceOf[MeleeCards]
      this.getName == otherCard.getName
    } else false
  }
}
