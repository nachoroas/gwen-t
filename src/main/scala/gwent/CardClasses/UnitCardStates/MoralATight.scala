package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import gwent.CardClasses.UnitCard

class MoralATight(context:UnitCard,n:Int=1) extends CardState(context) {
  private var a:Int=n
  
  override def getStrenght: Int = context.getStrenght *2 +a

  override def toMoralBState(): Unit = {
    a += 1
  }

  override def toTightBondState(): Unit = {
  }

  override def toFrozenState(): Unit = {
    context.State=new AllState(context,a)
  }
}
