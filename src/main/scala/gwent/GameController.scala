package cl.uchile.dcc
package gwent

import gwent.Cards
import gwent.States.{GameState, StartGame}

import scala.collection.mutable


class GameController() {

  /** Current state of the game, initially set to an instance of IdleState. */
  var state: GameState = new StartGame(this)
}
