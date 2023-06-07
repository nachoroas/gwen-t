package cl.uchile.dcc
package gwent.States

import gwent.GameController

class StartRound (context:GameController) extends GameState (context){

  override def toPlayerTurn(): Unit = {
    context.state= new PlayerTurn(context)
  }

  override def doChangeCards(): Unit = {
    context.doChangeCards()
  }

}
