package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.{Board, BoardSide}

/**
 * Represents a range card in the game.
 *
 * @param name The name of the range card.
 * @param strength The strength of the range card.
 * @param ability The ability of the range card.
 */

class RangeCards (name:String,strenght:Int,ability:Int) extends AbstractUnitClass(name,strenght,ability) {

  /**
   * Plays the range card on the game board.
   *
   * @param side The game board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new RangeCards("Archer", 3, 0)
   * card.be_played(gameBoardSide)  // Returns true or false
   */
  def be_played(side:BoardSide) : Unit={
    side.playcard(this)
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[RangeCards]) {
      val otherCard = o.asInstanceOf[RangeCards]
      if (this.getName == otherCard.getName) {
        this.getStrenght == otherCard.getStrenght
      }
      else false
    } else false
  }
}