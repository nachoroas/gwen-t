package cl.uchile.dcc
package gwent.CardClasses.CardAbilities
import gwent.CardClasses.{SiegeCards, UnitCard}

class TorrentialRain extends ComposerAbility {

  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list) {
      r.State.toFrozenState()
    }
  }

}
