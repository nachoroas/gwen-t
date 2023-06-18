package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import gwent.CardClasses.UnitCard

class FrozenATight (context:UnitCard) extends CardState(context) {

  override def getStrenght: Int = 2
  
  override def toMoralBState(): Unit = {
    context.State=new AllState(context)
  }

  override def toTightBondState(): Unit = {
  }

  override def toRegularState(): Unit = {
    context.State= new TightBond(context)
  }
}
