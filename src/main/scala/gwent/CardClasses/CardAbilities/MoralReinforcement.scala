package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

class MoralReinforcement extends ComposerAbility {

  override def activateM(list: List[MeleeCards]): Unit = {
    for (r <- list.tail) {
      r.State.toMoralBState()
    }
  }

  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list.tail) {
      r.State.toMoralBState()
    }
  }

  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list.tail) {
      r.State.toMoralBState()
    }
  }

}
