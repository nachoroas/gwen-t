package cl.uchile.dcc
package gwent

import gwent.Board.BoardSide

import cl.uchile.dcc.gwent.Visitor.Visitor


/**Trait for the cards which can be in the hand or deck*/
trait Cards extends Subject {
  def getName: String

  def getAbility(): String

  def be_played(side: BoardSide): Unit
  
  def accept(visitor: Visitor):Unit
}