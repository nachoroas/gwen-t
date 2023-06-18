package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController

class StartGame(context: GameController) extends GameState (context){

  override def toStartRound(): Unit = {
    context.state= new StartRound(context)
  }

}
