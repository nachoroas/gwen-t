package cl.uchile.dcc
package gwent.States

import gwent.GameController

class CPU_turn(context:GameController) extends GameState(context){

  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
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
