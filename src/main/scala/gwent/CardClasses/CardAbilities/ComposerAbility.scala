package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

import cl.uchile.dcc.gwent.Controller.Observer.CardObserver

class ComposerAbility extends Ability {

  def activateM(list:List[MeleeCards]): Unit = {
  }
  def activateR(list: List[RangeCards]): Unit = {
  }
  def activateS(list: List[SiegeCards]): Unit = {
  }
  def notify(r: CardObserver): Unit={
}
  override def toString: String = getClass.getSimpleName


}
