package cl.uchile.dcc
package gwent.States

import gwent.GameController

class StartGame(context: GameController) extends GameState (context){

  override def toStartRound(): Unit = {
    context.state= new StartRound(context)
  }

}
