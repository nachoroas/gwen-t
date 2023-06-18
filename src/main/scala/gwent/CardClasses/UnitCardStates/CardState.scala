package cl.uchile.dcc
package gwent.CardClasses.UnitCardStates

import gwent.Cards

import cl.uchile.dcc.gwent.CardClasses.UnitCard

class CardState(context:UnitCard){
  
  context.State=this
  
  def getStrenght:Int=context.getStrenght
  
  def toFrozenState():Unit={
    context.State=new FrozenState(context)
  }
  def toTightBondState():Unit={
    context.State=new TightBond(context)
  }
  def toMoralBState():Unit={
    context.State=new MoralBoosted(context)
  }

  def toRegularState(): Unit = {
  }
}
