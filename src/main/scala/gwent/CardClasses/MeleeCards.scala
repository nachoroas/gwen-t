package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSide

/**
 * Represents a melee card in the game.
 *
 * @param name The name of the melee card.
 * @param strength The strength of the melee card.
 * @param ability The ability of the melee card.
 */

class MeleeCards (name:String,strenght:Int,ability:Int) extends AbstractUnitClass(name,strenght,ability){

  /**
   * Plays the melee card on the game board.
   *
   * @param side The game board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new MeleeCards("Swordsman", 5, 0)
   * card.be_played(gameBoardSide)  // Returns true or false
   */
  def be_played(side: BoardSide): Unit = {
    side.playcard(this)
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[MeleeCards]) {
      val otherCard = o.asInstanceOf[MeleeCards]
      if (this.getName == otherCard.getName){
        this.getStrenght == otherCard.getStrenght
      }
      else false
    } else false
  }
}
