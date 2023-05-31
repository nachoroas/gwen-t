package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSide

/**
 * Represents a siege card in the game.
 *
 * @param name The name of the siege card.
 * @param strength The strength of the siege card.
 * @param ability The ability of the siege card.
 */
class SiegeCards (name:String,strenght:Int,ability:Int) extends AbstractUnitClass(name,strenght,ability) {

  /**
   * Plays the siege card on the specified board side.
   *
   * @param side The board side to play the card on.
   * @return True if the card can be played, false otherwise.
   * @example
   * val card = new SiegeCards("Cannon", 5, 0)
   * card.be_played(boardSide)  // Returns true or false
   */
  def be_played(side: BoardSide): Unit = {
    side.playcard(this)
  }

  override def equals(o: Any): Boolean = {
    if (o.isInstanceOf[SiegeCards]) {
      val otherCard = o.asInstanceOf[SiegeCards]
      if (this.getName == otherCard.getName) {
        this.getStrenght == otherCard.getStrenght
      }
      else false
    } else false
  }
}