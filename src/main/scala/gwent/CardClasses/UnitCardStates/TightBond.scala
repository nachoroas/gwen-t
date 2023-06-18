package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import gwent.CardClasses.UnitCard

class TightBond(context:UnitCard) extends CardState(context) {

  override def getStrenght: Int = context.getStrenght * 2

  override def toMoralBState(): Unit = {
    context.State=new MoralATight(context)
  }

  override def toTightBondState(): Unit = {
  }

  override def toFrozenState(): Unit = {
    context.State=new FrozenATight(context)
  }
}
