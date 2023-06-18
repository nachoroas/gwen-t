package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import cl.uchile.dcc.gwent.CardClasses.UnitCard


class FrozenAMoral(context:UnitCard,n:Int=1) extends CardState(context) {
  private var a:Int=n

  override def getStrenght: Int = 2+a

  override def toMoralBState(): Unit = {
    a+=1
  }

  override def toTightBondState(): Unit = {
    context.State= new AllState(context)
  }

  override def toRegularState(): Unit ={
    context.State=new MoralBoosted(context)
  }
}
