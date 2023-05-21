package cl.uchile.dcc
package gwent.Board

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.gwent.Cards
import cl.uchile.dcc.gwent.Players.Player

class Board (side1:BoardSide,side2:BoardSide) extends BoardSide{
  private var WeatherZone : List[Cards] = List()

  override def playcard(carta: WeatherCards): Unit = {
    WeatherZone = carta :: WeatherZone
  }
}


