package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import gwent.CardClasses.UnitCard

class FrozenState(context:UnitCard) extends CardState(context) {

  override def getStrenght: Int = 1

  override def toMoralBState(): Unit = {
    context.State= new FrozenAMoral(context)
  }

  override def toTightBondState(): Unit = {
    context.State= new FrozenATight(context)
  }

  override def toRegularState(): Unit = {
    context.State= new CardState(context)
  }
}
