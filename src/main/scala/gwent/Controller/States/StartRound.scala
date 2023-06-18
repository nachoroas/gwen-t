package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController

class StartRound (context:GameController) extends GameState (context){

  override def toPlayerTurn(): Unit = {
    context.state= new PlayerTurn(context)
  }


}
