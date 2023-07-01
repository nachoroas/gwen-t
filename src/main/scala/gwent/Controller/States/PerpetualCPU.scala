package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

import cl.uchile.dcc.gwent.Players.{Hand, Player}

import scala.util.Random

class PerpetualCPU(context:GameController) extends GameState(context) {

  override def doCPU_turn(j:Player,p:Player,m:Hand): Unit = {
    if (j.getTotalStrenght > p.getTotalStrenght) {
      j.PlayCard(Random.nextInt(m.Largu())) //MM
    }
    else {
      val WC = j.getWeathersCard
      if (WC.nonEmpty) {
        j.PlayCard(WC.head) 
      }
      else {
        doPass_turn() 
      }
    }
  }

  override def doPass_turn(): Unit = {
    context.state=new EndRound(context)
    context.LoseGems()
  }

}
