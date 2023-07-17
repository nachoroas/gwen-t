package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Board.Board
import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Players.Player

class StartRound (context:GameController) extends GameState (context){

  override def toPlayerTurn(): Unit = {
    context.state= new PlayerTurn(context)
  }
  override def ShuffleDeck(j:Player,c:Player): Unit = {
    j.ShuffleDeck()
    c.ShuffleDeck()
  }

  override def doDrawCard(j:Player): Unit = {
    j.DrawCard()
    toPlayerTurn()
  }
  override def ClearBoard(b:Board):Unit={
    b.ClearAllBoard()
  }


}
