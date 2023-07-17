package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.Cards

import cl.uchile.dcc.gwent.CardClasses.Effects.Frozen
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, UnitCard}
import cl.uchile.dcc.gwent.Controller.Observer.CardObserver

class BitingFrost extends ComposerAbility {

  override def activateM(list:List[MeleeCards]): Unit = {
    for(r<-list){
      r.addEffect(new Frozen)
    }
  }
  override def notify(r: CardObserver): Unit={
    r.update(this)
  }
  override def equals(obj: Any): Boolean ={
    obj match {
    case _: BitingFrost => true
    case _ => false
  }
}
}
