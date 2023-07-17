package cl.uchile.dcc
package gwent.Controller.States

import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Players.{Hand, Player}

import scala.util.Random

class CPU_turn(context:GameController) extends GameState(context){

  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  override def doCPU_turn(j:Player,p:Player,M:Hand): Unit = {
    if (j.getTotalStrenght > p.getSideStrenght) {
      j.PlayCard(Random.nextInt(M.Largu()))
      toPlayerTurn() 
    }
    else {
      val WC = j.getWeathersCard
      if (WC.nonEmpty) {
        j.PlayCard(WC.head)
        toPlayerTurn()
      }
      else {
        doPass_turn() 
      }
    }
  }

  override def doPass_turn(): Unit = {
    context.state= new PerpetualPlayer(context)
  }

}
