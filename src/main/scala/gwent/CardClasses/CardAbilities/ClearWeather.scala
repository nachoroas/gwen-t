package cl.uchile.dcc
package gwent.CardClasses.CardAbilities

import gwent.CardClasses.{MeleeCards, SiegeCards, RangeCards, WeatherCards}

class ClearWeather extends ComposerAbility {

  override def activateM(list:List[MeleeCards]): Unit = {
    for (r<-list){
      r.State.toRegularState()
    }
  }
  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list) {
      r.State.toRegularState()
    }
  }
  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list) {
      r.State.toRegularState()
    }
  }


}
