package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

class ComposerAbility extends Ability {

  def activateM(list:List[MeleeCards]): Unit = {
  }
  def activateR(list: List[RangeCards]): Unit = {
  }
  def activateS(list: List[SiegeCards]): Unit = {
  }
  override def toString: String = getClass.getSimpleName

}
