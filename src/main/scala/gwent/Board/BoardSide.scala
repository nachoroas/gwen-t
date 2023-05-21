package cl.uchile.dcc
package gwent.Board

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.gwent.Cards


class BoardSide(){
  private var MeleeZone: List[Cards] = List()
  private var RangedZone: List[Cards] = List()
  private var SiegeZone: List[Cards] = List()

  def playcard(carta: MeleeCards): Unit = {
    MeleeZone = carta :: MeleeZone
  }

  def playcard(carta: RangeCards): Unit = {
    RangedZone = carta :: RangedZone
  }

  def playcard(carta: SiegeCards): Unit = {
    SiegeZone = carta :: SiegeZone
  }
  def playcard(carta: WeatherCards): Unit ={
    this.playcard(carta)
  }
}