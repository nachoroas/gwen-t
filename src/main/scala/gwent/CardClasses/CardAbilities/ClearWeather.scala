package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.gwent.Controller.Observer.CardObserver

class ClearWeather extends ComposerAbility {

  override def activateM(list:List[MeleeCards]): Unit = {
    for (r<-list){
      r.removeEffect()
    }
  }
  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list) {
      r.removeEffect()
    }
  }
  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list) {
      r.removeEffect()
    }
  }
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: ClearWeather => true
      case _ => false
    }
  }

  override def notify(r: CardObserver): Unit = {
    r.update(this)
  }


}
