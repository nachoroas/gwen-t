package cl.uchile.dcc
package Controller.Observer

import model.Cards

import cl.uchile.dcc.model.CardClasses.CardAbilities.{Ability, BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.model.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

trait CardObserver extends Observer{
  def update(ability: TorrentialRain):Unit
  def update(ability: BitingFrost):Unit
  def update(ability: ImpenetrableFog):Unit
  def update(ability: ClearWeather):Unit
  def update(card:MeleeCards, ability:Ability):Unit
  def update(card:RangeCards,ability:Ability):Unit
  def update(card:SiegeCards, ability:Ability):Unit
  

}
