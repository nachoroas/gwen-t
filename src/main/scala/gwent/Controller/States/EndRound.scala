package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController

class EndRound(context:GameController) extends GameState(context){

  override def toEndGame(): Unit ={
    context.state = new EndGame(context)
  }

  override def toStartRound(): Unit = {
    context.state = new StartRound(context)
  }

}
