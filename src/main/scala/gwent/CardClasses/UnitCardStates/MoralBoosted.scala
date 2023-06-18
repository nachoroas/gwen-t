package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import gwent.CardClasses.UnitCard

class MoralBoosted(context:UnitCard,n:Int=1) extends CardState(context) {
  private var a: Int = n

  override def getStrenght: Int = context.getStrenght+a

  override def toMoralBState(): Unit = {
    a+=1
  }

  override def toTightBondState(): Unit = {
    context.State= new MoralATight(context,a)
  }

  override def toFrozenState(): Unit = {
    context.State= new FrozenAMoral(context,a)
  }
}
