package cl.uchile.dcc
package gwent

import gwent.Board.BoardSide


/**Trait for the cards which can be in the hand or deck*/
trait Cards{
def getName:String
  //to use abilities not implemented here
def UseAbility():Boolean
def be_played(side: BoardSide):Unit
}
