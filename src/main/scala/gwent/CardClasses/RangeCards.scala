package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}
import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.gwent.Visitor.Visitor

/**
 * Represents a range card in the game.
 *
 * @param name The name of the range card.
 * @param strength The strength of the range card.
 * @param ability The ability of the range card.
 */

case class RangeCards (override val name:String,override val strenght:Int,override val ability:Ability) extends AbstractUnitClass(name,strenght,ability) {

  /**
   * Plays the range card on the game board.
   *
   * @param side The game board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new RangeCards("Archer", 3, 0)
   * card.be_played(gameBoardSide)  // Returns true or false
   */
  def be_played(side:BoardSide) : Unit={
    side.PlayRangedCard(this)
  }

  def accept(visitor: Visitor): Unit = {
    visitor.visitRangeCard(this)

  }
  def notifyObserver(): Unit = {
    for (r <- Observers) {
      r.update(this, ability)
    }
  }
  
}