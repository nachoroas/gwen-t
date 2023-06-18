package cl.uchile.dcc
package gwent.CardClasses.CardAbilities
import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

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
    card.State.toTightBondState()
    for (r <- list) {
      if (card.equals(r)) {
        r.State.toTightBondState()
      }
    }

  }
}
