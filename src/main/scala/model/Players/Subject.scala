package cl.uchile.dcc
package model.Players

import Controller.Observer.Observer
import model.CardClasses.CardAbilities.Ability

trait Subject[T <: Observer]{

  def registerObserver(obs: T):Unit

  def notifyObserver():Unit

}
