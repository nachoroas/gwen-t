package cl.uchile.dcc
package gwent.CardClasses.CardAbilities
import gwent.CardClasses.{SiegeCards, UnitCard}

import cl.uchile.dcc.gwent.CardClasses.Effects.Frozen
import cl.uchile.dcc.gwent.Controller.Observer.CardObserver

class TorrentialRain extends ComposerAbility {

  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list) {
      r.addEffect(new Frozen)
    }
  }

  override def notify(r: CardObserver): Unit = {
    r.update(this)
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case _: TorrentialRain => true
      case _ => false
    }
  }

}
