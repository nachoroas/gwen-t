package cl.uchile.dcc
package gwent.Visitor

import gwent.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

class Visitor {
  def visitMeleeCard(meleeCard: MeleeCards):Unit={
  }

  def visitRangeCard(rangeCards: RangeCards):Unit={
  }

  def visitSiegeCard(siegeCards: SiegeCards):Unit={
  }

  def visitWeatherCard(weatherCards: WeatherCards):Unit={
  }
}
