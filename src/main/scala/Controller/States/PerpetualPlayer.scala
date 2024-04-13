package cl.uchile.dcc
package Controller.States

import cl.uchile.dcc.Controller.GameController
import cl.uchile.dcc.model.Cards
import cl.uchile.dcc.model.Players.Player
/**
 * The game state where the player has passed their turn and is waiting for the end of the round.
 *
 * @param context The game controller that manages the game state.
 */
class PerpetualPlayer(context:GameController) extends GameState(context){
  /**
   * Performs the pass turn action.
   * Overrides the base method in the parent class.
   * Transitions to the end round state and triggers the loss of gems of someone.
   */
  override def doPass_turn(): Unit = {
    context.state = new EndRound(context)
    context.LoseGems()
  }

  /**
   * Performs the play card action with an input index.
   * Overrides the base method in the parent class.
   *
   * @param input The index of the card to play.
   * @param j     The player.
   */
  override def doPlayCard(input: Int, j: Player): Unit = {
    j.PlayCard(input)
  }

  /**
   * Performs the play card action with a specific card.
   * Overrides the base method in the parent class.
   *
   * @param card The card to play.
   * @param j    The player.
   */

  override def doPlayCard(card: Cards, j: Player): Unit = {
    j.PlayCard(card)
  }
  
}
