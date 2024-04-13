package cl.uchile.dcc
package Controller.States

import cl.uchile.dcc.Controller.GameController
import cl.uchile.dcc.model.Players.Player

class EndRound(context:GameController) extends GameState(context){
  /**
   * Transitions to the start of a new round.
   * Overrides the base method in the parent class.
   */
  override def toStartRound(): Unit = {
    context.state = new StartRound(context)
    context.ClearBoard()
    context.ShuffleDeck()
  }
  /**
   * Handles the loss of gems by the players.
   * Overrides the base method in the parent class.
   *
   * @param p The player.
   * @param c The CPU player.
   */
  override def LoseGems(p: Player, c: Player): Unit = {
    if (p.getSideStrenght > c.getSideStrenght){
      c.losegem()
      CheckIfTheGameEnded()
    }
    else if (p.getSideStrenght < c.getSideStrenght){
      p.losegem()
      CheckIfTheGameEnded()
    }
    else{
      p.losegem()
      c.losegem()
      CheckIfTheGameEnded()
    }

  }

  /**
   * Checks if the game has ended after the loss of gems.
   * If the game has not ended, transitions to the start of a new round.
   */
  private def CheckIfTheGameEnded():Unit={
    try{
      context.toStartRound()
    }
    catch {
      case e: InvalidTransitionException =>
    }

  }


}
