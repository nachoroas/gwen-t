package cl.uchile.dcc
package gwent.Board

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

import cl.uchile.dcc.gwent.Cards


class BoardSide(){
  private var MeleeZone: List[Cards] = List()
  private var LargoMelee: Int=0
  private var RangedZone: List[Cards] = List()
  private var LargoRanged: Int=0
  private var SiegeZone: List[Cards] = List()
  private var LargoSiege: Int=0

  def playcard(carta: MeleeCards): Boolean = {
    MeleeZone = carta :: MeleeZone
    LargoMelee += 1
    true
  }

  def playcard(carta: RangeCards): Boolean = {
    RangedZone = carta :: RangedZone
    LargoRanged+=1
    true
  }

  def playcard(carta: SiegeCards): Boolean = {
    SiegeZone = carta :: SiegeZone
    LargoSiege+=1
    true
  }
  def playcard(carta: WeatherCards): Boolean ={
    this.playcard(carta)
  }
  def ShowMelee(index:Int):Cards={
    if (index<=LargoMelee){
      val x=MeleeZone(index)
      x
    }
    else
      val x=MeleeZone(LargoMelee)
      x
  }

  def ShowRanged(index: Int): Cards = {
    if (index <= LargoRanged) {
      val x = RangedZone(index)
      x
    }
    else
      val x = RangedZone(LargoRanged)
      x
  }

  def ShowSiege(index: Int): Cards = {
    if (index <= LargoSiege) {
      val x=SiegeZone(index)
      x
    }
    else
      val x= SiegeZone(LargoSiege)
      x
  }

  def ShowWeather(index:Int):Cards= {
    this.ShowWeather(index)
  }
}