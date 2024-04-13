package cl.uchile.dcc
package Controller.States

import cl.uchile.dcc.Controller.GameController
import cl.uchile.dcc.model.Players.{Hand, Player}

import scala.util.Random
/**
 * The game state where it's the CPU's turn to make a move.
 *
 * @param context The game controller that manages the game state.
 */
class CPU_turn(context:GameController) extends GameState(context){
  /**
   * Transitions to the player turn state.
   * Overrides the base method in the parent class.
   */
  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }
  /**
   * Performs the CPU turn action.
   * Overrides the base method in the parent class.
   *
   * @param j The CPU player.
   * @param p The player.
   * @param M The CPU's hand.
   */
  override def doCPU_turn(j:Player,p:Player,M:Hand): Unit = {
    if (j.getTotalStrenght > p.getSideStrenght) {
      j.PlayCard(Random.nextInt(M.Largu()))
      toPlayerTurn() 
    }
    else {
      val WC = j.getWeathersCard
      if (WC.nonEmpty) {
        j.PlayCard(WC.head)
        toPlayerTurn()
      }
      else {
        doPass_turn() 
      }
    }
  }
  /**
   * Performs the pass turn action.
   * Overrides the base method in the parent class.
   */
  override def doPass_turn(): Unit = {
    context.state= new PerpetualPlayer(context)
  }

}
