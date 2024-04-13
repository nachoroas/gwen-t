package cl.uchile.dcc
package model

import model.Board.BoardSide

import cl.uchile.dcc.Controller.Observer.CardObserver
import cl.uchile.dcc.model.Players.Subject
import cl.uchile.dcc.model.Visitor.Visitor


/**Trait for the cards which can be in the hand or deck*/
trait Cards extends Subject[CardObserver] {
  def getName: String

  def getAbility(): String

  def be_played(side: BoardSide): Unit
  
  def accept(visitor: Visitor):Unit
}