package cl.uchile.dcc
package gwent.CardClasses.CardAbilities
import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

import cl.uchile.dcc.gwent.CardClasses.Effects.TightBondEffect

class TightBond extends ComposerAbility {

  override def activateM(list: List[MeleeCards]): Unit = {
    val exampleCard: MeleeCards = list.head
    function(list,exampleCard)
  }

  override def activateR(list: List[RangeCards]): Unit = {
    val exampleCard: RangeCards = list.head
    function(list,exampleCard)
  }

  override def activateS(list: List[SiegeCards]): Unit = {
    val exampleCard: SiegeCards = list.head
    function(list,exampleCard)
  }
  private def function[T<:UnitCard](list: List[T],card:T):Unit={
    for (r <- list) {
      if (card.equals(r)) {
        r.addEffect(new TightBondEffect())
      }
    }

  }
}
