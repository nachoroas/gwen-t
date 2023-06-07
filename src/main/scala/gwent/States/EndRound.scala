package cl.uchile.dcc
package gwent.States

import gwent.GameController

class EndRound(context:GameController) extends GameState(context){

  override def toEndGame(): Unit ={
    context.state = new EndGame(context)
  }

  override def toStartRound(): Unit = {
    context.state = new StartRound(context)
  }

}
