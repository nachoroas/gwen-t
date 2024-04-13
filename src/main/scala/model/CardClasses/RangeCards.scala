package cl.uchile.dcc
package model.CardClasses

import model.Cards

import cl.uchile.dcc.model.Board.{Board, BoardSide}
import cl.uchile.dcc.model.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.model.Visitor.Visitor

/**
 * Represents a range card in the game.
 *
 * @param name     The name of the range card.
 * @param strenght The strength of the range card.
 * @param ability  The ability of the range card.
 */
case class RangeCards (override val name:String,override val strenght:Int,override val ability:Ability) extends AbstractUnitClass(name,strenght,ability) {
  //case class because we want to use the equals method

  /**
   * Plays the range card on the game board.
   *
   * @param side The game board side to play the card on.
   * @example
   * val card = RangeCards("Archer", 3, 0)
   * card.be_played(gameBoardSide) 
   */
  def be_played(side:BoardSide) : Unit={
    side.PlayRangedCard(this)
  }
  /**
   * Accepts a visitor and invokes the appropriate method for the range card.
   *
   * @param visitor The visitor to accept.
   */
  def accept(visitor: Visitor): Unit = {
    visitor.visitRangeCard(this)

  }
  /**
   * Notifies the observers of the range card about the ability change.
   */
  def notifyObserver(): Unit = {
    for (r <- Observers) {
      r.update(this, ability)
    }
  }
  
}