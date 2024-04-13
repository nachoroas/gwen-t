package cl.uchile.dcc
package Controller.States

import cl.uchile.dcc.Controller.GameController
import cl.uchile.dcc.model.Cards
import cl.uchile.dcc.model.Players.Player

/**
 * The game state where it's the player's turn to make a move.
 *
 * @param context The game controller that manages the game state.
 */

class PlayerTurn(context: GameController) extends GameState (context){

  /**
   * Transitions to the CPU turn state.
   * Overrides the base method in the parent class.
   */
  override def toCpu_turn(): Unit = {
    context.state = new CPU_turn(context)
  }

  /**
   * Performs the play card action based on the input.
   * Overrides the base method in the parent class.
   *
   * @param input The input specifying the card to be played.
   * @param j     The player who is playing the card.
   */
  override def doPlayCard(input:Int,j:Player): Unit = {
    j.PlayCard(input)
    toCpu_turn()
  }
  /**
   * Performs the play card action using the specified card.
   * Overrides the base method in the parent class.
   *
   * @param card The card to be played.
   * @param j The player who is playing the card.
   */
  override def doPlayCard(card: Cards,j:Player): Unit = {
    j.PlayCard(card)
    toCpu_turn()
  }
  /**
   * Performs the pass turn action.
   * Overrides the base method in the parent class.
   */
  override def doPass_turn(): Unit = {
    context.state= new PerpetualCPU(context)
  }
}
