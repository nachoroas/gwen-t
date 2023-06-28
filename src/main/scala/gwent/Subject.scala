package cl.uchile.dcc
package gwent

import gwent.Controller.Observer.Observer

import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability

trait Subject {

  def registerObserver(obs: Observer):Unit

  def notifyObserver():Unit

}
