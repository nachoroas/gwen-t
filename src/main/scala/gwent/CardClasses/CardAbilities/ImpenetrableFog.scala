package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.RangeCards

import cl.uchile.dcc.gwent.CardClasses.Effects.Frozen

class ImpenetrableFog extends ComposerAbility {

  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list) {
      r.addEffect(new Frozen)
    }
  }
}
