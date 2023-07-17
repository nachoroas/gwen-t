package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSide
import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.gwent.Visitor.Visitor

/**
 * Represents a siege card in the game.
 *
 * @param name The name of the siege card.
 * @param strenght The strength of the siege card.
 * @param ability The ability of the siege card.
 */
case class SiegeCards (override val name:String,override val strenght:Int,override val ability:Ability) extends AbstractUnitClass(name,strenght,ability) {

  /**
   * Plays the siege card on the specified board side.
   *
   * @param side The board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new SiegeCards("Cannon", 5, 0)
   * card.be_played(boardSide)  // Returns true or false
   */
  def be_played(side: BoardSide): Unit = {
    side.PlaySiegeCard(this)
  }

  def accept(visitor: Visitor): Unit = {
    visitor.visitSiegeCard(this)
  }

  def notifyObserver(): Unit = {
    for (r <- Observers) {
      r.update(this, ability)
    }
  }
}