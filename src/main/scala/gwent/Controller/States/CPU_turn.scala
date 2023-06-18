package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController

class CPU_turn(context:GameController) extends GameState(context){

  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  override def toEndRound(): Unit = {
    context.state = new EndRound(context)
  }

  override def doCPU_turn(): Unit = {
    context.doCPU_turn()
  }

  override def doPass_turn(): Unit = {
    
  }

}
