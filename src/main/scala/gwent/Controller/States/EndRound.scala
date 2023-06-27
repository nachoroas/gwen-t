package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Players.Player

class EndRound(context:GameController) extends GameState(context){

  override def toEndGame(): Unit ={
    context.state = new EndGame(context)
  }

  override def toStartRound(): Unit = {
    context.state = new StartRound(context)
  }

  /*
  override def getWinner(p: Player, c: Player): String = {
    if (p.getTotalStrenght > c.getTotalStrenght) {
      p.getName
    }
    else {
      c.getName
    }
  }
  */

}
