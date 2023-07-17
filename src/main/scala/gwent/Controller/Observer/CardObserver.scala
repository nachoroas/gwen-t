package cl.uchile.dcc
package gwent.Controller.Observer

import gwent.Cards

import cl.uchile.dcc.gwent.CardClasses.CardAbilities.{Ability, BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, UnitCard}

trait CardObserver extends Observer{
  def update(ability: TorrentialRain):Unit
  def update(ability: BitingFrost):Unit
  def update(ability: ImpenetrableFog):Unit
  def update(ability: ClearWeather):Unit
  def update(card:MeleeCards, ability:Ability):Unit
  def update(card:RangeCards,ability:Ability):Unit
  def update(card:SiegeCards, ability:Ability):Unit
  

}
