package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

import cl.uchile.dcc.gwent.CardClasses.Effects.MoralReinforcementEffect

class MoralReinforcement extends ComposerAbility {

  override def activateM(list: List[MeleeCards]): Unit = {
    for (r <- list.tail) {
      r.addEffect(new MoralReinforcementEffect)
    }
  }

  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list.tail) {
      r.addEffect(new MoralReinforcementEffect)
    }
  }

  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list.tail) {
      r.addEffect(new MoralReinforcementEffect)
    }
  }

}
