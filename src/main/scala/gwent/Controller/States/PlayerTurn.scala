package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController

class PlayerTurn(context: GameController) extends GameState (context){

  override def toCpu_turn(): Unit = {
    context.state = new CPU_turn(context)
  }

  override def toEndRound(): Unit = {
    context.state = new EndRound(context)
  }

  override def doDrawCard(): Unit = {
    context.doDrawCard()
  }

  override def doPlayCard(input:Int): Unit = {
    context.doPlayCard(input)
  }

  override def doPass_turn(): Unit = {
    context.doPass_turn()
  }
}
