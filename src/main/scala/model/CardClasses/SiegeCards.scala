package cl.uchile.dcc
package model.CardClasses

import model.Cards

import cl.uchile.dcc.model.Board.BoardSide
import cl.uchile.dcc.model.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.model.Visitor.Visitor

/**
 * Represents a siege card in the game.
 *
 * @param name     The name of the siege card.
 * @param strenght The strength of the siege card.
 * @param ability  The ability of the siege card.
 */
case class SiegeCards (override val name:String,override val strenght:Int,override val ability:Ability) extends AbstractUnitClass(name,strenght,ability) {
  //case class because we want to use the equals method
  /**
   * Plays the siege card on the specified board side.
   *
   * @param side The board side to play the card on.
   * @example
   * val card = SiegeCards("Cannon", 5, 0)
   * card.be_played(boardSide) 
   */
  def be_played(side: BoardSide): Unit = {
    side.PlaySiegeCard(this)
  }
  /**
   * Accepts a visitor and invokes the appropriate method for the siege card.
   *
   * @param visitor The visitor to accept.
   */
  def accept(visitor: Visitor): Unit = {
    visitor.visitSiegeCard(this)
  }
  /**
   * Notifies the observers of the siege card about the ability change.
   */
  def notifyObserver(): Unit = {
    for (r <- Observers) {
      r.update(this, ability)
    }
  }
}