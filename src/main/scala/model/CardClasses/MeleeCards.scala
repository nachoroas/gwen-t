package cl.uchile.dcc
package model.CardClasses

import model.Cards

import cl.uchile.dcc.model.Board.BoardSide
import cl.uchile.dcc.model.CardClasses.CardAbilities.Ability
import cl.uchile.dcc.model.Visitor.Visitor

/**
 * The `MeleeCards` case class represents a melee unit card in the game.
 *
 * @param name     The name of the melee card.
 * @param strenght The strength of the melee card.
 * @param ability  The ability of the melee card.
 */

case class MeleeCards (override val name:String,override val strenght:Int,override val ability:Ability) extends AbstractUnitClass(name,strenght,ability){
  //case class because we want to use the equals method

  /**
   * Plays the melee card on the game board.
   *
   * @param side The game board side to play the card on.
   * @example
   * val card = MeleeCards("Swordsman", 5, 0)
   * card.be_played(gameBoardSide)  
   */
  def be_played(side: BoardSide): Unit = {
    side.PlayMeleeCard(this)
    
  }
  /**
   * Accepts a visitor and invokes the appropriate method for the melee card.
   *
   * @param visitor The visitor to accept.
   */
  def accept(visitor: Visitor): Unit = {
    visitor.visitMeleeCard(this)

  }
  /**
   * Notifies the observers of the melee card about the ability change.
   */
  def notifyObserver(): Unit = {
    for (r <- Observers) {
      r.update(this, ability)
    }
  }
  

}
