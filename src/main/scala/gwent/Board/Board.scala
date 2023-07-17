package cl.uchile.dcc
package gwent.Board

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.gwent.Cards
import cl.uchile.dcc.gwent.Controller.Observer.CardObserver
import cl.uchile.dcc.gwent.Players.Player

/**
 * The `Board` class represents a game board with two sides and a weather zone.
 *
 * @constructor Create a new board with the given sides.
 * @param side1 The first side of the board.
 * @param side2 The second side of the board.
 */
class Board (side1: BoardSide,side2:BoardSide) {
  private var WeatherZone: List[WeatherCards] = List()
  private var LargoWeather: Int = 0

  /**
   * Sets the board for each side by assigning the current board instance.
   */
  def setSides():Unit={
    side1.setBoard(this)
    side2.setBoard(this)
  }

  /**
   * Plays a weather card by adding it to the weather zone and incrementing the length of the weather.
   *
   * @param carta The weather card to be played.
   */
  def PlayWeatherCard(carta: WeatherCards): Unit = {
    WeatherZone=List(carta)
    LargoWeather=1
  }

  /**
   * Returns the total number of cards on the board, including cards on both sides and in the weather zone.
   *
   * @return The total number of cards on the board.
   */
  def Ncards:Int={
    side1.getNcards+side2.getNcards+LargoWeather
  }
  def ClearAllBoard():Unit={
    side1.ClearSide()
    side2.ClearSide()
    WeatherZone=List()
    LargoWeather=0
  }
  
}


