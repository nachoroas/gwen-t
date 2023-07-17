package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSide
import cl.uchile.dcc.gwent.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.gwent.Visitor.Visitor

/**
 * Represents a melee card in the game.
 *
 * @param name The name of the melee card.
 * @param strength The strength of the melee card.
 * @param ability The ability of the melee card.
 */

case class MeleeCards (override val name:String,override val strenght:Int,override val ability:Ability) extends AbstractUnitClass(name,strenght,ability){

  /**
   * Plays the melee card on the game board.
   *
   * @param side The game board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new MeleeCards("Swordsman", 5, 0)
   * card.be_played(gameBoardSide)  // Returns true or false
   */
  def be_played(side: BoardSide): Unit = {
    side.PlayMeleeCard(this)
    
  }

  def accept(visitor: Visitor): Unit = {
    visitor.visitMeleeCard(this)

  }
  def notifyObserver(): Unit = {
    for (r <- Observers) {
      r.update(this, ability)
    }
  }
  

}
