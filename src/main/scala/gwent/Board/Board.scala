package cl.uchile.dcc
package gwent.Board

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.gwent.Cards
import cl.uchile.dcc.gwent.Players.Player

class Board (side1:BoardSide,side2:BoardSide) extends BoardSide {
  private var WeatherZone : List[Cards] = List()
  private var LargoWeather: Int=0

  override def playcard (carta: WeatherCards): Boolean = {
    WeatherZone = carta :: WeatherZone
    LargoWeather += 1
    true
  }
  override def ShowWeather(index:Int):Cards={
    if (index <=  LargoWeather) {
      val x = WeatherZone(index)
      x
    }
    else
      val x = WeatherZone(LargoWeather)
      x
  }
}


