package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

import cl.uchile.dcc.gwent.Cards
import cl.uchile.dcc.gwent.Players.Player

class PerpetualPlayer(context:GameController) extends GameState(context){
  override def doPass_turn(): Unit = {
    context.state = new EndRound(context)
    context.LoseGems()
  }

  override def doPlayCard(input: Int, j: Player): Unit = {
    j.PlayCard(input)
  }

  override def doPlayCard(card: Cards, j: Player): Unit = {
    j.PlayCard(card)
  }
  
}
