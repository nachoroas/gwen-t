package cl.uchile.dcc
package Controller.States

import model.Cards
import cl.uchile.dcc.Controller.GameController

import cl.uchile.dcc.model.Board.Board
import cl.uchile.dcc.model.Players.{Hand, Player}

/**
 * The base class for different game states in the Gwent game.
 *
 * @param context The game controller that manages the game state.
 */
class GameState protected(val context: GameController) {
  // Set the state of the context to this state
  context.state = this
  /**
   * Transitions to the CPU turn state.
   * This method should be overridden in the specific game state implementation.
   */
  def toCpu_turn():Unit={
    transitionError("toCpu_turn")
  }

  /**
   * Transitions to the player turn state.
   * This method should be overridden in the specific game state implementation.
   */
  def toPlayerTurn():Unit={
    transitionError("toPlayerTurn")
  }

  /**
   * Transitions to the start round state.
   * This method should be overridden in the specific game state implementation.
   */
  def toStartRound():Unit={
    transitionError("toStartRound")
  }

  /**
   * Transitions to the end round state.
   * This method should be overridden in the specific game state implementation.
   */
  def toEndRound():Unit={
    transitionError("toEndRound")    
  }

  /**
   * Transitions to the end game state.
   * This method should be overridden in the specific game state implementation.
   */
  def toEndGame(): Unit = {
    transitionError("toEndGame")
  }

  /**
   * Performs the action of playing a card by its input index.
   * This method should be overridden in the specific game state implementation.
   *
   * @param input The input index of the card to play.
   * @param j     The player who is playing the card.
   */
  def doPlayCard(input:Int,j:Player):Unit={
    ActionError("doPlayCard")
  }

  /**
   * Performs the action of playing a card.
   * This method should be overridden in the specific game state implementation.
   *
   * @param card The card to play.
   * @param j    The player who is playing the card.
   */
  def doPlayCard(card:Cards,j:Player):Unit={
    ActionError("doPlayCard")
  }

  /**
   * Performs the action of passing the turn.
   * This method should be overridden in the specific game state implementation.
   */
  def doPass_turn():Unit={
    ActionError("doPass_turn")
  }

  /**
   * Performs the action of the CPU's turn.
   * This method should be overridden in the specific game state implementation.
   *
   * @param j The CPU player.
   * @param P The human player.
   * @param m The hand of the CPU player.
   */
  def doCPU_turn(j:Player,P:Player,m:Hand):Unit={
    ActionError("doCPU_turn")
  }

  /**
   * Performs the action of drawing a card for a player.
   * This method should be overridden in the specific game state implementation.
   *
   * @param j The player who is drawing a card.
   */
  def doDrawCard(j:Player): Unit = {
    ActionError("doDrawCard")
  }

  /**
   * Performs the action of losing gems.
   * This method should be overridden in the specific game state implementation.
   *
   * @param p The player who loses gems.
   * @param c The opponent player.
   */
  def LoseGems(p:Player,c:Player):Unit={
    ActionError("LoseGems")
  }

  /**
   * Performs the action of clearing the game board.
   * This method should be overridden in the specific game state implementation.
   *
   * @param b The game board to clear.
   */
  def ClearBoard(b:Board):Unit={
    ActionError("ClearBoard")
  }

  /**
   * Performs the action of shuffling the player's deck.
   * This method should be overridden in the specific game state implementation.
   *
   * @param p The player whose deck needs to be shuffled.
   * @param c The opponent player.
   */
  def ShuffleDeck(p:Player,c:Player):Unit={
    ActionError("ShuffleDeck")
  }

  /**
   * Throws an exception indicating an invalid transition to a target state.
   *
   * @param targetState The name of the target state.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }

  /**
   * Throws an exception indicating an invalid action in the current state.
   *
   * @param action The name of the action.
   */
  private def ActionError(action: String): Unit = {
    throw new InvalidActionException(
      s"Cannot do $action in ${getClass.getSimpleName}"
    )
  }

  /**
   * Returns the name of the current game state.
   *
   * @return The name of the current game state.
   */
  def getState:String={
    getClass.getSimpleName
  }


}