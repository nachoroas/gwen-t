package cl.uchile.dcc
package gwent.States

import gwent.{Cards, GameController}


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
  def doChangeCards():Unit={
  }
  def doDrawCard():Unit={
  }
  def doPlayCard():Unit={
  }
  def doPass_turn():Unit={
  }


  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }


}