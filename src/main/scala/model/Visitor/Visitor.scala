package cl.uchile.dcc
package model.Visitor

import model.CardClasses.{MeleeCards, RangeCards, SiegeCards, WeatherCards}

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
