package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.CardClasses.UnitCardStates.CardState

trait UnitCard extends Cards{
  var State:CardState
  def getStrenght:Int

  def getActualStrenght:Int

}
