package cl.uchile.dcc
package gwent.CardClasses

import gwent.Cards

import cl.uchile.dcc.gwent.Board.BoardSide

/** A class to define all the Siege unit classes
 *
 * this class defines almost every method for the Siege unit classes
 *
 * @param name the name of the card
 *
 * @param strenght the strenght of the card
 *
 * @param ability the ability of the card, it is not yet implemented
 *                but i want to separate the abilities by numbers
 *
 * ideally i won't use a abstract class to create a object so i will don't write a example
 */

class SiegeCards (name:String,strenght:Int,ability:Int) extends AbstractUnitClass(name,strenght,ability) {
  
  /** its tell the card to play itself but its not yet implented
   *
   * @param void no parameters
   * @return true of false
   * @example
   * {{{
   * for a card which extend from here named "a"
   * a.be_played()=true
   * }}}
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