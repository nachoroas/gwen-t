package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.RangeCards

import cl.uchile.dcc.gwent.CardClasses.Effects.Frozen
import cl.uchile.dcc.gwent.Controller.Observer.CardObserver

class ImpenetrableFog extends ComposerAbility {

  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list) {
      r.addEffect(new Frozen)
    }
  }

  override def notify(r: CardObserver): Unit = {
    r.update(this)
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case _: ImpenetrableFog => true
      case _ => false
    }
  }
}
