package cl.uchile.dcc
package model.CardClasses.CardAbilities

import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.Controller.Observer.CardObserver

/**
 * The `ClearWeather` class represents the ability of the Clear Weather weather card in the Gwent game.
 * It extends the `ComposerAbility` class and provides the implementation to activate the Clear Weather ability on different types of cards.
 */
class ClearWeather extends ComposerAbility {

  /**
   * Activates the Clear Weather ability on a list of melee cards by removing all weather effects from each card.
   *
   * @param list The list of melee cards on which to activate the Clear Weather ability.
   */
  override def activateM(list:List[MeleeCards]): Unit = {
    for (r<-list){
      r.removeEffect()
    }
  }

  /**
   * Activates the Clear Weather ability on a list of range cards by removing all effects from each card.
   *
   * @param list The list of range cards on which to activate the Clear Weather ability.
   */
  override def activateR(list: List[RangeCards]): Unit = {
    for (r <- list) {
      r.removeEffect()
    }
  }

  /**
   * Activates the Clear Weather ability on a list of siege cards by removing all effects from each card.
   *
   * @param list The list of siege cards on which to activate the Clear Weather ability.
   */
  override def activateS(list: List[SiegeCards]): Unit = {
    for (r <- list) {
      r.removeEffect()
    }
  }

  /**
   * Checks if the given object is equal to this ClearWeather instance.
   *
   * @param obj The object to compare for equality.
   * @return True if the object is a ClearWeather instance, false otherwise.
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case _: ClearWeather => true
      case _ => false
    }
  }
  /**
   * Notifies a card observer about the Clear Weather ability.
   *
   * This method is called to update the observer about the Clear Weather ability being activated.
   *
   * @param r The card observer to notify.
   */
  override def notify(r: CardObserver): Unit = {
    r.update(this)
  }


}
