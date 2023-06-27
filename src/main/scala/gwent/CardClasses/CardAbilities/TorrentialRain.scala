package cl.uchile.dcc
package gwent.CardClasses.CardAbilities
import gwent.CardClasses.{SiegeCards, UnitCard}

import cl.uchile.dcc.gwent.CardClasses.Effects.Frozen

class TorrentialRain extends ComposerAbility {

  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list) {
      r.addEffect(new Frozen)
    }
  }

}
