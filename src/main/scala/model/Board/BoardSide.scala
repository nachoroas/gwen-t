package cl.uchile.dcc
package model.Board

import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard, WeatherCards}
import cl.uchile.dcc.Controller.Observer.CardObserver

import cl.uchile.dcc.model.CardClasses.CardAbilities.{Ability, BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.model.Cards
import cl.uchile.dcc.model.Players.Subject
import cl.uchile.dcc.model.Visitor.getStrenghtVisitor

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

  /**
   * Returns the total number of cards in the ranged zone of this side.
   *
   * @return The total number of cards in the ranged zone.
   */
  def getLargoRanged:Int=LargoRanged

  /**
   * Returns the total number of cards in the siege zone of this side.
   *
   * @return The total number of cards in the siege zone.
   */
  def getLargoSiege:Int=LargoSiege

  /**
   * Returns the total number of cards in all zones of this side.
   *
   * @return The total number of cards in all zones.
   */
  def getNcards:Int=getLargoMelee+getLargoRanged+getLargoSiege

  private def getStrenght(Zone:List[UnitCard]):Int= {
    var suma:Int = 0
    for(r <- Zone){
      suma += r.getStrenght
    }
    suma
  }

  /**
   * Returns the total strength of all cards in all zones of this side.
   *
   * @return The total strength of all cards in all zones.
   */
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

  /**
   * Updates the Cards in the board side when a Biting Frost ability is activated.
   *
   * @param ability The Biting Frost ability.
   */
  def update(ability:BitingFrost): Unit = {
    ability.activateM(MeleeZone)
    removeZoneFrost(RangedZone)
    removeZoneFrost(SiegeZone)
    }
  /**
   * Updates the Cards in the board side when an Impenetrable Fog ability is activated.
   *
   * @param ability The Impenetrable Fog ability.
   */
  def update(ability: ImpenetrableFog): Unit = {
    ability.activateR(RangedZone)
    removeZoneFrost(MeleeZone)
    removeZoneFrost(SiegeZone)
  }
  /**
   * Updates the Cards in the board side when a Torrential Rain ability is activated.
   *
   * @param ability The Torrential Rain ability.
   */
  def update(ability: TorrentialRain): Unit = {
    ability.activateS(SiegeZone)
    removeZoneFrost(RangedZone)
    removeZoneFrost(MeleeZone)
  }
  /**
   * Updates the Cards in the the board side when a Clear Weather ability is activated.
   *
   * @param ability The Clear Weather ability.
   */
  def update(ability: ClearWeather): Unit = {
    ability.activateR(RangedZone)
    ability.activateM(MeleeZone)
    ability.activateS(SiegeZone)
  }

  /**
   * Updates the Cards in the  board side when a melee card's ability is activated.
   *
   * @param card    The melee card.
   * @param ability The ability of the card.
   */
  def update(card:MeleeCards,ability:Ability):Unit={
    ability.activateM(MeleeZone)
  }

  /**
   * Updates the Cards in the board side when a ranged card's ability is activated.
   *
   * @param card    The ranged card.
   * @param ability The ability of the card.
   */

  def update(card: RangeCards, ability: Ability): Unit = {
    ability.activateR(RangedZone)
  }

  /**
   * Updates the Cards in the board side when a siege card's ability is activated.
   *
   * @param card    The siege card.
   * @param ability The ability of the card.
   */
  def update(card: SiegeCards, ability: Ability): Unit = {
    ability.activateS(SiegeZone)
  }
}