package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.RangeCards

class ImpenetrableFog extends ComposerAbility {

  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list) {
      r.State.toFrozenState()
    }
  }
}
