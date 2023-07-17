package cl.uchile.dcc
package gwent.Controller.States

import gwent.Cards

import cl.uchile.dcc.gwent.Board.Board
import cl.uchile.dcc.gwent.Controller.GameController
import cl.uchile.dcc.gwent.Players.{Hand, Player}


class GameState protected(val context: GameController) {
  // Set the state of the context to this state
  context.state = this

  def toCpu_turn():Unit={
    transitionError("toCpu_turn")
  }
  def toPlayerTurn():Unit={
    transitionError("toPlayerTurn")
  }
  def toStartRound():Unit={
    transitionError("toStartRound")
  }
  def toEndRound():Unit={
    transitionError("toEndRound")    
  }
  def toEndGame(): Unit = {
    transitionError("toEndGame")
  }
  def doPlayCard(input:Int,j:Player):Unit={
    ActionError("doPlayCard")
  }
  def doPlayCard(card:Cards,j:Player):Unit={
    ActionError("doPlayCard")
  }
  def doPass_turn():Unit={
    ActionError("doPass_turn")
  }
  def doCPU_turn(j:Player,P:Player,m:Hand):Unit={
    ActionError("doCPU_turn")
  }
  def doDrawCard(j:Player): Unit = {
    ActionError("doDrawCard")
  }
  def LoseGems(p:Player,c:Player):Unit={
    ActionError("LoseGems")
  }
  def ClearBoard(b:Board):Unit={
    ActionError("ClearBoard")
  }
  def ShuffleDeck(p:Player,c:Player):Unit={
    ActionError("ShuffleDeck")
  }
  
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
  private def ActionError(action: String): Unit = {
    throw new InvalidActionException(
      s"Cannot do $action in ${getClass.getSimpleName}"
    )
  }
  def getState():String={
    getClass.getSimpleName
  }


}