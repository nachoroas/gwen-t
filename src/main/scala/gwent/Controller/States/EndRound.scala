package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Players.Player

class EndRound(context:GameController) extends GameState(context){

  override def toStartRound(): Unit = {
    context.state = new StartRound(context)
    context.ShuffleDeck()
  }

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
  private def CheckIfTheGameEnded():Unit={
    try{
      context.toStartRound()
    }
    catch {
      case e: InvalidTransitionException =>
    }

  }


}
