package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

class PerpetualPlayer(context:GameController) extends GameState(context){
  override def doPass_turn(): Unit = {
    context.state = new EndRound(context)
  }
  
}
