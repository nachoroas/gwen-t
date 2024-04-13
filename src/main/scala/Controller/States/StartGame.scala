package cl.uchile.dcc
package Controller.States

import cl.uchile.dcc.Controller.GameController

/**
 * The game state where the game is starting.
 *
 * @param context The game controller that manages the game state.
 */
class StartGame(context: GameController) extends GameState (context){
  /**
   * Transitions to the start round state.
   * Overrides the base method in the parent class.
   */
  override def toStartRound(): Unit = {
    context.state= new StartRound(context)
  }

}
