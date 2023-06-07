package cl.uchile.dcc
package gwent.States

import gwent.GameController

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

  override def doPlayCard(): Unit = {
    context.doPlayCard()
  }

  override def doPass_turn(): Unit = {
    context.doPass_turn()
  }
}
