package cl.uchile.dcc
package Controller.States

import cl.uchile.dcc.Controller.GameController
import cl.uchile.dcc.model.Players.{Hand, Player}

import scala.util.Random

/**
 * The game state where the CPU player has passed their turn and is waiting for the end of the round.
 *
 * @param context The game controller that manages the game state.
 */
class PerpetualCPU(context:GameController) extends GameState(context) {
  /**
   * Performs the CPU turn.
   * Overrides the base method in the parent class.
   *
   * @param j The CPU player.
   * @param p The player.
   * @param m The CPU player's hand.
   */
  override def doCPU_turn(j:Player,p:Player,m:Hand): Unit = {
    if (j.getSideStrenght>p.getSideStrenght){
      doPass_turn()
    }
    else if (j.getTotalStrenght >= p.getSideStrenght) {
      j.PlayCard(Random.nextInt(m.Largu()))
      doCPU_turn(j,p,m)
    }
    else {
      val WC = j.getWeathersCard
      if (WC.nonEmpty) {
        j.PlayCard(WC.head)
      }
      else {
        doPass_turn()
      }
    }
    
  }

  /**
   * Performs the pass turn action.
   * Overrides the base method in the parent class.
   * Transitions to the end round state and triggers the loss of gems.
   */
  override def doPass_turn(): Unit = {
    context.state=new EndRound(context)
    context.LoseGems()
  }

}
