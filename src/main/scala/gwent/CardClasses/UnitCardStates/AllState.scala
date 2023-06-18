package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import gwent.CardClasses.UnitCard

class AllState(context:UnitCard,n:Int=1) extends CardState(context) {
  
  private var a:Int=n

  override def getStrenght: Int = 1*2+a

  override def toMoralBState(): Unit = {
    a += 1
  }

  override def toTightBondState(): Unit ={
  }
  override def toRegularState(): Unit = {
    context.State=new MoralATight(context,a)
  }
}
