package cl.uchile.dcc
package gwent

import gwent.Controller.Observer.Observer

import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability

trait Subject[T <: Observer]{

  def registerObserver(obs: T):Unit

  def notifyObserver():Unit

}
