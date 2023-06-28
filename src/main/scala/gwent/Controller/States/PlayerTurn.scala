package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Cards
import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Players.Player

class PlayerTurn(context: GameController) extends GameState (context){

  override def toCpu_turn(): Unit = {
    context.state = new CPU_turn(context)
  }
  
  override def doPlayCard(input:Int,j:Player): Unit = {
    j.PlayCard(input)
    toCpu_turn()
  }

  override def doPlayCard(card: Cards,j:Player): Unit = {
    j.PlayCard(card)
    toCpu_turn()
  }

  override def doPass_turn(): Unit = {
    context.state= new PerpetualCPU(context)
  }
}
