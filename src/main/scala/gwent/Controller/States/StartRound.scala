package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Players.Player

class StartRound (context:GameController) extends GameState (context){

  override def toPlayerTurn(): Unit = {
    context.state= new PlayerTurn(context)
  }

  override def doDrawCard(j:Player): Unit = {
    j.DrawCard()
    toPlayerTurn()
  }


}
