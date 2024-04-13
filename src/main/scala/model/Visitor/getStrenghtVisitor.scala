package cl.uchile.dcc
package model.Visitor

import model.CardClasses.{MeleeCards, RangeCards, SiegeCards}

class getStrenghtVisitor extends Visitor {
  private var totalStrenght:Int=0

  override def visitMeleeCard(meleeCard: MeleeCards): Unit = {
    totalStrenght+=meleeCard.getStrenght
  }

  override def visitRangeCard(rangeCards: RangeCards): Unit = {
    totalStrenght+=rangeCards.getStrenght
  }

  override def visitSiegeCard(siegeCards: SiegeCards): Unit = {
    totalStrenght+=siegeCards.getStrenght
  }
  def getResult:Int=totalStrenght


}
