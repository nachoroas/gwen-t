package cl.uchile.dcc
package gwent.Board

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard, WeatherCards}

import cl.uchile.dcc.gwent.CardClasses.CardAbilities.{Ability, BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.gwent.{Cards, Subject}
import cl.uchile.dcc.gwent.Controller.Observer.CardObserver
import cl.uchile.dcc.gwent.Visitor.getStrenghtVisitor

import scala.collection.mutable
import scala.collection.mutable.Map


/**
 * The `BoardSide` class represents a side of the game board with different zones for melee, ranged, and siege cards.
 */
class BoardSide() extends CardObserver {
  private var MeleeZone: List[MeleeCards] = List()
  private var LargoMelee: Int=0
  private var RangedZone: List[RangeCards] = List()
  private var LargoRanged: Int=0
  private var SiegeZone: List[SiegeCards] = List()
  private var LargoSiege: Int=0
  private var Table:Board=_

  /**
   * Sets the board for this side by assigning the current board instance.
   *
   * @param board The board instance to be set.
   */
  def setBoard(board: Board):Unit={
    Table=board
  }

  /**
   * Plays a melee card by adding it to the melee zone and incrementing the melee length.
   *
   * @param carta The melee card to be played.
   */
  def PlayMeleeCard(carta: MeleeCards): Unit = {
    MeleeZone = carta :: MeleeZone
    LargoMelee += 1

  }

  /**
   * Plays a ranged card by adding it to the ranged zone and incrementing the ranged length.
   *
   * @param carta The ranged card to be played.
   */
  def PlayRangedCard(carta: RangeCards): Unit = {
    RangedZone = carta :: RangedZone
    LargoRanged+=1
  }

  /**
   * Plays a siege card by adding it to the siege zone and incrementing the siege length.
   *
   * @param carta The siege card to be played.
   */
  def PlaySiegeCard(carta: SiegeCards): Unit = {
    SiegeZone = carta :: SiegeZone
    LargoSiege+=1
  }

  /**
   * Plays a weather card by forwarding it to the board instance to be played.
   *
   * @param carta The weather card to be played.
   */
  def PlayWeatherCard(carta: WeatherCards): Unit ={
    Table.PlayWeatherCard(carta)
  }

  /**
   * Returns the total number of cards in all zones of this side.
   *
   * @return The total number of cards in all zones.
   */
  def getLargoMelee: Int = LargoMelee
  
  def getLargoRanged:Int=LargoRanged
  
  def getLargoSiege:Int=LargoSiege
  
  def getNcards:Int=getLargoMelee+getLargoRanged+getLargoSiege

  private def getStrenght(Zone:List[UnitCard]):Int= {
    var suma:Int = 0
    for(r <- Zone){
      suma += r.getStrenght
    }
    suma
  }
  def getTotalStrenght:Int={
    getStrenght(MeleeZone)+getStrenght(RangedZone)+getStrenght(SiegeZone)
  }


  /**
   * Clears the side of the board by resetting all zone lengths and emptying the zones.
   */
  def ClearSide():Unit={
    LargoSiege=0
    LargoRanged=0
    LargoMelee=0
    MeleeZone=List[MeleeCards]()
    RangedZone=List[RangeCards]()
    SiegeZone=List[SiegeCards]()
  }
  private def removeZoneFrost(list:List[UnitCard]):Unit={
    for (r <- list){
      r.removeEffect()
    }
  }
  def update(ability:BitingFrost): Unit = {
    ability.activateM(MeleeZone)
    removeZoneFrost(RangedZone)
    removeZoneFrost(SiegeZone)
    }

  def update(ability: ImpenetrableFog): Unit = {
    ability.activateR(RangedZone)
    removeZoneFrost(MeleeZone)
    removeZoneFrost(SiegeZone)
  }

  def update(ability: TorrentialRain): Unit = {
    ability.activateS(SiegeZone)
    removeZoneFrost(RangedZone)
    removeZoneFrost(MeleeZone)
  }

  def update(ability: ClearWeather): Unit = {
    ability.activateR(RangedZone)
    ability.activateM(MeleeZone)
    ability.activateS(SiegeZone)
  }
  def update(card:MeleeCards,ability:Ability):Unit={
    ability.activateM(MeleeZone)
  }

  def update(card: RangeCards, ability: Ability): Unit = {
    ability.activateR(RangedZone)
  }

  def update(card: SiegeCards, ability: Ability): Unit = {
    ability.activateS(SiegeZone)
  }
}