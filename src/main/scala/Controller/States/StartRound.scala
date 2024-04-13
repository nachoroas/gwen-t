package cl.uchile.dcc
package Controller.States

import cl.uchile.dcc.Controller.GameController
import cl.uchile.dcc.model.Board.Board
import cl.uchile.dcc.model.Players.Player

/**
 * The game state where a new round is starting.
 *
 * @param context The game controller that manages the game state.
 */
class StartRound (context:GameController) extends GameState (context){
  /**
   * Transitions to the player turn state.
   * Overrides the base method in the parent class.
   */
  override def toPlayerTurn(): Unit = {
    context.state= new PlayerTurn(context)
  }

  /**
   * Shuffles the decks of the players.
   * Overrides the base method in the parent class.
   *
   * @param j The player whose deck is being shuffled.
   * @param c The CPU player whose deck is being shuffled.
   */
  override def ShuffleDeck(j:Player,c:Player): Unit = {
    j.ShuffleDeck()
    c.ShuffleDeck()
  }
  /**
   * Performs the draw card action for the player.
   * Overrides the base method in the parent class.
   *
   * @param j The player drawing the card.
   */
  override def doDrawCard(j:Player): Unit = {
    j.DrawCard()
    toPlayerTurn()
  }

  /**
   * Clears the game board.
   * Overrides the base method in the parent class.
   *
   * @param b The game board to be cleared.
   */
  override def ClearBoard(b:Board):Unit={
    b.ClearAllBoard()
  }


}
